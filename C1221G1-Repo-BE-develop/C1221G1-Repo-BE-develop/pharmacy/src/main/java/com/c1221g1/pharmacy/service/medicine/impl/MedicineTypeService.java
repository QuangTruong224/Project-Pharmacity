package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.repository.medicine.IMedicineTypeRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineTypeService implements IMedicineTypeService {
    @Autowired
    private IMedicineTypeRepository medicineTypeRepository;
    /**
     * this function use to get medicineTypeList
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<MedicineType> getAll() {
        return this.medicineTypeRepository.getAll();
    }
}
