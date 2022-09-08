//package com.c1221g1.pharmacy.controller.invoice;
//
//import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
//import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
//import com.c1221g1.pharmacy.entity.customer.Customer;
//import com.c1221g1.pharmacy.entity.employee.Employee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InvoiceMedicineController_SalesManager {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    // Test khi list thuốc null
//    @Test
//    public void createRetailInvoice_invoiceMedicineDtoList_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    // Test khi list thuốc rỗng
//    @Test
//    public void createRetailInvoice_invoiceMedicineDtoList_14() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi list customer null
//    @Test
//    public void createRetailInvoice_customer_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
////        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi list customer rỗng
//    @Test
//    public void createRetailInvoice_customer_14() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
////        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi employee  null
//    @Test
//    public void createRetailInvoice_employee_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
////        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi employee  rỗng
//    @Test
//    public void createRetailInvoice_employee_14() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
////        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi setTypeOfInvoice  null
//    @Test
//    public void createRetailInvoice_setTypeOfInvoice_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
////        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi setTypeOfInvoice  rỗng
//    @Test
//    public void createRetailInvoice_setTypeOfInvoice_14() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
////        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    // Test khi invoiceNote null
//    @Test
//    public void createRetailInvoice_invoiceNote_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(0);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
////        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    // Test thành công
//    @Test
//    public void createRetailInvoice_18() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("KH-0001");
//        Employee employee = new Employee();
//        employee.setEmployeeId("NV-0001");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> invoiceMedicineDtoList = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        invoiceMedicineDto.setInvoiceMedicineQuantity(3);
//        invoiceMedicineDto.setInvoice(invoiceDto);
//
//        invoiceMedicineDtoList.add(invoiceMedicineDto);
//
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("người lớn");
//        invoiceDto.setInvoiceTotalMoney(3000.0);
//        invoiceDto.setInvoiceMedicineList(invoiceMedicineDtoList);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/createRetail")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
