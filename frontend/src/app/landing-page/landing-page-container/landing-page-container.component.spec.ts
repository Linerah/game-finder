import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandingPageContainerComponent } from './landing-page-container.component';

describe('LandingPageContainerComponent', () => {
  let component: LandingPageContainerComponent;
  let fixture: ComponentFixture<LandingPageContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandingPageContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandingPageContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
