import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PaymentOnlineDto} from '../../../dto/cart/PaymentOnlineDto';
import {LookupPaymentOnlineService} from '../lookup-payment-online.service';

@Component({
  selector: 'app-look-up-payment-online',
  templateUrl: './look-up-payment-online.component.html',
  styleUrls: ['./look-up-payment-online.component.css']
})
export class LookUpPaymentOnlineComponent implements OnInit {
  paymentOnlines: PaymentOnlineDto[] = [];
  @ViewChild('paymentIdSearch') paymentIdSearch: ElementRef;
  @ViewChild('customerNameSearch') customerNameSearch: ElementRef;
  paymentIdVal: string;
  customerNameVal: string;
  totalPages: number;
  currentPage: number;
  format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;

  constructor(private lookupPaymentOnlineService: LookupPaymentOnlineService) {
  }

  ngOnInit(): void {
    console.log(0);
    this.getPaymentOnlines({page: 0, size: 5});
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: Call service, Get payment online with param is request
   * @param request
   */
  private getPaymentOnlines(request) {
    this.lookupPaymentOnlineService.getAll(request)
      .subscribe(data => {
          console.log(data);
          this.paymentOnlines = data['content'];
          this.currentPage = data['number'];
          this.totalPages = data['totalPages'];
        }
        , error => {
          console.log(error);
          this.paymentOnlines = [];
        }
      );
  }

  private checkSpecialKey() {

  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: back to previous page.
   */
  previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      request['size'] = 5;
      request['paymentOnlineId'] = this.paymentIdSearch.nativeElement.value;
      request['customerName'] = this.customerNameSearch.nativeElement.value;
      this.getPaymentOnlines(request);
    }
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: jump to next page.
   */
  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 5;
      request['paymentOnlineId'] = this.paymentIdSearch.nativeElement.value;
      request['customerName'] = this.customerNameSearch.nativeElement.value;
      this.getPaymentOnlines(request);
    }
  }

  /**
   * Created by: KhoaPV
   * Date created: 02/7/2022
   * function: Get value of input search, and call method getPaymentOnline.
   */
  searchPaymentOnline() {
    this.paymentIdVal = this.paymentIdSearch.nativeElement.value;
    this.customerNameVal = this.customerNameSearch.nativeElement.value;
    if (this.format.test(this.customerNameVal) || this.format.test(this.paymentIdVal)) {
      this.paymentOnlines = [];
    } else {
      const request = {};
      request['page'] = 0;
      request['size'] = 5;
      request['paymentOnlineId'] = this.paymentIdSearch.nativeElement.value;
      request['customerName'] = this.customerNameSearch.nativeElement.value;
      this.getPaymentOnlines(request);
    }

  }
}
