import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ReportListComponent} from './report-list/report-list.component';
import {StatistitalChartComponent} from './statistital-chart/statistital-chart.component';
import {AuthGuard} from "../../service/security/auth.guard";


const routes: Routes = [
  {path: 'report', component: ReportListComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
  {path: 'static', component: StatistitalChartComponent,canActivate:[AuthGuard],data:{
      roles: ["ROLE_MANAGER","ROLE_EMPLOYEE"]
    }},
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ReportRoutingModule {
}

