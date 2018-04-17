import {Component, ViewChild} from '@angular/core';
import {RecipeTableComponent} from '../recipe-table/recipe-table.component';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent {
  @ViewChild('recipeTable') recipeTable: RecipeTableComponent;

  constructor() {
  }
}
