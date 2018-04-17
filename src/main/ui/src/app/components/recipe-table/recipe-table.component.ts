import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {RecipeListVO} from '../../models/recipe-list-vo';
import {AppService} from '../../app.service';
import {Router} from '@angular/router';
import {ConfirmationService} from 'primeng/api';
import {GrowlMessageService} from '../../services/growl-message.service';
import {isNullOrUndefined} from 'util';
import {OverlayPanel} from 'primeng/primeng';
import {IngredientListComponent} from '../ingredient-list/ingredient-list.component';

@Component({
  selector: 'app-recipe-table',
  templateUrl: './recipe-table.component.html',
  styleUrls: ['./recipe-table.component.scss']
})
export class RecipeTableComponent implements OnInit {
  public recipes: RecipeListVO[];
  public selectedRecipe: RecipeListVO;

  public isLoading: boolean;
  public descriptionPanelText: any;

  @Input() readOnlyTable = false;
  @Input() showTableHeader = true;

  @ViewChild('ingredientList') ingredientList: IngredientListComponent;

  constructor(private appService: AppService,
              private router: Router,
              private confirmationService: ConfirmationService,
              private growlMessageService: GrowlMessageService) {
    this.isLoading = true;
    this.recipes = [];
  }

  ngOnInit() {
    this.loadRecipes();
  }

  private loadRecipes(): void {
    this.appService.callRestGet('recipe/list')
      .then(dataResponse => {
        this.recipes = dataResponse.map(recipe => new RecipeListVO(recipe));
      });
    this.isLoading = false;
  }

  public addNewRecipe(): void {
    this.redirectToNewOrModify();
  }

  public editRecipe(): void {
    if (!this.readOnlyTable && this.showTableHeader) {
      this.redirectToNewOrModify(this.selectedRecipe.id);
    }
  }

  private redirectToNewOrModify(param?: any): void {
    if (!isNullOrUndefined(param)) {
      this.router.navigate(['/new-modify-recipe', param]);
    } else {
      this.router.navigate(['/new-modify-recipe']);
    }
  }

  private deleteRecipe(): void {
    const index = this.findSelectedRecipeIndex();
    const id = this.selectedRecipe.id;
    this.appService.callRestDelete(`recipe/delete/${id}`, true)
      .then(() => {
        this.recipes = this.recipes.filter((val, i) => i !== index);
      });
  }

  private findSelectedRecipeIndex(): number {
    return this.recipes.indexOf(this.selectedRecipe);
  }

  public openConfirmationDialog() {
    this.confirmationService.confirm({
      message: 'Do you want to delete this recipe?',
      header: 'Delete recipe',
      icon: 'fa fa-trash',
      accept: () => this.getDeleteAcceptFunction()
    });
  }

  private getDeleteAcceptFunction(): void {
    this.deleteRecipe();
    this.growlMessageService.successMessage('Delete successful');
  }

  public showIngredientsPanel(event: Event, recipeId: number, panel: OverlayPanel) {
    this.ingredientList.init(recipeId);
    panel.toggle(event);
  }

  public showDescriptionPanel(event: Event, description, panel: OverlayPanel): void {
    this.descriptionPanelText = description || 'This recipe has no description.';
    panel.toggle(event);
  }
}
