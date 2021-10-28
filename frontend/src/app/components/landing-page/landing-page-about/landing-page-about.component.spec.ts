import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandingPageAboutComponent } from './landing-page-about.component';

describe('LandingPageAboutComponent', () => {
  let component: LandingPageAboutComponent;
  let fixture: ComponentFixture<LandingPageAboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandingPageAboutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandingPageAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
