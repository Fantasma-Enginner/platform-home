import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { assetUrl } from 'src/single-spa/asset-url';

import { RecursosService } from '@tsir/resources-api';
import { ResourceDTO } from '@tsir/resources-api';
import { Router } from '@angular/router';

import { JwtHelperService } from '@auth0/angular-jwt';
import { PerfilesService, ProfileDTO, UserDetailDTO, UsuariosService } from '@tsir/users-api';
import Swal from 'sweetalert2';

@Component({
  selector: 'home-navbar',
  templateUrl: './primary-nav.component.html',
  styleUrls: ['./primary-nav.component.css']
})
export class PrimaryNavComponent implements OnInit {

  logoConcessionerUrl = './assets/img/logoCCFC.png';

  isLogged = false;

  sections: Section[] = [];

  resources: ResourceDTO[] = [];

  userDetail: UserDetailDTO;
  userProfile?: ProfileDTO;

  userName?: string;
  profileName?: string;

  constructor(
    private session: SessionService,
    private resourceService: RecursosService,
    private usersService: UsuariosService,
    private profilesService: PerfilesService,
    private router: Router
  ) {
  }

  ngOnInit() {
    const helper = new JwtHelperService();
    const token = localStorage.getItem('token');
    if (helper.isTokenExpired(token)) {
      this.onLogout();
      Swal.fire('VIAL +', 'Su sesión ha expirado. Por favor autenticarse nuevamente', 'warning');
      return;
    }
    const decodeToken = helper.decodeToken(token);
    this.setSecurityConfiguration();
    this.loadResources();
    this.loadUserData(decodeToken.sub);
  }

  private setSecurityConfiguration(): void {
    this.resourceService.configuration.accessToken = localStorage.getItem('token');
    this.usersService.configuration.accessToken = localStorage.getItem('token');
    this.profilesService.configuration.accessToken = localStorage.getItem('token');
  }

  private loadUserData(code: number): void {
    this.usersService.getUser(code).subscribe(
      (respUser) => {
        this.userDetail = respUser;
        this.userName = this.userDetail.user.firstName + ' ' + this.userDetail.user.lastName;
        this.profilesService.getProfile(this.userDetail.enrollment.profile).subscribe(
          (respProf) => {
            this.userProfile = respProf;
            this.profileName = this.userProfile.name;
          }
        );
      }
    );
  }

  private loadResources(): void {
    this.resourceService.findResources().subscribe(
      (data) => {
        this.resources = data;
        this.loadMenu();
      }
    );
  }


  private loadMenu() {
    const map = new Map<number, Section>();
    this.resources.forEach(r => {
      if (!r.parent && !map.has(r.id)) {
        const apps: App[] = [];
        const section = new Section(r.label, r.icon, apps);
        map.set(r.id, section);
      } else {
        if (r.path) {
          const app = new App(r.label, r.path, r.icon);
          const section = map.get(r.parent);
          section.apps.push(app);
        }
      }
    });
    this.sections = [...map.values()];
  }

  onLogout() {
    this.session.stopSession();
    this.router.navigate(['/vial-plus']);
  }

}

export class App {

  constructor(public name: string, public url: string, public icon: string) {
  }

}

export class Section {

  constructor(public name: string, public icon: string, public apps: App[]) {
  }

  isEmpty(): boolean {
    return this.apps ? this.apps.length === 0 : true;
  }

}
