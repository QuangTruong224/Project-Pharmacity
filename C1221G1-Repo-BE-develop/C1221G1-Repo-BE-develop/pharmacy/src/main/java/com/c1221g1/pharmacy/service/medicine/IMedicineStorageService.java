package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;

import java.util.List;
import java.util.Optional;

public interface IMedicineStorageService {


    boolean checkExistInMedicineStorage(String medicineId);

    Long checkMedicineQuantity(String medicineId);

    boolean changeMedicineQuantity(String medicineId, Long quantity, int manipulation) ;
    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function getStorageByIdMedicine
     * */
    Optional<MedicineStorage> getStorageByIdMedicine(String id);


    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateMedicineQuantity
     * */

    void updateMedicineQuantity(MedicineStorage storage);

    List<MedicineStorage> getAll();

}
