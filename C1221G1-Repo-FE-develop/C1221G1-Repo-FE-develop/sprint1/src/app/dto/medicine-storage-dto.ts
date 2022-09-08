import {Medicine} from "../model/medicine/medicine";


export interface MedicineStorageDto {
  readonly medicineStorageDtoId: number,
  medicine: Medicine,
  quantity: number
}
