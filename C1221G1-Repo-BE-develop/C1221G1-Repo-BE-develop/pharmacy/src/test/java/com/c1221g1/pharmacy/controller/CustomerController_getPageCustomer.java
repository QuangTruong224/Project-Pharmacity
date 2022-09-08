//package com.c1221g1.pharmacy.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultHandler;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import javax.persistence.Column;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerController_getPageCustomer {
//
//    /**
//     * create by TinBQ
//     * time: 30/06/2022
//     * This method to test show customer list and search
//     */
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void getSearchAndSortCustomer_5() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//
//    @Test
//    public void getSearchAndSortCustomer_6() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(2))
//                .andExpect(jsonPath("$.content[1].customerId").value("KH-00003"))
//                .andExpect(jsonPath("$.content[1].customerName").value("Nguyễn Văn A"))
//                .andExpect(jsonPath("$.content[1].customerBirthday").value("1991-05-24"))
//                .andExpect(jsonPath("$.content[1].customerGender").value(1))
//                .andExpect(jsonPath("$.content[1].customerAddress").value("Quảng Nam"))
//                .andExpect(jsonPath("$.content[1].customerPhone").value("0905386737"))
//                .andExpect(jsonPath("$.content[1].customerNote").value("Không có"))
//                .andExpect(jsonPath("$.content[1].customerUsername.username").value("nva@gmail.com"))
//                .andExpect(jsonPath("$.content[1].flag").value(true));
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerId_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerId","null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerId_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerId",""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerId_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerId","KH-99999"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerId_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerId","KH-0002"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerId_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerId","1"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerTypeId_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerType","null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerTypeId_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerType",""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerTypeId_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerType","3"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerTypeId_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerType","1"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerTypeId_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerType","1"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerName_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerName","null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerName_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerName",""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerName_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerName","abc"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerName_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerName","Nguyễn Văn A"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerName_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerName","Nguyễn Văn A"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerAddress_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerAddress","null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerAddress_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers?")
//                                .param("customerAddress",""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerAddress_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerAddress","Huế"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerAddress_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerAddress","Quảng Nam"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerAddress_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerAddress","Quảng Nam"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerPhone_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerPhone","null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerPhone_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerPhone",""))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerPhone_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerPhone","0123456789"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerPhone_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerPhone","0905386737"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void getSearchAndSortCustomer_customerPhone_11() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/manager-customer/customers")
//                                .param("customerPhone","0905386737"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//}
