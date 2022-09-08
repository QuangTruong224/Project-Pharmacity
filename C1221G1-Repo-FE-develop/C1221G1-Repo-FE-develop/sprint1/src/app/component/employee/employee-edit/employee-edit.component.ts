import {Component, EventEmitter, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

import {ActivatedRoute, Router} from '@angular/router';
import {finalize} from 'rxjs/operators';
import {formatDate} from '@angular/common';
import {AngularFireStorage} from '@angular/fire/storage';
import {ToastrService} from 'ngx-toastr';
import {Employee} from '../../../model/employee/employee';
import {Position} from '../../../model/employee/position';
import {EmployeeService} from '../../../service/employee/employee.service';
import {PositionService} from '../../../service/employee/position.service';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  id: string;
  employeeFormEdit: FormGroup;
  employee: Employee[] = [];
  position: Position[] = [];
  errorUser: string;
  errorImage: string;
  employeeImage: string;
  selectedImage: any = null;
  valueEmployee: any;
  downloadURL: string;
  listIMG: Array<string> = [];
  myMap = new Map();
  checkUploadAvatar = false;
  giveURLtoCreate = new EventEmitter<string>();
  selectedFile: File;
  display: string;


  compareWithId(item1, item2) {
    return item1 && item2 && item1.positionId === item2.positionId;
  }

  constructor(private  employeeService: EmployeeService,
              private positionService: PositionService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage,
              private toastr: ToastrService) {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    this.employeeFormEdit = new FormGroup({
      employeeId: new FormControl(''),
      // tslint:disable-next-line:max-line-length
      employeeName: new FormControl('', [Validators.required, Validators.pattern('^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
      employeeImage: new FormControl(''),
      employeeAddress: new FormControl('', [Validators.required]),
      // tslint:disable-next-line:max-line-length
      employeePhone: new FormControl('', [Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|9]|7[0|6-9]|8[0-6|9]|9[0-4|6-9])[0-9]{7}$')]),
      employeeDateStart: new FormControl('', [Validators.required]),
      employeeNote: new FormControl(''),
      flag: new FormControl(''),
      position: new FormControl('', [Validators.required]),
      employeeUsername: new FormGroup({
        // tslint:disable-next-line:max-line-length
        username: new FormControl(''),
        password: new FormControl(''),
        flag: new FormControl('')
      })
    });
  }

  /*
    Created by TamNA
    Time: 11:50:00 03/07/2022
    Function:  Show position
*/
  ngOnInit(): void {
    this.positionService.getAllPosition().subscribe(position => {
      this.position = position;
    });
    this.getEmployeeById(this.id);
  }

  /*
    Created by TamNA
    Time: 13:50:00 03/07/2022
    Function:  Get employee by id
*/
  getEmployeeById(id: string) {
    return this.employeeService.findEmployeeById(id).subscribe(employee => {
      this.employeeFormEdit.patchValue(employee);
      this.valueEmployee = employee;
      console.log(this.valueEmployee);
      // lấy hình ảnh và gắn lên cho employeeImage
      this.employeeImage = employee.employeeImage;
      console.log(employee.employeeImage);
    }, error => {
      this.router.navigateByUrl('/employee/list');
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
        this.displayEmployeeImage();
      };
    }
    this.employeeImage = '';
  }

  /*
  Created by TamNA
  Time: 12:50:00 03/07/2022
  Function:  Edit Employee
*/
  onSubmit(id: string) {
    if (!this.employeeFormEdit.valid) {
      this.toastr.warning('Bắt buộc phải nhập đúng thông tin !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      });

      this.employeeFormEdit.markAllAsTouched();
    }
    const employee = this.employeeFormEdit.value;
    console.log(this.valueEmployee);
    console.log(Object.is(employee.toString(), this.valueEmployee.toString()));

    if (this.employeeFormEdit.valid) {
      if ((this.selectedImage == null && employee.employeeImage.length > 0)) {
        this.employeeService.updateEmployee(id, employee).subscribe(() => {
          this.toastr.success('Chỉnh Sửa Thành Công !', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
          this.router.navigateByUrl('/employee/list');
        });
      } else {
        const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
        const fileRef = this.storage.ref(nameImg);
        this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(finalize(() => {
          fileRef.getDownloadURL().subscribe(url => {
            this.employeeFormEdit.patchValue(employee.employeeImage = url);
// Call API to update
            this.employeeFormEdit.patchValue(employee.employeeImage = url);
            this.employeeService.updateEmployee(id, employee).subscribe(() => {
              this.toastr.success('Chỉnh Sửa Thành Công !', 'Thông báo', {
                timeOut: 3000,
                progressBar: true
              });
              this.router.navigateByUrl('/employee/list');
            }, error => {
              this.errorUser = error.error.errorMap.usersName;
              this.errorImage = error.error.errorMap.employeeImage;
            });
          });
        })).subscribe();
      }
    }
  }

  /*
  Created by TamNA
  Time: 18:50:00 03/07/2022
  Function:  check Date start of employee
*/
  checkDay() {
    const dayWork = new Date(this.employeeFormEdit.get('employeeDateStart').value);
    const today = Date.now();
    // @ts-ignore
    if (dayWork - today >= 1) {
      this.employeeFormEdit.get('employeeDateStart').setErrors({check: true});
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
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
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
