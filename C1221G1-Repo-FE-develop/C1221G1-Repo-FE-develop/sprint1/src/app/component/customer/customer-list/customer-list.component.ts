import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {CustomerType} from '../../../model/customer/customer-type';
import {CustomerTypeService} from '../../../service/customer/customer-type.service';
import {CustomerService} from '../../../service/customer/customer.service';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})


export class CustomerListComponent implements OnInit {
  // public customers: Customer;
  public customer: Customer[];
  public customerType: CustomerType[];
  public totalPages: number;
  public currentPage: number;
  public data: any;
  public isChoosen: boolean;
  public choosenIndex: number;
  public choosenId: string;
  public idDelete: string;
  public nameDelete: string;
  public isInputHidden = true;
  public isSelectHidden = false;
  public check: string;
  public isHasContent = false;
  @ViewChild('keySearch1') keySearch1: ElementRef;
  @ViewChild('keySearch2') keySearch2: ElementRef;
  @ViewChild('sort') valueSort: ElementRef;
  @ViewChild('type') type: ElementRef;
  @ViewChild('valueSearchDropDown') typeSort: ElementRef;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCustomerToDisplay();
    this.getAllCustomerType();
    console.log(this.customerType);
  }

  /**
   * create by TinBQ
   * time: 01/07/2022
   * This method to get data from table customer in database
   */

  getAllCustomerToDisplay() {
    this.customerService.getAllCustomer({
      page: 0, size: 5, customerId: ''
      , customerType: '', customerName: '', customerAddress: '', customerPhone: '', sort: ''
    })
      .subscribe(customers => {
        this.customer = customers['content'];
        this.currentPage = customers['number'];
        this.totalPages = customers['totalPages'];
      }, () => {
        this.customer = null;
        this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
      }); }
  /**
   * create by TinBQ
   * time: 01/07/2022
   * This method to get data from table customer-type in database
   */
  getAllCustomerType() {
    this.customerTypeService.getAllCustomerType().subscribe(customerTypes => {
      this.customerType = customerTypes;
      console.log(this.customerType);
    });
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to transfer previous page
   */
  previousPage() {
    console.log(this.currentPage);
    const request = {};
    if ((this.currentPage) > 0) {
      // @ts-ignore
      request['page'] = this.currentPage - 1;
      // @ts-ignore
      request['size'] = 5;
      request['sort'] = this.valueSort.nativeElement.value;
      // @ts-ignore
      request['owner'] = this.ownerSearch;
      // @ts-ignore
      switch (this.keySearch1.nativeElement.value) {
        case 'noChoice':
          break;
        case 'customerId':
          request['customerId'] = this.keySearch2.nativeElement.value;
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerType':
          request['customerId'] = '';
          request['customerType']= this.typeSort.nativeElement.value;
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerName':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName']  = this.keySearch2.nativeElement.value;
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerAddress':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = this.keySearch2.nativeElement.value;
          request['customerPhone'] = '';
          break;
        case
        'customerPhone':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = this.keySearch2.nativeElement.value;
          break;
      }
      this.customerService.getAllCustomer(request)
        .subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
        }, () => {});
    }
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to transfer next page
   */
  nextPage() {
    console.log(this.currentPage);
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      // @ts-ignore
      request['page'] = this.currentPage + 1;
      // @ts-ignore
      request['size'] = 5;
      request['sort'] = this.valueSort.nativeElement.value;
      // @ts-ignore
      request['owner'] = this.ownerSearch;
      // @ts-ignore
      switch (this.keySearch1.nativeElement.value) {
        case 'customerId':
          request['customerId'] = this.keySearch2.nativeElement.value;
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerType':
          request['customerId'] = '';
          request['customerType']= this.typeSort.nativeElement.value;
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerName':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName']  = this.keySearch2.nativeElement.value;
          request['customerAddress'] = '';
          request['customerPhone'] = '';
          break;
        case
        'customerAddress':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = this.keySearch2.nativeElement.value;
          request['customerPhone'] = '';
          break;
        case
        'customerPhone':
          request['customerId'] = '';
          request['customerType'] = '';
          request['customerName'] = '';
          request['customerAddress'] = '';
          request['customerPhone'] = this.keySearch2.nativeElement.value;
          break;
      }
      this.customerService.getAllCustomer(request)
        .subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
        }, () => {});
    }
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to search customer base on condition
   */
  search() {
    this.check = this.keySearch2.nativeElement.value;
    switch (this.keySearch1.nativeElement.value) {
      case 'noChoice':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          page: 0
          , size: 5
          , customerId: this.keySearch2.nativeElement.value
          , customerType : this.keySearch2.nativeElement.value
          , customerPhone : this.keySearch2.nativeElement.value
          , customerAddress : this.keySearch2.nativeElement.value
          , customerName : this.keySearch2.nativeElement.value
          , sort: ''
        }).subscribe(customers => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        }, () => {});
        break;
      case 'customerId':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          customerId: this.check.trim()
          , page: 0
          , size: 5
          , customerType : ''
          , customerPhone : ''
          , customerAddress : ''
          , customerName : ''
          , sort: ''
        }).subscribe(customers =>  {
          if (customers !== null) {
            this.customer = customers['content'];
            this.currentPage = customers['number'];
            this.totalPages = customers['totalPages'];
          } else {
            this.customer = null;
            this.isHasContent = true;
            this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          }
        }, () => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'customerName':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          customerName: this.check.trim()
          , page: 0
          , size: 5
          , customerType : ''
          , customerPhone : ''
          , customerAddress : ''
          , customerId : ''
          , sort: ''
        }).subscribe(customers =>  {
          if (customers !== null) {
            this.customer = customers['content'];
            this.currentPage = customers['number'];
            this.totalPages = customers['totalPages'];
          } else {
            this.customer = null;
            this.isHasContent = true;
            this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          }
        }, () => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'customerType':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          customerType: this.typeSort.nativeElement.value
          , page: 0
          , size: 5
          , customerId : ''
          , customerPhone : ''
          , customerAddress : ''
          , customerName : ''
          , sort: ''
        }).subscribe(customers =>  {
          if (customers !== null) {
            this.customer = customers['content'];
            this.currentPage = customers['number'];
            this.totalPages = customers['totalPages'];
          } else {
            this.customer = null;
            this.isHasContent = true;
            this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          }
        }, () => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'customerAddress':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          customerAddress: this.check.trim()
          , page: 0
          , size: 5
          , customerType : ''
          , customerPhone : ''
          , customerId : ''
          , customerName : ''
          , sort: ''
        }).subscribe(customers =>  {
          if (customers !== null) {
            this.customer = customers['content'];
            this.currentPage = customers['number'];
            this.totalPages = customers['totalPages'];
          } else {
            this.customer = null;
            this.isHasContent = true;
            this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          }
        }, () => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'customerPhone':
        if (this.check === '%') {
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.customer = null;
        }
        this.customerService.getAllCustomer({
          page: 0
          , size: 5
          ,  customerPhone: this.check.trim()
          , customerType : ''
          , customerId : ''
          , customerAddress : ''
          , customerName : ''
          , sort: ''
        }).subscribe(customers =>  {
          if (customers !== null) {
            this.customer = customers['content'];
            this.currentPage = customers['number'];
            this.totalPages = customers['totalPages'];
          } else {
            this.customer = null;
            this.isHasContent = true;
            this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          }
        }, () => {
          this.customer = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
    }
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to soft customer base on condition
   */
  sortBy(value: any) {
    switch (this.valueSort.nativeElement.value) {
      case 'customer_id':
        this.customerService.getAllCustomer({
          page: 0, size: 5, customerId: this.keySearch2.nativeElement.value, customerType: '', customerName: '',
          customerPhone: '', customerAddress: '', sort: value
        }).subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.customer = null;
          this.isHasContent = true;
        });
        break;
      case 'customer_name':
        this.customerService.getAllCustomer({
          page: 0, size: 5, customerId: '', customerType: '', customerName: this.keySearch2.nativeElement.value,
          customerPhone: '', customerAddress: '', sort: value
        }).subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.customer = null;
          this.isHasContent = true;
        });
        break;
      case 'customer_address':
        this.customerService.getAllCustomer({
          page: 0, size: 5, customerId: '', customerType: '', customerName: '',
          customerPhone: '', customerAddress: this.keySearch2.nativeElement.value, sort: value
        }).subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.customer = null;
          this.isHasContent = true;
        });
        break;
      case 'customer_phone':
        this.customerService.getAllCustomer({
          page: 0, size: 5, customerId: '', customerType: '', customerName: '',
          customerPhone: this.keySearch2.nativeElement.value, customerAddress: '', sort: value
        }).subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.customer = null;
          this.isHasContent = true;
        });
        break;
      case 'customer_type_id':
        this.customerService.getAllCustomer({
          page: 0, size: 5, customerId: '', customerType: this.typeSort.nativeElement.value, customerName: '',
          customerPhone: '', customerAddress: '', sort: value
        }).subscribe(customers => {
          this.customer = customers['content'];
          this.currentPage = customers['number'];
          this.totalPages = customers['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.customer = null;
          this.isHasContent = true;
        });
        break;
    }
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to delet customer in database
   */
  deleteCustomer(customerId: string) {
    this.customerService.delete(customerId).subscribe(() => {
      this.toastr.success('Xóa Thành Công !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      });
      this.router.navigateByUrl('/customer/list');
      this.ngOnInit();
    });
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to get id delete customer
   */
  getValueToDelete(i: number, customerId: string, customerName: string) {
    if (this.choosenIndex !== i) {
      this.isChoosen = true;
      this.choosenIndex = i;
      this.choosenId = customerId;
    } else {
      this.isChoosen = !this.choosenId;
      this.choosenIndex = null;
      this.idDelete = null;
    }
    if (this.isChoosen) {
      this.idDelete = customerId;
      this.nameDelete = customerName;
    }
  }

  /**
   * create by TinBQ
   * time: 04/07/2022
   * This method to change drop down list when admin choose field'mã khách hàng'
   */
  changeValueFind(value: any) {
    console.log(value);
    switch (value) {
      case 'customerId':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'customerName':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'customerType':
        this.isInputHidden = false;
        this.isSelectHidden = true;
        break;
      case 'customerAddress':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'customerPhone':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
    }
  }


}
