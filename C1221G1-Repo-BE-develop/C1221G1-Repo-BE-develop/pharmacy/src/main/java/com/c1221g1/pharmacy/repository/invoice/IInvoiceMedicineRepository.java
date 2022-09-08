package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInvoiceMedicineRepository extends JpaRepository<InvoiceMedicine, Integer> {
    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    @Transactional
    @Modifying
    @Query(value = "insert into invoice_medicine (invoice_medicine_quantity, medicine_id ,invoice_id)" +
            " value (?1,?2,?3)", nativeQuery = true)
    void createInvoiceMedicine(Integer quantity, String medicineId, String invoiceId);

    /*
            Created by TrinhNN
              Function: Find invoiceMedicine by Invoice id
        */
    @Query(value = "select *" +
            "from invoice inner join invoice_medicine  on invoice.invoice_id = invoice_medicine.invoice_id" +
            " where invoice.invoice_id = :invoice_id and invoice.type_of_invoice_id = 2", nativeQuery = true)
    List<InvoiceMedicine> findByInvoiceId(@Param("invoice_id") String id);
}