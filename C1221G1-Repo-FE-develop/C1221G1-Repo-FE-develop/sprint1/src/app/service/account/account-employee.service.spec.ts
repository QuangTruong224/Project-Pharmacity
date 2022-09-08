import { TestBed } from '@angular/core/testing';

import { AccountEmployeeService } from './account-employee.service';

describe('AccountEmployeeService', () => {
  let service: AccountEmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccountEmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
