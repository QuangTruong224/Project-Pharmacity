import {Component, OnInit} from '@angular/core';
import {AccountEmployee} from "../../../model/account/accountEmployee";
import {AccountEmployeeService} from "../../../service/account/account-employee.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Position} from "../../../model/employee/position";

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {
  accountEmployeeList: AccountEmployee [] = [];
  page = 0;
  name = '';
  id = '';
  username = '';
  position = '';
  public activeProjectIndex: number;
  idClick = '';
  totalPages = 0;
  pageSize: 0;
  firsts = false;
  last = false;
  flag = false;
  searchForm: FormGroup;


  constructor(private accountEmployeeService: AccountEmployeeService,
              private  router: Router) {
    this.searchForm = new FormGroup({
      typeSearch: new FormControl(''),
      inputSearch: new FormControl('')
    })
  }

  ngOnInit(): void {
    this.getAll()
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * list account
  //  *
  getAll() {
    this.accountEmployeeService.getAllAccountEmployee(
      this.id = '', this.name = '', this.position = '', this.username = '', this.page).subscribe
    ((data: any) => {
      if (data !=null) {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElemnts;
      }
    }, error => {

    });
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * pagination
  //  *

  previous() {
    if (this.page > 0) {
      this.accountEmployeeService.getAllAccountEmployee(this.id, this.name, this.position, this.username, this.page - 1).subscribe(
        (data: any) => {
          this.accountEmployeeList = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {

        }
      );
    }
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * pagination
  //  *
  next() {
    if (this.page < this.totalPages - 1) {
      this.accountEmployeeService.getAllAccountEmployee(this.id, this.name, this.position, this.username, this.page + 1).subscribe(
        data => {
          this.accountEmployeeList = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {

        }
      );
    }
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * search account
  //  *
  search() {
    const input = this.searchForm.get('inputSearch').value;
    const type = this.searchForm.get('typeSearch').value;

    if (type === 'id' && input.trim() !== '') {
      this.accountEmployeeService.getAllAccountEmployee(this.id = input.trim(), this.name = '', this.position = '', this.username = '', this.page).subscribe
      ((data: any) => {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
      }, error => {
        this.accountEmployeeList = null;
        this.page = 0;
        this.totalPages = 0;
      });
    } else if (type === 'username' && input.trim() !== '') {
      this.accountEmployeeService.getAllAccountEmployee(this.id = '', this.name = '', this.position = '', this.username = input.trim(), this.page).subscribe
      ((data: any) => {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
      }, error => {
        this.accountEmployeeList = null;
        this.page = 0;
        this.totalPages = 0;
      });
    } else if (type === 'name' && input.trim() !== '') {
      this.accountEmployeeService.getAllAccountEmployee(this.id = '', this.name = input.trim(), this.position = '', this.username = '', this.page).subscribe
      ((data: any) => {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
      }, error => {
        this.accountEmployeeList = null;
        this.page = 0;
        this.totalPages = 0;
      });
    } else if (type === 'position' && input.trim() !== '') {
      this.accountEmployeeService.getAllAccountEmployee(this.id = '', this.name = '', this.position = input.trim(), this.username = '', this.page).subscribe
      ((data: any) => {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
      }, error => {
        this.accountEmployeeList = null;
        this.page = 0;
        this.totalPages = 0;
      });
    } else if (input.trim() == '') {
      this.accountEmployeeService.getAllAccountEmployee(
        this.id = '', this.name = '', this.position = '', this.username = '', this.page).subscribe
      ((data: any) => {
        this.accountEmployeeList = data.content;
        this.page = data.number;
        this.totalPages = data.totalPages;
        this.firsts = data.first;
        this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
      }, error => {
      });
    }
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * choose index html, id employee
  //  *

  public activeProject(index: number, account: AccountEmployee): void {
    if (this.activeProjectIndex != index) {
      this.flag = true;
    } else {
      this.flag = !this.flag;
    }
    this.activeProjectIndex = index;
    if (this.flag == true) {
      this.idClick = account.employeeId;
    } else {
      this.idClick = '';
    }
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * check click edit
  //  *
  clickEdit(sucessButton: HTMLButtonElement) {
    if (this.idClick) {
      this.router.navigate(['/account/update/', this.idClick]);
    } else {
      sucessButton.click();
    }
  }
}
