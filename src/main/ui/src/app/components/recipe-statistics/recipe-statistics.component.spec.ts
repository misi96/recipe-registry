import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeStatisticsComponent } from './recipe-statistics.component';

describe('RecipeStatisticsComponent', () => {
  let component: RecipeStatisticsComponent;
  let fixture: ComponentFixture<RecipeStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipeStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipeStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
