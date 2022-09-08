import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {SupplierService} from '../../../service/supplier.service';
import {Supplier} from '../../../model/Supplier';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css']
})
export class SupplierListComponent implements OnInit {

  @ViewChild('nameSearchingSelect') nameSearch: ElementRef;
  @ViewChild('sort') sort: ElementRef;
  @ViewChild('valueSearch') valueSearch: ElementRef;

  public listSupplier: Supplier[];
  totalPages: number;
  currentPage: number = 0;
  ownerSearch = '';

  valueSupplier: Supplier;
  chosenIndex: number;
  isChosen: Boolean;
  chooseId: string;
  stt: number = 1;
  idDelete: string;
  nameDelete: String;

  constructor(private supplierService: SupplierService,
              private toastr: ToastrService) {

  }

  ngOnInit(): void {
    this.getListSupplier({
      page: 0,
      size: 10000,
      searchId: '',
      searchName: '',
      searchAddress: '',
      searchPhone: '',
      sort: '',
      owner: this.ownerSearch
    });

  }

  /**
   * delete the value
   * method: delete
   *  @23h 01/06/2022 LuatTN
   *  @this  delete Supplier
   */
  confirmDelete() {
    this.supplierService.deleteSupplier(this.idDelete).subscribe(() => {
      this.ngOnInit();
      this.toastr.success('Xóa Thành Công ! ' + this.nameDelete, 'Thông Báo Xác Nhận', {
        timeOut: 3000,
        progressBar: true
      });
      this.chooseId = null;
      this.chosenIndex = null;
      this.idDelete = null;
      this.nameDelete = null;
      this.isChosen = false;
    }, e => {
    });
  }


  /**
   * previous Page
   *  @23h 01/06/2022 LuatTN
   *  @public
   */
  public previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      // @ts-ignore
      request.page = this.currentPage - 1;
      // @ts-ignore
      request.size = 10000;
      // @ts-ignore
      request.sort = this.sort.nativeElement.value;

      switch (this.nameSearch.nativeElement.value) {
        case 'supplierId': {
          request['searchId'] = this.ownerSearch;
          break;
        }
        case 'supplierName': {
          request['searchName'] = this.ownerSearch;
          break;
        }
        case 'supplierAddress': {
          request['searchAddress'] = this.ownerSearch;
          break;
        }
        case 'supplierPhone': {
          request['searchPhone'] = this.ownerSearch;
        }
      }
      this.getListSupplier(request);
    }
  }

  /**
   * next Page
   *  @23h 01/06/2022 LuatTN
   *  @public
   */
  public nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      // @ts-ignore
      request.page = this.currentPage + 1;
      // @ts-ignore
      request.size = 10000;
      // @ts-ignore
      request.owner = this.ownerSearch;
      // @ts-ignore
      request.sort = this.sort.nativeElement.value;
      switch (this.nameSearch.nativeElement.value) {
        case 'supplierId': {
          request['searchId'] = this.ownerSearch;
          break;
        }
        case 'supplierName': {
          request['searchName'] = this.ownerSearch;
          break;
        }
        case 'supplierAddress': {
          request['searchAddress'] = this.ownerSearch;
          break;
        }
        case 'supplierPhone': {
          request['searchPhone'] = this.ownerSearch;
        }
      }

      this.getListSupplier(request);
    }

  }

  /**
   * read the value when is on click
   * method: click()
   *  @23h 01/06/2022 LuatTN
   *   @this  get all Supplier
   */
  getValueTest(item: Supplier) {

  }

  /**
   * get value when searching
   * @23h 01/06/2022 LuatTN
   *
   */
  search(ownerSearch: HTMLInputElement) {
    //   get value when searching
    this.ownerSearch = ownerSearch.value;
    switch (this.nameSearch.nativeElement.value) {
      case 'supplierId': {
        this.getListSupplier({
          page: 0,
          size: 10000,
          searchId: this.valueSearch.nativeElement.value,
          sort: this.sort.nativeElement.value,
          owner: this.ownerSearch
        });
        break;
      }
      case 'supplierName': {
        this.getListSupplier({
          page: 0,
          size: 10000,
          searchName: this.valueSearch.nativeElement.value,
          sort: this.sort.nativeElement.value,
        });
        break;
      }
      case 'supplierAddress': {
        this.getListSupplier({
          page: 0,
          size: 10000,
          searchAddress: this.valueSearch.nativeElement.value,
          sort: this.sort.nativeElement.value,
          owner: this.ownerSearch
        });
        break;
      }
      case 'supplierPhone': {
        this.getListSupplier({
          page: 0,
          size: 10000,
          searchPhone: this.valueSearch.nativeElement.value,
          sort: this.sort.nativeElement.value,
          owner: this.ownerSearch
        });
        break;
      }
      default: {
        this.toastr.warning('Chưa Có Lựa Chọn Khi Tìm Kiếm ', 'Thông Báo Hệ Thống', {
          timeOut: 3000,
          progressBar: true
        });
        this.getListSupplier({
          page: 0,
          size: 10000,
          searchId: '',
          sort: '',
          owner: this.ownerSearch
        });
      }
    }
  }

  /**
   * method test db click
   */
  getValueSupplier(item: Supplier) {
    this.valueSupplier = item;
    this.toastr.success('Xác Nhận Đã Chọn 1 Nhà Cung Cấp  '
      + this.valueSupplier.supplierName, 'Thông Báo Xác Nhận', {
      timeOut: 3000,
      progressBar: true,
      positionClass: 'toast-top-center',
    });
  }

  /**
   * read the value of API
   * method: get
   *  @23h 01/06/2022 LuatTN
   *   @this  get all Supplier
   */
  private getListSupplier(request) {
    this.supplierService.getAll(request).subscribe(data => {
        if (data !== null) {
          this.listSupplier = data.content;
          this.currentPage = data.number;
          this.totalPages = data.totalPages;
        } else {
          this.listSupplier = [];
          this.currentPage = data.number;
          this.totalPages = data.totalPages;
        }
      }, error => {
        this.listSupplier.length = 0;
      }, () => {
      }
    );
  }

  /**
   * click choose supplier
   * @LuatTN 10h 05/07/2022
   * @param supplier
   */
  chooseSupplier(index: number, supplier: Supplier): void {
    if (this.chosenIndex != index) {
      this.isChosen = true;
      this.chosenIndex = index;
      this.chooseId = supplier.supplierId;
      this.nameDelete = supplier.supplierName;
    } else {
      this.isChosen = !this.isChosen;
      this.chooseId = null;
      this.chosenIndex = null;
      this.idDelete = null;
      this.nameDelete = null;

    }
    if (this.isChosen) {
      this.idDelete = supplier.supplierId;
      this.toastr.success('Xác Nhận Đã Chọn 1 Nhà Cung Cấp ' + supplier.supplierName, 'Thông Báo Xác Nhận', {
        timeOut: 1000,
        progressBar: true,
      });
    }

  }

  getInforE() {
    if (!this.isChosen) {
      this.toastr.warning('Vui Lòng Chọn Nhà Cung Cấp', 'Thông Báo Hệ Thống', {
        timeOut: 2000,
        progressBar: true,
      });
    }
  }
}
