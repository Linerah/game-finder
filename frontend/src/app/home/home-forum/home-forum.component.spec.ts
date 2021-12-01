import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeForumComponent } from './home-forum.component';

describe('HomeForumComponent', () => {
  let component: HomeForumComponent;
  let fixture: ComponentFixture<HomeForumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeForumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeForumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
