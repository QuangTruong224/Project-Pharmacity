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
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AccountEmployeeController_getListAndSearchAccountPage {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case if list returns size = 0 then return status 4xx
//     */
//    @Test
//    public void getListAndSearchAccountPage_5() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage/"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case if list returns size > 0 then return status 2xx ( success )
//     * and will have the same value as in DB
//     */
//    @Test
//    public void getListAndSearchAccountPage_6() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage/"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(5))
//                .andExpect(jsonPath("$.content[4].password").value("111111"))
//                .andExpect(jsonPath("$.content[4].positionId").value(2))
//                .andExpect(jsonPath("$.content[4].username").value("nguena"))
//                .andExpect(jsonPath("$.content[4].employeeName").value("Nguyễn A"))
//                .andExpect(jsonPath("$.content[4].employeeId").value("NV-0006"));
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with id = null
//     */
//    @Test
//    public void getListAndSearchAccountPage_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("id","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with id = ""
//     */
//    @Test
//    public void getListAndSearchAccountPage_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("id",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with id wrong
//     */
//    @Test
//    public void getListAndSearchAccountPage_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("id","k"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with id correct
//     */
//    @Test
//    public void getListAndSearchAccountPage_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("id","NV-0003"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with name = null
//     */
//    @Test
//    public void getListAndSearchAccountPage_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("name","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with name = ""
//     */
//    @Test
//    public void getListAndSearchAccountPage_12() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("name",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with name wrong
//     */
//    @Test
//    public void getListAndSearchAccountPage_13() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("name","k"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with name correct
//     */
//    @Test
//    public void getListAndSearchAccountPage_14() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("name","Nguyễn Văn C"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with username = null
//     */
//    @Test
//    public void getListAndSearchAccountPage_15() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("username","null"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with username = ""
//     */
//    @Test
//    public void getListAndSearchAccountPage_16() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("username",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with username wrong
//     */
//    @Test
//    public void getListAndSearchAccountPage_17() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("username","j"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with username correct
//     */
//    @Test
//    public void getListAndSearchAccountPage_18() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("username","nguena"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with position = null
//     */
//    @Test
//    public void getListAndSearchAccountPage_19() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("position","null"))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with position = ""
//     */
//    @Test
//    public void getListAndSearchAccountPage_20() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("position",""))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with position not available
//     */
//    @Test
//    public void getListAndSearchAccountPage_21() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("position","1"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//
//
//    /**
//     * HaiNX
//     * 02/07/2022
//     * tes case search with position correct
//     */
//    @Test
//    public void getListAndSearchAccountPage_22() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-account/account/listAccountPage")
//                                .param("position","2"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//
//}
