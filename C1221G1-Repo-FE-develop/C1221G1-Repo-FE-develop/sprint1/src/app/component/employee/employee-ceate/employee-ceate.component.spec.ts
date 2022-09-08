import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeCeateComponent } from './employee-ceate.component';

describe('EmployeeCeateComponent', () => {
  let component: EmployeeCeateComponent;
  let fixture: ComponentFixture<EmployeeCeateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeCeateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCeateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
