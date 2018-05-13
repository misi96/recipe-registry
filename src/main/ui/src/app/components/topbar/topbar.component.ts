import {Component, ViewChild} from '@angular/core';
import {SidebarComponent} from '../sidebar/sidebar.component';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent {
  @ViewChild('sidebarComponent') sidebar: SidebarComponent;

  constructor() {
  }
}
