import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccountListComponent} from "./account-list/account-list.component";
import {AccountEditComponent} from "./account-edit/account-edit.component";
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: 'list', component: AccountListComponent,canActivate:[AuthGuard],data:{
    roles: ["ROLE_MANAGER"]
    }},
  {path: 'update/:id', component: AccountEditComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER"]
    }}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
