import {Component, OnInit} from '@angular/core';
import {SupplierService} from '../../../service/supplier.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-supplier-edit',
  templateUrl: './supplier-edit.component.html',
  styleUrls: ['./supplier-edit.component.css']
})
export class SupplierEditComponent implements OnInit {


  supplierForm: FormGroup;
  idSupplier: string = '';
  submitted = false;
  currentPage: number = 0;

  constructor(private supplierService: SupplierService,
              private activatedRoute: ActivatedRoute,
              private toastr: ToastrService,
              private router: Router) {
  }

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
   * read the value of API
   * method: get
   *  @23h 01/06/2022 LuatTN
   *   @this  get value  Supplier
   */
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idSupplier = paramMap.get('supplierId');
      this.getSupplier(this.idSupplier);
    });
  }

  /**
   * read the value of API
   * method: get
   *  @23h 01/06/2022 LuatTN
   *   @this  get value  Supplier
   */
  getSupplier(supplierId: string) {
    return this.supplierService.findById(supplierId).subscribe(supplier => {
      this.supplierForm = new FormGroup({
        supplierId: new FormControl(supplier.supplierId),
        supplierName: new FormControl(supplier.supplierName, [Validators.required,
          Validators.pattern("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")]),
        supplierAddress: new FormControl(supplier.supplierAddress),
        supplierPhone: new FormControl(supplier.supplierPhone, [Validators.required,
          Validators.pattern("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")]),
        supplierEmail: new FormControl(supplier.supplierEmail, [Validators.required,
          Validators.pattern("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")]),
        note: new FormControl(supplier.note)
      });
    });
  }

  /**
   * get the value Supplier
   * method: patch
   *  @23h 01/06/2022 LuatTN
   *  @this update Supplier
   *
   */
  updateSupplier() {
    this.submitted = true;

    const supplierValue = this.supplierForm.value;

    supplierValue.supplierName = supplierValue.supplierName.trim();
    supplierValue.supplierAddress = supplierValue.supplierAddress.trim();
    supplierValue.supplierEmail = supplierValue.supplierEmail.trim();
    supplierValue.supplierPhone = supplierValue.supplierPhone.trim();
    this.supplierService.updateSupplier(this.idSupplier, supplierValue).subscribe(next => {
      this.toastr.success('Cập Nhập Thông Tin Mới Cho Nhà Cung Cấp ' + this.supplierName.value, 'Thông Báo Hệ Thống ', {
        timeOut: 3000,
        progressBar: true
      });
      this.router.navigate(['supplier/']);
    }, e => {
    }, () => {
    });


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
