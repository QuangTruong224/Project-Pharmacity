package com.c1221g1.pharmacy.service.prescription.impl;

import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import com.c1221g1.pharmacy.repository.prescription.IMedicinePrescriptionRepository;
import com.c1221g1.pharmacy.service.prescription.IMedicinePrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicinePrescriptionService implements IMedicinePrescriptionService {

    @Autowired
    private IMedicinePrescriptionRepository medicinePrescriptionRepository;

    @Override
    public void saveMedicinePrescription(MedicinePrescription medicinePrescription) {
        this.medicinePrescriptionRepository.save(medicinePrescription);
    }

    @Override
    public void editMedicinePrescription(MedicinePrescription medicinePrescription) {
        this.medicinePrescriptionRepository.editMedicinePrescription(medicinePrescription);
    }

    @Override
    public MedicinePrescription findById(int id) {
        return this.medicinePrescriptionRepository.findById(id).orElse(null);
    }

//    @Override
//    public boolean savePrescriptionAndMedicinePrescription(PrescriptionDto prescriptionDto) {
//        List<MedicinePrescriptionDto> medicinePrescriptionDtoList = prescriptionDto.getMedicinePrescriptionDtoList();
////        for (MedicinePrescriptionDto item : medicinePrescriptionDtoList) {
////            MedicineStorage medicineStorage = this.iMedicineStorageService
////                    .getStorageByIdMedicine(item.getMedicineId()).get();
////            Long quantityCurrentMedicine = medicineStorage.getMedicineQuantity();
////            if (quantityCurrentMedicine - item.getQuantity() < 0) {
////                throw new Exception("hết thuốc");
////            }
////            medicineStorage.setMedicineQuantity(quantityCurrentMedicine - item.getQuantity());
////        }
//
//        Prescription prescription = new Prescription();
//        Prescription newPrescription = prescriptionService.savePrescription(prescription);
//
//        for (MedicinePrescriptionDto medicinePrescriptionDto : medicinePrescriptionDtoList) {
//            MedicinePrescription medicinePrescription = new MedicinePrescription();
//            Medicine medicine = medicineRepository.findById(medicinePrescriptionDto.getMedicineId()).orElse(null);
//            medicinePrescription.setMedicine(medicine);
//            medicinePrescription.setPrescription(newPrescription);
//            medicinePrescription.setMedicinePrescriptionTimes(medicinePrescriptionDto.getTimes());
//            medicinePrescription.setMedicinePrescriptionNumberPerTime(medicinePrescriptionDto.getNumberPerTime());
//            this.medicinePrescriptionRepository.save(medicinePrescription);
//        }
//        if (newPrescription != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
