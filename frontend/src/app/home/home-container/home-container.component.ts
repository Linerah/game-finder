import { Component, OnInit } from '@angular/core';
import {AppService} from "../../app.service";

@Component({
  selector: 'app-home-container',
  templateUrl: './home-container.component.html',
  styleUrls: ['./home-container.component.css']
})
export class HomeContainerComponent implements OnInit {
  public formActive = false;

  constructor(private app: AppService) { }

  ngOnInit(): void {
  }

  private getPosts(){
    return this.app.getPosts();
  }

}
