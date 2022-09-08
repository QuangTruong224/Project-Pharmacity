import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MedicineType} from '../../../model/medicine/medicine-type';
import {MedicineOrigin} from '../../../model/medicine/medicine-origin';
import {MedicineUnit} from '../../../model/medicine/medicine-unit';
import {MedicineConversionUnit} from '../../../model/medicine/medicine-conversion-unit';
import {AngularFireStorage, AngularFireStorageReference} from '@angular/fire/storage';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {MedicineService} from '../../../service/medicine/medicine.service';
import {finalize} from 'rxjs/operators';
import {formatDate} from '@angular/common';
import {Medicine} from '../../../model/medicine/medicine';
import {ToastrService} from 'ngx-toastr';


@Component({
  selector: 'app-medicine-edit',
  templateUrl: './medicine-edit.component.html',
  styleUrls: ['./medicine-edit.component.css']
})
export class MedicineEditComponent implements OnInit {
  medicineEditForm: FormGroup;
  confirmMedicine: Medicine;
  medicineTypeList: MedicineType[];
  medicineOriginList: MedicineOrigin[];
  medicineUnitList: MedicineUnit[];
  medicineConversionUnitList: MedicineConversionUnit[];
  selectedImage: any;
  previewImage: any;
  fileRef: AngularFireStorageReference;
  nameImg: string;
  fireBaseURL: string;
  id?: string;
  validationMessages = {
    medicineName: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
    ],
    medicineActiveIngredients: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự và không có kí tự đặc biệt'},
    ],
    medicineImportPrice: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 giới hạn 2 số thập phân.'},
    ],
    medicineDiscount: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 bé hơn 100 giới hạn 2 số thập phân.'},
    ],
    medicineWholesaleProfit: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 bé hơn 100 giới hạn 2 số thập phân.'},
    ],
    medicineRetailSaleProfit: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 bé hơn 100 giới hạn 2 số thập phân.'},
    ],
    medicineTax: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 bé hơn 100 giới hạn 2 số thập phân.'},
    ],
    medicineConversionRate: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: 'Lớn hơn 0 bé hơn 100.'},
    ],
    medicineManufacture: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
    ],
    medicineUsage: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
    ],
    medicineInstruction: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
    ],
    medicineAgeApproved: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
    ],
    medicineImage: [
      {type: 'pattern', message: 'phải là định dạng ảnh jpg, png, gif, bmp.'},
    ],
    medicineOrigin: [
      {type: 'required', message: 'Không được để trống.'},
    ],
    medicineType: [
      {type: 'required', message: 'Không được để trống.'},
    ],
    medicineUnit: [
      {type: 'required', message: 'Không được để trống.'},
    ],
    medicineConversionUnit: [
      {type: 'required', message: 'Không được để trống.'},
    ]
  };

  submit = false;
  isLoading = false;

  constructor(private route: Router,
              private formBuilder: FormBuilder,
              private toastrService: ToastrService,
              private medicineService: MedicineService,
              private activatedRoute: ActivatedRoute,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {
  }

  ngOnInit(): void {
    this.getALlDropDownList();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      this.getMedicine(this.id);
    });
  }

  /**
   * this function use to get all list spend to dropdown
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getALlDropDownList() {
    this.getMedicineTypeList();
    this.getMedicineOriginList();
    this.getMedicineUnitList();
    this.getMedicineConversionUnitList();
  }

  /**
   * this function use to get all medicine type
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineTypeList() {
    return this.medicineService.getMedicineTypeList().subscribe(medicineTypeList => {
      this.medicineTypeList = medicineTypeList;
    });
  }

  /**
   * this function use to get all medicine origin
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineOriginList() {
    return this.medicineService.getMedicineOriginList().subscribe(medicineOriginList => {
      this.medicineOriginList = medicineOriginList;
    });
  }

  /**
   * this function use to get all medicine unit
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineUnitList() {
    return this.medicineService.getMedicineUnitList().subscribe(medicineUnitList => {
      this.medicineUnitList = medicineUnitList;
    });
  }

  /**
   * this function use to get all medicine conversion unit
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineConversionUnitList() {
    return this.medicineService.getMedicineConversionUnitList().subscribe(medicineConversionUnitList => {
      this.medicineConversionUnitList = medicineConversionUnitList;
    });
  }

  /**
   * this function use to update exist medicine
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  updateMedicine() {
    this.submit = true;
    if (this.medicineEditForm.valid) {
      this.isLoading = true;
      if (this.selectedImage == null && this.confirmMedicine.medicineImage.length > 0) {
        this.medicineService.updateMedicine(this.confirmMedicine.medicineId, this.medicineEditForm.value).subscribe(() => {
          this.isLoading = false;
          this.toastrService.success('Bạn đã chỉnh sửa thành công !', 'Chỉnh sửa');
          this.route.navigateByUrl('/medicine/list');
        }, error => {
          this.isLoading = false;
          this.toastrService.error('Bạn đã cố gắng làm gì đó dẫn tới chỉnh sửa thất bại !', 'Chỉnh sửa');
        });
      } else {
        this.nameImg = this.getCurrentDateTime() + this.selectedImage.name;
        this.fileRef = this.storage.ref(this.nameImg);
        this.storage.upload(this.nameImg, this.selectedImage).snapshotChanges().pipe(finalize(() => {
          this.fileRef.getDownloadURL().subscribe(url => {
            this.fireBaseURL = url;
            this.medicineEditForm.patchValue({medicineImage: this.fireBaseURL});
            this.medicineService.updateMedicine(this.confirmMedicine.medicineId, this.medicineEditForm.value).subscribe(() => {
              this.isLoading = false;
              this.toastrService.success('Bạn đã chỉnh sửa thành công !', 'Chỉnh sửa');
              this.route.navigateByUrl('/medicine/list');
            }, error => {
              this.isLoading = false;
              this.toastrService.error('Bạn đã cố gắng làm gì đó dẫn tới chỉnh sửa thất bại !', 'Chỉnh sửa');
            });
          });
        })).subscribe();
      }
    } else {
      this.isLoading = false;
      this.toastrService.error('Bạn đã chỉnh sửa thất bại !', 'Chỉnh sửa');
    }
  }

  /**
   * this function use to get current date time
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  /**
   * this function use to display image before update on view
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url
      reader.onload = (event) => { // called once readAsDataURL is completed
        this.previewImage = event.target.result;
      };
    }
  }

  /**
   * this function use to get exist medicine form be
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicine(id: string) {
    return this.medicineService.findMedicineById(id).subscribe(medicine => {
      this.confirmMedicine = medicine;
      this.onSubmitExistMedicine();
    }, error => {
      this.route.navigateByUrl('not-found');
    });
  }

  /**
   * this function use to create EditForm
   *
   * @Author LongNH
   * @Time 22:00 04/07/2022
   */
  private onSubmitExistMedicine() {
    this.medicineEditForm = this.formBuilder.group({
      medicineName: new FormControl(this.confirmMedicine.medicineName,
        [Validators.compose([
          Validators.required,
          Validators.pattern
          (/^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\w|_]{2,50}$/)])]),
      medicineActiveIngredients: new FormControl(this.confirmMedicine.medicineActiveIngredients,
        [Validators.compose([
          Validators.required])]),
      medicineImportPrice: new FormControl(this.confirmMedicine.medicineImportPrice,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d+(\.\d|\.\d[0-9])?$/)
        ])]),
      medicineDiscount: new FormControl(this.confirmMedicine.medicineDiscount,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineWholesaleProfit: new FormControl(this.confirmMedicine.medicineWholesaleProfit,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)
        ])]),
      medicineRetailSaleProfit: new FormControl(this.confirmMedicine.medicineRetailSaleProfit,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineTax: new FormControl(this.confirmMedicine.medicineTax,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineConversionRate: new FormControl(this.confirmMedicine.medicineConversionRate,
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^[1-9][0-9]?$/)])]),
      medicineManufacture: new FormControl(this.confirmMedicine.medicineManufacture,
        [Validators.compose([
          Validators.required])]),
      medicineUsage: new FormControl(this.confirmMedicine.medicineUsage,
        [Validators.compose([
          Validators.required])]),
      medicineInstruction: new FormControl(this.confirmMedicine.medicineInstruction,
        [Validators.compose([
          Validators.required])]),
      medicineAgeApproved: new FormControl(this.confirmMedicine.medicineAgeApproved,
        [Validators.compose([
          Validators.required])]),
      medicineImage: new FormControl(this.confirmMedicine.medicineImage),
      medicineDescription: new FormControl(this.confirmMedicine.medicineDescription),
      flag: new FormControl(this.confirmMedicine.flag),
      medicineOrigin: new FormControl(this.confirmMedicine.medicineOrigin,
        [Validators.compose([Validators.required])]),
      medicineType: new FormControl(this.confirmMedicine.medicineType,
        [Validators.compose([Validators.required])]),
      medicineUnit: new FormControl(this.confirmMedicine.medicineUnit,
        [Validators.compose([Validators.required])]),
      medicineConversionUnit: new FormControl(this.confirmMedicine.medicineConversionUnit,
        [Validators.compose([Validators.required])]),
    });
  }

  /**
   * this function use to compare Type medicine for display view
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  compareType(type1: MedicineType, type2: MedicineType): boolean {
    return type1 && type2 ? type1.medicineTypeId === type2.medicineTypeId : type1 === type2;
  }

  /**
   * this function use to compare Unit medicine for display view
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  compareUnit(unit1: MedicineUnit, unit2: MedicineUnit): boolean {
    return unit1 && unit2 ? unit1.medicineUnitId === unit2.medicineUnitId : unit1 === unit2;
  }

  /**
   * this function use to compare Origin medicine for display view
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  compareOrigin(origin1: MedicineOrigin, origin2: MedicineOrigin): boolean {
    return origin1 && origin2 ? origin1.medicineOriginId === origin2.medicineOriginId : origin1 === origin2;
  }

  /**
   * this function use to compare Conversion Unit medicine for display view
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  compareConversionUnit(conversionUnit1: MedicineConversionUnit, conversionUnit2: MedicineConversionUnit): boolean {
    return conversionUnit1 && conversionUnit2 ?
      conversionUnit1.medicineConversionUnitId === conversionUnit2.medicineConversionUnitId :
      conversionUnit1 === conversionUnit2;
  }
}
