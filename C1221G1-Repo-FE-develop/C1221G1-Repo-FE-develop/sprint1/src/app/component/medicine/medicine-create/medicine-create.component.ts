import {Component, Inject, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {MedicineService} from '../../../service/medicine/medicine.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MedicineOrigin} from '../../../model/medicine/medicine-origin';
import {MedicineUnit} from '../../../model/medicine/medicine-unit';
import {MedicineConversionUnit} from '../../../model/medicine/medicine-conversion-unit';
import {MedicineType} from '../../../model/medicine/medicine-type';
import {AngularFireStorage, AngularFireStorageReference} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';


@Component({
  selector: 'app-medicine-create',
  templateUrl: './medicine-create.component.html',
  styleUrls: ['./medicine-create.component.css']
})
export class MedicineCreateComponent implements OnInit {
  medicineCreateForm: FormGroup;
  medicineTypeList: MedicineType[];
  medicineOriginList: MedicineOrigin[];
  medicineUnitList: MedicineUnit[];
  medicineConversionUnitList: MedicineConversionUnit[];
  selectedImage: any;
  previewImage: any;
  fileRef: AngularFireStorageReference;
  nameImg: string;
  fireBaseURL: string;
  errorList: any = '';
  validationMessages = {
    medicineName: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự và không có kí tự đặc biệt'},
    ],
    medicineActiveIngredients: [
      {type: 'required', message: 'Không được để trống.'},
      {type: 'pattern', message: '2 đến 50 kí tự'},
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
              private medicineService: MedicineService,
              private toastrService: ToastrService,
              @Inject(AngularFireStorage) private storage: AngularFireStorage,
  ) {
  }

  ngOnInit(): void {
    this.getALlDropDownList();
    this.onSubmitNewMedicine();
  }

  /**
   * this function use to create CreateForm
   *
   * @Author LongNH
   * @Time 22:00 04/07/2022
   */
  onSubmitNewMedicine() {
    this.medicineCreateForm = this.formBuilder.group({
      medicineName: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern
          (/^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\w|_]{2,50}$/)])]),
      medicineActiveIngredients: new FormControl('',
        [Validators.compose([
          Validators.required])]),
      medicineImportPrice: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d+(\.\d|\.\d[0-9])?$/)])]),
      medicineDiscount: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineWholesaleProfit: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)
        ])]),
      medicineRetailSaleProfit: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineTax: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^(?!(?:0|0\.0|0\.00)$)[+]?\d{1,2}(\.\d|\.\d[0-9])?$/)])]),
      medicineConversionRate: new FormControl('',
        [Validators.compose([
          Validators.required,
          Validators.pattern(/^[1-9][0-9]?$/)])]),
      medicineManufacture: new FormControl('',
        [Validators.compose([
          Validators.required])]),
      medicineUsage: new FormControl('',
        [Validators.compose([
          Validators.required])]),
      medicineInstruction: new FormControl('',
        [Validators.compose([
          Validators.required])]),
      medicineAgeApproved: new FormControl('',
        [Validators.compose([
          Validators.required])]),
      medicineImage: new FormControl(''),
      medicineDescription: new FormControl(''),
      medicineOrigin: new FormControl('',
        [Validators.compose([Validators.required])]),
      medicineType: new FormControl('',
        [Validators.compose([Validators.required])]),
      medicineUnit: new FormControl('',
        [Validators.compose([Validators.required])]),
      medicineConversionUnit: new FormControl('',
        [Validators.compose([Validators.required])]),
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
   * this function use to create new medicine
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */

  createMedicine() {
    this.submit = true;
    if (this.medicineCreateForm.valid) {
      this.isLoading = true;
      if (this.selectedImage == null) {
        this.medicineService.createMedicine(this.medicineCreateForm.value).subscribe(() => {
          this.isLoading = false;
          this.toastrService.success('Bạn đã thêm mới thành công !', 'Thêm mới');
          this.route.navigateByUrl('/medicine/list');
        }, error => {
          this.isLoading = false;
          this.toastrService.error('Bạn đã cố gắng làm gì đó dẫn tới thêm mới thất bại !', 'Thêm mới');
        });
      }
      this.nameImg = this.getCurrentDateTime() + this.selectedImage.name;
      this.fileRef = this.storage.ref(this.nameImg);
      this.storage.upload(this.nameImg, this.selectedImage).snapshotChanges().pipe(finalize(() => {
        this.fileRef.getDownloadURL().subscribe(url => {
          this.fireBaseURL = url;
          this.medicineCreateForm.patchValue({medicineImage: this.fireBaseURL});
          console.log(this.medicineCreateForm.value);
          this.medicineService.createMedicine(this.medicineCreateForm.value).subscribe(() => {
            this.isLoading = false;
            this.toastrService.success('Bạn đã thêm mới thành công !', 'Thêm mới');
            this.route.navigateByUrl('/medicine/list');
          }, error => {
            this.isLoading = false;
            this.toastrService.error('Bạn đã cố gắng làm gì đó dẫn tới thêm mới thất bại !', 'Thêm mới');
          });
        });
      })).subscribe();
    } else {
      this.isLoading = false;
      this.toastrService.error('Bạn đã thêm mới thất bại !', 'Thêm mới');
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
   * this function use to display image before create on view
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
}
