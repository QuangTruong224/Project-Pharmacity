<<<<<<< HEAD
package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.user.payload.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created By HuuNQ
 * Test Mockito
 */

@SpringBootTest
@AutoConfigureMockMvc
public class UserController_getSignIn {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getSignIn_username_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(null);
        loginRequest.setPassword("123123");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                        .post("/api/manager-security/users/sign-in")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getSignIn_username_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("123123");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getSignIn_username_15() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("abcab cs");
        loginRequest.setPassword("123123");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_username_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("abcb");
        loginRequest.setPassword("123123");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_username_17() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("abcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcb");
        loginRequest.setPassword("123123");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_username_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("an.nguyen");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getSignIn_password_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword(null);
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getSignIn_password_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_password_15() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("abc abcas");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_password_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("an");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_password_17() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("an.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.com");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSignIn_password_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("an.nguyen@gmail.com");
        loginRequest.setPassword("an.nguyen");
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/manager-security/users/sign-in")
                                .content(this.objectMapper.writeValueAsString(loginRequest))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
=======
//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.user.payload.LoginRequest;
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
//
///**
// * Created By HuuNQ
// * Test Mockito
// */
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserController_getSignIn {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void getSignIn_username_13() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(null);
//        loginRequest.setPassword("123123");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                        .post("/api/manager-security/users/sign-in")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void getSignIn_username_14() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("");
//        loginRequest.setPassword("123123");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_username_15() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("abcab cs");
//        loginRequest.setPassword("123123");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_username_16() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("abcb");
//        loginRequest.setPassword("123123");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_username_17() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("abcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcbabcb");
//        loginRequest.setPassword("123123");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_username_18() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("an.nguyen");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void getSignIn_password_13() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword(null);
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void getSignIn_password_14() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_password_15() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("abc abcas");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_password_16() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("an");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_password_17() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("an.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.coman.nguyen@gmail.com");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getSignIn_password_18() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("an.nguyen@gmail.com");
//        loginRequest.setPassword("an.nguyen");
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/api/manager-security/users/sign-in")
//                                .content(this.objectMapper.writeValueAsString(loginRequest))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383
