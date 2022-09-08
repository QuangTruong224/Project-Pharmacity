import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicineCreateComponent} from './medicine-create/medicine-create.component';
import {MedicineEditComponent} from './medicine-edit/medicine-edit.component';
import {MedicineDetailComponent} from './medicine-detail/medicine-detail.component';
import {MedicineListComponent} from './medicine-list/medicine-list.component';
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: 'create', component: MedicineCreateComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'list', component: MedicineListComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'edit/:id', component: MedicineEditComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'detail/:medicineId', component: MedicineDetailComponent}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class MedicineRoutingModule {
}

