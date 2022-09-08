package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import com.c1221g1.pharmacy.entity.prescription.Prescription;

public interface IMedicinePrescriptionService {
    void saveMedicinePrescription(MedicinePrescription medicinePrescription);

    void editMedicinePrescription(MedicinePrescription medicinePrescription);

    MedicinePrescription findById(int id);
}
