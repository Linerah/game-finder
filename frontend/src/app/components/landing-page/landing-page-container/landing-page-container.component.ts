import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-landing-page-container',
  templateUrl: './landing-page-container.component.html',
  styleUrls: ['./landing-page-container.component.css']
})
export class LandingPageContainerComponent implements OnInit {

  constructor() { }

  loadScripts(){
    let script = document.createElement('script');
    script.text = 'const tween = KUTE.fromTo(\n' +
      '          \'#blob1\',\n' +
      '          { path: \'#blob1\' },\n' +
      '          { path: \'#blob2\' },\n' +
      '          { repeat: 999, duration: 3000, yoyo: true }\n' +
      '        ).start();'
    let script2 = document.createElement('script');
    script2.text = 'const tween2 = KUTE.fromTo(\n' +
      '          \'#blob3\',\n' +
      '          { path: \'#blob3\' },\n' +
      '          { path: \'#blob4\' },\n' +
      '          { repeat: 999, duration: 3000, yoyo: true }\n' +
      '        ).start();'
    document.getElementsByClassName("blobs")[0].appendChild(script);
    document.getElementsByClassName("blobs")[0].appendChild(script2);
  }


  ngOnInit(): void {
    this.loadScripts();
  }

}
