package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IMedicineStorageRepository extends JpaRepository<MedicineStorage, Integer> {

    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateQuantityMedicine
     * */
    @Query(value = "SELECT medicine_storage_id, flag, medicine_quantity, medicine_id " +
            "FROM medicine_storage " +
            "WHERE medicine_id = :medicine_id AND flag = TRUE ",
            nativeQuery = true)
    Optional<MedicineStorage> getStorageByMedicineId(@Param("medicine_id") String id);

    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateMedicineQuantity
     * */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `medicine_storage` SET `medicine_quantity` = ?1 " +
            "WHERE (`medicine_storage_id` = ?2) AND flag = TRUE ",
            nativeQuery = true)
    void updateMedicineQuantity(Long medicineQuantity, Integer medicineStorageId);

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: finding medicine storage object by medicine id
     *
     * @param medicineId
     * @return medicineStorage object
     */

    @Query(value = "SELECT medicine_storage_id, medicine_id , medicine_quantity, flag " +
            "FROM medicine_storage " +
            "WHERE medicine_id = :id AND `flag` = TRUE", nativeQuery = true)
    MedicineStorage findMedicineStorageById(@Param("id") String medicineId);

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: get medicine quantity in storage.
     *
     * @param medicineId
     * @return medicine quantity
     */

    @Query(value = "SELECT  medicine_quantity " +
            "FROM medicine_storage " +
            "WHERE medicine_id = :id AND `flag` = TRUE", nativeQuery = true)
    Long getMedicineQuantityByMedicineId(@Param("id") String medicineId);

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: decrease quantity of medicine by medicine for export storage medince
     *
//     * @param medicineId
//     * @param quantity
//     * @return void
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine_storage SET medicine_quantity = :quantity " +
            "WHERE medicine_id = :medicine_id", nativeQuery = true)
    void changeMedicineQuantity(@Param("medicine_id") String medicineId, @Param("quantity") Long quantity);

}