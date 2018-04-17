import {BaseVO} from './base-vo';

export class IngredientBaseVO extends BaseVO {
  energy: any;
  name: string;
  quantity: number;
  quantityType: number;
  quantityTypeName: string;
  recipeId: number;

  constructor() {
    super();
  }
}
