import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestainfoComponent } from './restainfo.component';

describe('RestainfoComponent', () => {
  let component: RestainfoComponent;
  let fixture: ComponentFixture<RestainfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestainfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestainfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
