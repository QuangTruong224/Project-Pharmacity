package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITypeOfInvoiceRepository extends JpaRepository<TypeOfInvoice,Integer> {

    @Query(value = "select type_of_invoice_id, type_of_invoice_name from type_of_invoice  where type_of_invoice_id = 2;",nativeQuery = true)
    TypeOfInvoice getTypeOfInvoiceWholeSale();
    @Query(value = "select type_of_invoice_id, type_of_invoice_name from type_of_invoice  where type_of_invoice_id = 3;",nativeQuery = true)
    TypeOfInvoice getTypeOfInvoiceRefund();
}

