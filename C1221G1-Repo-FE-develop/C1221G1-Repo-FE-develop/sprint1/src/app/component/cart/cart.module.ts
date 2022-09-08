import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartRoutingModule } from './cart-routing.module';
import { CartModalComponent } from './cart-modal/cart-modal.component';
import {PaymentOnlineComponent} from "./payment-online/payment-online.component";
import {CartComponent} from "./cart/cart.component";
import {PaymentFinishComponent} from "./payment-finish/payment-finish.component";
import {NgxPayPalModule} from "ngx-paypal";
import {ReactiveFormsModule} from "@angular/forms";
import {NgxSpinnerModule} from "ngx-spinner";


@NgModule({
  declarations: [
    CartModalComponent,
    PaymentOnlineComponent,
    CartComponent,
    PaymentFinishComponent,],
  imports: [
    CommonModule,
    CartRoutingModule,
    NgxPayPalModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
  ]
})
export class CartModule { }
