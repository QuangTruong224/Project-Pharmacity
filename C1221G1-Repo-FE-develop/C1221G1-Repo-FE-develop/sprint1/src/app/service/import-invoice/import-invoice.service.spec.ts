import { TestBed } from '@angular/core/testing';

import { ImportInvoiceService } from './import-invoice.service';

describe('ImportInvoiceService', () => {
  let service: ImportInvoiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImportInvoiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
