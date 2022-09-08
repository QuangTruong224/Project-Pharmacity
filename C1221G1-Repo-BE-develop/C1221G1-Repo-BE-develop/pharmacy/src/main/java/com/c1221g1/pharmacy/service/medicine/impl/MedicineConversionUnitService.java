package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.repository.medicine.IMedicineConversionUnitRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineConversionUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineConversionUnitService implements IMedicineConversionUnitService {
    @Autowired
    private IMedicineConversionUnitRepository medicineConversionUnitRepository;
    /**
     * this function use to get medicineConversionUnitList
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<MedicineConversionUnit> getAll() {
        return this.medicineConversionUnitRepository.getAll();
    }
}
