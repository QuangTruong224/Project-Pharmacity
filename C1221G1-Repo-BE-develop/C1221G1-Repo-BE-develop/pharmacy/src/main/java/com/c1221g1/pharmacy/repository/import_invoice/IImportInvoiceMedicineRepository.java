package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.dto.import_invoice.MedicineImportDto;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImportInvoiceMedicineRepository extends JpaRepository<ImportInvoiceMedicine, Integer> {



    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: use MedicineImportDto object to get list medicine_id and quantity in import_invoice_medicine table
     * by importInvoiceId
     *
     * @param importInvoiceId
     * @return List<MedicineImportDto>
     */
    @Query(value = "SELECT iim.medicine_id medicineImportId," +
            " iim.import_invoice_medicine_import_amount medicineImportQuantity " +
            "FROM import_invoice_medicine iim " +
            "WHERE import_invoice_id = :id AND flag = 1", nativeQuery = true)
    List<MedicineImportDto> findImportMedicineByImportInvoiceId(@Param("id") String importInvoiceId);

}
