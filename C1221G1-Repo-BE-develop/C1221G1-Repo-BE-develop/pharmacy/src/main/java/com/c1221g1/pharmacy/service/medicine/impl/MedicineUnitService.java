package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import com.c1221g1.pharmacy.repository.medicine.IMedicineUnitRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineUnitService implements IMedicineUnitService {
    @Autowired
    private IMedicineUnitRepository medicineUnitRepository;
    /**
     * this function use to get medicineUnitList
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<MedicineUnit> getAll() {
        return medicineUnitRepository.getAll();
    }
}
