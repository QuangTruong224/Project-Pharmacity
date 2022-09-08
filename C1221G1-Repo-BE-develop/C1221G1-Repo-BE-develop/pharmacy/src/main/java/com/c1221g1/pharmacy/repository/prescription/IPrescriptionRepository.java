package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDetail;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionMedicineDetail;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IPrescriptionRepository extends JpaRepository<Prescription, String> {
    /**
     * HienTLD
     * Câu lệnh sql danh sách toa thuốc và tìm kiếm
     * 16:00 29/06/2022
     */
    @Query(value = "select prescription.prescription_id, prescription.flag, prescription.prescription_name, prescription.prescription_target_user," +
            " prescription.prescription_symptom, prescription.prescription_number_of_days, prescription.prescription_note from prescription" +
            " where prescription.prescription_id like :id and prescription.prescription_name like :names" +
            " and prescription.prescription_target_user like :target and prescription.prescription_symptom like :symptom and prescription.flag = 1",
            countQuery = "select prescription.prescription_id,prescription.flag, prescription.prescription_name, prescription.prescription_target_user," +
                    " prescription.prescription_symptom, prescription.prescription_number_of_days, prescription.prescription_note from prescription" +
                    " where prescription.prescription_id like :id and prescription.prescription_name like :names" +
                    " and prescription.prescription_target_user like :target and prescription.prescription_symptom like :symptom and flag = 1",
            nativeQuery = true)
    Page<Prescription> findAllPage(
            Pageable pageable,
            @Param("id") String id,
            @Param("names") String names,
            @Param("target") String target,
            @Param("symptom") String symptom);

    /**
     * HienTLD
     * Câu lệnh sql chi tiết toa thuốc
     * 10:55 04/07/2022
     */

    @Query(value = "select prescription.prescription_id as prescriptionId," +
            " prescription.prescription_name as prescriptionName," +
            " prescription.prescription_number_of_days as prescriptionNumberOfDays," +
            " medicine.medicine_id as medicineId," +
            " medicine.medicine_name as medicineName," +
            " medicine_prescription.medicine_prescription_times as medicinePrescriptionTimes," +
            " medicine_prescription.medicine_prescription_number_per_time as medicinePrescriptionNumberPerTime," +
            " (medicine_prescription.medicine_prescription_times*medicine_prescription.medicine_prescription_number_per_time" +
            "*prescription.prescription_number_of_days)" +
            " as totalQuantityMedicine" +
            " from prescription inner join medicine_prescription on prescription.prescription_id = " +
            " medicine_prescription.prescription_id inner join medicine on medicine_prescription.medicine_id =" +
            " medicine.medicine_id" +
            " where prescription.prescription_id = :idPrescription" +
            " group by medicine_prescription.medicine_prescription_id", nativeQuery = true)
    List<IMedicinePrescriptionDto> detailPrescriptionById(@Param("idPrescription") String id);
//    @Query(value = "select prescription.prescription_id as prescriptionId, prescription.prescription_name as " +
//            " prescriptionName, prescription.prescription_target_user as prescriptionTargetUser," +
//            " prescription.prescription_symptom as prescriptionSymptom, prescription.prescription_number_of_days as" +
//            " prescriptionNumberOfDays, prescription.prescription_note as prescriptionNote," +
//            " medicine_prescription.medicine_prescription_times as medicinePrescriptionTimes, " +
//            " medicine_prescription.medicine_prescription_number_per_time as medicinePrescriptionNumberPerTime," +
//            " (medicine_prescription.medicine_prescription_times*medicine_prescription.medicine_prescription_number_per_time" +
//            "*prescription.prescription_number_of_days)" +
//            " as totalQuantityMedicine" +
//            " from prescription inner join medicine_prescription on prescription.prescription_id = " +
//            " medicine_prescription.prescription_id" +
//            " where prescription.prescription_id = :idPrescription" +
//            " group by prescription.prescription_id",
//            nativeQuery = true)
//    IMedicinePrescriptionDto detailPrescriptionById(@Param("idPrescription") String id);

    /**
     * HienTLD
     * Câu lệnh sql xoá toa thuốc theo cờ 'flag'
     * 16:00 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update prescription set `flag` = 0 where prescription_id = :id", nativeQuery = true)
    void deletePrescriptionById(@Param("id") String id);


    /**
     * HienTLD
     * Sửa toa thuốc (xoá theo cờ 'flag')
     * update 11:18 30/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update prescription" +
            " set prescription_name = :#{#prescription.prescriptionName}," +
            " prescription_symptom = :#{#prescription.prescriptionSymptom}," +
            " prescription_target_user = :#{#prescription.prescriptionTargetUser}," +
            " prescription_note = :#{#prescription.prescriptionNote}," +
            " prescription_number_of_days = :#{#prescription.prescriptionNumberOfDays} " +
            " where prescription_id = :#{#prescription.prescriptionId}",
            nativeQuery = true)
    void editPrescription(Prescription prescription);

    /**
     * <<<<<<< HEAD
     * HienTLD
     * Lấy List<Prescription>
     * update 11:18 30/06/2022
     */
    @Query(value = "select prescription.prescription_id, " +
            " prescription.flag, " +
            " prescription.prescription_name," +
            " prescription.prescription_target_user," +
            " prescription.prescription_symptom, " +
            " prescription.prescription_number_of_days, " +
            " prescription.prescription_note " +
            "from prescription",
            nativeQuery = true)
    List<Prescription> findAllPre();

    /**
     * DaLQA
     * Function: getInfoPrescription
     * Time: 11:18 05/07/2022
     */
    @Query(value = "select prescription_id      as prescriptionId\n" +
            "     , prescription_name           as prescriptionName\n" +
            "     , prescription_symptom        as symptom\n" +
            "     , prescription_target_user    as targetUser\n" +
            "     , prescription_number_of_days as numberOfDays\n" +
            "from prescription\n" +
            "where prescription_id = :id ", nativeQuery = true)
    PrescriptionDetail getDetailPrescription(@Param("id") String id);

    /**
     * DaLQA
     * Function: getInfoPrescription
     * Time: 11:18 05/07/2022
     */
    @Query(value = "select medicine_prescription.prescription_id                                           as prescriptionId\n" +
            "     , medicine_prescription.medicine_id                                                       as medicineId\n" +
            "     , medicine_name                                                                           as medicineName\n" +
            "     , medicine_prescription.medicine_prescription_times                                       as times\n" +
            "     , medicine_prescription.medicine_prescription_number_per_time                             as numberPerTime\n" +
            "     , (medicine_prescription_times\n" +
            "    * medicine_prescription_number_per_time * prescription_number_of_days)\n" +
            "                                                                                               as totalQuantity\n" +
            "   , (((medicine_import_price*(medicine_retail_sale_profit)/100+1))/medicine_conversion_rate) as retailPrice\n" +
            "from medicine_prescription\n" +
            "         left join prescription p on medicine_prescription.prescription_id = p.prescription_id\n" +
            "         left join medicine m on medicine_prescription.medicine_id = m.medicine_id\n" +
            "where p.prescription_id = :id ", nativeQuery = true)
    List<PrescriptionMedicineDetail> getDetailListPreMe(@Param("id") String id);
}

