package com.c1221g1.pharmacy.controller.prescription;


import com.c1221g1.pharmacy.dto.prescription.MedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import com.c1221g1.pharmacy.service.prescription.IMedicinePrescriptionService;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-prescription/prescriptions")
public class MedicinePrescriptionController {
    @Autowired
    private IMedicineService medicineService;

    @Autowired
    private IPrescriptionService prescriptionService;

    @Autowired
    private IMedicinePrescriptionService medicinePrescriptionService;

    @PostMapping("/create-med-pre")
    public ResponseEntity<List<FieldError>> createPrescription(
            @Validated @RequestBody MedicinePrescriptionDto medicinePrescriptionDto,
            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        MedicinePrescription medicinePrescription = new MedicinePrescription();

        BeanUtils.copyProperties(medicinePrescriptionDto, medicinePrescription);

        this.medicinePrescriptionService.saveMedicinePrescription(medicinePrescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * HienTLD
     * Sửa chi tiết đơn thuốc
     * update 11:18 30/06/2022
     */
    @PatchMapping("med-pre/{id}")
    public ResponseEntity<List<FieldError>> editPrescription(
            @Validated @RequestBody MedicinePrescriptionDto medicinePrescriptionDto,
            BindingResult bindingResult,
            @PathVariable int id) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        MedicinePrescription medicinePrescription = new MedicinePrescription();

        medicinePrescription.setMedicinePrescriptionId(id);

        BeanUtils.copyProperties(medicinePrescriptionDto, medicinePrescription);

        this.medicinePrescriptionService.editMedicinePrescription(medicinePrescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * HienTLD
     * Chi tiết toa thuốc
     * 10:58 06/07/2022
     */
    @GetMapping(value = "med-pre/{id}")
    public ResponseEntity<MedicinePrescription> getInfoPrescription(@PathVariable int id) {

        MedicinePrescription medicinePrescription = this.medicinePrescriptionService.findById(id);

        if (medicinePrescription == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(medicinePrescription, HttpStatus.OK);
    }

//    @PostMapping("")
//    public ResponseEntity<Map<String, String>> createPrescription(@Validated @RequestBody
//                                                                              PrescriptionDto prescriptionDto,
//                                                                   BindingResult bindingResult) throws Exception {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError());
//            Map<String, String> errorMap = bindingResult.getFieldErrors()
//                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
//            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
//        }
//        try {
//            boolean checkCreateMedicinePrescription = this.medicinePrescriptionService.savePrescriptionAndMedicinePrescription(prescriptionDto);
//            return new ResponseEntity<>(checkCreateMedicinePrescription ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
//        } catch (Exception e){
//            Map<String,String> errors = new HashMap<>();
//            errors.put("errors","số lượng trong kho không đủ");
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//        }
//    }
}
