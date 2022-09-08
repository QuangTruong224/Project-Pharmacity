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
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InvoiceRestController_deleteInvoice {
//    @Autowired
//    private MockMvc mockMvc;
//
//    // delete by flag so patch method is used
//    /**
//     * @author: TuanPA
//     * @time: 15:10 30/12/2022
//     * function: test method with invoiceId null
//     * @throws Exception
//     */
//    @Test
//    public void deleteInvoice_25() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .patch("/api/manager-sale/invoices/list/{invoiceId}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:26 30/12/2022
//     * function: test method with invoiceId value ""
//     * @throws Exception
//     */
//    @Test
//    public void deleteInvoice_26() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .patch("/api/manager-sale/invoices/list/{invoiceId}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:26 30/12/2022
//     * function: test method with invoiceId arg is invalid
//     * @throws Exception
//     */
//    @Test
//    public void deleteInvoice_27() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .patch("/api/manager-sale/invoices/list/{invoiceId}", "HD-000"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:26 30/12/2022
//     * function: test method with invoiceId arg is valid
//     * @throws Exception
//     */
//    @Test
//    public void deleteInvoice_28() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .patch("/api/manager-sale/invoices/list/{invoiceId}", "HD-001"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
