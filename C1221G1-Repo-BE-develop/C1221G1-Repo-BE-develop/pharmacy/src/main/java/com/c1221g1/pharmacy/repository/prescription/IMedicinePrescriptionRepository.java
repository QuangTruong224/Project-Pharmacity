package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IMedicinePrescriptionRepository extends JpaRepository<MedicinePrescription, Integer> {
    /**
     * HienTLD
     * Sửa chi tiết đơn thuốc
     * update 11:18 30/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update medicine_prescription" +
            " set medicine_prescription_times = :#{#medicinePrescription.medicinePrescriptionTimes}," +
            " medicine_prescription_number_per_time = :#{#medicinePrescription.medicinePrescriptionNumberPerTime}," +
            " medicine_id = :#{#medicinePrescription.medicine}," +
            " prescription_id = :#{#medicinePrescription.prescription}" +
            " where medicine_prescription_id = :#{#medicinePrescription.medicinePrescriptionId}",
            nativeQuery = true)
    void editMedicinePrescription(MedicinePrescription medicinePrescription);
}
