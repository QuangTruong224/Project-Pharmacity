package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {
    /**
     * Created by DaLQA
     * Time: 23:00 30/06/2022
     * Function: get list getListMedicineSale
     */
    @Query(value = "SELECT  medicine_id AS medicineId" +
            ", medicine_name AS medicineName," +
            " (((medicine_import_price*(medicine_retail_sale_profit)/100+1))/medicine_conversion_rate)" +
            " AS retailPrice FROM medicine"
            , nativeQuery = true)
    List<MedicineSale> getListMedicineSale();

    /**
     * Created by MyC
     * Time: 23:00 30/06/2022
     * Function: use procedure in DB search list medicine
     */
    @Query(value = "CALL look_up(:columName, :condition, :keyWord)", nativeQuery = true)
    List<MedicineLookUpDto> getAllMedicine(@Param("columName") String columName, @Param("condition") String condition,
                                           @Param("keyWord") String keyWord);

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine SET flag = 0 WHERE medicine_id = :id ", nativeQuery = true)
    void deleteMedicineById(@Param("id") String id);

    /**
     * this function use to edit exist medicine
     *
     * @author LongNH
     * @Time 20:01 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine "
            + "SET medicine_name=:#{#medicine.medicineName},medicine_active_ingredients=:#{#medicine.medicineActiveIngredients},"
            + "medicine_import_price=:#{#medicine.medicineImportPrice},medicine_discount=:#{#medicine.medicineDiscount},"
            + "medicine_wholesale_profit=:#{#medicine.medicineWholesaleProfit},"
            + "medicine_retail_sale_profit=:#{#medicine.medicineRetailSaleProfit},medicine_tax=:#{#medicine.medicineTax},"
            + "medicine_conversion_rate=:#{#medicine.medicineConversionRate},medicine_manufacture=:#{#medicine.medicineManufacture},"
            + "medicine_usage=:#{#medicine.medicineUsage},medicine_instruction=:#{#medicine.medicineInstruction},"
            + "medicine_age_approved=:#{#medicine.medicineAgeApproved},medicine_image=:#{#medicine.medicineImage},"
            + "medicine_description=:#{#medicine.medicineDescription},flag =:#{#medicine.flag},"
            + "medicine_origin_id=:#{#medicine.medicineOrigin},"
            + "medicine_type_id=:#{#medicine.medicineType},medicine_unit_id=:#{#medicine.medicineUnit},"
            + "medicine_conversion_unit_id=:#{#medicine.medicineConversionUnit}" + " WHERE medicine_id=:#{#medicine.medicineId}", nativeQuery = true)
    void updateMedicine(Medicine medicine);

    /**
     * this function use to find exist medicine in db if not exist return null
     *
     * @author LongNH
     * @Time 20:50 29/06/2022
     */
    @Query(value = "SELECT medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price,medicine_discount,"
            + "medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate,"
            + "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved,"
            + "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," + "medicine_conversion_unit_id,flag "
            + "FROM medicine WHERE flag = 1 AND medicine_id =:id ", nativeQuery = true)
    Optional<Medicine> findMedicineById(@Param("id") String id);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Query(value =
            "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName, m.medicine_active_ingredients AS medicineActiveIngredients, m.medicine_import_price * (1 + m.medicine_retail_sale_profit / 100) / m.medicine_conversion_rate AS medicinePrice, m.medicine_manufacture AS medicineManufacture, "
                    + "m.medicine_usage AS medicineUsage, m.medicine_instruction AS medicineInstruction, m.medicine_age_approved AS medicineAgeApproved, m.medicine_image AS medicineImage, m.medicine_description AS medicineDescription, mo.medicine_origin_name AS medicineOrigin, "
                    + "mcu.medicine_conversion_unit_name AS medicineConversionUnit, ms.medicine_quantity AS medicineQuantity  "
                    + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
                    + "INNER JOIN medicine_conversion_unit mcu ON m.medicine_conversion_unit_id = mcu.medicine_conversion_unit_id "
                    + "INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id "
                    + "INNER JOIN medicine_unit mu ON m.medicine_unit_id = mu.medicine_unit_id INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id WHERE m.flag = 1 AND m.medicine_id = :medicineId", nativeQuery = true)
    Optional<MedicineDetailDto> getMedicineDetailDtoById(@Param("medicineId") String medicineId);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @Query(value = "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName, m.medicine_active_ingredients AS medicineActiveIngredients, m.medicine_import_price * (1 + m.medicine_retail_sale_profit / 100) / m.medicine_conversion_rate AS medicinePrice, m.medicine_manufacture AS medicineManufacture, "
            + "m.medicine_usage AS medicineUsage, m.medicine_instruction AS medicineInstruction, m.medicine_age_approved AS medicineAgeApproved, m.medicine_image AS medicineImage, m.medicine_description AS medicineDescription, mo.medicine_origin_name AS medicineOrigin, "
            + "mcu.medicine_conversion_unit_name AS medicineConversionUnit, ms.medicine_quantity AS medicineQuantity  "
            + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
            + "INNER JOIN medicine_conversion_unit mcu ON m.medicine_conversion_unit_id = mcu.medicine_conversion_unit_id "
            + "INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id "
            + "INNER JOIN medicine_unit mu ON m.medicine_unit_id = mu.medicine_unit_id INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id WHERE m.flag = 1 AND m.medicine_type_id = :medicineTypeId AND m.medicine_id != :medicineId LIMIT 5", nativeQuery = true)
    List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId, Integer medicineTypeId);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return Integer: medicineTypeId of that medicine
     */
    @Query(value = "SELECT m.medicine_type_id FROM medicine m WHERE m.medicine_id = :medicineId", nativeQuery = true)
    Integer findMedicineTypeById(String medicineId);

    /*
    Created by AnP
    Time: 21:00 29/06/2022
    Function: Get list 10 medicines best seller,
*/
    @Query(value = "SELECT medicineId,medicineName,medicinePrice,medicineImage, medicineQuantity, sum(totalQuantity) AS soldQuantity\n" +
            "                    FROM\n" +
            "                    (SELECT m.medicine_id AS medicineId,\n" +
            "                    m.medicine_name AS medicineName,\n" +
            "                    (m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,\n" +
            "                    m.medicine_image AS medicineImage, ms.medicine_quantity as medicineQuantity ,\n" +
            "                    sum(cd.cart_detail_quantity) AS totalQuantity\n" +
            "                    FROM medicine m\n" +
            "                             INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id\n" +
            "                             INNER JOIN cart_detail cd ON m.medicine_id = cd.medicine_id\n" +
            "                             INNER JOIN cart c ON cd.cart_id = c.cart_id\n" +
            "                             INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id\n" +
            "                    WHERE c.cart_status = 1\n" +
            "                    GROUP BY m.medicine_id\n" +
            "                    UNION\n" +
            "                    SELECT m.medicine_id AS medicineId,\n" +
            "                           m.medicine_name AS medicineName,\n" +
            "                           (m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,\n" +
            "                           m.medicine_image AS medicineImage, ms.medicine_quantity as medicineQuantity ,\n" +
            "                           sum(im.invoice_medicine_quantity) AS totalQuantity\n" +
            "                    FROM medicine m\n" +
            "                             INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id\n" +
            "                             INNER JOIN invoice_medicine im ON m.medicine_id = im.medicine_id\n" +
            "                             INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id\n" +
            "                    GROUP BY m.medicine_id\n" +
            "                    ) AS total\n" +
            "                    GROUP BY medicineId\n" +
            "                    ORDER BY soldQuantity DESC\n" +
            "                    LIMIT 10",
            nativeQuery = true)
    List<IMedicineDto> getListMedicineBestSeller();

    /*
        Created by AnP
        Time: 18:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */
    @Query(value =
            "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName,"
                    + "(m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,"
                    + "m.medicine_manufacture AS medicineManufacture, "
                    + "m.medicine_image AS medicineImage,"
                    + "mt.medicine_type_name AS medicineTypeName, ms.medicine_quantity as medicineQuantity "
                    + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
                    + "INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id "
                    + " INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id"
                    + " WHERE m.medicine_name LIKE concat('%',:name,'%') AND m.medicine_type_id = :typeId AND m.flag=1"
                    + " ORDER BY CASE WHEN :sort = 'priceDesc' THEN medicinePrice END DESC, CASE WHEN :sort = 'priceAsc' THEN medicinePrice END ASC, CASE WHEN :sort = 'idDesc' THEN medicineId END DESC",
            countQuery =
                    "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName,"
                            + "(m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,"
                            + "m.medicine_manufacture AS medicineManufacture, "
                            + "m.medicine_image AS medicineImage,"
                            + "mt.medicine_type_name AS medicineTypeName, ms.medicine_quantity as medicineQuantity "
                            + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
                            + "INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id"
                            + " INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id"
                            + " WHERE m.medicine_name LIKE concat('%',:name,'%') AND m.medicine_type_id = :typeId AND m.flag=1"
                            + " ORDER BY CASE WHEN :sort = 'priceDesc' THEN medicinePrice END DESC, CASE WHEN :sort = 'priceAsc' THEN medicinePrice END ASC, CASE WHEN :sort = 'idDesc' THEN medicineId END DESC",
            nativeQuery = true)
    Page<IMedicineDto> getAllMedicineByNameAndTypeId(Pageable pageable, @Param("name") String name, @Param("typeId") Integer typeId, @Param("sort") String sort);

    /*
        Created by AnP
        Time: 18:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name
    */
    @Query(value =
            "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName,"
                    + "(m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,"
                    + "m.medicine_manufacture AS medicineManufacture, "
                    + "m.medicine_image AS medicineImage,"
                    + "mt.medicine_type_name AS medicineTypeName, ms.medicine_quantity as medicineQuantity "
                    + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
                    + "INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id"
                    + " INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id"
                    + " WHERE m.medicine_name LIKE concat('%',:name,'%') AND m.flag=1"
                    + " ORDER BY CASE WHEN :sort = 'priceDesc' THEN medicinePrice END DESC, CASE WHEN :sort = 'priceAsc' THEN medicinePrice END ASC, CASE WHEN :sort = 'idDesc' THEN medicineId END DESC",
            countQuery =
                    "SELECT m.medicine_id AS medicineId, m.medicine_name AS medicineName,"
                            + "(m.medicine_import_price * (1+m.medicine_retail_sale_profit/100)/m.medicine_conversion_rate) AS medicinePrice,"
                            + "m.medicine_manufacture AS medicineManufacture, "
                            + "m.medicine_image AS medicineImage,"
                            + "mt.medicine_type_name AS medicineTypeName, ms.medicine_quantity as medicineQuantity "
                            + "FROM medicine m INNER JOIN medicine_origin mo ON m.medicine_origin_id = mo.medicine_origin_id "
                            + "INNER JOIN medicine_type mt ON m.medicine_type_id = mt.medicine_type_id"
                            + " INNER JOIN medicine_storage ms ON m.medicine_id = ms.medicine_id"
                            + " WHERE m.medicine_name LIKE concat('%',:name,'%') AND m.flag=1"
                            + " ORDER BY CASE WHEN :sort = 'priceDesc' THEN medicinePrice END DESC, CASE WHEN :sort = 'priceAsc' THEN medicinePrice END ASC, CASE WHEN :sort = 'idDesc' THEN medicineId END DESC",
            nativeQuery = true)
    Page<IMedicineDto> getAllMedicineByName(Pageable pageable, @Param("name") String name, @Param("sort") String sort);

}

