import { Component, Output, EventEmitter, OnInit } from '@angular/core';
@Component({
  selector: 'app-home-sidebar',
  templateUrl: './home-sidebar.component.html',
  styleUrls: ['./home-sidebar.component.css']
})
export class HomeSidebarComponent implements OnInit {
  @Output() toggleFormEvent = new EventEmitter<boolean>();
  value: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  toggleForm() {
    this.value = !this.value;
    this.toggleFormEvent.emit(this.value);
  }

}
