import 'firebase/database';
import {TokenStorageService} from './service/security/token-storage.service';
import {AfterViewChecked, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import firebase from 'firebase/app';
import 'firebase/database';
import {config} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewChecked {
  title = 'pharmacy-manager';
  isGuest: boolean;
  user;

  constructor(private tokenStorageService: TokenStorageService,
              private cdr: ChangeDetectorRef) {
    firebase.initializeApp(config);
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
    if (this.user == null) {
      this.isGuest = true;
    }
    if (this.user != null) {
      if (this.user.roles[0] == 'ROLE_USER') {
        this.isGuest = true;
      } else {
        this.isGuest = false;
      }
    }
  }

  ngAfterViewChecked(): void {
    this.ngOnInit();
    this.cdr.detectChanges();
  }
}
