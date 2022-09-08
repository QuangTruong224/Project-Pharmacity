//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.customer.CustomerDto;
//import com.c1221g1.pharmacy.entity.customer.CustomerType;
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
//public class CustomerController_editCustomer {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:10 30/06/2022
//     * Function test method with arg customer name not null
//     */
//    @Test
//    public void editCustomer_customerName_19() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName(null);
//        customerDto.setCustomerBirthday("1999-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Không ");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * Create by TruongNQ
//     * Time : 20:12 30/06/2022
//     * Function test method with arg customer name not empty
//     */
//    @Test
//    public void editCustomer_customerName_20() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("");
//        customerDto.setCustomerBirthday("1999-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Không ");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:14 30/06/2022
//     * Function test method with arg customer name size min 2
//     */
//    @Test
//    public void editCustomer_customerName_22() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("a");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:17 30/06/2022
//     * Function test method with arg customer name size max 20
//     */
//    @Test
//    public void editCustomer_customerName_23() throws Exception {
//
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn Quang Trường Hải Tín");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:20 30/06/2022
//     * Function test method with valid arg customer name and valid data
//     */
//    @Test
//    public void editCustomer_customerName_24() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Quang Trường");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:21 30/06/2022
//     * Function test method with arg customer phone not null
//     */
//    @Test
//    public void editCustomer_customerPhone_19() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone(null);
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:23 30/06/2022
//     * Function test method with arg customer phone not empty
//     */
//    @Test
//    public void editCustomer_customerPhone_20() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:25 30/06/2022
//     * Function test method with arg customer phone not item
//     */
//    @Test
//    public void editCustomer_customerPhone_21() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("1234567890");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:30 30/06/2022
//     * Function test method with valid arg customer phone and valid data
//     */
//    @Test
//    public void editCustomer_customerPhone_24() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:32 30/06/2022
//     * Function test method with arg customer type not null
//     */
//    @Test
//    public void editCustomer_customerType_19() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by TruongNQ
//     * Time : 20:34 30/06/2022
//     * Function test method with valid arg customer type and valid data
//     */
//    @Test
//    public void editCustomer_customerType_24() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    /**
//     * Create by TruongNQ
//     * Time : 20:35 30/06/2022
//     * Function test method with arg customer gender not null
//     */
//    @Test
//    public void editCustomer_customerGender_19() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(null);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        CustomerType customerType= new CustomerType();
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//    /**
//     * Create by TruongNQ
//     * Time : 20:37 30/06/2022
//     * Function test method with valid arg customer gender and valid data
//     */
//    @Test
//    public void editCustomer_customerGender_24() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        CustomerType customerType= new CustomerType();
//        customerDto.setCustomerId("KH-00001");
//        customerDto.setCustomerName("Nguyễn Văn T");
//        customerDto.setCustomerBirthday("2000-04-22");
//        customerDto.setCustomerGender(1);
//        customerDto.setCustomerAddress("Đà Nẵng");
//        customerDto.setCustomerPhone("0905123456");
//        customerDto.setCustomerNote("Khách hàng mua lần đầu");
//        customerDto.setCustomerUsername(null);
//        customerDto.setFlag(true);
//        customerType.setCustomerTypeId(1);
//        customerDto.setCustomerType(customerType);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager_customer/customers/{customerId}","KH-00001")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//
//    }
//
//}
