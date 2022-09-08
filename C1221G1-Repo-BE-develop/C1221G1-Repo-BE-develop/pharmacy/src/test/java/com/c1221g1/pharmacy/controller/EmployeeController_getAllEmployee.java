//package com.c1221g1.pharmacy.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeController_getAllEmployee {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:30 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_5() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 14:30 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_6() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(1))
//                .andExpect(jsonPath("$.content[0].employeeId").value("NV001"))
//                .andExpect(jsonPath("$.content[0].employeeName").value("tbg"))
//                .andExpect(jsonPath("$.content[0].employeeImage").value("abs"))
//                .andExpect(jsonPath("$.content[0].employeeAddress").value("hue"))
//                .andExpect(jsonPath("$.content[0].employeePhone").value("0123456789"))
//                .andExpect(jsonPath("$.content[0].employeeDateStart").value("2022-06-16"))
//                .andExpect(jsonPath("$.content[0].employeeNote").value("haha"))
//                .andExpect(jsonPath("$.content[0].employeeUsername.username").value("tbg"))
//                .andExpect(jsonPath("$.content[0].position.positionId").value("1"))
//                .andExpect(jsonPath("$.content[0].flag").value(true));
//    }
//
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeId_11() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees?employeeId=NV001&employeeName=tbg&position=1&employeeAddress=hue&employeePhone=0123"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(1))
//                .andExpect(jsonPath("$.content[0].employeeId").value("NV001"))
//                .andExpect(jsonPath("$.content[0].employeeName").value("tbg"))
//                .andExpect(jsonPath("$.content[0].employeeImage").value("abs"))
//                .andExpect(jsonPath("$.content[0].employeeAddress").value("hue"))
//                .andExpect(jsonPath("$.content[0].employeePhone").value("0123456789"))
//                .andExpect(jsonPath("$.content[0].employeeDateStart").value("2022-06-16"))
//                .andExpect(jsonPath("$.content[0].employeeNote").value("haha"))
//                .andExpect(jsonPath("$.content[0].employeeUsername.username").value("tbg"))
//                .andExpect(jsonPath("$.content[0].position.positionId").value("1"))
//                .andExpect(jsonPath("$.content[0].flag").value(true));
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeId_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//        .param("employeeId","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeId_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeId",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeId_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeId","NV002"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeId_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeId","NV001"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeName_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeName","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeName_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeName",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeName_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeName","anh tam"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeName_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeName","tbg"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_position_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("position","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_position_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("position",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_position_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("position","6"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_position_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("position","1"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeAddress_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeAddress","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeAddress_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeAddress",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeAddress_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeAddress","da nang"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeeAddress_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeeAddress","hue"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeePhone_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeePhone","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeePhone_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeePhone",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeePhone_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeePhone","0123"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * this function use to test function getAllEmployee in EmployeeController
//     *
//     * @author GiangTB
//     * @Time 17:00 30/06/2022
//     */
//    @Test
//    public void getAllEmployee_employeePhone_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-employee/employees")
//                        .param("employeePhone","0123456789"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//}
