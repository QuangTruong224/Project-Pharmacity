package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceMedicineController_createRetailInvoice {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test khi customerId = null
    @Test
    void createRetailInvoice_customerId_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(30);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi customerId rỗng
    @Test
    void createRetailInvoice_customerId_14() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(30);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi customerId sai định dạng
    @Test
    void createRetailInvoice_customerId_15() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("abc-0001");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(30);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi employeeId sai định dạng
    @Test
    void createRetailInvoice_employeeId_15() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("KH-00001");
        invoiceDto.setEmployeeId("NV-002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(30);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi quantity quá số lượng
    @Test
    void createRetailInvoice_quantity_16() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("KH-0001");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(3012312);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi quantity là số âm
    @Test
    void createRetailInvoice_quantity_17() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("KH-0001");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(-12);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test khi thành công
    @Test
    void createRetailInvoice_18() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId("HD-00001");
        invoiceDto.setCustomerId("KH-00001");
        invoiceDto.setEmployeeId("NV-00002");
        invoiceDto.setTypeOfInvoiceId(1);
        invoiceDto.setInvoiceNote("người lớn");
        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        invoiceMedicineDto.setQuantity(30);
        invoiceMedicineDto.setMedicineId("T-00001");
        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-sale/invoiceMedicines/createRetail")
                .content(this.objectMapper.writeValueAsString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
