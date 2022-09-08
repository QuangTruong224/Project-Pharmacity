//package com.c1221g1.pharmacy.controller.medicine;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SupplierRestController_getPageSupplier {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * trần ngọc luật 11h 30/06/2022
//     * tes case if list returns size = 0 then return status 4xx
//     */
//    @Test
//    public void getListSupplier_5() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines/supplier/"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật 11h21 30/06/2022
//     * tes case if list returns size > 0 then return status 2xx ( success )
//     * and will have the same value as in batabasse
//     */
//    @Test
//    public void getListSupplier_6() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines/supplier/"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(5))
//                .andExpect(jsonPath("$.content[4].supplierId").value("NCC-00022"))
//                .andExpect(jsonPath("$.content[4].supplierName").value("Nhà Thuốc Thiên An "))
//                .andExpect(jsonPath("$.content[4].supplierAddress").value("63 Phạm Vinh  "))
//                .andExpect(jsonPath("$.content[4].supplierPhone").value("999999999"))
//                .andExpect(jsonPath("$.content[4].supplierEmail").value("thienan@gmail.com"))
//                .andExpect(jsonPath("$.content[4].note").value("Thân Thiện")
//                );
//    }
//
//
//
//}
