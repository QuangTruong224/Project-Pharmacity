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
//public class InvoiceRestController_getListInvoice {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * @author: TuanPA
//     * @time: 15:00 30/12/2022
//     * function: test method with no argument, there is no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_5() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with no argument, the is valid data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_6() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with startTime arg is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startTime_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startTime}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with endTime arg is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endTime_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{endTime}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with startDate arg is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startDate_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startDate}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with endDate arg is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endDate_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{endDate}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with typeOfInvoice arg is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_typeOfInvoice_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{typeOfInvoice}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with fieldSort arg of interface Pageable is null
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_fieldSort_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{fieldSort}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with startDate arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startDate_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startDate}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with endDate arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endDate_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startDate}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-001"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("1"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("08:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("1"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(50000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with startTime arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startTime_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startTime}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with endTime arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endTime_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{endTime}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with typeOfInvoice arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_typeOfInvoice_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{typeOfInvoice}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:01 30/12/2022
//     * function: test method with fieldSort arg has value ""
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_fieldSort_8() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{fieldSort}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-002"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("07:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("2"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(100000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//    // Because startTime, endTime, startDate, endDate args can not be invalid so no need to test method with these args
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with typeOfInvoice arg is invalid
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_typeOfInvoice_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{typeOfInvoice}", "5"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 15:09 30/12/2022
//     * function: test method with fieldSort arg is invalid
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_fieldSort_9() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{fieldSort}", "aaa"))
//                .andDo(print())
//                .andExpect(status().is5xxServerError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:18 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startDate_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startDate}", "2022-06-30"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:19 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endDate_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{endDate}", "2021-06-30"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:20 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_startTime_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startTime}", "08:00 AM"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:21 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_endTime_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{endTime}", "08:00 AM"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:25 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_typeOfInvoice_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{typeOfInvoice}", 1))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:25 30/12/2022
//     * function: test method with valid arg but no data in database
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_fieldSort_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{fieldSort}", "invoiceId"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * @author: TuanPA
//     * @time: 16:26 30/12/2022
//     * function: test method with valid args and valid data
//     * @throws Exception
//     */
//    @Test
//    public void getListInvoice_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-sale/invoices/list/{startDate},{endDate},{startTime},{endTime},{typeOfInvoice},{fieldSort}"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(2))
//                .andExpect(jsonPath("$.totalElements").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true))
//                .andExpect(jsonPath("$.content[2].id").value("HD-001"))
//                .andExpect(jsonPath("$.content[2].customer.id").value("1"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedDate").value("2022-01-02"))
//                .andExpect(jsonPath("$.content[2].invoiceCreatedTime").value("08:30 AM"))
//                .andExpect(jsonPath("$.content[2].employee.id").value("1"))
//                .andExpect(jsonPath("$.content[2].invoiceTotalMoney").value(50000))
//                .andExpect(jsonPath("$.content[2].invoiceNote").value("n/a"));
//    }
//}
