//package com.c1221g1.pharmacy.controller;
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
//public class EmployeeController_deleteEmployeeById {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function use to test function deleteEmployeeById in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:00 30/06/2022
//     */
//    @Test
//    public void deleteEmployeeById_25() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete("/api/manager-employee/employees/{}","null"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test function deleteEmployeeById in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:00 30/06/2022
//     */
//    @Test
//    public void deleteEmployeeById_26() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete("/api/manager-employee/employees/{id}",""))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test function deleteEmployeeById in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:00 30/06/2022
//     */
//    @Test
//    public void deleteEmployeeById_27() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete("/api/manager-employee/employees/{id}","NV0099"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test function deleteEmployeeById in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:00 30/06/2022
//     */
//    @Test
//    public void deleteCustomer_28() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.delete("/api/manager-employee/employees/{id}","NV001"))
//                .andExpect(status().isOk());
//    }
//}
