//package com.c1221g1.pharmacy.controller.medicine;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SupplierRestController_getSupplier {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * @throws Exception
//     * @tacgia trần ngọc luật
//     * test get supplier value when id = null
//     * 13h56 30/06/2022
//     */
//    @Test
//    public void getInfoSupplier_1() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-medicine/medicines/supplier/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test get supplier value when id = ""
//     * 14h10 30/06/2022
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getInfoSupplier_2() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-medicine/medicines/supplier/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test get supplier value when id not in database
//     * 14h16 30/06/2022
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getInfoSupplier_3() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-medicine/medicines/supplier/{id}", "NCC-99999"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test get supplier value when id = value id  in  database
//     * 14h20 30/06/2022
//     */
//    @Test
//    public void getInfoSupplier_4() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-medicine/medicines/supplier/{id}", "NCC-00019"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//}
