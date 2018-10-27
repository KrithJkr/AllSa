import{async, ComponentFixture, TestBed}from '@angular/core/testing';

import {RestaComponent} from './resta.component';

describe('RestaComponent', () => {
  let component: RestaComponent;
  let fixture: ComponentFixture<RestaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
