import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Player } from './player/player';
import { PlayerService } from './player/player.service';

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
    // this.loadScript();
  }

  public loadScript(){
      let node = document.createElement('script'); // creates the script tag
      node.src = 'https://cdn.jsdelivr.net/npm/kute.js@2.1.2/dist/kute.min.js'; // sets the source (insert url in between quotes)
      document.getElementsByTagName('head')[0].appendChild(node);

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
