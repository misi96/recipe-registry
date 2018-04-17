import {isNullOrUndefined} from 'util';
import {IngredientBaseVO} from './ingredient-base-vo';
import {IngredientFormVO} from './ingredient-form-vo';

export class IngredientListVO extends IngredientBaseVO {
  constructor(ingredientListVO?: IngredientListVO) {
    super();
    if (isNullOrUndefined(ingredientListVO)) {
      return;
    }
    Object.assign(this, ingredientListVO);
    this.energy = `${this.energy} kcal`;
  }

  public static createIngredientFormVO(ingredientListVO: IngredientListVO): IngredientFormVO {
    const energy = ingredientListVO.energy;
    (<any>ingredientListVO).energy = +energy.substr(0, energy.length - 5);
    delete ingredientListVO.quantityTypeName;
    return new IngredientFormVO(ingredientListVO);
  }
}
