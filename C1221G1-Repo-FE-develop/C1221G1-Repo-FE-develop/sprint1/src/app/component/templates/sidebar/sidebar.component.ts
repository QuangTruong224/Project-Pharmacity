import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  isLogIn = false;
  username: string;

  constructor(private tokenStorageService: TokenStorageService,
              private router: Router) {}

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.isLogIn = true;
      this.username = this.tokenStorageService.getUser().username;
    }
  }


  signOut(e) {

    this.tokenStorageService.signOut();
    this.router.navigateByUrl('/log/sign-in').then();
    this.ngOnInit();

  }
}
