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
//public class ImportInvoiceController_deleteImportInvoice {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function use to test delete when id = null
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void deleteImportInvoice_25() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/delete/{id}", "null"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test delete when id = ""
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void deleteImportInvoice_26() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/delete/{id}", ""))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test delete when id = HDN-00012 does not exist
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void deleteImportInvoice_27() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/delete/{id}", "HDN-00012"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test delete when id = HDN-00003 exist
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void deleteImportInvoice_28() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/delete/{id}", "HDN-00003"))
//                            .andDo(print())
//                            .andExpect(status().isOk());
//    }
//}
