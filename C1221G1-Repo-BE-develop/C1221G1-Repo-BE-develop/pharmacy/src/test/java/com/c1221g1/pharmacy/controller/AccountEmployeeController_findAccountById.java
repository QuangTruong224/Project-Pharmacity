//package com.c1221g1.pharmacy.controller;
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
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AccountEmployeeController_findAccountById {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case if find account by employeeID null
//     */
//    @Test
//    public void findAccountById_1() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-account/account/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case if find account by employeeID available
//     */
//    @Test
//    public void gfindAccountById_2() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-account/account/{id}", "NV-0006"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.password").value("111111"))
//                .andExpect(jsonPath("$.positionId").value(2))
//                .andExpect(jsonPath("$.username").value("nguena"))
//                .andExpect(jsonPath("$.employeeName").value("Nguyễn A"))
//                .andExpect(jsonPath("$.employeeId").value("NV-0006"));
//
//    }
//
//}
