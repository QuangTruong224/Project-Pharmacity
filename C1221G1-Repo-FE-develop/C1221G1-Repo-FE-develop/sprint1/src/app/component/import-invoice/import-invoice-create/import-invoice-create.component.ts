import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Medicine} from '../../../model/medicine/medicine';
import {ImportInvoiceMedicine} from '../../../model/import-invoice/import-invoice-medicine';
import {Employee} from '../../../model/employee/employee';
import {Supplier} from '../../../model/Supplier';
import {ImportInvoiceService} from '../../../service/import-invoice/import-invoice.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {Users} from '../../../model/users/users';

@Component({
  selector: 'app-import-invoice-create',
  templateUrl: './import-invoice-create.component.html',
  styleUrls: ['./import-invoice-create.component.css']
})
export class ImportInvoiceCreateComponent implements OnInit {
  createImportInvoiceForm: FormGroup;
  suppliers: Supplier[];
  selectedSupplier: Supplier;
  public now: Date = new Date();
  medicines: Medicine[];
  medicineList: Medicine[] = [];
  importInvoiceMedicineList: ImportInvoiceMedicine[];
  flagNoMedicine = true;
  isShowMedicineList = false;
  medicineCurrent: ImportInvoiceMedicine;
  intoMoney = 0;
  totalMoney = 0;
  prePayment = 0;
  remainMoney = 0;
  employees: Employee[];
  defaultEmployee: Employee;
  medicineSelected: Medicine;
  importInvoiceMedicineSelectedArray: FormArray;
  cartEmpty = false;
  cartMedicine: boolean;
  quantityCart = 0;
  medicineSelectedArray: Array<Medicine> = [];
  flagExistMedicine = false;
  medicineDelete: Medicine;
  checkInvalidRemainMoney = false;
  checkInvalidRemainMoney2 = false;
  private user: Users;

  getEmployee() {
    this.user = this.tokenStorageService.getUser();
    this.importInvoiceService.getEmployee().subscribe(employees => {
      employees.forEach(e => {
        if (e.employeeUsername.username === this.user.username) {
          this.defaultEmployee = e;
        }
      });
    }, error => {
      console.log(error);
    });
  }

  constructor(private fb: FormBuilder,
              private ref: ChangeDetectorRef,
              private importInvoiceService: ImportInvoiceService,
              private toastr: ToastrService,
              private route: Router,
              private tokenStorageService: TokenStorageService) {
    importInvoiceService.getSupplierList().subscribe(suppliers => {
      this.importInvoiceService.getMedicineList().subscribe(medicines => {
        this.medicines = medicines;
        this.suppliers = suppliers;
        this.selectedSupplier = this.suppliers[0];
        importInvoiceService.getEmployee().subscribe(employees => {
          // this.employees = employees;
          // this.defaultEmployee = employees[10];
          this.getEmployee();
          console.log(this.defaultEmployee);
          this.createImportInvoiceForm = this.fb.group({
            importInvoiceId: this.fb.control(''),
            importSystemCode: this.fb.control('', [Validators.required, Validators.pattern('^[0]?[1-9]+[0-9]*$')]),
            paymentPrepayment: this.fb.control('', [Validators.required]),
            total: '',
            importInvoiceDate: (this.now.getFullYear().toString() + '/' + '0' + (this.now.getMonth() + 1).toString().slice(-2)
              + '/' + '0' + this.now.getDate().toString().slice(-2)),
            importInvoiceHour: (this.now.toTimeString().slice(0, 5)),
            supplier: (this.suppliers[0]),
            employee: this.defaultEmployee,
            flag: true,
            importInvoiceMedicineList: this.fb.array(this.medicineList
              .map(importInvoiceMedicine => this.addNewImportInvoiceMedicine(importInvoiceMedicine))),
          });
        });
      });
    });
  }

  ngOnInit() {
    this.checkNoMedicine();
  }

  equal(item1, item2) {
    return item1 && item2 && item1.supplierId === item2.supplierId;
  }

  // create by TrungTVH 2/7/2022: -> listen change from supplier selected
  onChange($event) {
    this.selectedSupplier = $event;
  }

  get importInvoiceMedicineListSelected(): FormArray {
    this.importInvoiceMedicineSelectedArray = this.createImportInvoiceForm.get('importInvoiceMedicineList') as FormArray;
    return this.importInvoiceMedicineSelectedArray;
  }

  checkNoMedicine() {
    if (this.importInvoiceMedicineSelectedArray.length === 0) {
      this.flagNoMedicine = true;
      return true;
    } else {
      this.flagNoMedicine = false;
      return false;
    }
  }

