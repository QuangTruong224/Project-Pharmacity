package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.dto.cart.CustomerDtoForCart;
import com.c1221g1.pharmacy.entity.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getRetailCustomer
     * */
    Customer getRetailCustomer();

    Page<Customer> findAllCustomer(Pageable pageable,
                                   String customerId,
                                   String customerName,
                                   String customerAddress,
                                   String customerPhone,
                                   String customerType);

    /**
     * Create by TinBQ
     * Time : 20:21 29/06/2022
     * Function to delete customer by id
     */
    void deleteCustomer(String id);

    /**
     * Create by TinBQ
     * Time : 20:21 29/06/2022
     * Function find customer by id
     */
    Customer findById(String id);

    /**
     * Create by TruongNQ
     * Time : 15:05 29/06/2022
     * Function create customer
     */
    Customer save(Customer customer);

    /**
     * Create by TruongNQ
     * Time : 18:04 29/06/2022
     * Function find by customer id
     */
    Customer findByCustomerId(String customerId);

    /**
     * Create by TruongNQ
     * Time : 20:23 29/06/2022
     * Function update customer
     */
    void updateCustomer(Customer customer);

    /**
     * Create by TrinhNN
     * Time : 20:21 29/06/2022
     * Function get customer by customerType = 2 'khách sỉ'
     */
    List<Customer> findByCustomerType();

    /**
     * Created by: KhoaPV
     * Date created: 6/7/2022
     * function: call repository to find customerDto by username.
     *
     * @param customerUsername
     * @return totalItems
     */
    Customer findCustomerByUsername(String customerUsername);

}