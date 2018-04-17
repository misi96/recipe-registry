import {Component, EventEmitter, Input, Output, ViewChild} from '@angular/core';
import {AppService} from '../../app.service';
import {isNullOrUndefined} from 'util';
import {ConfirmationService} from 'primeng/api';
import {GrowlMessageService} from '../../services/growl-message.service';
import {IngredientListVO} from '../../models/ingredient-list-vo';
import {NewModifyIngredientComponent} from '../new-modify-ingredient/new-modify-ingredient.component';
import {IngredientFormVO} from '../../models/ingredient-form-vo';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.scss']
})
export class IngredientListComponent {
  public ingredients: IngredientListVO[];
  public selectedIngredient: IngredientListVO;

  public recipeId: number;

  @Input() readOnlyTable = false;

  @Output() ingredientListChange: EventEmitter<number>;

  @ViewChild('newModifyIngredientPopup') newModifyIngredientPopup: NewModifyIngredientComponent;

  constructor(private appService: AppService,
              private confirmationService: ConfirmationService,
              private growlMessageService: GrowlMessageService) {
    this.ingredientListChange = new EventEmitter<number>();
    this.ingredients = [];
  }

  public init(recipeId: number) {
    this.recipeId = recipeId;
    this.loadIngredients();
  }

  private loadIngredients(): void {
    this.appService.callRestGet(`ingredient/list/${this.recipeId}`)
      .then(dataResponse => {
        this.ingredients = dataResponse.map(ingredient => new IngredientListVO(ingredient));
        this.sendCalculatedEnergy();
      });
  }

  private sendCalculatedEnergy() {
    if (!isNullOrUndefined(this.ingredients)) {
      this.ingredientListChange.emit(this.calculateEnergy());
    }
  }

  private calculateEnergy(): number {
    return this.ingredients
      .map(ingredient => +ingredient.energy
        .substr(0, ingredient.energy.length - 4))
      .reduce((a, b) => a + b, 0);
  }

  public addNewIngredient(): void {
    if (!this.readOnlyTable) {
      this.newModifyIngredientPopup.initDialog();
    }
  }

  public editIngredient(ingredient: IngredientListVO): void {
    if (!this.readOnlyTable) {
      this.newModifyIngredientPopup.initDialog(ingredient);
    }
  }

  public addNewIngredientToTheList(ingredient: IngredientFormVO): void {
    this.ingredients = [new IngredientListVO(ingredient), ...this.ingredients];
    this.sortIngredientListByName();
  }

  private sortIngredientListByName(): void {
    this.ingredients
      .sort((ingredient1, ingredient2) => {
        const ingredient1Name = ingredient1.name.toLowerCase();
        const ingredient2Name = ingredient2.name.toLowerCase();
        return ingredient1Name > ingredient2Name ? 1 : ingredient1Name < ingredient2Name ? -1 : 0;
      });
  }

  public addModifiedIngredientToTheList(ingredient: IngredientFormVO): void {
    this.ingredients[this.getSelectedIngredientIndex()] = new IngredientListVO(ingredient);
    this.ingredients = [...this.ingredients];
  }

  private getSelectedIngredientIndex(): number {
    return this.ingredients.indexOf(this.selectedIngredient);
  }

  public saveIngredientsForNewRecipe(recipeId: number): void {
    this.ingredients.map(ingredient => ingredient.recipeId = recipeId);
    this.ingredients.map(ingredient => IngredientListVO.createIngredientFormVO(ingredient));
    this.appService.callRestSave('ingredient/list/add', this.ingredients);
  }

  public openConfirmationDialog() {
    if (!isNullOrUndefined(this.recipeId)) {
      this.ingredients.length === 1 ? this.showDeleteWarningMessage() : this.confirmDelete();
    } else {
      this.confirmDelete();
    }
  }

  private showDeleteWarningMessage(): void {
    this.growlMessageService.warnMessage('The recipe must have at least one ingredient!');
  }

  private confirmDelete(): void {
    this.confirmationService.confirm(this.getConfirmationObject());
  }

  private getConfirmationObject(): any {
    return {
      message: 'Do you want to delete this ingredient?',
      header: 'Delete ingredient',
      icon: 'fa fa-trash',
      accept: () => this.getDeleteAcceptFunction()
    };
  }

  private getDeleteAcceptFunction(): void {
    this.deleteIngredient();
    this.growlMessageService.successMessage('Delete succesful');
  }

  private deleteIngredient(): void {
    if (!isNullOrUndefined(this.recipeId)) {
      this.appService.callRestDelete(`ingredient/delete/${this.selectedIngredient.id}`, true)
        .then(() => {
          this.deleteIngredientFromTheList();
          this.sendCalculatedEnergy();
        });
    } else {
      this.deleteIngredientFromTheList();
    }
  }

  private deleteIngredientFromTheList(): void {
    const index = this.findSelectedIngredientIndex();
    this.ingredients = this.ingredients.filter((val, i) => i !== index);
  }

  private findSelectedIngredientIndex(): number {
    return this.ingredients.indexOf(this.selectedIngredient);
  }

  public handleSavingFinished(): void {
    !isNullOrUndefined(this.recipeId) ? this.loadIngredients() : this.sendCalculatedEnergy();
  }
}
