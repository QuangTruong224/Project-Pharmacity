//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
//import com.c1221g1.pharmacy.dto.employee.Position;
//import com.c1221g1.pharmacy.dto.import_invoice.ImportInvoiceDto;
//import com.c1221g1.pharmacy.dto.import_invoice.SupplierDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class
//ImportInvoiceController_createImportInvoice {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: test pass all.
//     */
//    @Test
//    public void createImportInvoice_importSystemCode_18() throws Exception {
//        ImportInvoiceDto importInvoiceDto = new ImportInvoiceDto();
//        importInvoiceDto.setImportSystemCode(1);
//        importInvoiceDto.setImportInvoiceDate("01-01-2022");
//        importInvoiceDto.setFlag(true);
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierId("NCC-0001");
//        supplierDto.setSupplierName("Viet My");
//        supplierDto.setSupplierAddress("da nang");
//        supplierDto.setSupplierPhone("0901231231");
//        supplierDto.setSupplierEmail("vietmy@gmail.com");
//        supplierDto.setNote("goodnight");
//        supplierDto.setFlag(true);
//        importInvoiceDto.setSupplierDto(supplierDto);
//        importInvoiceDto.setImportSystemCode(1111);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-0001");
//        employeeDto.setEmployeeName("Trung");
//        employeeDto.setEmployeeImage("123.png");
//        employeeDto.setEmployeeAddress("da nang");
//        employeeDto.setEmployeePhone("090123121");
//        employeeDto.setEmployeeDateStart("01-01-2022");
//        employeeDto.setEmployeeNote("01-01-2022");
//        employeeDto.setFlag(true);
//        Position position = new Position();
//        position.setPositionId(1);
//        position.setPositionName("M");
//        employeeDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/import-invoice/createImportInvoice")
//                        .content(this.objectMapper.writeValueAsString(importInvoiceDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: test importSystemCode not null.
//     */
//    @Test
//    public void createImportInvoice_importSystemCode_13() throws Exception {
//        ImportInvoiceDto importInvoiceDto = new ImportInvoiceDto();
//        importInvoiceDto.setImportSystemCode(null);
//        importInvoiceDto.setImportInvoiceDate("01-01-2022");
//        importInvoiceDto.setFlag(true);
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierId("NCC-0001");
//        supplierDto.setSupplierName("Viet My");
//        supplierDto.setSupplierAddress("da nang");
//        supplierDto.setSupplierPhone("0901231231");
//        supplierDto.setSupplierEmail("vietmy@gmail.com");
//        supplierDto.setNote("goodnight");
//        supplierDto.setFlag(true);
//        importInvoiceDto.setSupplierDto(supplierDto);
//        importInvoiceDto.setImportSystemCode(null);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-0001");
//        employeeDto.setEmployeeName("Trung");
//        employeeDto.setEmployeeImage("123.png");
//        employeeDto.setEmployeeAddress("da nang");
//        employeeDto.setEmployeePhone("090123121");
//        employeeDto.setEmployeeDateStart("01-01-2022");
//        employeeDto.setEmployeeNote("01-01-2022");
//        employeeDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/import-invoice/createImportInvoice")
//                        .content(this.objectMapper.writeValueAsString(importInvoiceDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: test importInvoiceDate not null.
//     */
//    @Test
//    public void createImportInvoice_importInvoiceDate_13() throws Exception {
//        ImportInvoiceDto importInvoiceDto = new ImportInvoiceDto();
//        importInvoiceDto.setImportSystemCode(1);
//        importInvoiceDto.setImportInvoiceDate(null);
//        importInvoiceDto.setFlag(true);
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierId("NCC-0001");
//        supplierDto.setSupplierName("Viet My");
//        supplierDto.setSupplierAddress("da nang");
//        supplierDto.setSupplierPhone("0901231231");
//        supplierDto.setSupplierEmail("vietmy@gmail.com");
//        supplierDto.setNote("goodnight");
//        supplierDto.setFlag(true);
//        importInvoiceDto.setSupplierDto(supplierDto);
//        importInvoiceDto.setImportSystemCode(null);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-0001");
//        employeeDto.setEmployeeName("Trung");
//        employeeDto.setEmployeeImage("123.png");
//        employeeDto.setEmployeeAddress("da nang");
//        employeeDto.setEmployeePhone("090123121");
//        employeeDto.setEmployeeDateStart("01-01-2022");
//        employeeDto.setEmployeeNote("01-01-2022");
//        employeeDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/import-invoice/createImportInvoice")
//                        .content(this.objectMapper.writeValueAsString(importInvoiceDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: test importInvoiceDate not "".
//     */
//    @Test
//    public void createImportInvoice_importInvoiceDate_14() throws Exception {
//        ImportInvoiceDto importInvoiceDto = new ImportInvoiceDto();
//        importInvoiceDto.setImportSystemCode(1);
//        importInvoiceDto.setImportInvoiceDate("");
//        importInvoiceDto.setFlag(true);
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierId("NCC-0001");
//        supplierDto.setSupplierName("Viet My");
//        supplierDto.setSupplierAddress("da nang");
//        supplierDto.setSupplierPhone("0901231231");
//        supplierDto.setSupplierEmail("vietmy@gmail.com");
//        supplierDto.setNote("goodnight");
//        supplierDto.setFlag(true);
//        importInvoiceDto.setSupplierDto(supplierDto);
//        importInvoiceDto.setImportSystemCode(null);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-0001");
//        employeeDto.setEmployeeName("Trung");
//        employeeDto.setEmployeeImage("123.png");
//        employeeDto.setEmployeeAddress("da nang");
//        employeeDto.setEmployeePhone("090123121");
//        employeeDto.setEmployeeDateStart("01-01-2022");
//        employeeDto.setEmployeeNote("01-01-2022");
//        employeeDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/import-invoice/createImportInvoice")
//                        .content(this.objectMapper.writeValueAsString(importInvoiceDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: test flag not null.
//     */
//    @Test
//    public void createImportInvoice_flag_13() throws Exception {
//        ImportInvoiceDto importInvoiceDto = new ImportInvoiceDto();
//        importInvoiceDto.setImportSystemCode(1);
//        importInvoiceDto.setImportInvoiceDate("01-01-2022");
//        importInvoiceDto.setFlag(null);
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierId("NCC-0001");
//        supplierDto.setSupplierName("Viet My");
//        supplierDto.setSupplierAddress("da nang");
//        supplierDto.setSupplierPhone("0901231231");
//        supplierDto.setSupplierEmail("vietmy@gmail.com");
//        supplierDto.setNote("goodnight");
//        supplierDto.setFlag(true);
//        importInvoiceDto.setSupplierDto(supplierDto);
//        importInvoiceDto.setImportSystemCode(null);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-0001");
//        employeeDto.setEmployeeName("Trung");
//        employeeDto.setEmployeeImage("123.png");
//        employeeDto.setEmployeeAddress("da nang");
//        employeeDto.setEmployeePhone("090123121");
//        employeeDto.setEmployeeDateStart("01-01-2022");
//        employeeDto.setEmployeeNote("01-01-2022");
//        employeeDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/import-invoice/createImportInvoice")
//                        .content(this.objectMapper.writeValueAsString(importInvoiceDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}