import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServingCalculatorComponent } from './serving-calculator.component';

describe('FoodServingsCalculatorComponent', () => {
  let component: ServingCalculatorComponent;
  let fixture: ComponentFixture<ServingCalculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServingCalculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServingCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
