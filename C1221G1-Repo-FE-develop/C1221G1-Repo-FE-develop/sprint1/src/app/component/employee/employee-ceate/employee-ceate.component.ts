import {Component, EventEmitter, Inject, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/storage';
import {ToastrService} from 'ngx-toastr';
import {EmployeeService} from '../../../service/employee/employee.service';
import {Employee} from '../../../model/employee/employee';
import {PositionService} from '../../../service/employee/position.service';
import {Position} from '../../../model/employee/position';

@Component({
  selector: 'app-employee-ceate',
  templateUrl: './employee-ceate.component.html',
  styleUrls: ['./employee-ceate.component.css']
})
export class EmployeeCeateComponent implements OnInit {

  employeeFormCreate: FormGroup;
  employee: Employee[] = [];
  position: Position[] = [];
  errorUser: string;
  errorImage: string;
  selectedImage: any = null;
  downloadURL: string;
  listIMG: Array<string> = [];
  myMap = new Map();
  checkUploadAvatar = false;
  giveURLtoCreate = new EventEmitter<string>();
  selectedFile: File;

  constructor(private  employeeService: EmployeeService,
              private positionService: PositionService,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage,
              private toastr: ToastrService) {
    this.employeeFormCreate = new FormGroup({
      employeeId: new FormControl('Auto save'),
      // tslint:disable-next-line:max-line-length
      employeeName: new FormControl('', [Validators.required, Validators.pattern('^^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
      employeeImage: new FormControl('', [Validators.required, Validators.pattern('(\\S.*\\.(?:png$|jpg$))')]),
      // tslint:disable-next-line:max-line-length
      employeeAddress: new FormControl('', [Validators.required]),
      // tslint:disable-next-line:max-line-length
      employeePhone: new FormControl('', [Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|9]|7[0|6-9]|8[0-6|9]|9[0-4|6-9])[0-9]{7}$')]),
      employeeDateStart: new FormControl('', [Validators.required]),
      employeeNote: new FormControl(''),
      flag: new FormControl(''),
      position: new FormControl('', [Validators.required]),
      employeeUsername: new FormGroup({
        // tslint:disable-next-line:max-line-length
        username: new FormControl('', Validators.compose([Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')])),
        password: new FormControl(''),
        flag: new FormControl('')
      })
    });
  }

  /*
    Created by TamNA
    Time: 12:50:00 03/07/2022
    Function:  Show image
*/
  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      // tslint:disable-next-line:prefer-const
      let reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url
      this.selectedImage = event.target.files[0];
      // tslint:disable-next-line:no-shadowed-variable
      reader.onload = (event) => { // called once readAsDataURL is completed
        // @ts-ignore
        this.downloadURL = this.displayEmployeeImage();
      };
    }
  }

  /*
    Created by TamNA
    Time: 12:50:00 03/07/2022
    Function:  Show position
*/
  ngOnInit(): void {
    this.positionService.getAllPosition().subscribe(position => {
      this.position = position;
    });
  }

  /*
  Created by TamNA
  Time: 12:50:00 03/07/2022
  Function:  Save Employee
*/
  onSubmit() {
    if (!this.employeeFormCreate.valid) {
      this.toastr.warning('Bắt buộc phải nhập đúng thông tin !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      });

      this.employeeFormCreate.markAllAsTouched();
    }
    const employee = this.employeeFormCreate.value;
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(finalize(() => {
      fileRef.getDownloadURL().subscribe(url => {
        this.employeeFormCreate.patchValue(employee.employeeImage = url);
// Call API to create
        this.employeeService.saveEmployee(employee).subscribe(() => {
          this.toastr.success('Thêm Mới Thành Công !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.router.navigateByUrl('/employee/list');
        }, error => {
          this.toastr.error('Thêm Mới Thất Bại !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.errorUser = error.error?.errorMap?.usersName;
        });
      });
    })).subscribe();
  }


  /*
  Created by TamNA
  Time: 12:50:00 03/07/2022
  Function:  check Date start of employee
*/
  checkDay() {
    const dayWork = new Date(this.employeeFormCreate.get('employeeDateStart').value);
    const today = Date.now();
    // @ts-ignore
    if (dayWork - today >= 1) {
      this.employeeFormCreate.get('employeeDateStart').setErrors({check: true});
    }
  }

  /*
Created by TamNA
Time: 12:50:00 03/07/2022
Function:  show Time Now
*/
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  /*
Created by TamNA
Time: 12:50:00 03/07/2022
Function:  Show image on firebase
*/
  displayEmployeeImage() {
    this.checkUploadAvatar = true;
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(finalize(() => {
      fileRef.getDownloadURL().subscribe(url => {
        this.downloadURL = url;
        this.giveURLtoCreate.emit(this.downloadURL);
        this.checkUploadAvatar = false;
        this.listIMG.push(url);
        for (let i = 0; i < this.listIMG.length; i++) {
          this.myMap.set(i, this.listIMG[i]);
        }
      });
    })).subscribe();
  }
}
