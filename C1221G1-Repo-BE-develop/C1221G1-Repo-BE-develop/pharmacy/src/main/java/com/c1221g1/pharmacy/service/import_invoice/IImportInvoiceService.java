package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IImportInvoiceService {
    ImportInvoice saveImportInvoice(ImportInvoice importInvoice);

    Boolean saveImportInvoiceMedicine(ImportInvoiceMedicine importInvoiceMedicine);

    Boolean updateMedicineStorage(Medicine medicine, Integer importInvoiceMedicineImportAmount);

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, Pageable pageable);

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    void deleteById(String id);
}
