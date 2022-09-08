package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.dto.import_invoice.ISupplierDto;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import com.c1221g1.pharmacy.repository.import_invoice.ISupplierRepository;
import com.c1221g1.pharmacy.service.import_invoice.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    ISupplierRepository iSupplierRepository;


    /**
     * DI
     * call method save(supplier) in ISupplierRepository
     * 11h38 29/06/2022 trần ngọc luật
     */
    @Override
    public void save(Supplier supplier) {
        supplier.setFlag(true);
        iSupplierRepository.save(supplier);
    }

    /**
     * DI
     * call method indByIdSupplier(id); in ISupplierRepository
     * 11h38 29/06/2022 trần ngọc luật
     */
    @Override
    public Supplier findById(String id) {
        return iSupplierRepository.findByIdSupplier(id);
    }

    /**
     * DI
     * call method update() in ISupplierRepository
     * 11h38 29/06/2022 trần ngọc luật
     */
    @Override
    public void update(Supplier supplier) {
        iSupplierRepository.updateSupplier(supplier);
    }

    /**
     * DI
     * call method deleteSupplierById(id) in ISupplierRepository
     * 11h38 29/06/2022 trần ngọc luật
     */
    @Override
    public void removeSupplierById(String id) {
        iSupplierRepository.deleteSupplierById(id);
    }

    /**
     * DI
     * call method getAllSupplier in ISupplierRepository
     * find All list and
     * before the field to search add "%" to search for a match
     * 11h38 29/06/2022 trần ngọc luật
     */
    @Override
    public Page<Supplier> findAll(String searchId,
                                  String searchName,
                                  String searchAddress,
                                  String searchPhone,
                                  Pageable pageable) {

        return iSupplierRepository.getAllSupplier("%" + searchId + "%", "%" + searchName + "%", "%" + searchAddress + "%", "%" + searchPhone + "%", pageable);
    }

    /**
     * Created by: TrungTVH
     * Date created: 4/7/2022
     * function: create temp supplier service dùng tạm
     */
    @Override
    public List<Supplier> getList() {
        return this.iSupplierRepository.findAll();
    }

    @Override
    public ISupplierDto findByIdDEtail(String id) {
        return iSupplierRepository.findByIdDetailSupplier(id);
    }
}
