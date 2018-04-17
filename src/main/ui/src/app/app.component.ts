import {Component, Renderer2} from '@angular/core';
import {Message} from 'primeng/primeng';
import {GrowlMessageService} from './services/growl-message.service';
import {NavigationStart, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  public messages: Message[];

  constructor(private growlMessageService: GrowlMessageService,
              private renderer: Renderer2,
              private router: Router) {
    this.subscribeToRouterEvent();
    this.subscribeToMessageEmitter();
  }

  private subscribeToMessageEmitter(): void {
    const callBack = message => {
      this.messages = [];
      this.messages.push(message);
    };
    this.growlMessageService.messageEmitter().subscribe(callBack);
  }

  private subscribeToRouterEvent(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        const urlBase = 'assets/layout/images/';
        switch (event.url) {
          case '/':
            this.renderer.setStyle(document.body, 'background', 'url(' + urlBase + 'table.jpg)');
            break;
          case '/recipes':
            this.renderer.setStyle(document.body, 'background', 'url(' + urlBase + 'platter.jpg)');
            break;
          case '/new-modify-recipe':
            this.renderer.setStyle(document.body, 'background', 'url(' + urlBase + 'burger.jpg)');
            break;
          case '/serving-calculator':
            this.renderer.setStyle(document.body, 'background', 'url(' + urlBase + 'tomato.jpg)');
            break;
          default:
            this.renderer.setStyle(document.body, 'background', 'url(' + urlBase + 'pizza.jpg)');
        }
      }
    });
  }
}
