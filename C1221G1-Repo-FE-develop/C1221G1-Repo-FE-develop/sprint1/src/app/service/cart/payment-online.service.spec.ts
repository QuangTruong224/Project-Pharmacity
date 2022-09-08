import { TestBed } from '@angular/core/testing';

import { PaymentOnlineService } from './payment-online.service';

describe('PaymentOnlineService', () => {
  let service: PaymentOnlineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaymentOnlineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
