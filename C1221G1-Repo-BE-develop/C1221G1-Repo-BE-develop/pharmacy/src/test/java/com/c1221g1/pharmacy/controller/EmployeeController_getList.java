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
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeController_getList {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_5() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees/list"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_6() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees/list"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$[0].employeeId").value("NV001"))
//                .andExpect(jsonPath("$[0].employeeName").value("tbg"))
//                .andExpect(jsonPath("$[0].employeeImage").value("abs"))
//                .andExpect(jsonPath("$[0].employeeAddress").value("hue"))
//                .andExpect(jsonPath("$[0].employeePhone").value("0123456789"))
//                .andExpect(jsonPath("$[0].employeeDateStart").value("2022-06-16"))
//                .andExpect(jsonPath("$[0].employeeNote").value("haha"))
//                .andExpect(jsonPath("$[0].employeeUsername.username").value("tbg"))
//                .andExpect(jsonPath("$[0].position.positionId").value("1"))
//                .andExpect(jsonPath("$[0].flag").value(true));
//    }
//
//
//}