  checkExistMedicine(medicine: Medicine) {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.medicineSelectedArray.length; i++) {
      if (this.medicineSelectedArray[i] === medicine && this.medicineSelectedArray[i] !== null) {
        this.flagExistMedicine = true;
        break;
      } else {
        this.flagExistMedicine = false;
      }
    }
  }

  chooseMedicine() {
    this.cartMedicine = false;
    this.isShowMedicineList = true;
  }

  importMedicine(importInvoiceMedicine: ImportInvoiceMedicine) {
    this.medicineCurrent = importInvoiceMedicine;
    const importInvoiceMedicineForm = this.addNewImportInvoiceMedicine(this.medicineCurrent);
    this.checkExistMedicine(this.medicineSelected);
    if (this.flagExistMedicine === false) {
      this.medicineSelectedArray.push(this.medicineSelected);
      this.importInvoiceMedicineListSelected.push(importInvoiceMedicineForm);
      this.checkNoMedicine();
      this.updateQuantityCart();
      this.cartEmpty = false;
    } else {
      this.toastr.warning('Thuốc ' + this.medicineSelected.medicineName + ' đã có trong hoá đơn!', 'Hệ thống thông báo', {
        timeOut: 3000,
        progressBar: true
      });
    }
  }

  addNewImportInvoiceMedicine(importInvoiceMedicine: ImportInvoiceMedicine) {
    return this.fb.group({
      id: [this.medicineSelected.medicineId],
      importInvoiceMedicineId: [importInvoiceMedicine.importInvoiceMedicineId],
      medicineUnit: [importInvoiceMedicine.medicineUnit.medicineUnitName],
      intoMoney: 0,
      medicine: this.medicineSelected,
      medicineName: this.medicineSelected.medicineName,
      importInvoiceMedicineImportPrice: [this.medicineCurrent.medicineImportPrice],
      importInvoiceMedicineImportAmount: [1, [Validators.required, Validators.min(0), Validators.pattern('^[0]?[1-9]+[0-9]*$')]],
      importInvoiceMedicineDiscountRate: [this.medicineSelected.medicineDiscount],
      importInvoiceMedicineExpiry: ['', [Validators.required]],
      importInvoiceMedicineVat: [this.medicineSelected.medicineTax],
      importInvoiceMedicineLotNumber: ['', [Validators.required]],
      flag: true
    });
  }

  updateRemain() {
    const tempRemainMoney = this.totalMoney - this.prePayment;
    if (isNaN(this.prePayment) || this.prePayment < 0) {
      this.checkInvalidRemainMoney2 = true;
    } else if (tempRemainMoney < 0) {
      this.checkInvalidRemainMoney2 = false;
      this.checkInvalidRemainMoney = true;
    } else {
      this.remainMoney = tempRemainMoney;
      this.checkInvalidRemainMoney2 = false;
      this.checkInvalidRemainMoney = false;
    }
  }

  sendMedicine(medicine: Medicine) {
    this.medicineSelected = medicine;
  }

  showMedicineImportList() {
    this.isShowMedicineList = false;
    this.cartMedicine = true;
  }

  sendMedicineToDelete(i: number) {
    this.importInvoiceMedicineSelectedArray.removeAt(i);
    const index = this.medicineSelectedArray.indexOf(this.medicineDelete);
    if (index > -1) {
      this.medicineSelectedArray.splice(index, 1);
    }
    this.updateTotal();
    this.updateQuantityCart();
    this.checkNoMedicine();
  }

  sendMedicineDelete(medicine: Medicine) {
    this.medicineDelete = medicine;
  }

  updateQuantityCart() {
    this.quantityCart = this.importInvoiceMedicineSelectedArray.length;
  }

  updateTotal() {
    const ctrl = this.createImportInvoiceForm.controls.importInvoiceMedicineList as FormArray;
    this.totalMoney = 0;
    ctrl.controls.forEach(x => {
      const parsed = parseFloat((x.get('intoMoney').value));
      this.totalMoney += parsed;
      this.ref.detectChanges();
    });
    this.updateRemain();
    this.updateQuantityCart();
  }

  createNewImportInvoice() {
    if (this.checkNoMedicine()) {
      this.toastr.warning('Vui lòng chọn thuốc!', 'Hệ thống thông báo', {
        timeOut: 3000,
        progressBar: true
      });
    } else {
      if (this.createImportInvoiceForm.valid) {
        this.importInvoiceService.save(this.createImportInvoiceForm.value).subscribe(() =>
          console.log('saved'));
        this.toastr.success('Tạo Hoá Đơn Nhập Kho Thành Công !', 'Hệ thống thông báo', {
          timeOut: 3000,
          progressBar: true
        });
        this.createImportInvoiceForm.reset();
        this.importInvoiceMedicineSelectedArray.controls.forEach(x => {
            let count = 0;
            this.importInvoiceMedicineSelectedArray.removeAt(count);
            count++;
          }
        );
        this.updateQuantityCart();
        this.checkNoMedicine();
        this.route.navigateByUrl('/import-invoice');
      } else {
        this.toastr.warning('Thông tin hoá đơn không hợp lệ!', 'Hệ thống thông báo', {
          timeOut: 3000,
          progressBar: true
        });
      }
    }
  }

  payOff() {
    this.prePayment = this.totalMoney;
    this.updateRemain();
  }
}
