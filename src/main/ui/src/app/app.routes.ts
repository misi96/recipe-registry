import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {IntroductionComponent} from './components/introduction/introduction.component';
import {RecipeListComponent} from './components/recipe-list/recipe-list.component';
import {ServingCalculatorComponent} from './components/serving-calculator/serving-calculator.component';
import {NewModifyRecipeComponent} from './components/new-modify-recipe/new-modify-recipe.component';
import {RecipeStatisticsComponent} from './components/recipe-statistics/recipe-statistics.component';

export const routes: Routes = [
  {path: '', redirectTo: '/introduction', pathMatch: 'full'},
  {path: 'introduction', component: IntroductionComponent},
  {path: 'recipes', component: RecipeListComponent},
  {path: 'new-modify-recipe', component: NewModifyRecipeComponent},
  {path: 'new-modify-recipe/:recipeId', component: NewModifyRecipeComponent},
  {path: 'serving-calculator', component: ServingCalculatorComponent},
  {path: 'statistics', component: RecipeStatisticsComponent},
  {path: '**', redirectTo: '/introduction'}
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
