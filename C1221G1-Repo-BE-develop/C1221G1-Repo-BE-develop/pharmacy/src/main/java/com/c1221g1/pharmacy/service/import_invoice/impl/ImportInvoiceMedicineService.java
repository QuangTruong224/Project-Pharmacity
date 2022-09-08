package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.dto.import_invoice.MedicineImportDto;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceMedicineRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceMedicineService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportInvoiceMedicineService implements IImportInvoiceMedicineService {
    @Autowired
    private IImportInvoiceMedicineRepository importInvoiceMedicineRepository;
    @Autowired
    private IMedicineStorageService medicineStorageService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: get list medicie_id and quantity in import_invoice_medicine table
     * by importInvoiceId
     *
     * @param importInvoiceId
     * @return List<MedicineImportDto>
     */
    @Override
    public List<MedicineImportDto> findImportMedicineByImportInvoiceId(String importInvoiceId) {
        return importInvoiceMedicineRepository.findImportMedicineByImportInvoiceId(importInvoiceId);
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: update/create info medicine quantity in medicine storage
     * by medicineImportDtoList, include (medicine_id and quantity)
     *
     * @param importInvoiceId
     * @return true if update success
     * and return fall if update fail.
     */
    @Override
    public boolean updateMedicineStorage(String importInvoiceId) {
        List<MedicineImportDto> medicineImportDtoList = this.findImportMedicineByImportInvoiceId(importInvoiceId);
        boolean flag = false;
        for (int i = 0; i < medicineImportDtoList.size(); i++) {
            String medicineId = medicineImportDtoList.get(i).getMedicineImportId();
            Long medicineQuantityImport = Long.parseLong(medicineImportDtoList.get(i).getMedicineImportQuantity());
            flag = medicineStorageService.changeMedicineQuantity(medicineId, medicineQuantityImport, 1);
        }
        return flag;
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: save ImportInvoiceMedicine
     *
     * @param importInvoiceMedicine
     */
    @Override
    public void saveImportInvoiceMedicine(ImportInvoiceMedicine importInvoiceMedicine) {
        this.importInvoiceMedicineRepository.save(importInvoiceMedicine);
    }
}
