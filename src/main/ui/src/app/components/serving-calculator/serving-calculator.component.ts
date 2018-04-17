import {Component, HostListener, OnInit, ViewChild} from '@angular/core';
import {RecipeTableComponent} from '../recipe-table/recipe-table.component';
import {isNullOrUndefined} from 'util';
import {SelectItem} from 'primeng/api';
import {AppService} from '../../app.service';
import {IngredientListVO} from '../../models/ingredient-list-vo';
import {IngredientListComponent} from '../ingredient-list/ingredient-list.component';
import * as jsPDF from 'jspdf'
import {RecipeListVO} from '../../models/recipe-list-vo';
import {AdvancedLog} from '../../services/advanced-log';

@Component({
  selector: 'app-serving-calculator',
  templateUrl: './serving-calculator.component.html',
  styleUrls: ['./serving-calculator.component.scss']
})
export class ServingCalculatorComponent implements OnInit {
  public static NO_RECIPE_DESCRIPTION = 'This recipe has no description.';

  public steps: any[];
  public activeStepIndex: number;

  public selectedNumberOfServings: number;
  public numberOfServingsOptions: SelectItem[];

  public firstRowButtons: SelectItem[];
  public secondRowButtons: SelectItem[];
  public thirdRowButtons: SelectItem[];
  public fourthRowButtons: SelectItem[];

  public displayedRecipe: RecipeListVO;

  public screenWidth: number;

  private ingredients: IngredientListVO[];
  private recipeToCalculateVO: RecipeToCalculate;

  private document: any;
  private currentRow: number;

  @ViewChild('recipeTable') recipeTable: RecipeTableComponent;
  @ViewChild('ingredientList') ingredientList: IngredientListComponent;

  constructor(private appService: AppService) {
    this.recipeToCalculateVO = new RecipeToCalculate();
    this.screenWidth = window.innerWidth;
    this.loadNumberOfServingsOptions();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.screenWidth = event.target.innerWidth;
    this.loadNumberOfServingsOptions();
  }

  public isSmallerDevice(): boolean {
    return this.screenWidth < 641;
  }

  ngOnInit() {
    this.loadSteps();
    this.activeStepIndex = 0;
  }

  private loadNumberOfServingsOptions(): void {
    this.numberOfServingsOptions = [];
    for (let i = 1; i <= 20; i++) {
      const number = i, text = number === 1 ? ' Person' : ' People';
      this.numberOfServingsOptions.push({label: `${this.isSmallerDevice() ? number : number + text}`, value: number});
    }
    this.sliceNumberOfServingsOptions();
  }

  private sliceNumberOfServingsOptions(): void {
    this.firstRowButtons = this.numberOfServingsOptions.slice(0, 5);
    this.secondRowButtons = this.numberOfServingsOptions.slice(5, 10);
    this.thirdRowButtons = this.numberOfServingsOptions.slice(10, 15);
    this.fourthRowButtons = this.numberOfServingsOptions.slice(15, 20);
  }

  private loadSteps(): void {
    this.steps = [
      {label: 'Select a recipe'},
      {label: 'Set number of servings'},
      {label: 'Start cooking'}
    ];
  }

  public handlePreviousButton() {
    if (this.activeStepIndex > 0) {
      this.activeStepIndex--;
    }
  }

  public handleNextButton() {
    this.initRecipeToCalculateVOFields();
    if (this.activeStepIndex < 2) {
      this.activeStepIndex++;
    }
  }

  private initRecipeToCalculateVOFields(): void {
    switch (this.activeStepIndex) {
      case 0:
        this.displayedRecipe = JSON.parse(JSON.stringify(this.recipeTable.selectedRecipe));
        this.recipeToCalculateVO.recipeId = this.displayedRecipe.id;
        this.setDescriptionInCaseOfNull();
        break;
      case 1:
        this.recipeToCalculateVO.numberOfServings = this.selectedNumberOfServings;
        this.getCalculatedIngredientValues();
    }
  }

  private setDescriptionInCaseOfNull(): void {
    const description = this.displayedRecipe.description;
    if (isNullOrUndefined(description)) {
      this.displayedRecipe.description = ServingCalculatorComponent.NO_RECIPE_DESCRIPTION;
    }
  }

