package com.c1221g1.pharmacy.controller.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDetail;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionMedicineDetail;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-prescription/prescriptions")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService prescriptionService;

    /**
     * HienTLD
     * Danh sách toa thuốc và tìm kiếm
     * 16:00 29/06/2022
     */
    @GetMapping("")
    public ResponseEntity<Page<Prescription>> getPageAndSearchPrescription(@RequestParam Optional<String> id,
                                                                           @RequestParam Optional<String> names,
                                                                           @RequestParam Optional<String> target,
                                                                           @RequestParam Optional<String> symptom,
                                                                           @PageableDefault(value = 5) Pageable pageable) {

        String idVal = id.orElse("");
        String nameVal = names.orElse("");
        String targetVal = target.orElse("");
        String symptomVal = symptom.orElse("");

        Page<Prescription> prescriptionPage = this.prescriptionService
                .findAllPageAndSearch(pageable, idVal, nameVal, targetVal, symptomVal);

        if (!prescriptionPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prescriptionPage, HttpStatus.OK);
    }

    /**
     * HienTLD
     * danh sách List<>
     * 23:56 05/07/2022
     */
    @GetMapping("/list")
    public ResponseEntity<List<Prescription>> getListPrescription() {

        List<Prescription> prescriptionList = this.prescriptionService.findAllListPrescription();

        if (prescriptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }

//    /**
//     * HienTLD
//     * Lấy tất cả chỉ định toa thuốc
//     * 16:30 29/06/2022
//     */
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<List<IMedicinePrescriptionDto>> getMedicinePrescription(@PathVariable String id) {
//
//        List<IMedicinePrescriptionDto> medicinePrescriptionDto = this.prescriptionService.getPrescriptionById(id);
//
//        if (medicinePrescriptionDto == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(medicinePrescriptionDto, HttpStatus.OK);
//    }

    /**
     * HienTLD
     * Thêm mới toa thuốc
     * 16:30 29/06/2022
     */
    @PostMapping(value = "")
    public ResponseEntity<List<FieldError>> createPrescription(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Prescription prescription = new Prescription();

        prescriptionDto.setFlag(true);

        BeanUtils.copyProperties(prescriptionDto, prescription);


        this.prescriptionService.savePrescription(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * HienTLD
     * Xoá toa thuốc (xoá theo cờ 'flag')
     * 16:00 29/06/2022
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable("id") String id) {
        try {
            this.prescriptionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * HienTLD
     * Sửa toa thuốc
     * update 11:18 30/06/2022
     */
    @PatchMapping("/{id}")
    public ResponseEntity<List<FieldError>> editPrescription(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                             BindingResult bindingResult,
                                                             @PathVariable String id) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Prescription prescription = new Prescription();

        prescription.setPrescriptionId(id);

        prescription.setFlag(true);

        BeanUtils.copyProperties(prescriptionDto, prescription);

        this.prescriptionService.edit(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * Created by DaLQA
     * Time: 10:46 AM 05/07/2022
     * Function: getPrescriptionDetail
     * */
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<PrescriptionDetail> getPrescriptionDetail(@PathVariable String id) {
        PrescriptionDetail prescriptionDetail = this.prescriptionService.getDetailPrescription(id);


        if (prescriptionDetail == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(prescriptionDetail, HttpStatus.OK);
    }

    /*
     * Created by DaLQA
     * Time: 10:46 AM 05/07/2022
     * Function: getListPrescriptionMedicine
     * */
    @GetMapping("/detail/prescriptions-medicines/{id}")
    public ResponseEntity<List<PrescriptionMedicineDetail>> getListPrescriptionMedicine(@PathVariable String id) {
        List<PrescriptionMedicineDetail> prescriptionMedicineDetails = this.prescriptionService.getListPreMeDetail(id);
        if (prescriptionMedicineDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescriptionMedicineDetails, HttpStatus.OK);
    }

    /**
     * HienTLD
     * Chi tiết toa thuốc
     * 10:58 06/07/2022
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Prescription> getInfoPrescription(@PathVariable String id) {

        Prescription prescription = this.prescriptionService.findById(id);

        if (prescription == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }
}

