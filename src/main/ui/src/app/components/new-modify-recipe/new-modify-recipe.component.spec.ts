import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewModifyRecipeComponent } from './new-modify-recipe.component';

describe('NewModifyRecipeComponent', () => {
  let component: NewModifyRecipeComponent;
  let fixture: ComponentFixture<NewModifyRecipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewModifyRecipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewModifyRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
