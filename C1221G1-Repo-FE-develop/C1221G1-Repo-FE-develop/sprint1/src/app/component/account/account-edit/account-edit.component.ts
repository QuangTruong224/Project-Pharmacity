import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {AccountEmployeeService} from "../../../service/account/account-employee.service";
import {PositionService} from "../../../service/employee/position.service";
import {Position} from "../../../model/employee/position";

@Component({
  selector: 'app-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit {
  updateForm: FormGroup;
  id: string;
  positions: Position [];
  position: any;

  equals(item1, item2) {
    return item1 && item2 && item2.positionId === item1.positionId;
  };


  constructor(private accountEmployeeService: AccountEmployeeService,
              private positionService: PositionService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private toastr: ToastrService) {

  }

  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * get list position
  //  *
  ngOnInit(): void {
    this.positionService.getAllPosition().subscribe(position => {
      this.positions = position;
      this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        this.id = paramMap.get('id')
        this.accountEmployeeService.findAccountEmployeeById(this.id).subscribe(account => {
          for (let p of this.positions) {
            if (p.positionName === account.positionName) {
              this.position = p
            }
          }
          this.updateForm = new FormGroup({
            employeeId: new FormControl(account.employeeId),
            employeeName: new FormControl(account.employeeName),
            position: new FormControl(this.position, [Validators.required]),
            username: new FormControl(account.username),
            password: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$')])),
          })
        },() => this.toastr.warning("Không tìm thấy đối tượng chỉnh sửa !", "Thông báo", {
          timeOut: 2000,
          progressBar: true
        }));
      })
    });


  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * update account
  //  *
  update(id: string) {
    if (!this.updateForm.valid) {
      this.updateForm.markAllAsTouched();
    }
    if (this.updateForm.valid) {
      const account = this.updateForm.value;
      this.accountEmployeeService.update(id, account).subscribe(() => {
        this.toastr.success("Chỉnh sửa thành công !", "Thông báo", {
          timeOut: 2000,
          progressBar: true
        });
        this.router.navigateByUrl('/account/list');
      }, error => {
        this.toastr.warning("Chỉnh thất bại!", "Thông báo", {
          timeOut: 2000,
          progressBar: true
        });
      })
    }
  }
}
