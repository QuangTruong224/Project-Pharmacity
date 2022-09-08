//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
//import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
//import com.c1221g1.pharmacy.entity.customer.Customer;
//import com.c1221g1.pharmacy.entity.employee.Employee;
//import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
//import com.c1221g1.pharmacy.entity.medicine.Medicine;
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
//@SpringBootTest
//@AutoConfigureMockMvc
//public class InvoiceMedicineController_createRefundInvoice {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//    @Test
//    public void createRefundInvoice_18()throws Exception{
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        Medicine medicine = new Medicine();
//        medicine.setMedicineId("1");
//        invoiceMedicineDto.setMedicine(medicine);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(1);
//        list.add(invoiceMedicineDto);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    /*
//    Test khi list thuốc rỗng
//     */
//    @Test
//    public void createRefundInvoice_invoiceMedicineDtoList_14() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        Medicine medicine = new Medicine();
//        medicine.setMedicineId("");
//        invoiceMedicineDto.setMedicine(medicine);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(null);
//        list.add(invoiceMedicineDto);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//   Test khi list thuốc null
//    */
//    @Test
//    public void createRefundInvoice_invoiceMedicineDtoList_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        list = null;
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//   Test khi customer null
//    */
//    @Test
//    public void createRefundInvoice_customer_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        Medicine medicine = new Medicine();
//        medicine.setMedicineId("1");
//        invoiceMedicineDto.setMedicine(medicine);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(1);
//        list.add(invoiceMedicineDto);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setCustomer(null);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//  Test khi employee null
//   */
//    @Test
//    public void createRefundInvoice_employee_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        Medicine medicine = new Medicine();
//        medicine.setMedicineId("1");
//        invoiceMedicineDto.setMedicine(medicine);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(1);
//        list.add(invoiceMedicineDto);
//        invoiceDto.setEmployee(null);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setTypeOfInvoice(typeOfInvoice);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
// Test khi Type Of Invoice null
//  */
//    @Test
//    public void createRefundInvoice_typeOfInvoice_13() throws Exception {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        Employee employee = new Employee();
//        employee.setEmployeeId("1");
//        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
//        typeOfInvoice.setTypeOfInvoiceId(1);
//        List<InvoiceMedicineDto> list = new ArrayList<>();
//        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
//        Medicine medicine = new Medicine();
//        medicine.setMedicineId("1");
//        invoiceMedicineDto.setMedicine(medicine);
//        invoiceMedicineDto.setInvoiceMedicineQuantity(1);
//        list.add(invoiceMedicineDto);
//        invoiceDto.setEmployee(employee);
//        invoiceDto.setCustomer(customer);
//        invoiceDto.setTypeOfInvoice(null);
//        invoiceDto.setInvoiceNote("Hang de vo");
//        invoiceDto.setInvoiceTotalMoney(11111.0);
//        invoiceDto.setInvoiceMedicineList(list);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-sale/invoiceMedicines/refund")
//                .content(this.objectMapper.writeValueAsString(invoiceDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().is4xxClientError());
//    }
//
//}
