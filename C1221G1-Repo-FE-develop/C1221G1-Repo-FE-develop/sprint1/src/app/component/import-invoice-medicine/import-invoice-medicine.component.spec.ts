import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportInvoiceMedicineComponent } from './import-invoice-medicine.component';

describe('ImportInvoiceMedicineComponent', () => {
  let component: ImportInvoiceMedicineComponent;
  let fixture: ComponentFixture<ImportInvoiceMedicineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportInvoiceMedicineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportInvoiceMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
