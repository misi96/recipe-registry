import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {IntroductionComponent} from './components/introduction/introduction.component';
import {RecipeListComponent} from './components/recipe-list/recipe-list.component';
import {ServingCalculatorComponent} from './components/serving-calculator/serving-calculator.component';
import {NewModifyRecipeComponent} from './components/new-modify-recipe/new-modify-recipe.component';

export const routes: Routes = [
  {path: '', redirectTo: '/introduction', pathMatch: 'full'},
  {path: 'introduction', component: IntroductionComponent},
  {path: 'recipes', component: RecipeListComponent},
  {path: 'serving-calculator', component: ServingCalculatorComponent},
  {path: 'new-modify-recipe', component: NewModifyRecipeComponent},
  {path: 'new-modify-recipe/:recipeId', component: NewModifyRecipeComponent},
  {path: '**', redirectTo: '/introduction'}
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
