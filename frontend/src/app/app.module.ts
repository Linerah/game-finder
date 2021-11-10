import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppService } from './app.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import{LandingPageModule} from './landing-page/landing-page.module';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {LandingPageContainerComponent} from "./landing-page/landing-page-container/landing-page-container.component";
import {FormsModule} from "@angular/forms";
import { HomeComponent } from './home/home.component';
import {AuthGuard} from "./auth-guard/auth-guard.service";
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'landing'},
  { path: 'landing', component: LandingPageContainerComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', canActivate: [AuthGuard] ,component: HomeContainerComponent},
  { path:'signup', component: SignupComponent},

];

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeContainerComponent,
    SignupComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    LandingPageModule,
    FormsModule
  ],
  providers: [AppService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})

export class AppModule { }
