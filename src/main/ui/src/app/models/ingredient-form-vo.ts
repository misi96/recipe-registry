import {isNullOrUndefined} from 'util';
import {IngredientBaseVO} from './ingredient-base-vo';

export class IngredientFormVO extends IngredientBaseVO {
  constructor(ingredientFormVO?: IngredientFormVO) {
    super();
    if (isNullOrUndefined(ingredientFormVO)) {
      return;
    }
    Object.assign(this, ingredientFormVO);
  }
}
