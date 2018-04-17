import {RecipeBaseVO} from './recipe-base-vo';
import {isNullOrUndefined} from 'util';

export class RecipeListVO extends RecipeBaseVO {
  constructor(recipeListVO?: RecipeListVO) {
    super();
    if (isNullOrUndefined(recipeListVO)) {
      return;
    }
    Object.assign(this, recipeListVO);
    this.energy = `${this.energy} kcal`;
    this.cookingTime = `${this.cookingTime} ${this.cookingTime > 1 ? 'minutes' : 'minute'}`;
  }
}
