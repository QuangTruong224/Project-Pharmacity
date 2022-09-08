package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceMedicineService;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportInvoiceService implements IImportInvoiceService {

    @Autowired
    private IImportInvoiceRepository importInvoiceRepository;
    @Autowired
    private IImportInvoiceMedicineService importInvoiceMedicineService;
    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: save ImportInvoiceMedicine
     *
     * @param importInvoice
     * @return ImportInvoice
     */
    @Override
    public ImportInvoice saveImportInvoice(ImportInvoice importInvoice) {
        return this.importInvoiceRepository.save(importInvoice);
    }

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     * @return
     */
    @Override
    public Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, Pageable pageable) {
        return importInvoiceRepository.findAllImportInvoice(startDate, endDate, pageable);
    }

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @Override
    public void deleteById(String id) {
        importInvoiceRepository.deleteImportInvoice(id);
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: save importInvoiceMedicine
     *
     * @param importInvoiceMedicine
     * @return true;
     * note: return true, for validate after.
     */
    @Override
    public Boolean saveImportInvoiceMedicine(ImportInvoiceMedicine importInvoiceMedicine) {
        this.importInvoiceMedicineService.saveImportInvoiceMedicine(importInvoiceMedicine);
        return true;
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: update MedicineStorage
     *
     * @param medicine
     * @param importInvoiceMedicineImportAmount
     * @return true if update success
     * false if update fail,
     * manipulation = 1 -> import.
     */
    @Override
    public Boolean updateMedicineStorage(Medicine medicine, Integer importInvoiceMedicineImportAmount) {
        String medicineId = medicine.getMedicineId();
        Long quantity = Long.valueOf(importInvoiceMedicineImportAmount);
        return this.iMedicineStorageService.changeMedicineQuantity(medicineId, quantity, 1);
    }
}
