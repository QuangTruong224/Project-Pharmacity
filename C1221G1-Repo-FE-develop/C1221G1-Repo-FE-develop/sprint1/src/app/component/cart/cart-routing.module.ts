import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CartComponent} from './cart/cart.component';
import {PaymentOnlineComponent} from './payment-online/payment-online.component';
import {PaymentFinishComponent} from './payment-finish/payment-finish.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'details'},
  {path: 'details', component: CartComponent},
  {path: 'payment-online', component: PaymentOnlineComponent},
  {path: 'payment-success', component: PaymentFinishComponent},
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class CartRoutingModule {
}

