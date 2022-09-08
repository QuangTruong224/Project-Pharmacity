//package com.c1221g1.pharmacy.controller;
//
//
//import com.c1221g1.pharmacy.dto.account.AccountEmployeeDto;
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
//public class AccountEmployeeController_updateAccount {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    /**
//     * HaiNX
//     * Time : 02/07/2022
//     * Function test method with password not null
//     */
//    @Test
//    public void editAccount_accountPassword_1() throws Exception {
//        AccountEmployeeDto accountEmployeeDto = new AccountEmployeeDto();
//        accountEmployeeDto.setPassword(null);
//        accountEmployeeDto.setEmployeeId("NV-0003");
//        accountEmployeeDto.setEmployeeName("Nguyễn Văn C");
//        accountEmployeeDto.setUsername("nguyenc");
//        accountEmployeeDto.getPosition().setPositionId(2);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager-account/account/updateAccount?id=NV-0003/")
//                        .content(this.objectMapper.writeValueAsString(accountEmployeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//    /**
//     * HaiNX
//     * Time : 02/07/2022
//     * Function test method with password not empty
//     */
//    @Test
//    public void editAccount_accountPassword_2() throws Exception {
//        AccountEmployeeDto accountEmployeeDto = new AccountEmployeeDto();
//        accountEmployeeDto.setPassword("");
//        accountEmployeeDto.setEmployeeId("NV-0003");
//        accountEmployeeDto.setEmployeeName("Nguyễn Văn C");
//        accountEmployeeDto.setUsername("nguyenc");
//        accountEmployeeDto.getPosition().setPositionId(2);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager-account/account/updateAccount?id=NV-0003/")
//                        .content(this.objectMapper.writeValueAsString(accountEmployeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * HaiNX
//     * Time : 02/07/2022
//     * Function test method with password size min 6
//     */
//    @Test
//    public void editAccount_accountPassword_3() throws Exception {
//        AccountEmployeeDto accountEmployeeDto = new AccountEmployeeDto();
//        accountEmployeeDto.setPassword("888");
//        accountEmployeeDto.setEmployeeId("NV-0003");
//        accountEmployeeDto.setEmployeeName("Nguyễn Văn C");
//        accountEmployeeDto.setUsername("nguyenc");
//        accountEmployeeDto.getPosition().setPositionId(2);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager-account/account/updateAccount?id=NV-0003/")
//                        .content(this.objectMapper.writeValueAsString(accountEmployeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * HaiNX
//     * Time : 02/07/2022
//     * Function test method with password correct
//     */
//
//    @Test
//    public void editAccount_accountPassword_4() throws Exception {
//        AccountEmployeeDto accountEmployeeDto = new AccountEmployeeDto();
//        accountEmployeeDto.setPassword("08080808");
//        accountEmployeeDto.setEmployeeId("NV-0003");
//        accountEmployeeDto.setEmployeeName("Nguyễn Văn C");
//        accountEmployeeDto.setUsername("nguyenc");
//        accountEmployeeDto.getPosition().setPositionId(2);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/manager-account/account/updateAccount?id=NV-0003")
//                        .content(this.objectMapper.writeValueAsString(accountEmployeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//}
