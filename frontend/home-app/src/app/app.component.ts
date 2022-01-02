import { Component } from '@angular/core';
import { SessionService } from './services/session.service';

@Component({
  selector: 'home-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'home';

  constructor(private session: SessionService) { }


  isLogged(): boolean {
    return this.session.isLogged();
  }

}
