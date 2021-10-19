import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandingPageHelpComponent } from './landing-page-help.component';

describe('LandingPageHelpComponent', () => {
  let component: LandingPageHelpComponent;
  let fixture: ComponentFixture<LandingPageHelpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandingPageHelpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandingPageHelpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
