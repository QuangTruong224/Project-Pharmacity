import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReportRoutingModule } from './report-routing.module';
import {StatistitalChartComponent} from "./statistital-chart/statistital-chart.component";
import {ReportListComponent} from "./report-list/report-list.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    StatistitalChartComponent,
    ReportListComponent,
  ],
    imports: [
        CommonModule,
        ReportRoutingModule,
        ReactiveFormsModule
    ]
})
export class ReportModule { }
