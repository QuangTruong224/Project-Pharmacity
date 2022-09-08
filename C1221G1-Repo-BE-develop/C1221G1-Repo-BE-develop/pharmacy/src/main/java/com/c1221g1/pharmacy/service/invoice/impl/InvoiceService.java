package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.IInvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository iInvoiceRepository;

    /*
     * Created by DaLQA
     * Time: 1:30 PM 02/07/2022
     * Function: function saveInvoice
     * */
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        invoice.setInvoiceCreatedDate(LocalDate.now().toString());
        invoice.setInvoiceCreateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        invoice.setFlag(true);
        return this.iInvoiceRepository.save(invoice);
    }

    /*
     * Created by TrinhNN
     * Function: find invoice by invoice id
     * */
    @Override
    public Invoice findByInvoiceId(String invoiceId) {
        return iInvoiceRepository.findByInvoiceId(invoiceId,true);
    }

    /**
     * @author: TuanPA
     * Function: List and search and sort invoices
     */
    @Override
    public Page<IInvoiceDto> findAllInvoice(String startDate, String endDate,
                                            String typeOfInvoiceId, Pageable pageable) {
        return iInvoiceRepository.findAllInvoice(startDate,endDate,typeOfInvoiceId,pageable);
    }

    @Override
    public void delete(String id) {
        iInvoiceRepository.deleteByFlag(id);
    }

    @Override
    public Invoice findById(String id) {
        return iInvoiceRepository.findInvoiceById(id);
    }
}