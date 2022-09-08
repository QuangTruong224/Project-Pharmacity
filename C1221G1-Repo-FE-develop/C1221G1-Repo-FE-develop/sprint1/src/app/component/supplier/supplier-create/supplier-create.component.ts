import {Component, OnInit} from '@angular/core';
import {SupplierService} from '../../../service/supplier.service';
import {AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-supplier-create',
  templateUrl: './supplier-create.component.html',
  styleUrls: ['./supplier-create.component.css']
})
export class SupplierCreateComponent implements OnInit {

  constructor(private supplierService: SupplierService,
              private toastr: ToastrService,
              private router: Router) {
  }


  submitted = false;

  ngOnInit(): void {
  }

  /**
   * from bingding
   * @LuatTN 365
   */
  supplierForm: FormGroup = new FormGroup({
    supplierId: new FormControl(''),
    supplierName: new FormControl('', [Validators.required,
      Validators.pattern('^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$')]),
    supplierAddress: new FormControl(''),
    supplierPhone: new FormControl('',
      [Validators.required,
        Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')],
      [this.checkDuplicatePhone(this.supplierService)]
    ),
    supplierEmail: new FormControl('', [Validators.required,
      Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')], [this.checkDuplicateEmail(this.supplierService)]),
    note: new FormControl(''),
    flag: new FormControl(true)
  });

  get supplierName() {
    return this.supplierForm.get('supplierName');
  }

  get supplierAddress() {
    return this.supplierForm.get('supplierAddress');
  }

  get supplierPhone() {
    return this.supplierForm.get('supplierPhone');
  }

  get supplierEmail() {
    return this.supplierForm.get('supplierEmail');
  }

  /**
   * save the value
   * method: ngsubmit call saveSupplier() in service
   *  @23h 01/06/2022 LuatTN
   *  @this  save Supplier
   */
  createSupplier() {
    this.submitted = true;
    const supplierValue = this.supplierForm.value;
    if (this.supplierForm.valid) {
      supplierValue.supplierName = supplierValue.supplierName.trim();
      supplierValue.supplierAddress = supplierValue.supplierAddress.trim();
      supplierValue.supplierEmail = supplierValue.supplierEmail.trim();
      supplierValue.supplierPhone = supplierValue.supplierPhone.trim();
      this.supplierService.saveSupplier(supplierValue).subscribe(() => {
        this.supplierForm.reset();
        this.toastr.success('Thêm Mới Thành Công !', 'Thông Báo Chúc Mừng', {
          timeOut: 3000,
          progressBar: true
        });
        this.submitted = false;
      });
    } else {
      this.toastr.error('Bạn thêm mới thất bại  ', 'Thêm mới !', {
        timeOut: 1500,
        progressBar: true
      });
    }
  }

  /**
   * check phone exists
   *  @23h 01/06/2022 LuatTN
   * @param value
   * @finished!!
   */
  checkDuplicateEmail(supplierService: SupplierService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return supplierService
        .checkMailNotTaken(control.value)
        .pipe(
          map((result) => {
              return result ? null : {
                emailAlreadyExists: true
              };
            }
          )
        );
    };
  };

  /**
   * check phone exists
   *  @23h 01/06/2022 LuatTN
   * @param value
   * @finished!!
   */
  private checkDuplicatePhone(supplierService: SupplierService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return supplierService
        .checkPhoneNotTaken(control.value)
        .pipe(
          map((result) => {
              return result ? null : {
                phoneAlreadyExists: true
              };
            }
          )
        );
    };
  }
}
