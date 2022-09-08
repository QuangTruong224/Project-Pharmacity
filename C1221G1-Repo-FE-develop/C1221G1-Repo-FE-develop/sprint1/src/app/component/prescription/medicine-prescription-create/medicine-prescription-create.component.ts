import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {MedicinePrescriptionService} from '../../../services/prescription/medicine-prescription.service';
import {Prescription} from '../../../models/prescription/prescription';
import {PrescriptionService} from '../../../services/prescription/prescription.service';
import {Medicine} from '../../../models/medicine/medicine';
import {MedicineService} from '../../../services/medicine.service';

@Component({
  selector: 'app-medicine-prescription-create',
  templateUrl: './medicine-prescription-create.component.html',
  styleUrls: ['./medicine-prescription-create.component.css']
})
export class MedicinePrescriptionCreateComponent implements OnInit {
  medicines: Medicine[];
  prescriptions: Prescription[];
  medicinePrescriptionForm: FormGroup = new FormGroup({
    medicinePrescriptionTimes: new FormControl('', [Validators.required, Validators.min(1),
      Validators.max(5)]),
    medicinePrescriptionNumberPerTime: new FormControl('', [Validators.required, Validators.min(1),
      Validators.max(30)]),
    prescription: new FormControl('', [Validators.required]),
    medicine: new FormControl('', [Validators.required])
  });

  constructor(private medicinePrescriptionService: MedicinePrescriptionService,
              private prescriptionService: PrescriptionService,
              private medicineService: MedicineService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.prescriptionService.getAllPrescription1().subscribe(prescriptions => {
      this.prescriptions = prescriptions;
    });
    this.medicineService.getAllMedicine1().subscribe(medicines => {
      this.medicines = medicines;
    });
  }

  submit() {
    if (this.medicinePrescriptionForm.valid) {
      this.medicinePrescriptionService.createMedicinePrescription(this.medicinePrescriptionForm.value).subscribe(() => {
        this.medicinePrescriptionForm.reset();
        this.toastr.success('Thêm mới thành công !', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
      }, e => {
        console.log(e);
      }, () => {
        this.router.navigate(['/prescription/list']);
      });
    }
  }
}
