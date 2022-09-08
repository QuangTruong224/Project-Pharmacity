package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

    /**
<<<<<<< HEAD
     * create by TinBQ and TruongNQ
     * time: 30/06/2022
     * This method to get customer type in database
     */

    @Query(value = "SELECT customer_type_id, customer_type_name FROM customer_type", nativeQuery = true)
    List<CustomerType> getAllCustomerType();

}
