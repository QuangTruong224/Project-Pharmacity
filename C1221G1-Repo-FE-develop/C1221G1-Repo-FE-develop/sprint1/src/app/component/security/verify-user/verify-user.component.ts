import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SecurityService} from "../../../service/security/security.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-verify-user',
  templateUrl: './verify-user.component.html',
  styleUrls: ['./verify-user.component.css']
})
export class VerifyUserComponent implements OnInit {
  token :string;
  username:string;
  status :boolean;
  constructor(private activatedRoute: ActivatedRoute,
              private securityService:SecurityService,
              private toast:ToastrService,
              private router:Router) {
    this.token = this.activatedRoute.snapshot.paramMap.get('token');
    this.username = this.activatedRoute.snapshot.paramMap.get('username');
  }

  ngOnInit(): void {
    this.securityService.verifyUser(this.token,this.username).subscribe(
      next => {
        this.status = true;
        console.log(next);
        this.toast.success("Bạn đã xác nhận tài khoản thành công.","Chúc mừng")
        this.router.navigateByUrl('/home-page').then();
      },error => {
        this.status = false;
        console.log(error);
        this.toast.warning("Xác thực tài khoản thất bại vui lòng thử lại.","Thông báo")
      }
    )
  }

}
