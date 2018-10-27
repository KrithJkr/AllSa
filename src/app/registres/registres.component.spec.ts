import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistresComponent } from './registres.component';

describe('RegistresComponent', () => {
  let component: RegistresComponent;
  let fixture: ComponentFixture<RegistresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
