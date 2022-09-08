package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.repository.invoice.ITypeOfInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfInvoiceService implements ITypeOfInvoiceService {
    @Autowired
    private ITypeOfInvoiceRepository iTypeOfInvoiceRepository;
    @Override
    public TypeOfInvoice getTypeOfInvoiceWholeSale() {
        return iTypeOfInvoiceRepository.getTypeOfInvoiceWholeSale();
    }
}