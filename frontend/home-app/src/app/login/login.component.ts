import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { UsuariosService } from '@tsir/users-api';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { assetUrl } from 'src/single-spa/asset-url';

@Component({
  selector: 'home-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authenticationService: UsuariosService,
    private session: SessionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  message?: string;
  private error = false;
  private success = false;
  loginForm: FormGroup;
  private defaultRoute = '/home-app/intro';
  logoConcessionerUrl = './assets/img/logoCCFC.png';
  logoCompanyUrl = './assets/img/logoPlus.png';

  ngOnInit(): void {
    if (this.session.isLogged()) {
      this.router.navigate([this.defaultRoute]);
    } else {
      this.initLoginForm();
    }
  }

  onLogin() {
    const authData = this.loginForm.value;
    this.authenticationService.login(authData, 'response').subscribe(
      resp => {
        this.session.startSession(resp.headers.get('Authorization'));
        this.setSuccess('Bienvenido');
        this.router.navigate([this.defaultRoute]);
      },
      error => {
        this.setError('Credenciales no válidas');
      }
    );
  }

  private initLoginForm() {
    this.loginForm = this.formBuilder.group({
      user: ['', Validators.required],
      password: ['', Validators.required],
      cardId: [],
      fingerprint: []
    });
  }

  numberOnly(event: any): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;
  }

  isSuccess(): boolean {
    return this.success;
  }

  isError() {
    return this.error;
  }

  private setSuccess(message: string) {
    this.success = true;
    this.error = false;
    this.message = message;
  }

  private setError(message: string) {
    this.success = false;
    this.error = true;
    this.message = message;
  }

  clearMessage() {
    this.error = false;
    this.success = false;
    this.message = null;
  }

}
