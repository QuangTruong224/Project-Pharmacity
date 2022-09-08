package com.c1221g1.pharmacy.controller.customer;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-customer/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    /**
     * create by TinBQ
     * time: 29/06/2022
     * This method to get data from table customer have paging, searching and sorting follow field "customerId",
     * "customerName", "customerAddress", "customerPhone", "customerType"
     */

    @GetMapping("")
    public ResponseEntity<Page<Customer>> getSearchAndSortCustomer(
            @RequestParam Optional<String> customerId,
            @RequestParam Optional<String> customerType,
            @RequestParam Optional<String> customerName,
            @RequestParam Optional<String> customerAddress,
            @RequestParam Optional<String> customerPhone,
            @RequestParam Optional<String> sort,
            @RequestParam Optional<String> dir,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Pageable pageable) {

        String valueCustomerId = customerId.orElse("");
        String valueCustomerType = customerType.orElse("");
        String valueCustomerName = customerName.orElse("");
        String valueCustomerAddress = customerAddress.orElse("");
        String valueCustomerPhone = customerPhone.orElse("");
        String valueSort = sort.orElse("");
        String dirVal = dir.orElse("");
        System.out.println(customerId);
        if ("".equals(valueSort)) {
            pageable = PageRequest.of(page, size);
        } else {
            if (dirVal.equals("asc")) {
                pageable = PageRequest.of(page, size, Sort.by(valueSort).ascending());
            } else {
                pageable = PageRequest.of(page, size, Sort.by(valueSort).descending());
            }
        }

        Page<Customer> customerPage = iCustomerService.findAllCustomer(pageable, valueCustomerId, valueCustomerName, valueCustomerAddress, valueCustomerPhone, valueCustomerType);

        if (!customerPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * create by TinBQ
     * time: 29/06/2022
     * This method to set field flag in Database from 1 to 0
     */

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") String id) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            if ("".equals(id) || "null".equals(id)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            this.iCustomerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create by TruongNQ
     * Time : 20:20 29/06/2022
     * Function create customer
     */
    @PostMapping(value = "")
    public ResponseEntity<List<FieldError>> createCustomer(@Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setFlag(true);
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by TruongNQ
     * Time : 20:21 29/06/2022
     * Function get customer by id
     */
    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String customerId) {
        Customer customer = iCustomerService.findByCustomerId(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Create by TruongNQ
     * Time : 20:22 29/06/2022
     * Function update customer by id
     */
    @PatchMapping(value = "/{customerId}")
    public ResponseEntity<List<FieldError>> updateCustomer(@PathVariable String customerId, @Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customerOptional = Optional.ofNullable(iCustomerService.findByCustomerId(customerId));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDto.setCustomerId(customerOptional.get().getCustomerId());
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Create by TrinhNN
     * Time : 20:21 29/06/2022
     * Function get customer by customerType = 2 'khách sỉ'
     */
    @GetMapping(value = "/getCustomerType")
    public ResponseEntity<List<Customer>> getCustomerByCustomerType() {
        List<Customer> customer = iCustomerService.findByCustomerType();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}

