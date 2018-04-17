import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {SelectItem} from 'primeng/api';
import {isNullOrUndefined} from 'util';
import {AppService} from '../../app.service';
import {IngredientFormVO} from '../../models/ingredient-form-vo';
import {IngredientListVO} from '../../models/ingredient-list-vo';
import {NgForm} from '@angular/forms';
import {GrowlMessageService} from '../../services/growl-message.service';

@Component({
  selector: 'app-new-modify-ingredient',
  templateUrl: './new-modify-ingredient.component.html',
  styleUrls: ['./new-modify-ingredient.component.scss']
})
export class NewModifyIngredientComponent implements OnInit {
  public display: boolean;
  public displayedIngredient: IngredientFormVO;
  public quantityTypes: SelectItem[];

  private isExistingIngredient: boolean;

  @Input() recipeId: number;

  @Output() savingFinished: EventEmitter<void>;
  @Output() newRecipeNewIngredient: EventEmitter<IngredientFormVO>;
  @Output() newRecipeModifiedIngredient: EventEmitter<IngredientFormVO>;

  @ViewChild('ingredientForm') ingredientForm: NgForm;

  constructor(private appService: AppService,
              private growlMessageService: GrowlMessageService) {
    this.display = false;
    this.displayedIngredient = new IngredientFormVO();
    this.savingFinished = new EventEmitter<void>();
    this.newRecipeNewIngredient = new EventEmitter<IngredientFormVO>();
    this.newRecipeModifiedIngredient = new EventEmitter<IngredientFormVO>();
  }

  ngOnInit() {
    this.loadQuantityTypeOptions();
  }

  private loadQuantityTypeOptions(): void {
    this.appService.callRestGet('category/ingredient/list')
      .then(dataResponse => {
        this.quantityTypes = dataResponse.map(type => {
          return {label: type.name, value: type.id};
        });
        this.quantityTypes.unshift({label: '', value: null});
      });
  }

  public initDialog(ingredient?: IngredientListVO) {
    this.isExistingIngredient = !isNullOrUndefined(ingredient);
    if (this.isExistingIngredient) {
      this.setExistingIngredient(ingredient);
    } else {
      this.displayedIngredient = new IngredientFormVO();
    }
    this.openDialog();
  }

  private setExistingIngredient(ingredient: IngredientListVO): void {
    if (!isNullOrUndefined(this.recipeId)) {
      this.appService.callRestGet(`ingredient/get/${ingredient.id}`)
        .then(dataResponse => {
          this.displayedIngredient = new IngredientFormVO(dataResponse);
        });
    } else {
      this.displayedIngredient = IngredientListVO.createIngredientFormVO(this.getIngredientCopy(ingredient));
    }
  }

  private getIngredientCopy(ingredient: IngredientListVO) {
    return JSON.parse(JSON.stringify(ingredient));
  }

  public saveIngredient(): void {
    this.displayedIngredient.recipeId = this.recipeId;
    if (this.ingredientForm.dirty) {
      !isNullOrUndefined(this.recipeId) ? this.saveExistingRecipeIngredient() : this.saveNewRecipeIngredient();
    } else {
      this.growlMessageService.infoMessage('There were no changes to save!');
    }
  }

  private saveNewRecipeIngredient(): void {
    if (this.isExistingIngredient) {
      this.sendNewRecipeIngredient(this.newRecipeModifiedIngredient);
    } else {
      this.sendNewRecipeIngredient(this.newRecipeNewIngredient);
    }
  }

  private saveExistingRecipeIngredient(): void {
    this.isExistingIngredient ? this.updateIngredient() : this.addNewIngredient();
  }

  private addNewIngredient(): void {
    this.appService.callRestSave('ingredient/add', this.displayedIngredient, true)
      .then(() => {
        this.displayedIngredient = null;
        this.savingFinished.emit();
        this.hideDialog();
      });
  }

  private updateIngredient(): void {
    this.appService.callRestUpdate('ingredient/update', this.displayedIngredient, true)
      .then(() => {
        this.displayedIngredient = null;
        this.emitAndHideDialog();
      });
  }

  private sendNewRecipeIngredient(newRecipeIngredientEmitter: EventEmitter<IngredientFormVO>): void {
    this.setQuantityTypeName();
    newRecipeIngredientEmitter.emit(this.displayedIngredient);
    this.emitAndHideDialog();
  }

  private setQuantityTypeName(): void {
    const quantityTypeName = this.quantityTypes.find(type => type.value === this.displayedIngredient.quantityType).label;
    this.displayedIngredient.quantityTypeName = quantityTypeName;
  }

  private emitAndHideDialog(): void {
    this.savingFinished.emit();
    this.hideDialog();
  }

  private openDialog(): void {
    this.display = true;
  }

  public hideDialog() {
    this.display = false;
  }
}
