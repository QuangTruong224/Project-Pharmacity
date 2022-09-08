select medicine_name,
       medicine_retail_sale_profit * medicine_import_price        as retail_price,
       medicine_image,
       sum(cart_detail_quantity) + sum(invoice_medicine_quantity) as total_quantity
from medicine
         inner join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id
         inner join cart_detail on medicine.medicine_id = cart_detail.medicine_id
         inner join cart c on cart_detail.cart_id = c.cart_id
where c.cart_status = 1
group by medicine.medicine_id
order by total_quantity desc
limit 10;

select m.medicine_id as medicineId, m.medicine_name as medicineName,
       (m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,
       m.medicine_manufacture as medicineManufacture,
       m.medicine_image as medicineImage,
       mt.medicine_type_name as medicineTypeName,
       sum(im.invoice_medicine_quantity)+ sum(cd.cart_detail_quantity) as totalQuantity
from medicine m
    left join invoice_medicine im on m.medicine_id = im.medicine_id
                left join cart_detail cd on m.medicine_id = cd.medicine_id
                inner join cart c on cd.cart_id = c.cart_id
                inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id
where c.cart_status = 1
group by m.medicine_id
order by totalQuantity desc
limit 10;

select medicine_id                 as medicineId,
       flag,
       medicine_active_ingredients as medicineActiveIngredients,
       medicine_age_approved       as medicineAgeApproved,
       medicine_conversion_rate    as medicineConversionRate,
       medicine_description        as medicineDescription,
       medicine_discount           as medicineDiscount,
       medicine_image              as medicineImage,
       medicine_import_price       as medicineImportPrice,
       medicine_instruction        as medicineInstruction,
       medicine_manufacture        as medicineManufacture,
       medicine_name               as medicineName,
       medicine_quantity           as medicineQuantity,
       medicine_retail_sale_profit as medicineRetailSaleProfit,
       medicine_tax                as medicineTax,
       medicine_usage              as medicineUsage,
       medicine_wholesale_profit   as medicineWholesaleProfit,
       medicine_conversion_unit_id as medicineConversionUnitId,
       medicine_origin_id          as medicineOriginId,
       medicine_type_id            as medicineTypeId,
       medicine_unit_id            as medicineUnitId
from medicine
where medicine_name like concat('%', '%', '%');

select medicine_id                 ,
       flag,
       medicine_active_ingredients ,
       medicine_age_approved       ,
       medicine_conversion_rate    ,
       medicine_description        ,
       medicine_discount           ,
       medicine_image              ,
       medicine_import_price       ,
       medicine_instruction        ,
       medicine_manufacture        ,
       medicine_name               ,
       medicine_quantity           ,
       medicine_retail_sale_profit ,
       medicine_tax                ,
       medicine_usage              ,
       medicine_wholesale_profit   ,
       medicine_conversion_unit_id ,
       medicine_origin_id          ,
       medicine_type_id            ,
       medicine_unit_id
from medicine


