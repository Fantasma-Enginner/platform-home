import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmptyRouteComponent } from './empty-route/empty-route.component';
import { PrimaryNavComponent } from './primary-nav/primary-nav.component';
import { LoginComponent } from './login/login.component';

import { ApiModule as ResourceAPI } from '@tsir/resources-api';
import { ApiModule as UserAPI, } from '@tsir/users-api';
import { BASE_PATH as RESOURCES_PATH } from '@tsir/resources-api';
import { BASE_PATH as MGMT_PATH } from '@tsir/users-api';
import { ReactiveFormsModule } from '@angular/forms';
import { PlatformLocation } from '@angular/common';
import { environment } from 'src/environments/environment';
import { HomeComponent } from './home/home.component';
import { HttpErrorInterceptor } from './helpers/http-error-interceptor';
import { JwtModule } from '@auth0/angular-jwt';

const portGateway = 8760;

export function getResourcesURL(pl: PlatformLocation) {
  const protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/platform-manager/api/v1`;
}

export function getUsersURL(pl: PlatformLocation) {
  const protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/settings-users/api/v1`;
}

export function tokenGetter() {
  return localStorage.getItem("token");
}

@NgModule({
  declarations: [
    AppComponent,
    EmptyRouteComponent,
    PrimaryNavComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ResourceAPI,
    UserAPI,
    HttpClientModule,
    ReactiveFormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter
      }
    }),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptor, multi: true
    },
    {
      provide: MGMT_PATH, useFactory: getUsersURL,
      deps: [PlatformLocation]
    },
    {
      provide: RESOURCES_PATH, useFactory: getResourcesURL,
      deps: [PlatformLocation]
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }


