import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Player } from './domain/player';
import { PlayerService } from './service/player.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public players!: Player[]; // the '!' lets angular know that the variable will be initialized.
  public title = "gamefinderapp";

  // Dependency Injection of the Service
  constructor(private playerService: PlayerService){}

  //this will run whenever the component is initialized.
  ngOnInit(){
    this.getPlayers();
  }

  public getPlayers(): void {
    this.playerService.getPlayers().subscribe(
      (response: Player[]) =>{
        this.players = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
