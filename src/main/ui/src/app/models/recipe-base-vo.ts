import {BaseVO} from './base-vo';
import {IngredientListVO} from './ingredient-list-vo';

export class RecipeBaseVO extends BaseVO {
  cookingTime: number | string;
  description: string;
  difficulty: number;
  energy: any;
  ingredients: IngredientListVO;
  name: string;
  category: string;

  constructor() {
    super();
    this.energy = 0;
  }
}
