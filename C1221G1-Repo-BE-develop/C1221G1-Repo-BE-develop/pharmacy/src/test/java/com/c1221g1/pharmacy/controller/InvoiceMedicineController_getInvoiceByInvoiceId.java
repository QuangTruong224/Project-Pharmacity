//package com.c1221g1.pharmacy.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InvoiceMedicineController_getInvoiceByInvoiceId {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
///*
//test input success
// */
//    @Test
//    public void getInvoice_11() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/{id}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.medicine.medicineId").value("1"))
//                .andExpect(jsonPath("$.Invoice.invoiceId").value("1"))
//                .andExpect(jsonPath("$.quantity").value("1"));
//    }
//
//    /*
//  test input null
//   */
//    @Test
//    public void getInvoice_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-sale/invoices/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
// test input rỗng
//  */
//    @Test
//    public void getInvoice_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/manager-sale/invoices/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//}
