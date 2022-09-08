package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IInvoiceMedicineService {
    /*
     * Created by DaLQA
     * Time: 1:16 PM 02/07/2022
     * Function: function createInvoiceMedicine
     * */
    boolean saveInvoiceMedicine(InvoiceDto invoiceDto) throws Exception;

    List<InvoiceMedicine> findByInvoiceId(String id);

    boolean saveWholesaleInvoiceMedicine(InvoiceDto invoiceDto) throws Exception;

    boolean saveRefundInvoiceMedicine(InvoiceDto invoiceDto);
}