import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingPageContainerComponent } from './landing-page-container/landing-page-container.component';
import { LandingPageAboutComponent } from './landing-page-about/landing-page-about.component';
import { LandingPageHelpComponent } from './landing-page-help/landing-page-help.component';
import { LandingPageMainComponent } from './landing-page-main/landing-page-main.component';



@NgModule({
  declarations: [
    LandingPageContainerComponent,
    LandingPageAboutComponent,
    LandingPageHelpComponent,
    LandingPageMainComponent,
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    LandingPageContainerComponent
  ]
})
export class LandingPageModule { }
