import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrescriptionRoutingModule } from './prescription-routing.module';
import { PrescriptionModalComponent } from './prescription-modal/prescription-modal.component';
import {PrescriptionCreateComponent} from './prescription-create/prescription-create.component';
import {PrescriptionEditComponent} from './prescription-edit/prescription-edit.component';
import {PrescriptionListComponent} from './prescription-list/prescription-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MedicinePrescriptionCreateComponent } from './medicine-prescription-create/medicine-prescription-create.component';

@NgModule({
  declarations: [
    PrescriptionModalComponent,
    PrescriptionCreateComponent,
    PrescriptionEditComponent,
    PrescriptionListComponent,
    MedicinePrescriptionCreateComponent
  ],
  imports: [
    CommonModule,
    PrescriptionRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class PrescriptionModule { }
