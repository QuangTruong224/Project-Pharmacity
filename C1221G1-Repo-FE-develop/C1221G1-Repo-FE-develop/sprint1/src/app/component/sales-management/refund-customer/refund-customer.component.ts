import {ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {InvoiceWholesaleAndRefundService} from "../../../service/invoiceWholesaleAndRefund.service";
import {InvoiceDto} from "../../../dto/invoice-dto";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MedicineOfInvoiceDto} from "../../../dto/medicine-of-invoice-dto";
import {ListMedicineDto} from "../../../dto/list-medicine-dto";
import {InvoiceMedicine} from "../../../model/invoice-medicine";
import {Medicine} from "../../../model/medicine/medicine";
import {ToastrService} from "ngx-toastr";
import {Employee} from "../../../model/employee/employee";
import {TokenStorageService} from "../../../service/security/token-storage.service";


@Component({
  selector: 'app-refund-customer',
  templateUrl: './refund-customer.component.html',
  styleUrls: ['./refund-customer.component.css']
})
export class RefundCustomerComponent implements OnInit {
  invoice: InvoiceDto;
  medicineOfInvoiceList: MedicineOfInvoiceDto[] = [];
  searchInvoice: string;
  invoiceMedicineList: InvoiceMedicine[] = [];
  medicineRefundList: MedicineOfInvoiceDto[] = [];
  isShowMedicineList: boolean;
  invoiceForm: FormGroup;
  medicineList: MedicineOfInvoiceDto[] = [];
  medicineCurrent: MedicineOfInvoiceDto;
  invoiceMedicineSelectedArray: FormArray;
  medicineSelect: Medicine;
  employee: Employee;
  user: any;
  flag: boolean;
  quantityRefund: number;
  medicineDelete: Medicine;
  medicineSelectedArray: any;
  totalMoney: number;


  constructor(private invoiceService: InvoiceWholesaleAndRefundService, private fb: FormBuilder,
              private toastr: ToastrService, private tokenStorageService: TokenStorageService,private ref: ChangeDetectorRef) {
    this.invoiceForm = this.fb.group({
      medicineRefundList: this.fb.array(this.medicineList
        .map(invoiceMedicine => this.addNewMedicineRefund(invoiceMedicine)))
    })
  }

  ngOnInit(): void {
    this.getCurrentEmployee()
  }


  search() {
    this.invoiceService.search(this.searchInvoice).subscribe(data => {
      this.invoice = data;
    })
  }


  get invoiceMedicineSelected(): FormArray {
    this.invoiceMedicineSelectedArray = this.invoiceForm.get('medicineRefundList') as FormArray;
    return this.invoiceMedicineSelectedArray;
  }


  createInvoice() {
    this.medicineOfInvoiceList = this.invoiceMedicineSelected.value;
    for (let medicine of this.medicineOfInvoiceList) {
      if ((medicine.quantityRefund * medicine.medicine.medicineConversionRate) > medicine.invoiceMedicineQuantity) {
        this.toastr.warning("Số lượng trả " + medicine.medicineName + "sai", "Sai số lượng trả", {
          timeOut: 3000,
          progressBar: true
        });
      } else {
        let invoiceMedicine: any = {
          medicineId: medicine.medicine.medicineId,
          quantity: medicine.quantityRefund
        }
        this.invoiceMedicineList.push(invoiceMedicine);
      }
    }
    let invoice: any = {
      employeeId: this.employee.employeeId,
      customerId: this.invoice.customer.customerId,
      invoiceId: this.invoice.invoiceId,
      invoiceMedicineList: this.invoiceMedicineList,
    }
    console.log(invoice)
    if (invoice.invoiceMedicineList.length < 1) {
      this.toastr.warning("Bạn nhập sai thông tin !", "Hóa đơn hoàn trả", {
        timeOut: 3000,
        progressBar: true
      });
    } else {
      this.invoiceService.createRefundInvoice(invoice).subscribe(
        () => {
          this.toastr.success("Thêm mới thành công !", "Hóa đơn hoàn trả", {
            timeOut: 3000,
            progressBar: true
          })
          this.invoiceForm.reset();
          this.invoiceMedicineSelectedArray.controls.forEach(x => {
              let count = 0;
              this.invoiceMedicineSelectedArray.removeAt(count);
              count++;
            }
          );
          this.medicineOfInvoiceList = null;
          this.invoice = null;
        }, error => {
          this.toastr.warning("Bạn nhập sai thông tin", "Hóa đơn hoàn trả", {
            timeOut: 3000,
            progressBar: true
          });
          console.log(error)
        }
      )
    }
  }

  showChooseMedicine() {
    this.isShowMedicineList = !this.isShowMedicineList;
    this.invoiceService.getInvoiceMedicine(this.searchInvoice).subscribe(invoiceMedicine => {
      this.medicineOfInvoiceList = invoiceMedicine;
    })
  }

  importMedicine(medicine: any) {
    this.isShowMedicineList = !this.isShowMedicineList
    this.medicineCurrent = medicine;
    const invoiceRefund = this.addNewMedicineRefund(this.medicineCurrent);
    const myArray = this.invoiceMedicineSelected.value;
    const test = myArray.filter(data => data.medicine.medicineId == invoiceRefund.value.medicine.medicineId && invoiceRefund.value.medicine.medicineId != '')
    if (this.medicineCurrent.medicine.medicineId == '' || this.medicineCurrent.medicine.medicineName == '' || test.length > 0) {
      this.flag = true;
    } else {
      this.flag = false;
    }
    console.log(this.flag)
    if (!this.flag) {
      this.invoiceMedicineSelected.push(invoiceRefund);
    }
  }

  private addNewMedicineRefund(invoiceMedicine: MedicineOfInvoiceDto) {
    return this.fb.group({
      medicineName: [this.medicineSelect.medicineName],
      medicine: [this.medicineSelect],
      quantityRefund:[1, [Validators.required, Validators.min(0), Validators.pattern('^[0]?[1-9]+[0-9]*$')]],
      medicineUnit: [this.medicineSelect.medicineUnit.medicineUnitName],
      invoiceMedicineQuantity: [invoiceMedicine.invoiceMedicineQuantity],
      price: [this.medicineSelect.medicineImportPrice + ((this.medicineSelect.medicineWholesaleProfit) / 100 * this.medicineSelect.medicineImportPrice)],
      moneyOfMedicine: 0,
    })


  }

  sendMedicine(medicine: Medicine) {
    this.medicineSelect = medicine;
  }

  getCurrentEmployee() {
    this.user = this.tokenStorageService.getUser();
    this.invoiceService.getListEmployee().subscribe(employees => {
      employees.forEach(e => {
        if (e.employeeUsername.username == this.user.username) {
          this.employee = e;
        }
      });
    }, error => {
      console.log(error)
    });
  }

  updateTotal() {
    const ctrl = this.invoiceForm.controls.medicineRefundList as FormArray;
    console.log(ctrl);
    this.totalMoney = 0;
    ctrl.controls.forEach(x => {
      const parsed = parseFloat((x.get('moneyOfMedicine').value));
      console.log(parsed);
      this.totalMoney += parsed;
      console.log(this.totalMoney)
      this.ref.detectChanges();
    });
  }

  sendMedicineDelete(medicine: Medicine) {
    this.medicineDelete = medicine
  }

  sendMedicineToDelete(i: number) {
    this.invoiceMedicineSelectedArray.removeAt(i);
    const index = this.medicineSelectedArray.indexOf(this.medicineDelete);
    if (index > -1) {
      this.medicineSelectedArray.splice(index, 1);
    }
  }
}
