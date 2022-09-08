import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeCeateComponent} from './employee-ceate/employee-ceate.component';
import {EmployeeEditComponent} from './employee-edit/employee-edit.component';
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: 'list', component: EmployeeListComponent,canActivate:[AuthGuard],data:{

      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'create', component: EmployeeCeateComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER"]
    }},
  {path: 'edit/:id', component: EmployeeEditComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER"]
    }},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class EmployeeRoutingModule {
}



