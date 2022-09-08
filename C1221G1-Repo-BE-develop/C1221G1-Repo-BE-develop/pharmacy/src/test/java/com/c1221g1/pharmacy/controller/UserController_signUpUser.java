//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
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
///**
// * Created By HuuNQ
// * Test Mockito
// */
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserController_signUpUser {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Test
//    public void getSignUp_name_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName(null);
//        signUpRequest.setEmail("abc@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12-12-1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_name_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("");
//        signUpRequest.setEmail("abc@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12-12-1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_name_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("a4asc4");
//        signUpRequest.setEmail("abdasc@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_name_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("tên quá dài tên quá dài tên quá dài tên quá dài tên quá dài tên quá dài tên quá dài tên quá dài tên quá dài");
//        signUpRequest.setEmail("abdasc@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_name_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("tên");
//        signUpRequest.setEmail("abdasc@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_email_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail(null);
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_email_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_email_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("abc@gmail");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_email_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("n@gmail.com");
//        signUpRequest.setPassword("username.com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_password_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword(null);
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_password_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_password_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("username. *com");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_password_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("passwordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpasswordpassword");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_password_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("abcde");
//        signUpRequest.setConfirmPassword("username.com");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_confirmPassword_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword(null);
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_confirmPassword_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_confirmPassword_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerex*_Dointeárexáceptionnullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_confirmPassword_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexceptionnullpointerexceptionnullpointerexceptionnullpointerexceptionnullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_confirmPassword_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("n");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_gender_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(null);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_gender_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(Integer.valueOf(""));
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_gender_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(43);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_gender_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(4);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_gender_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(4444);
//        signUpRequest.setAddress("Không có địa chỉ");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void getSignUp_address_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress(null);
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_address_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901231231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    @Test
//    public void getSignUp_phone_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone(null);
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_phone_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_phone_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("018a123231");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_phone_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0183123231123");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_phone_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("01");
//        signUpRequest.setDayOfBirth("12/12/1999");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_13() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth(null);
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_14() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("1993/02/01");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_age18_15() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("01/02/2008");
//        signUpRequest.setNote("");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_16() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("1993/02/013");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_17() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("199/3/2");
//        signUpRequest.setNote("");
//
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignUp_dayOfBirth_18() throws Exception {
//        SignUpRequest signUpRequest = new SignUpRequest();
//        signUpRequest.setName("Nguyễn Thành An");
//        signUpRequest.setEmail("nguyenvanan@gmail.com");
//        signUpRequest.setPassword("nullpointerexception");
//        signUpRequest.setConfirmPassword("nullpointerexception");
//        signUpRequest.setGender(1);
//        signUpRequest.setAddress("Khong");
//        signUpRequest.setPhone("0901123123");
//        signUpRequest.setDayOfBirth("05/05/1993");
//        signUpRequest.setNote("khong");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-up")
//                                .content(this.objectMapper.writeValueAsString(signUpRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//}
