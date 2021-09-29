import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Player } from '../domain/player';
import { environment } from 'src/environments/environment';

// This makes the service available for the app.
@Injectable({providedIn: 'root'}) // or(exclusive) you could put it in providers.
export class PlayerService {
  private apiServerUrl = environment.apiBaseURL;

  // dependency injection http client in the service
  constructor(private http: HttpClient) { }

  // this method calls the http client, by doing a get to the url that we asigned.
  public getPlayers() :Observable<Player[]> {
    return this.http.get<Player[]>(`${this.apiServerUrl}/api/v1/player/all`);
  }

  public registerNewPlayer(player: Player) :Observable<Player> {
    return this.http.post<Player>(`${this.apiServerUrl}/api/v1/player/add`, player);
  }

 
  // To update email or name, add validators later ;P
  public updatePlayer(playerId: String, email: String, name: String) :Observable<Player> {
    if((email != null && email.length > 0) && (name != null && name.length > 0)){
      return this.http.put<Player>(`${this.apiServerUrl}/api/v1/player/update/${playerId}`, {name: `${name}`, email: `${email}`});
    }
    else if(email != null && email.length > 0){
      return this.http.put<Player>(`${this.apiServerUrl}/api/v1/player/update/${playerId}`, {email: `${email}`});
    }
    else if(name != null && name.length > 0){
      return this.http.put<Player>(`${this.apiServerUrl}/api/v1/player/update/${playerId}`, {name: `${name}`});
    }
    // this will not work, change it to an error statement. 
    return this.http.put<Player>(`${this.apiServerUrl}/api/v1/player/update/${playerId}`, null);
  
  }

  public deletePlayer(playerId: String) :Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/v1/player/delete/${playerId}`);
  }

}
