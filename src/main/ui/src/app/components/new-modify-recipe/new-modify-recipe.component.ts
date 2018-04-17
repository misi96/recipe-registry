import {Component, OnInit, ViewChild} from '@angular/core';
import {AppService} from '../../app.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SelectItem} from 'primeng/api';
import {GrowlMessageService} from '../../services/growl-message.service';
import {RecipeFormVO} from '../../models/recipe-form-vo';
import {isNullOrUndefined} from 'util';
import {IngredientListComponent} from '../ingredient-list/ingredient-list.component';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-new-modify-recipe',
  templateUrl: './new-modify-recipe.component.html',
  styleUrls: ['./new-modify-recipe.component.scss']
})
export class NewModifyRecipeComponent implements OnInit {
  public recipeFormTitle: string;
  public recipeCategories: SelectItem[];
  public displayedRecipe: RecipeFormVO;

  private isExistingRecipe: boolean;

  @ViewChild('recipeForm') recipeForm: NgForm;
  @ViewChild('ingredientList') ingredientList: IngredientListComponent;

  constructor(private appService: AppService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private growlMessageService: GrowlMessageService) {
    this.displayedRecipe = new RecipeFormVO();
    this.recipeFormTitle = 'Add new recipe';
    this.recipeCategories = [];
  }

  ngOnInit() {
    this.activatedRoute.params
      .subscribe(params => {
        this.isExistingRecipe = !isNullOrUndefined(params['recipeId']);
        this.createDisplayedRecipeFromUrlParam(params['recipeId']);
      });
  }

  private createDisplayedRecipeFromUrlParam(urlParam: number): void {
    this.recipeFormTitle = !isNullOrUndefined(urlParam) ? 'Edit recipe' : 'Add new recipe';
    !isNullOrUndefined(urlParam) ? this.loadRecipeById(+urlParam) : this.loadRecipeCategoryOptions();
  }

  private loadRecipeById(recipeId: number) {
    this.appService.callRestGet(`recipe/get/${recipeId}`)
      .then(dataResponse => {
        this.displayedRecipe = new RecipeFormVO(dataResponse);
        this.loadRecipeCategoryOptions();
        this.loadIngredientsTable();
      });
  }

  private loadRecipeCategoryOptions(): void {
    this.appService.callRestGet('category/recipe/list')
      .then(dataResponse => {
        this.recipeCategories = dataResponse.map(type => {
          return {label: type.name, value: type.id};
        });
        this.recipeCategories.unshift({label: '', value: null});
      });
  }

  private loadIngredientsTable(): void {
    this.ingredientList.init(this.displayedRecipe.id);
  }

  public saveRecipe(): void {
    if (this.recipeForm.form.dirty) {
      this.isExistingRecipe ? this.updateRecipe() : this.addNewRecipe();
    } else {
      this.growlMessageService.infoMessage('There were no changes to save!');
    }
  }

  private addNewRecipe(): void {
    this.appService.callRestSave('recipe/add', this.displayedRecipe, true)
      .then(dataResponse => {
        this.saveIngredientsForNewRecipe(dataResponse.id);
        this.router.navigate(['/recipes']);
      });
  }

  private updateRecipe(): void {
    this.appService.callRestUpdate('recipe/update', this.displayedRecipe, true)
      .then(() => {
        this.router.navigate(['/recipes']);
      });
  }

  private saveIngredientsForNewRecipe(newRecipeId: number): void {
    this.ingredientList.saveIngredientsForNewRecipe(newRecipeId);
  }

  public setDisplayedRecipeEnergy(value): void {
    this.displayedRecipe.energy = value;
  }

  public navigateBackToRecipeList(): void {
    this.router.navigate(['/recipes']);
  }

  public shouldSaveButtonBeDisabled(): boolean {
    const isIngredientsTableEmpty = isNullOrUndefined(this.ingredientList)
      || this.ingredientList.ingredients.length === 0;
    return !this.recipeForm.valid || isIngredientsTableEmpty;
  }
}
