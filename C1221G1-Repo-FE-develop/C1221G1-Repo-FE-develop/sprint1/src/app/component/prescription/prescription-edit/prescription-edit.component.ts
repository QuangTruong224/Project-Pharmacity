import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Prescription} from '../../../models/prescription/prescription';
import {PrescriptionService} from '../../../services/prescription/prescription.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {MedicinePrescriptionService} from '../../../services/prescription/medicine-prescription.service';
import {Medicine} from '../../../models/medicine/medicine';
import {MedicineService} from '../../../services/medicine.service';
import {MedicinePrescription} from '../../../models/prescription/medicine-prescription';

@Component({
  selector: 'app-prescription-edit',
  templateUrl: './prescription-edit.component.html',
  styleUrls: ['./prescription-edit.component.css']
})
export class PrescriptionEditComponent implements OnInit {


  constructor(private prescriptionService: PrescriptionService,
              private medicinePrescriptionService: MedicinePrescriptionService,
              private medicineService: MedicineService,
              private toastr: ToastrService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.prescriptionId = paramMap.get('id');
      this.getPrescription(this.prescriptionId);
    });
  }

  // prescriptionss: Prescription;
  // medicinePres: MedicinePrescription;
  // medicineType: Medicine[];
  // prescriptionType: Prescription[];
  prescriptionForm: FormGroup;
  prescriptionId: string;
  // medicinePrescriptionForm: FormGroup;
  // medicinePrescriptionId: number;

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.prescriptionId = paramMap.get('id');
      this.getPrescription(this.prescriptionId);
    });
  }

  getPrescription(prescriptionId: string) {
    return this.prescriptionService.getPrescriptionById(prescriptionId).subscribe(prescription => {
      this.prescriptionForm = new FormGroup({
        prescriptionId: new FormControl(prescription.prescriptionId),
        prescriptionName: new FormControl(prescription.prescriptionName, [Validators.required, Validators.minLength(5),
          Validators.maxLength(50), Validators.pattern('^[^!@#$%^&*()]*$')]),
        prescriptionSymptom: new FormControl(prescription.prescriptionSymptom, [Validators.required, Validators.minLength(5),
          Validators.maxLength(100), Validators.pattern('^[^!@#$%^&*()]*$')]),
        prescriptionTargetUser: new FormControl(prescription.prescriptionTargetUser, [Validators.required]),
        prescriptionNote: new FormControl(prescription.prescriptionNote, [Validators.required, Validators.minLength(5),
          Validators.maxLength(100), Validators.pattern('^[^!@#$%^&*()]*$')]),
        prescriptionNumberOfDays: new FormControl(prescription.prescriptionNumberOfDays, [Validators.required, Validators.min(1),
          Validators.max(365)]),
        flag: new FormControl(prescription.flag)
      });
    });
  }

  // getMedicinePrescription(medicinePrescriptionId: number) {
  //   return this.medicinePrescriptionService.getMedicinePrescriptionById(medicinePrescriptionId).subscribe(mPrescription => {
  //     this.medicinePrescriptionForm = new FormGroup({
  //       medicinePrescriptionId: new FormControl(mPrescription.medicinePrescriptionId),
  //       medicinePrescriptionTimes: new FormControl(mPrescription.medicinePrescriptionTimes,
  //         [Validators.required, Validators.minLength(1), Validators.maxLength(10)]),
  //       medicinePrescriptionNumberPerTime: new FormControl(mPrescription.medicinePrescriptionNumberPerTime,
  //         [Validators.required, Validators.minLength(1), Validators.maxLength(50)]),
  //       medicine: new FormControl(mPrescription.medicine, [Validators.required]),
  //       prescription: new FormControl(mPrescription.prescription, [Validators.required])
  //     });
  //   });
  // }

  updatePrescription(prescriptionId: string) {
    const prescription = this.prescriptionForm.value;
    this.prescriptionService.editPrescription(prescriptionId, prescription).subscribe(() => {
      this.toastr.success('Chỉnh sửa thành công !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      });
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigate(['/prescription/list']);
    });
  }

  // updateMedicinePrescription(medicinePrescriptionId: number) {
  //   const medicinePrescription = this.medicinePrescriptionForm.value;
  //   this.medicinePrescriptionService.editMedicinePrescription(medicinePrescriptionId, medicinePrescription).subscribe(() => {
  //     this.toastr.success('Chỉnh sửa thành công !', 'Thông báo', {
  //       timeOut: 3000,
  //       progressBar: true
  //     });
  //   }, e => {
  //     console.log(e);
  //   }, () => {
  //     this.router.navigate(['/prescription/list']);
  //   });
  // }

  // equals = (item1: string, item2: string) => {
  //   item1 = this.prescriptionss.prescriptionId;
  //   item2 = this.medicinePres.prescription;
  //   if (item1 === item2) {
  //       return this.medicinePrescriptionForm;
  //   }
  // }

  equals = (item1, item2) => {
    return item1 && item2 && item1.id === item2.id;
  }
}
