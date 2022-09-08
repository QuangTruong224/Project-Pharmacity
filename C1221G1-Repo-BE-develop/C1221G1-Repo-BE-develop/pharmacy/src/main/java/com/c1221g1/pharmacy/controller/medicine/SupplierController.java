package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.import_invoice.ISupplierDto;
import com.c1221g1.pharmacy.dto.import_invoice.SupplierDto;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import com.c1221g1.pharmacy.service.import_invoice.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-medicine/medicines/supplier")
public class SupplierController {


    @Autowired
    ISupplierService iSupplierService;


    /**
     * RequestParam (searchId)(searchName)(searchAddress)(searchPhone)
     * to get the search value
     * call method findAll() in supplierSevice
     * <p>
     * 18h 29/06/2022  trần ngọc luật
     */
    @GetMapping("")
    public ResponseEntity<Page<Supplier>> getPageSupplier(@RequestParam Optional<String> searchId,
                                                          @RequestParam Optional<String> searchName,
                                                          @RequestParam Optional<String> searchAddress,
                                                          @RequestParam Optional<String> searchPhone,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "5") Integer pageSize,
                                                          @RequestParam Optional<String> sort,
                                                          @RequestParam Optional<String> dir
    ) {
        Pageable pageable;
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if (dirVal.equals("asc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else if (dirVal.equals("desc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            }
        }

        String valueSupplierId = searchId.orElse("");
        String valueName = searchName.orElse("");
        String valueAddress = searchAddress.orElse("");
        String valuePhone = searchPhone.orElse("");
        Page<Supplier> supplierPage = iSupplierService.findAll(valueSupplierId, valueName, valueAddress, valuePhone, pageable);
            if (!supplierPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(supplierPage, HttpStatus.OK);
        }
    }

    /**
     * get supplier_id from the path
     * and assign it to a variable id
     * call removeSupplierById method to set 'flag' to 0 in repository
     * <p>
     *
     * @18h 29/06/2022  trần ngọc luật
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("id") String id) {
        try {

            if ("null".equals(id) || null == id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else if ("".equals(id)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                Supplier supplier = iSupplierService.findById(id);
                if (supplier == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                this.iSupplierService.removeSupplierById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * get for 1 supplier whose id is the value the user entered
     * (  Serve for detail screen, edit supplier information  )
     * <p></p>
     * 18h 29/06/2022  trần ngọc luật
     */
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") String id) {
        Supplier supplier = iSupplierService.findById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }


    /**
     * when submitting (if there is an error, 1 . will be returned) (HttpStatus.BAD_REQUEST) )
     * if no error then copy SupplierDto to Supplier
     * <p>
     * and call method save in service
     * 18h 29/06/2022 trần ngọc luật
     */
    @PostMapping(value = "")
    public ResponseEntity<?> saveSupplier(@Validated @RequestBody SupplierDto supplierDto,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Supplier supplier = new Supplier();
            BeanUtils.copyProperties(supplierDto, supplier);
            iSupplierService.save(supplier);
            return new ResponseEntity<>(supplier, HttpStatus.OK);

        }
    }

    /**
     * take the id on the path to get the update condition value
     * RequestBody to get all the value submitted by the user
     * <p>
     * call method update() in supplierService
     * 20h 29/06/2022 trần ngọc luật
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@Validated @RequestBody SupplierDto supplierDto,
                                            @PathVariable("id") String id,
                                            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.hasFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        if ("null".equals(id) || null == id) {
            return new ResponseEntity<>(bindingResult.hasFieldErrors(), HttpStatus.BAD_REQUEST);
        } else if ("".equals(id)) {
            return new ResponseEntity<>(bindingResult.hasFieldErrors(), HttpStatus.BAD_REQUEST);
        } else {
            supplierDto.setFlag(true);
            Supplier supplier = new Supplier();
            BeanUtils.copyProperties(supplierDto, supplier);
            System.err.println(supplier);
            iSupplierService.update(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    /**
     * get detail  for 1 supplier whose id is the value the user entered
     * (  Serve for detail screen, edit supplier information  )
     * <p></p>
     * 18h 29/06/2022  trần ngọc luật
     */
    @GetMapping("detail/{id}")
    public ResponseEntity<ISupplierDto> getSupplierDetail(@PathVariable("id") String id) {
        ISupplierDto supplier = iSupplierService.findByIdDEtail(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

}

