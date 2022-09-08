use c1221g1_pharmacy;
Select i.invoice_id invoiceId,
            i.invoice_created_date createdDay,
            i.employee_id employeeId,
            (if(i.type_of_invoice_id = 1,
                ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                                               *m.medicine_retail_sale_profit),
                ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                                               *m.medicine_wholesale_profit))) total,
           (if(i.type_of_invoice_id = 1,
               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                   *(m.medicine_retail_sale_profit-1),
               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                   *(m.medicine_wholesale_profit-1))) profit
            from invoice i
            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
            inner join medicine m on ic.medicine_id = m.medicine_id
            Where ((i.invoice_created_date>='2020-01-01') and (i.invoice_created_date<='2022-06-30'))
            Group by i.invoice_id;

select m.medicine_id, m.medicine_name, sum(im.invoice_medicine_quantity) total_quantity
from medicine m
inner join invoice_medicine im on m.medicine_id = im.medicine_id
group by m.medicine_id
order by total_quantity desc
limit 100;

select
       i.employee_id employeeId,
       sum((if(i.type_of_invoice_id = 1,
               ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                   *m.medicine_retail_sale_profit),
               ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                   *m.medicine_wholesale_profit)))) total,
       sum((if(i.type_of_invoice_id = 1,
               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                   *(m.medicine_retail_sale_profit-1),
               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                   *(m.medicine_wholesale_profit-1)))) profit
        from invoice i
         inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
         inner join medicine m on ic.medicine_id = m.medicine_id
        Where ((i.invoice_created_date>='2020-01-05') and (i.invoice_created_date<='2022-06-25'))
        Group by i.employee_id;

select s.supplier_id supplierId, s.supplier_name supplierName,
       sum((ii.total-ii.payment_prepayment)) balance
from supplier s
         inner join import_invoice ii on s.supplier_id = ii.supplier_id
group by s.supplier_id
having balance>0;

select m.medicine_id medicineId, m.medicine_name medicineName, ms.medicine_quantity
from medicine m
inner join medicine_storage ms on m.medicine_id = ms.medicine_id
where medicine_quantity<5;

select m.medicine_id medicineId, m.medicine_name medicineName, ms.medicine_quantity quantity,
       iim.import_invoice_medicine_expiry expiredDate
from medicine_storage ms
inner join medicine m on ms.medicine_id = m.medicine_id
inner join import_invoice_medicine iim on m.medicine_id = iim.medicine_id
where (iim.import_invoice_medicine_expiry-curdate()<10)
group by m.medicine_id;

Select      '1' month,
            sum((if(i.type_of_invoice_id = 1,
                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                        *m.medicine_retail_sale_profit),
                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                        *m.medicine_wholesale_profit)))) total,
            sum((if(i.type_of_invoice_id = 1,
                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                        *(m.medicine_retail_sale_profit-1),
                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                        *(m.medicine_wholesale_profit-1)))) profit
     from invoice i
              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
              inner join medicine m on ic.medicine_id = m.medicine_id
     Where (month(i.invoice_created_date)='1' and year(i.invoice_created_date)=:'year');
