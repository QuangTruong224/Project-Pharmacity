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
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ImportInvoiceController_getPageListImportInvoice {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * this function use to test get list when no parameters were passed and no result
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_5() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/"))
//                            .andDo(print())
//                            .andExpect(status().isNoContent());
//    }
//
//    /**
//     * this function use to test get list when no parameters were passed and has result
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_6() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice/"))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * this function use to test get list when parameters startDate is null
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startDate_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startDate", "null"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test get list when parameters startDate is ""
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startDate_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startDate", ""))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * note
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    // 9th cases do not need test because startDate is always exist.
//
//    /**
//     * this function use to test get list when parameters startDate is 2022-10-10
//     *
//     * @author HongHTX
//     * @Time 17:15 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startDate_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startDate", "2022-10-10"))
//                            .andDo(print())
//                            .andExpect(status().isNoContent());
//    }
//
//    /**
//     * this function use to test get list when parameters startDate is "2021-12-25"
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startDate_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startDate", "2021-12-25"))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * this function use to test get list when parameters endDate is null
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endDate_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endDate", "null"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test get list when parameters endDate is ""
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endDate_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endDate", ""))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * note
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    // 9th cases do not need test because endDate is always exist.
//
//    /**
//     * this function use to test get list when parameters endDate is 2010-10-10
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endDate_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endDate", "2010-10-10"))
//                            .andDo(print())
//                            .andExpect(status().isNoContent());
//    }
//
//    /**
//     * this function use to test get list when parameters endDate is "2022-01-05"
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endDate_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endDate", "2022-01-05"))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[2].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[2].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[2].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[2].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[2].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[2].total").value(675467400))
//                            .andExpect(jsonPath("$.content[2].flag").value(true))
//                            .andExpect(jsonPath("$.content[2].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[2].employee.employeeId").value(1));
//    }
//
//    /**
//     * this function use to test get list when parameters startTime is null
//     *
//     * @author HongHTX
//     * @Time 19:30 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startTime_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startTime", "null"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test get list when parameters startTime is ""
//     *
//     * @author HongHTX
//     * @Time 19:30 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startTime_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startTime", ""))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * note
//     *
//     * @author HongHTX
//     * @Time 19:30 30/06/2022
//     */
//    // 9th cases do not need test because startTime is always exist.
//
//    /**
//     * this function use to test get list when parameters startTime is "23:00"
//     *
//     * @author HongHTX
//     * @Time 19:30 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startTime_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startTime", "23:00"))
//                            .andDo(print())
//                            .andExpect(status().isNoContent());
//    }
//
//    /**
//     * this function use to test get list when parameters startTime is "15:00"
//     *
//     * @author HongHTX
//     * @Time 19:20 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_startTime_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("startTime", "15:00"))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[3].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[3].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[3].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[3].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[3].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[3].total").value(675467400))
//                            .andExpect(jsonPath("$.content[3].flag").value(true))
//                            .andExpect(jsonPath("$.content[3].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[3].employee.employeeId").value(1));
//    }
//
//    /**
//     * this function use to test get list when parameters endTime is null
//     *
//     * @author HongHTX
//     * @Time 19:40 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endTime_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endTime", "null"))
//                            .andDo(print())
//                            .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test get list when parameters endTime is ""
//     *
//     * @author HongHTX
//     * @Time 19:40 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endTime_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endTime", ""))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * note
//     *
//     * @author HongHTX
//     * @Time 19:40 30/06/2022
//     */
//    // 9th cases do not need test because endTime is always exist.
//
//    /**
//     * this function use to test get list when parameters endTime is "03:00"
//     *
//     * @author HongHTX
//     * @Time 19:40 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endTime_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endTime", "03:00"))
//                            .andDo(print())
//                            .andExpect(status().isNoContent());
//    }
//
//    /**
//     * this function use to test get list when parameters endTime is "20:30"
//     *
//     * @author HongHTX
//     * @Time 19:40 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_endTime_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                            .get("/api/manager-medicine/import-invoice")
//                            .param("endTime", "15:00"))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//                            .andExpect(jsonPath("$.totalPages").value(2))
//                            .andExpect(jsonPath("$.totalElements").value(7))
//                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                            .andExpect(jsonPath("$.content[4].total").value(675467400))
//                            .andExpect(jsonPath("$.content[4].flag").value(true))
//                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//    /**
//     * note
//     *
//     * @author HongHTX
//     * @Time 19:55 30/06/2022
//     */
//    // 7, 9th cases do not need test because if fieldSort always different null.
//    // 8th cases do not need test because if fieldSort = "" -> assign fieldSort =import_invoice_id.
//
//    /**
//     * this function use to test get list when sort follow [Mã HD]
//     *
//     * @author HongHTX
//     * @Time 19:55 30/06/2022
//     */
//    @Test
//    public void getPageListImportInvoice_fieldSort_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-medicine/import-invoice")
//                        .param("fieldSort", "import_invoice_id"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(7))
//                .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
//                .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
//                .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
//                .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
//                .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
//                .andExpect(jsonPath("$.content[4].total").value(675467400))
//                .andExpect(jsonPath("$.content[4].flag").value(true))
//                .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
//                .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
//    }
//
//}