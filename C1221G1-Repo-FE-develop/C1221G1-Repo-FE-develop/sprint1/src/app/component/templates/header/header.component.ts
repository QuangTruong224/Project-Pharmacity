import {AfterContentChecked, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareService} from '../../../share/ShareService';
import {MedicineHomePage} from '../../../dto/medicine/medicine-home-page';
import {TokenStorageService} from '../../../service/security/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit, AfterContentChecked {
  isLogIn = false;
  username: string;
  productQuantityInCart: number = 0;
  roles: string[];
  cartList: any[] = [];
  medicine = {} as MedicineHomePage;
  cartDetailDtos: any = [];
  medicineTypeList = [{id: 1, name: 'Bổ'}, {id: 2, name: 'Cảm'}];

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private tokenStorageService: TokenStorageService,
              private changeDetectorRef: ChangeDetectorRef,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.isLogIn = true;
      this.username = this.tokenStorageService.getUser().username;
      this.roles = this.tokenStorageService.getUser().roles;
    }
  }

  ngAfterContentChecked(): void {
    if (this.productQuantityInCart != 0) {
      this.productQuantityInCart = 0;
    }
    if (localStorage.getItem('cart')) {
      this.cartDetailDtos = JSON.parse(localStorage.getItem('cart'));
      this.productQuantityInCart += this.cartDetailDtos.length;
      this.changeDetectorRef.detectChanges();
    } else {
      this.productQuantityInCart = 0;
    }
    this.ngOnInit()
  }

  logout(e) {
    this.tokenStorageService.signOut();
    this.router.navigateByUrl("/log/sign-in").then();
    this.ngOnInit();
  }


  searchMedicine(name: HTMLInputElement, typeId: HTMLSelectElement) {
    this.medicine.medicineName = name.value;
    this.medicine.medicineTypeId = typeId.value;
    this.shareService.emitChange(this.medicine);
  }

}
