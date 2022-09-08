import {Component, OnInit} from '@angular/core';
import {AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {CustomerType} from '../../../model/customer/customer-type';
import {CustomerService} from '../../../service/customer/customer.service';
import {CustomerTypeService} from '../../../service/customer/customer-type.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  createForm: FormGroup;
  customerTypeList: CustomerType[];
  age: number;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private toastr: ToastrService,
              private router: Router) {
  }


  ngOnInit(): void {

    this.getCustomerType();
    this.createForm = new FormGroup({
      customerId: new FormControl(''),
      customerName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(20),
        Validators.pattern('^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
      customerBirthday: new FormControl('', [Validators.required]),
      customerGender: new FormControl('', [Validators.required]),
      customerAddress: new FormControl(''),
      customerPhone: new FormControl('', [Validators.required,
          Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]
        , this.checkDuplicatePhone(this.customerService),
      ),
      customerNote: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      customerType: new FormControl('', [Validators.required]),
    });
  }

  getCustomerType() {
    return this.customerTypeService.getAllCustomerType().subscribe(list => {
      this.customerTypeList = list;
    });
  }

  create() {
    // /** Để bắt lỗi khi submit
    if (!this.createForm.valid) {
      this.createForm.markAllAsTouched();
    }
    const customer = this.createForm.value;
    console.log(this.createForm.value);

    this.customerService.create(customer).subscribe(() => {
      }, error => {
        this.toastr.warning('Bắt buộc phải nhập đúng thông tin !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });

      },
      () => {
        this.toastr.success('Thêm mới thành công !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
        this.router.navigateByUrl('customer/list');
      });
  }

  private checkDuplicatePhone(customerService: CustomerService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return customerService
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

  check() {
    const birthDay = new Date(this.createForm.get('customerBirthday').value);
    // @ts-ignore
    const checkDay = Math.abs(Date.now() - birthDay);
    this.age = Math.floor((checkDay / (1000 * 3600 * 24)) / 365);
    if (this.age < 18) {
      this.createForm.get('customerBirthday').setErrors({check: true});
    } else if (this.age >= 100) {
      this.createForm.get('customerBirthday').setErrors({checkAge: true});
    }
  }
}
