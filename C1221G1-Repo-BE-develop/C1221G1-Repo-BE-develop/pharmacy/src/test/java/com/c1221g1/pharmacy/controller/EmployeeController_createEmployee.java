//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
//import com.c1221g1.pharmacy.entity.employee.Position;
//import com.c1221g1.pharmacy.entity.user.Users;
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
//public class EmployeeController_createEmployee {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /*
//      Created by TamNA
//      Time: 13:50:00 29/06/2022
//      Function:  create test name
// */
//    @Test
//    public void createEmployee_name_13() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("null");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 13:55:00 29/06/2022
//      Function:  create test name
// */
//
//    @Test
//    public void createEmployee_name_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 14:00:00 29/06/2022
//      Function:  create test name
// */
//    @Test
//    public void createEmployee_name_15() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("@l;skd");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//  Created by TamNA
//  Time: 14:05:00 29/06/2022
//  Function:  create test name
//*/
//    @Test
//    public void createEmployee_name_16() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("sdsadasdkashdkjashdkjashdkjashdjkashdkjashdkashdkashdkashdkashashdaksjd");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//  Created by TamNA
//  Time: 14:07:00 29/06/2022
//  Function:  create test name
//*/
//    @Test
//    public void createEmployee_name_17() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("s");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//  Created by TamNA
//  Time: 14:10:00 29/06/2022
//  Function:  create test name
//*/
//    @Test
//    public void createEmployee_name_18() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /*
//  Created by TamNA
//  Time: 14:10:00 29/06/2022
//  Function:  create test image
//*/
//    @Test
//    public void createEmployee_image_13() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn văn A");
//        employeeDto.setEmployeeImage("null");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 14:11:00 29/06/2022
//      Function:  create test image
// */
//
//    @Test
//    public void createEmployee_image_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 14:12:00 29/06/2022
//      Function:  create test image
// */
//    @Test
//    public void createEmployee_image_15() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Tâm");
//        employeeDto.setEmployeeImage("https:1234");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//        /*
//      Created by TamNA
//      Time: 14:12:00 29/06/2022
//      Function:  create test image
// */
//
//    @Test
//    public void createEmployee_image_18() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    /*
//   Created by TamNA
//   Time: 14:20:00 29/06/2022
//   Function:  create test address
//*/
//    @Test
//    public void createEmployee_address_13() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("null");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//   Created by TamNA
//   Time: 14:23:00 29/06/2022
//   Function:  create test address
//*/
//    @Test
//    public void createEmployee_address_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 14:25:00 29/06/2022
//      Function:  create test address
// */
//    @Test
//    public void createEmployee_address_15() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Tâm");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//        /*
//      Created by TamNA
//      Time: 14:25:00 29/06/2022
//      Function:  create test address
// */
//
//    @Test
//    public void createEmployee_address_18() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /*
//  Created by TamNA
//  Time: 14:20:00 29/06/2022
//  Function:  create test phone
//*/
//    @Test
//    public void createEmployee_phone_13() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("null");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//   Created by TamNA
//   Time: 14:23:00 29/06/2022
//   Function:  create test phone
//*/
//    @Test
//    public void createEmployee_phone_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng nam");
//        employeeDto.setEmployeePhone("");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//      Created by TamNA
//      Time: 14:25:00 29/06/2022
//      Function:  create test phone
// */
//    @Test
//    public void createEmployee_phone_15() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Tâm");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//        /*
//      Created by TamNA
//      Time: 14:25:00 29/06/2022
//      Function:  create test phone
// */
//
//    @Test
//    public void createEmployee_phone_18() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//
//    /*
//  Created by TamNA
//  Time: 14:20:00 29/06/2022
//  Function:  create test DateStart
//*/
//    @Test
//    public void createEmployee_DateStart_13() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("null");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /*
//   Created by TamNA
//   Time: 14:23:00 29/06/2022
//   Function:  create test DateStart
//*/
//    @Test
//    public void createEmployee_DateStart_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//            /*
//      Created by TamNA
//      Time: 14:25:00 29/06/2022
//      Function:  create test DateStart
// */
//
//    @Test
//    public void createEmployee_DateStart_18() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng Nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2000-12-01");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    /*
//Created by TamNA
//Time: 14:23:00 29/06/2022
//Function:  create test position
//*/
//    @Test
//    public void createEmployee_position_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2002/09/29");
//        employeeDto.setEmployeeNote("aaaa");
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//Created by TamNA
//Time: 14:57:00 29/06/2022
//Function:  create test userName
//*/
//    @Test
//    public void createEmployee_userName_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setEmployeeName("Nguyễn Văn A");
//        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
//        employeeDto.setEmployeeAddress("Quảng nam");
//        employeeDto.setEmployeePhone("0905700994");
//        employeeDto.setEmployeeDateStart("2002/09/29");
//        employeeDto.setEmployeeNote("aaaa");
//
//
//        com.c1221g1.pharmacy.entity.employee.Position position = new com.c1221g1.pharmacy.entity.employee.Position();
//        position.setPositionId(1);
//        employeeDto.setPosition(position);
//
//        Users usersDto = new Users();
//        usersDto.setUsername("nat");
//        employeeDto.setEmployeeUsername(usersDto);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-employee/employees/create")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//}
