package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.*;
import com.c1221g1.pharmacy.service.medicine.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-medicine/medicines")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IMedicineOriginService medicineOriginService;
    @Autowired
    private IMedicineTypeService medicineTypeService;
    @Autowired
    private IMedicineUnitService medicineUnitService;
    @Autowired
    private IMedicineConversionUnitService medicineConversionUnitService;

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all page medicine
     */

    @GetMapping("/search")
    public ResponseEntity<List<MedicineLookUpDto>> findAllMedicine(
                                                                   @RequestParam Optional<String> columName,
                                                                   @RequestParam Optional<String> condition,
                                                                   @RequestParam Optional<String> keyWord
    ) {
        String columNameValue = columName.orElse("medicineId");
        String conditionValue = condition.orElse("like");
        String keyWordValue = keyWord.orElse("'%%'");
        List<MedicineLookUpDto> medicinePage = medicineService.findAllMedicine(columNameValue, conditionValue, keyWordValue);
        if (medicinePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(medicinePage, HttpStatus.OK);

        }
    }


    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Medicine> deleteMedicineById(@PathVariable String id) {
        Medicine medicine = this.medicineService.findMedicineById(id).orElse(null);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.medicineService.deleteMedicineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * this function use to create medicineOriginList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineOriginList")
    public List<MedicineOrigin> medicineOriginList() {
        return this.medicineOriginService.getAll();
    }

    /**
     * this function use to create medicineTypeList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineTypeList")
    public List<MedicineType> medicineTypeList() {
        return this.medicineTypeService.getAll();
    }

    /**
     * this function use to create medicineUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineUnitList")
    public List<MedicineUnit> medicineUnitList() {
        return this.medicineUnitService.getAll();
    }

    /**
     * this function use to create medicineConversionUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineConversionUnitList")
    public List<MedicineConversionUnit> medicineConversionUnitList() {
        return this.medicineConversionUnitService.getAll();
    }

    /**
     * this function use to create new medicine
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @PostMapping("")
    public ResponseEntity<List<FieldError>> createMedicine(@Valid @RequestBody MedicineDto medicineDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Medicine medicine = new Medicine();
        MedicineType medicineType = new MedicineType();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineType.setMedicineTypeId(medicineDto.getMedicineType().getMedicineTypeId());
        medicineOrigin.setMedicineOriginId(medicineDto.getMedicineOrigin().getMedicineOriginId());
        medicineUnit.setMedicineUnitId(medicineDto.getMedicineUnit().getMedicineUnitId());
        medicineConversionUnit.setMedicineConversionUnitId(medicineDto.getMedicineConversionUnit().getMedicineConversionUnitId());
        medicine.setMedicineType(medicineType);
        medicine.setMedicineOrigin(medicineOrigin);
        medicine.setMedicineUnit(medicineUnit);
        medicine.setMedicineConversionUnit(medicineConversionUnit);
        BeanUtils.copyProperties(medicineDto, medicine);
        this.medicineService.createMedicine(medicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * this function use to get all medicine unit
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineUnit")
    public ResponseEntity<List<MedicineUnit>> getMedicineUnitList() {
        List<MedicineUnit> medicineUnitList = this.medicineUnitList();
        if (medicineUnitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineUnitList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine conversion unit
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineConversionUnit")
    public ResponseEntity<List<MedicineConversionUnit>> getMedicineConversionUnitList() {
        List<MedicineConversionUnit> medicineConversionUnitList = this.medicineConversionUnitList();
        if (medicineConversionUnitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineConversionUnitList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine origin
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineOrigin")
    public ResponseEntity<List<MedicineOrigin>> getMedicineOriginList() {
        List<MedicineOrigin> medicineOriginList = this.medicineOriginList();
        if (medicineOriginList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineOriginList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine type
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineType")
    public ResponseEntity<List<MedicineType>> getMedicineTypeList() {
        List<MedicineType> medicineTypeList = this.medicineTypeList();
        if (medicineTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineTypeList, HttpStatus.OK);
        }
    }

    /**
     * this function use to edit exist medicine
     *
     * @author LongNH
     * @Time 20:01 29/06/2022
     */
    @PatchMapping("{id}")
    public ResponseEntity<List<FieldError>> updateMedicine(@PathVariable("id") String id,
                                                           @Valid @RequestBody MedicineDto medicineDto,
                                                           BindingResult bindingResult) {
        Medicine existMedicine = this.medicineService.findMedicineById(id).orElse(null);
        if (existMedicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MedicineType medicineType = new MedicineType();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineType.setMedicineTypeId(medicineDto.getMedicineType().getMedicineTypeId());
        medicineOrigin.setMedicineOriginId(medicineDto.getMedicineOrigin().getMedicineOriginId());
        medicineUnit.setMedicineUnitId(medicineDto.getMedicineUnit().getMedicineUnitId());
        medicineConversionUnit.setMedicineConversionUnitId(medicineDto.getMedicineConversionUnit().getMedicineConversionUnitId());
        existMedicine.setMedicineType(medicineType);
        existMedicine.setMedicineOrigin(medicineOrigin);
        existMedicine.setMedicineUnit(medicineUnit);
        existMedicine.setMedicineConversionUnit(medicineConversionUnit);
        BeanUtils.copyProperties(medicineDto, existMedicine);
        existMedicine.setMedicineId(id);
        this.medicineService.updateMedicine(existMedicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * this function use to get exist medicine in db
     *
     * @author LongNH
     * @Time 19:25 03/07/2022
     */
    @GetMapping("{id}")
    public ResponseEntity<Medicine> findMedicineById(@PathVariable("id") String id) {
        Medicine existMedicine = this.medicineService.findMedicineById(id).orElse(null);
        if (existMedicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existMedicine, HttpStatus.OK);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */

    @GetMapping("detail/{medicineId}")
    public ResponseEntity<MedicineDetailDto> getMedicineDetailDtoById(@PathVariable("medicineId") String medicineId) {
        MedicineDetailDto medicineDetailDto = medicineService.getMedicineDetailDtoById(medicineId);
        if (medicineDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDto, HttpStatus.OK);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @GetMapping("get-5-relative-medicines-type/{medicineId}")
    public ResponseEntity<List<MedicineDetailDto>> get5RelativeMedicinesOf(@PathVariable("medicineId") String
                                                                                   medicineId) {
        List<MedicineDetailDto> medicineDetailDtoList = medicineService.get5RelativeMedicinesOf(medicineId);
        if (medicineDetailDtoList == null || medicineDetailDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDtoList, HttpStatus.OK);
    }

    /*
        Created by AnP
        Time: 18:00 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type And Sort
    */

    @GetMapping("")
    public ResponseEntity<Page<IMedicineDto>> getAllMedicineAndSearch(@RequestParam(defaultValue = "0") Integer
                                                                              page,
                                                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                                                      @RequestParam Optional<String> sort,
                                                                      @RequestParam Optional<String> name,
                                                                      @RequestParam Optional<Integer> typeId) {
        String nameVal = name.orElse("");
        Integer typeIdVal = typeId.orElse(null);
        String sortVal = sort.orElse("idDesc");
        Pageable pageable;
        pageable = PageRequest.of(page, pageSize);
        Page<IMedicineDto> medicineDtoPage = medicineService.getListAndSearch(pageable, nameVal, typeIdVal, sortVal);
        if (!medicineDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineDtoPage, HttpStatus.OK);
    }

    /*
        Created by AnP
        Time: 20:45 29/06/2022
        Function: Get list 10 medicines best seller,
    */

    @GetMapping("/best-seller")
    public ResponseEntity<List<IMedicineDto>> getListMedicineBestSeller() {
        List<IMedicineDto> medicineDtoList = medicineService.getListMedicineBestSeller();
        if (medicineDtoList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineDtoList, HttpStatus.OK);
    }

    /**
     * HienTLD
     * danh sách List<Medicine>
     * 8:58 06/07/2022
     */
    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> getAllMedicineList(){
        List<Medicine> medicineList = medicineService.findAllMedicine();

        if (medicineList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(medicineList, HttpStatus.OK);
    }
}
