import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AppService } from "src/app/app.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private app: AppService, private router: Router
    ,) {}

  canActivate() {
    // Check to see if a user has a valid token
    if (this.app.authenticated) {
      // If they do, return true and allow the user to load app
      return true;
    }
    // If not, they redirect them to the login page
    this.router.navigateByUrl('/login');
    return false;
  }


}