  private getCalculatedIngredientValues(): void {
    this.appService.callRestPost('serving-calculator/recipe', this.recipeToCalculateVO)
      .then(dataResponse => {
        this.ingredientList.ingredients = this.getRoundedIngredientValues(dataResponse.ingredients);
      });
  }

  private getRoundedIngredientValues(ingredients: any[]): any {
    return ingredients.map(ingredient => {
      ingredient.energy = `${this.checkDecimalPlaces(ingredient.energy)} kcal`;
      ingredient.quantity = this.checkDecimalPlaces(ingredient.quantity);
      return ingredient;
    });
  }

  private checkDecimalPlaces(value: number): any {
    const stringValueSplit = value.toFixed(2).toString().split('.');
    return stringValueSplit[1] === '00' ? Number.parseInt(stringValueSplit[0]) : value.toFixed(2);
  }

  public shouldNextButtonBeDisabled(): boolean {
    let shouldBeDisabled;
    switch (this.activeStepIndex) {
      case 0:
        shouldBeDisabled = isNullOrUndefined(this.recipeTable) || isNullOrUndefined(this.recipeTable.selectedRecipe);
        break;
      case 1:
        shouldBeDisabled = isNullOrUndefined(this.selectedNumberOfServings);
        break;
      case 2:
        shouldBeDisabled = true;
    }
    return shouldBeDisabled;
  }

  public downloadRecipe(): void {
    this.document = new jsPDF();
    this.currentRow = 20;
    this.setDocumentMainTitle(this.displayedRecipe.name);
    this.setAdditionalRecipeInformation();
    this.setMainRecipeInformation();
    this.document.save(this.convertRecipeNameToSnakeCase(this.displayedRecipe.name));
  }

  private setAdditionalRecipeInformation(): void {
    this.setDocumentSubTitle('Cooking time:');
    this.setDocumentText(this.displayedRecipe.cookingTime);

    this.setDocumentSubTitle('Difficulty:');
    this.setDocumentText(`Level ${this.displayedRecipe.difficulty}`);

    this.setDocumentSubTitle('Energy:');
    this.setDocumentText(this.displayedRecipe.energy);
  }

  private setMainRecipeInformation(): void {
    this.setDocumentSubTitle('Ingredients:');
    this.setDocumentIngredients();

    this.setDocumentSubTitle('Description:');
    this.setDocumentText(this.displayedRecipe.description);
  }

  private setDocumentIngredients(): void {
    for (let i = 0; i < this.ingredientList.ingredients.length; i++) {
      const currIng = this.ingredientList.ingredients[i];
      this.setDocumentText(`- ${currIng.name} - ${currIng.quantity} - ${currIng.quantityTypeName}`);
    }
  }

  private convertRecipeNameToSnakeCase(recipeName: string): string {
    return recipeName.toLowerCase().replace(/ /g, '_');
  }

  private setDocumentMainTitle(mainTitle: string): void {
    this.document.setFont('helvetica');
    this.document.setFontType('bold');
    this.document.setFontSize(24);
    this.document.text(15, this.currentRow, mainTitle);
    this.addNewRow();
  }

  private setDocumentSubTitle(subTitle: string): void {
    this.document.setFont('courier');
    this.document.setFontType('bolditalic');
    this.document.setFontSize(16);
    this.document.text(15, this.currentRow, subTitle);
    this.addNewRow();
  }

  private setDocumentText(text: any): void {
    this.document.setFont('times');
    this.document.setFontType('italic');
    this.document.setFontSize(12);
    const splitText = this.document.splitTextToSize(text, 180);
    this.document.text(20, this.currentRow, splitText);
    this.addNewRow();
  }

  private addNewRow(): void {
    this.currentRow += 10;
  }

  public hasRecipeDescription(): boolean {
    AdvancedLog.separatedLabeledLog('this.displayedRecipe.description', this.displayedRecipe.description);
    return this.displayedRecipe.description === 'This recipe has no description';
  }
}

class RecipeToCalculate {
  recipeId: number;
  numberOfServings: number;

  constructor() {
  }
}
