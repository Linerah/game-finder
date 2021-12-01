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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HomeContainerComponent } from './home/home-container/home-container.component';
import {AuthGuard} from "./auth-guard/auth-guard.service";
import { SignupComponent } from './signup/signup.component';
import { EditorModule } from '@tinymce/tinymce-angular';
import { HomeSidebarComponent } from './home/home-sidebar/home-sidebar.component';
import { HomeForumComponent } from './home/home-forum/home-forum.component';
import { HomePostComponent } from './home/home-post/home-post.component';
import{ HomeModule } from './home/home.module';




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
    HomeSidebarComponent,
    HomeForumComponent,
    HomePostComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    LandingPageModule,
    FormsModule,
    EditorModule,
    ReactiveFormsModule,
    HomeModule
  ],
  providers: [AppService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})

export class AppModule { }
