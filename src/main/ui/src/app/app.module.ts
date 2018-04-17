import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {
  ButtonModule,
  CalendarModule,
  ConfirmationService,
  ConfirmDialogModule,
  DataTableModule,
  DialogModule,
  DropdownModule,
  FieldsetModule,
  InputTextareaModule,
  InputTextModule,
  KeyFilterModule,
  OverlayPanelModule,
  ProgressBarModule,
  ScrollPanelModule,
  SelectButtonModule,
  SharedModule,
  SidebarModule,
  SpinnerModule
} from 'primeng/primeng';
import {AppRoutes} from './app.routes';
import {NewModifyRecipeComponent} from './components/new-modify-recipe/new-modify-recipe.component';
import {SidebarComponent} from './components/sidebar/sidebar.component';
import {RecipeListComponent} from './components/recipe-list/recipe-list.component';
import {AppService} from './app.service';
import {SliderModule} from 'primeng/slider';
import {IntroductionComponent} from './components/introduction/introduction.component';
import {GrowlMessageService} from './services/growl-message.service';
import {GrowlModule} from 'primeng/growl';
import {IngredientListComponent} from './components/ingredient-list/ingredient-list.component';
import {RatingModule} from 'primeng/rating';
import {NewModifyIngredientComponent} from './components/new-modify-ingredient/new-modify-ingredient.component';
import {StepsModule} from 'primeng/steps';
import {RecipeTableComponent} from './components/recipe-table/recipe-table.component';
import {ServingCalculatorComponent} from './components/serving-calculator/serving-calculator.component';

@NgModule({
  declarations: [
    AppComponent,
    NewModifyRecipeComponent,
    SidebarComponent,
    RecipeListComponent,
    ServingCalculatorComponent,
    IntroductionComponent,
    IngredientListComponent,
    NewModifyIngredientComponent,
    RecipeTableComponent
  ],
  imports: [
    AppRoutes,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    DataTableModule,
    SharedModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    CalendarModule,
    DropdownModule,
    ConfirmDialogModule,
    SidebarModule,
    ProgressBarModule,
    KeyFilterModule,
    SliderModule,
    SpinnerModule,
    GrowlModule,
    InputTextareaModule,
    RatingModule,
    FieldsetModule,
    StepsModule,
    OverlayPanelModule,
    SelectButtonModule,
    ScrollPanelModule
  ],
  providers: [AppService, ConfirmationService, GrowlMessageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
