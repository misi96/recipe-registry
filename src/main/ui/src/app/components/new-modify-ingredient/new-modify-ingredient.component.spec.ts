import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewModifyIngredientComponent } from './new-modify-ingredient.component';

describe('NewModifyIngredientComponent', () => {
  let component: NewModifyIngredientComponent;
  let fixture: ComponentFixture<NewModifyIngredientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewModifyIngredientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewModifyIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
