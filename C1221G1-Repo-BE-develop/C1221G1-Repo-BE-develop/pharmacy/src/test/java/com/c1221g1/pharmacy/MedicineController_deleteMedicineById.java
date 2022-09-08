//package com.c1221g1.pharmacy;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MedicineController_deleteMedicineById {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void deleteMedicineById_25() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.patch("/api/manager-medicine/medicines/delete/{}","null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void deleteMedicineById_26() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.patch("/api/manager-medicine/medicines/delete/{id}",""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void deleteMedicineById_27() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.patch("/api/manager-medicine/medicines/delete/{id}","T-0023"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void deleteMedicineById_28() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.patch("/api/manager-medicine/medicines/delete/{id}","T-0002"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//}
