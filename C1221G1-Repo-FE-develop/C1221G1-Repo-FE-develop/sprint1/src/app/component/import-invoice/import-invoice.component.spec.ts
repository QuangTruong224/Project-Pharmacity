import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {InvoiceListComponent} from '../sales-management/invoice-list/invoice-list.component';
import { ImportInvoiceComponent } from './import-invoice.component';

describe('ImportInvoiceComponent', () => {
  let component: ImportInvoiceComponent;
  let fixture: ComponentFixture<ImportInvoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportInvoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvoiceListComponent);
    fixture = TestBed.createComponent(ImportInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
