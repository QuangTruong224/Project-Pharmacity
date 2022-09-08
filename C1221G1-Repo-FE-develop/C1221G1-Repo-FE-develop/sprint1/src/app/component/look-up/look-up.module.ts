import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LookUpRoutingModule } from './look-up-routing.module';
import {LookUpPaymentOnlineComponent} from "./look-up-payment-online/look-up-payment-online.component";


@NgModule({
  declarations: [
    LookUpPaymentOnlineComponent
  ],
  imports: [
    CommonModule,
    LookUpRoutingModule
  ]
})
export class LookUpModule { }
