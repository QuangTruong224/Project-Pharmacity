import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportInvoiceCreateComponent } from './import-invoice-create.component';

describe('ImportInvoiceCreateComponent', () => {
  let component: ImportInvoiceCreateComponent;
  let fixture: ComponentFixture<ImportInvoiceCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportInvoiceCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportInvoiceCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
