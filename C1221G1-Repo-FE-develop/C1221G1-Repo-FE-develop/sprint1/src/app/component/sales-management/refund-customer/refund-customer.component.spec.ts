import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RefundCustomerComponent } from './refund-customer.component';

describe('RefundCustomerComponent', () => {
  let component: RefundCustomerComponent;
  let fixture: ComponentFixture<RefundCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RefundCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RefundCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
