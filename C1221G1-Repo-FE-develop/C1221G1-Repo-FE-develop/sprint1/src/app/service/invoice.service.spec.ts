import { TestBed } from '@angular/core/testing';

import { InvoiceWholesaleAndRefundService } from './invoiceWholesaleAndRefund.service';

describe('InvoiceService', () => {
  let service: InvoiceWholesaleAndRefundService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvoiceWholesaleAndRefundService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
