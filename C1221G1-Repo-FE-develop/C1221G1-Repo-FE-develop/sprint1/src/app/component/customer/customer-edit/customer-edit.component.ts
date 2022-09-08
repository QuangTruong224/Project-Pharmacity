import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../../../model/customer/customer-type';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerTypeService} from '../../../service/customer/customer-type.service';
import {CustomerService} from '../../../service/customer/customer.service';
import {Customer} from '../../../model/customer/customer';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer: Customer;
  customerId: string;
  customerTypeList: CustomerType[];
  age: number;

  updateForm = new FormGroup({
    customerId: new FormControl(''),
    customerName: new FormControl('', [Validators.required, Validators.minLength(2),
      Validators.maxLength(20), Validators.pattern('^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
    customerBirthday: new FormControl('', [Validators.required]),
    customerGender: new FormControl([Validators.required]),
    customerAddress: new FormControl(''),
    customerPhone: new FormControl('', [Validators.required,
      Validators.pattern('^(0?)(3[2-9]|5[6|9]|7[0|6-9]|8[0-6|9]|9[0-4|6-9])[0-9]{7}$')]),
    customerNote: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
    customerType: new FormControl('', [Validators.required])
  });

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private toastr: ToastrService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.customerId = paramMap.get('customerId');
      console.log(this.customerService.findById(this.customerId).subscribe(
        d => console.log(d)
      ));
    });
  }

  getCustomer(index: string) {
    return this.customerService.findById(index).subscribe(item => {
      this.customer = item;
      this.updateForm.patchValue(item);
    }, error => {
      this.toastr.warning('Không tìm thấy mã khách hàng ! ', '', {
        timeOut: 3000,
        progressBar: true
      });
      this.router.navigateByUrl('customer/list');
    });
  }

  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

  ngOnInit(): void {
    this.getList();
  }

  update(index: string) {
    if (!this.updateForm.valid) {
      this.updateForm.markAllAsTouched();
    }
    const value = this.updateForm.value;
    this.customerService.update(index, value).subscribe(() => {
      }, error => {
        this.toastr.warning('Bắt buộc phải nhập đúng thông tin !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });

      },
      () => {
        this.toastr.success('Chỉnh sửa thành công !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
        this.router.navigateByUrl('customer/list');
      });
  }

  getList() {
    this.customerTypeService.getAllCustomerType().subscribe(list => {
      this.customerTypeList = list;
    });
    this.getCustomer(this.customerId);
  }


  check() {
    const birthDay = new Date(this.updateForm.get('customerBirthday').value);
    // @ts-ignore
    const checkDay = Math.abs(Date.now() - birthDay);
    this.age = Math.floor((checkDay / (1000 * 3600 * 24)) / 365);
    if (this.age < 18) {
      this.updateForm.get('customerBirthday').setErrors({check: true});
    } else if (this.age >= 100) {
      this.updateForm.get('customerBirthday').setErrors({checkAge: true});
    }

  }
}
