package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.dto.invoice.IInvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function saveInvoice
     * */
    Invoice saveInvoice(Invoice invoice);

    Invoice findByInvoiceId(String invoiceId);

    Page<IInvoiceDto> findAllInvoice(String startDate, String endDate,
                                     String typeOfInvoiceId, Pageable pageable);

    void delete(String id);

    Invoice findById(String id);
}