import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PositionService} from '../../../service/employee/position.service';
import {EmployeeService} from '../../../service/employee/employee.service';
import {ToastrService} from 'ngx-toastr';
import {Employee} from '../../../model/employee/employee';
import {Position} from '../../../model/employee/position';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {


  @ViewChild('criteria') criteria: ElementRef;
  @ViewChild('valueSearchInput') valueSearchInput: ElementRef;
  @ViewChild('valueSearchDropDown') valueSearchDropDown: ElementRef;
  @ViewChild('valueSort') valueSort: ElementRef;
  public isInputHidden = true;
  public isSelectHidden = false;
  public positions: Position[];
  public employees: Employee[];
  public totalPages: number;
  public currentPage: number;
  public isHasContent = false;
  public employeeIdValue: string;
  public employeeNameValue: string;
  public drowDownValue: any = '';
  public str: string;
  constructor(private positionService: PositionService,
              private employeeService: EmployeeService,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllPosition();
    this.getAllEmployee();
  }

  getAllPosition() {
    this.positionService.getAllPosition().subscribe(positions => this.positions = positions);
  }

  getAllEmployee() {
    this.employeeService.getAllEmployee({
      page: 0, size: 8, employeeId: '', employeeName: '',
      position: '', employeeAddress: '', employeePhone: '', sort: ''
    }).subscribe(employees => {
      this.employees = employees['content'];
      this.currentPage = employees['number'];
      this.totalPages = employees['totalPages'];
      console.log(employees['content']);
    }, () => {
      this.employees = null;
      this.isHasContent = true;
      this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      });
    });
  }

  changeValueFind(value: any) {
    switch (value) {
      case 'code':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'name':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'position':
        this.isInputHidden = false;
        this.isSelectHidden = true;
        break;
      case 'address':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
      case 'phone':
        this.isInputHidden = true;
        this.isSelectHidden = false;
        break;
    }
  }

  search() {
    this.str = this.valueSearchInput.nativeElement.value;
    switch (this.criteria.nativeElement.value) {
      case 'code':
        if(this.str == '%'){
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !','Thông báo',{
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.employees = null;
        }
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: this.str.trim(), employeeName: '',
          position: '', employeeAddress: '', employeePhone: '', sort: ''
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'name':
        if(this.str == '%'){
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !','Thông báo',{
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.employees = null;
        }
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: this.str.trim(),
          position: '', employeeAddress: '', employeePhone: '', sort: ''
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'position':
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: this.valueSearchDropDown.nativeElement.value, employeeAddress: '', employeePhone: '', sort: ''
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        this.drowDownValue = this.valueSearchDropDown.nativeElement.value;
        break;
      case 'address':
        if(this.str == '%'){
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !','Thông báo',{
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.employees = null;
        }
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: '', employeeAddress: this.str.trim(), employeePhone: '', sort: ''
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
      case 'phone':
        if(this.str == '%'){
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !','Thông báo',{
            timeOut: 3000,
            progressBar: true
          });
          this.isHasContent = true;
          return this.employees = null;
        }
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: '', employeeAddress: '', employeePhone: this.str.trim(), sort: ''
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
          this.toastr.warning('Không tìm thấy dữ liệu tương ứng !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
        break;
    }
  }


  sortBy(value: any) {
    switch (this.criteria.nativeElement.value) {
      case 'code':
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: this.valueSearchInput.nativeElement.value, employeeName: '',
          position: '', employeeAddress: '', employeePhone: '', sort: value
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
        });
        break;
      case
      'name'
      :
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: this.valueSearchInput.nativeElement.value,
          position: '', employeeAddress: '', employeePhone: '', sort: value
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
        });
        break;
      case
      'position'
      :
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: this.valueSearchDropDown.nativeElement.value, employeeAddress: '', employeePhone: '', sort: value
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
        });
        break;
      case
      'address'
      :
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: '', employeeAddress: this.valueSearchInput.nativeElement.value, employeePhone: '', sort: value
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
        });
        break;
      case
      'phone'
      :
        this.employeeService.getAllEmployee({
          page: 0, size: 8, employeeId: '', employeeName: '',
          position: '', employeeAddress: '', employeePhone: this.valueSearchInput.nativeElement.value, sort: value
        }).subscribe(employees => {
          this.employees = employees['content'];
          this.currentPage = employees['number'];
          this.totalPages = employees['totalPages'];
          this.isHasContent = false;
        }, () => {
          this.employees = null;
          this.isHasContent = true;
        });
        break;
    }
  }


  previousPage() {
    console.log(this.currentPage);
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      console.log(this.currentPage);
      request['size'] = 8;
      request['sort'] = this.valueSort.nativeElement.value;
      switch (this.criteria.nativeElement.value) {
        case 'code':
          request['employeeId'] = this.valueSearchInput.nativeElement.value;
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'name':
          request['employeeId'] = '';
          request['employeeName'] = this.valueSearchInput.nativeElement.value;
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'position':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = this.valueSearchDropDown.nativeElement.value;
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'address':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = this.valueSearchInput.nativeElement.value;
          request['employeePhone'] = '';
          break;
        case 'phone':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = this.valueSearchInput.nativeElement.value;
          break;
      }
      this.employeeService.getAllEmployee(request).subscribe(employees => {
        this.employees = employees['content'];
        this.currentPage = employees['number'];
        this.totalPages = employees['totalPages'];
      }, () => {
      });
    }
  }

  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 8;
      request['sort'] = this.valueSort.nativeElement.value;
      switch (this.criteria.nativeElement.value) {
        case 'code':
          request['employeeId'] = this.valueSearchInput.nativeElement.value;
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'name':
          request['employeeId'] = '';
          request['employeeName'] = this.valueSearchInput.nativeElement.value;
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'position':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = this.valueSearchDropDown.nativeElement.value;
          request['employeeAddress'] = '';
          request['employeePhone'] = '';
          break;
        case 'address':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = this.valueSearchInput.nativeElement.value;
          request['employeePhone'] = '';
          break;
        case 'phone':
          request['employeeId'] = '';
          request['employeeName'] = '';
          request['position'] = '';
          request['employeeAddress'] = '';
          request['employeePhone'] = this.valueSearchInput.nativeElement.value;
          break;
      }
      this.employeeService.getAllEmployee(request).subscribe(employees => {
        this.employees = employees['content'];
        this.currentPage = employees['number'];
        this.totalPages = employees['totalPages'];
      }, () => {
      });
    }
  }

  getInforEmployeeDelete(employeeName: string, employeeId: string) {
    this.employeeIdValue = employeeId;
    this.employeeNameValue = employeeName;
  }

  deleteEmployeeByid(employeeIdValue: string) {
    this.employeeService.deleteEmployeeById(employeeIdValue).subscribe(() => {
      this.str = '';
      this.ngOnInit(),
        this.toastr.success('Xoá thành công!', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
    }, () =>
      this.toastr.warning('Không thể tìm thấy nhân viên cần xoá !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      }));
  }
}
