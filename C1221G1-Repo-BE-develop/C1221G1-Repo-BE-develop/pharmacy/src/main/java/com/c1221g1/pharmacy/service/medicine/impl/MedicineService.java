package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService implements IMedicineService {

    @Autowired
    private IMedicineRepository medicineRepository;

    /*
     * Created by DaLQA
     * Time: 04/07/2022
     * Function: function create getListMedicineSale
     * */
    @Override
    public List<MedicineSale> getListMedicineSale() {
        return this.medicineRepository.getListMedicineSale();
    }

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get list medicine and search
     */

    @Override
    public List<MedicineLookUpDto> findAllMedicine(String columName, String condition, String keyword) {
        return medicineRepository.getAllMedicine(columName, condition, keyword);
    }

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @Override
    public void deleteMedicineById(String id) {
        this.medicineRepository.deleteMedicineById(id);
    }

    /**
     * this function use to create new medicine
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */

    @Override
    public void createMedicine(Medicine medicine) {
        medicine.setFlag(true);
        this.medicineRepository.save(medicine);
    }

    /**
     * this function use to find medicine in db and return medicine
     *
     * @author LongNH
     * @Time 20:20 29/06/2022
     */
    @Override
    public Optional<Medicine> findMedicineById(String id) {
        return this.medicineRepository.findMedicineById(id);
    }

    /**
     * this function use to create exist medicine
     *
     * @author LongNH
     * @Time 20:10 29/06/2022
     */
    @Override
    public void updateMedicine(Medicine existMedicine) {
        this.medicineRepository.updateMedicine(existMedicine);
    }

    /**
     * Created by: TrungTVH
     * Date created: 4/7/2022
     * function: get medicine list dùng tạm
     */
    @Override
    public List<Medicine> getList() {
        return this.medicineRepository.findAll();
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Override
    public MedicineDetailDto getMedicineDetailDtoById(String medicineId) {
        return medicineRepository.getMedicineDetailDtoById(medicineId)
                .orElse(null);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @Override
    public List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId) {
        Integer medicineTypeId = medicineRepository.findMedicineTypeById(medicineId);
        if (medicineTypeId == null) {
            return Collections.emptyList();
        }
        return medicineRepository.get5RelativeMedicinesOf(medicineId, medicineTypeId);
    }

    /*
         Created by AnP
         Time: 17:30 29/06/2022
         Function: Get list 10 medicines best seller,
    */

    @Override
    public List<IMedicineDto> getListMedicineBestSeller() {
        return medicineRepository.getListMedicineBestSeller();
    }

    /*
        Created by AnP
        Time: 17:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */

    @Override
    public Page<IMedicineDto> getListAndSearch(Pageable pageable, String name, Integer typeId, String sort) {
        if (typeId != null) {
            return medicineRepository.getAllMedicineByNameAndTypeId(pageable, name, typeId, sort);
        }
        return medicineRepository.getAllMedicineByName(pageable, name, sort);
    }

    /**
     * HienTLD
     * danh sách List<>
     * 9:00 06/07/2022
     */
    @Override
    public List<Medicine> findAllMedicine() {
        return this.medicineRepository.findAll();
    }

}

