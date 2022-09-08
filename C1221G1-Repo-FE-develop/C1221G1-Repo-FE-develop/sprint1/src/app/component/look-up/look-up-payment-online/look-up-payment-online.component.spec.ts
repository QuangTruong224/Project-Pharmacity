import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LookUpPaymentOnlineComponent } from './look-up-payment-online.component';

describe('LookUpPaymentOnlineComponent', () => {
  let component: LookUpPaymentOnlineComponent;
  let fixture: ComponentFixture<LookUpPaymentOnlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LookUpPaymentOnlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LookUpPaymentOnlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
