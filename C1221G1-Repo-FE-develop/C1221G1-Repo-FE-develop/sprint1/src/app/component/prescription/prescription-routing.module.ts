import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PrescriptionListComponent} from './prescription-list/prescription-list.component';
import {PrescriptionCreateComponent} from './prescription-create/prescription-create.component';
import {PrescriptionEditComponent} from './prescription-edit/prescription-edit.component';
import {MedicinePrescriptionCreateComponent} from './medicine-prescription-create/medicine-prescription-create.component';
import {CustomerListComponent} from '../customer/customer-list/customer-list.component';
import {AuthGuard} from '../../service/security/auth.guard';


const routes: Routes = [
  {path: 'list', component: PrescriptionListComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }},
  {path: 'create', component: PrescriptionCreateComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }},
  {path: 'edit/:id', component: PrescriptionEditComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }},
  {path: 'create-medicine-prescription', component: MedicinePrescriptionCreateComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrescriptionRoutingModule { }
