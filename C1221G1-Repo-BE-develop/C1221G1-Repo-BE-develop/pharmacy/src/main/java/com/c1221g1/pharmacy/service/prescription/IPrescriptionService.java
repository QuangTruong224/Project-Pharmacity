package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDetail;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionMedicineDetail;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrescriptionService {
    Page<Prescription> findAllPageAndSearch(Pageable pageable, String id, String name, String target, String symptom);

    void savePrescription(Prescription prescription);

    Prescription findById(String id);

    void deleteById(String id);

    void edit(Prescription prescription);

    List<IMedicinePrescriptionDto> getPrescriptionById(String id);


    List<Prescription> findAllListPrescription();


    PrescriptionDetail getDetailPrescription(String id);

    List<PrescriptionMedicineDetail> getListPreMeDetail(String id);
}

