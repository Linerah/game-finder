import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {Player} from "./player/player";

@Injectable()
export class AppService {
  authenticated = false;
  direction = environment.apiBaseURL;

  constructor(private http: HttpClient) {
  }

  authenticate(credentials: any, callback: any) {

    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get(`${this.direction}/user`, {headers: headers}).subscribe(response => {
      // @ts-ignore
      if (response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }

  public getPosts() :Observable<any[]>{
    return this.http.get<any[]>(`${this.direction}/posts`);
  }

  public submitPost(post: any): Observable<Object>{
    return this.http.post(`${this.direction}/post`, post);
  }

}
