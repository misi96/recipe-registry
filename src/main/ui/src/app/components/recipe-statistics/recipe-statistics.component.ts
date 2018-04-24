import {Component, OnInit} from '@angular/core';
import {AppService} from '../../app.service';

@Component({
  selector: 'app-recipe-statistics',
  templateUrl: './recipe-statistics.component.html',
  styleUrls: ['./recipe-statistics.component.scss']
})
export class RecipeStatisticsComponent implements OnInit {

  public data: any;

  private recipeCategoryNames: string[];
  private recipeCategoryValues: number[];

  constructor(private appService: AppService) {
  }

  ngOnInit() {
    this.initPieChart();
  }

  private initPieChart(): void {
    this.appService.callRestGet('statistics/get')
      .then(dataResponse => {
        this.recipeCategoryNames = dataResponse.map(category => category.categoryName);
        this.recipeCategoryValues = dataResponse.map(category => category.categoryValue);
        this.initData();
      });
  }

  private initData(): void {
    this.data = {
      labels: this.recipeCategoryNames,
      datasets: [
        {
          data: this.recipeCategoryValues,
          backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56", "#26d649", "#f40202", "#00f2ff", "#ff00e1", "#ccbdbd"],
          hoverBackgroundColor: ["#FF6384", "#36A2EB", "#FFCE56", "#26d649", "#f40202", "#00f2ff", "#ff00e1", "#ccbdbd"]
        }]
    };
  }

}
