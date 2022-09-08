//package com.c1221g1.pharmacy.controller;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerController_deleteCustomer {
//
//    /**
//     * create by TinBQ
//     * time: 30/06/2022
//     * This method to test delete customer by update flag 1'b1 to 1'b0
//     */
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void deleteCustomer_25() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/api/manager-customer/customers")
//                                .param("customer_id","null"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void deleteCustomer_26() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/api/manager-customer/customers")
//                                .param("customer_id",""))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void deleteCustomer_27() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/api/manager-customer/customers")
//                                .param("customer_id","KH-99999"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void deleteCustomer_28() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.delete("/api/manager-customer/customers/{customerId}","KH0003"))
//                .andExpect(status().isOk());
//    }
//}
