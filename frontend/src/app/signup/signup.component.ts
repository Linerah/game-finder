import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Player} from "../player/player";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  credentials = {  firstName: '', lastName: '', email: '', password: ''};
  direction = environment.apiBaseURL;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }
  //TODO: Change it so it calls a service with the http request inside
  //TODO: Also, using .subscribe() make it stay in the same page if something is wrong in the text.
  signup(){
     this.http.post<any>(`${this.direction}/registration`, this.credentials)
       .subscribe(response =>  console.log(response.json));
     this.router.navigateByUrl("/login");

  }
}
