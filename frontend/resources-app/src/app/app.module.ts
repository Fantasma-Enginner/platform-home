import { BrowserModule, platformBrowser } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { PlatformLocation } from '@angular/common';

import { environment } from 'src/environments/environment';
import { ResourcesComponent } from './resources/resources.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmptyRouteComponent } from './empty-route/empty-route.component';

import { ApiModule as ResourceAPI } from '@tsir/resources-api';
import { BASE_PATH as RESOURCES_PATH } from '@tsir/resources-api';
import { JwtModule } from '@auth0/angular-jwt';

const portGateway = 8760;

export function getPlatformURL(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : "http:";
  return `${protocol}//${pl.hostname}:${portGateway}/platform-manager/api/v1`;
}

export function tokenGetter() {
  return localStorage.getItem("token");
}

@NgModule({
  declarations: [
    AppComponent,
    ResourcesComponent,
    EmptyRouteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ResourceAPI,
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
      provide: RESOURCES_PATH, useFactory: getPlatformURL,
      deps: [PlatformLocation]
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
