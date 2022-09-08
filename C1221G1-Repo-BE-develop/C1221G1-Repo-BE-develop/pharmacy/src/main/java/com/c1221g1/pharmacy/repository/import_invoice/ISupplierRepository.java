package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.dto.import_invoice.ISupplierDto;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ISupplierRepository extends JpaRepository<Supplier, String> {

    /**
     * get all the information in the db of the vendors table provided that the 'flag' = 1
     * ( 1 is exists in the list ) ( 0 is hidden from the list )
     * ( searchId ( vendor id )
     * searchName ( Provider name)
     * searchAddress (provider address)
     * searchPhone (provider phone number)    search for 4 fields named as follows)
     * 16h 29/06/2022
     */
    @Query(value = "select supplier_id, flag, note, supplier_address, supplier_email, supplier_name, supplier_phone" +
            " from supplier " +
            "where  supplier_id like :searchId and supplier_name like :searchName and supplier_address like :searchAddress and supplier_phone like :searchPhone " +
            " and `flag` = 1  ",
            countQuery = "select supplier_id, flag, note, supplier_address, supplier_email, supplier_name, supplier_phone" +
                    " from supplier " +
                    "where  supplier_id like :searchId and supplier_name like :searchName and supplier_address like :searchAddress and supplier_phone like :searchPhone " +
                    " and `flag` = 1  ",
            nativeQuery = true)
    Page<Supplier> getAllSupplier(
            @Param("searchId") String searchId,
            @Param("searchName") String searchName,
            @Param("searchAddress") String searchAddress,
            @Param("searchPhone") String searchPhone,
            Pageable pageable);

    /**
     * edit status 'flag ' 0
     * ( we will hide it from the list page)
     * <p>
     * because later on we will need to go to the deleted providers
     * 16h 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE supplier SET `flag` = 0 " +
            "WHERE supplier_id = :id",
            nativeQuery = true)
    void deleteSupplierById(@Param("id") String id);

    /**
     * get field values
     * supplier_name (supplier name )  supplier name
     * supplier_address supplier name )  supplier address
     * supplier_phone ( supplier name )  supplier phone )
     * supplier_email ( email  supplier)
     * note
     * save  in database
     * 16h 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = " insert into supplier (supplier_name, supplier_address,  supplier_phone, supplier_email, note) VALUE (:note, :supplier_address, :supplier_email, :supplier_name, :supplier_phone )",
            nativeQuery = true)
    void saveSupplier(@Param("supplier_name") String supplierName,
                      @Param("supplier_address") String supplierAddress,
                      @Param("supplier_phone") String supplierPhone,
                      @Param("supplier_email") String supplierEmail,
                      @Param("note") String note
    );


    /**
     * get for 1 supplier whose id is the value the user entered
     * (  Serve for detail screen, edit supplier information  )
     * 16h 29/06/2022
     */
    @Query(value = "select   supplier_id , supplier_name, supplier_address,supplier_phone, supplier_email,  note,  flag" +
            " from supplier " +
            "where supplier_id = :supplierId " +
            "and flag = 1 ",
            nativeQuery = true)
    Supplier findByIdSupplier(@Param("supplierId") String supplierId);


    /**
     * take all the value that the stop send down( and id )
     * reset the fields  (supplier_name) (supplier_address) (supplier_email)(supplier_phone) (note)
     * ( The value that you putting send )
     * 19h 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update supplier \n" +
            "set supplier_name= :#{#supplier.supplierName},\n" +
            "    supplier_address = :#{#supplier.supplierAddress},\n" +
            "    supplier_email = :#{#supplier.supplierEmail},\n" +
            "    supplier_phone= :#{#supplier.supplierPhone},\n" +
            "    note = :#{#supplier.note} " +
            "where supplier_id = :#{#supplier.supplierId}",
            nativeQuery = true)
    void updateSupplier(Supplier supplier);

    /**
     * get for 1 supplier whose id is the value the user entered
     * (  Serve for detail screen, edit supplier information  )
     * 16h 29/06/2022
     */
    @Query(value = "select  s.supplier_id as supplierId , s.flag as flag, s.note as note, s.supplier_address as supplierAddress, s.supplier_email as supplierEmail, " +
            "            s.supplier_name as supplierName, s.supplier_phone as supplierPhone , " +
            "             (ii.total - ii.payment_prepayment) as debt " +
            "             from supplier s " +
            "             join import_invoice ii " +
            "             on s.supplier_id = ii.supplier_id " +
            "             where s.supplier_id = :supplierId and s.flag = 1 " +
            "             group by s.supplier_id",
            nativeQuery = true)
    ISupplierDto findByIdDetailSupplier(@Param("supplierId") String id);
}
