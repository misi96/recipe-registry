import {Component} from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {
  public display: boolean;

  constructor() {
    this.display = false;
  }

  public showSidebar(): void {
    this.display = true;
  }

  public hideSidebar(): void {
    this.display = false;
  }
}
