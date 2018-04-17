import {RecipeBaseVO} from './recipe-base-vo';
import {isNullOrUndefined} from 'util';

export class RecipeFormVO extends RecipeBaseVO {
  numberOfServings: number;

  constructor(recipeFormVO?: RecipeFormVO) {
    super();
    this.numberOfServings = 1;
    if (isNullOrUndefined(recipeFormVO)) {
      this.numberOfServings = 1;
      return;
    }
    Object.assign(this, recipeFormVO);
  }
}
