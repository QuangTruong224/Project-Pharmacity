import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LookUpPaymentOnlineComponent} from './look-up-payment-online/look-up-payment-online.component';
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: '', redirectTo: 'payment-online',canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'payment-online', component: LookUpPaymentOnlineComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class LookUpRoutingModule {
}

