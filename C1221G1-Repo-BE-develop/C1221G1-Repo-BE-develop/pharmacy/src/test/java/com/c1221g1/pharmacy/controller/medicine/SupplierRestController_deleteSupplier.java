//package com.c1221g1.pharmacy.controller.medicine;
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
//public class SupplierRestController_deleteSupplier {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /***
//     *  check delete id = null
//     *  trần ngọc luật 14h00 30/06/2022
//     */
//    @Test
//    public void deleteSupplier_25() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete(
//                        "/api/manager-medicine/medicines/supplier/{supplier_id}", "null"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /***
//     *  check delete id = ""
//     *  trần ngọc luật 14h00 30/06/2022
//     */
//    @Test
//    public void deleteSupplier_26() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete(
//                        "/api/manager-medicine/medicines/supplier/{supplier_id}", ""))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /***
//     *  check delete id not in database
//     *  trần ngọc luật 14h00 30/06/2022
//     */
//    @Test
//    public void deleteSupplier_27() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete(
//                        "/api/manager-medicine/medicines/supplier/{supplier_id}", "NCC-99999"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /***
//     *  check delete id in database
//     *  trần ngọc luật 14h00 30/06/2022
//     */
//    @Test
//    public void deleteSupplier_28() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete(
//                        "/api/manager-medicine/medicines/supplier/{supplier_id}", "NCC-00024"))
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//}
