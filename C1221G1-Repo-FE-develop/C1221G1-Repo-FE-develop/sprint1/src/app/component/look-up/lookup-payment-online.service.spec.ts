import { TestBed } from '@angular/core/testing';

import { LookupPaymentOnlineService } from './lookup-payment-online.service';

describe('LookupPaymentOnlineService', () => {
  let service: LookupPaymentOnlineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LookupPaymentOnlineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
