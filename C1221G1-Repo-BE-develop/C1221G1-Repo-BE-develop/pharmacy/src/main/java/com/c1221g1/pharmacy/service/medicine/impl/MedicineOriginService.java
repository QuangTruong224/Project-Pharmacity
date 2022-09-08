package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.repository.medicine.IMedicineOriginRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineOriginService implements IMedicineOriginService {

    @Autowired
    private IMedicineOriginRepository medicineOriginRepository;
    /**
     * this function use to get medicineOriginList
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<MedicineOrigin> getAll() {
        return this.medicineOriginRepository.getAll();
    }
}
