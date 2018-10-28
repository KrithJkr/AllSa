import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmenudetailComponent } from './addmenudetail.component';

describe('AddmenudetailComponent', () => {
  let component: AddmenudetailComponent;
  let fixture: ComponentFixture<AddmenudetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmenudetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmenudetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
