import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImportInvoiceListComponent} from './import-invoice-list/import-invoice-list.component';
import {ImportInvoiceCreateComponent} from "./import-invoice-create/import-invoice-create.component";
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: '', component: ImportInvoiceListComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'create', component: ImportInvoiceCreateComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImportInvoiceRoutingModule { }
