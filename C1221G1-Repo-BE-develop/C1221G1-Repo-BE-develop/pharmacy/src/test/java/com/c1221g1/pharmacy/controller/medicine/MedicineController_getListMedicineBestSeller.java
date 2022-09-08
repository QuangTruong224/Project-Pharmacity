//package com.c1221g1.pharmacy.controller.medicine;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MedicineController_getListMedicineBestSeller {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /*
//        Created by AnP
//        Time: 14:00 30/06/2022
//        Function: Test JUnit 5 for method getListMedicineBestSeller(), case: size list = 0
//    */
//    @Test
//    public void getListMedicineBestSeller_5() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines/best-seller"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//       Created by AnP
//       Time: 14:05 30/06/2022
//       Function: Test JUnit 5 for method getListMedicineBestSeller(), case: size list > 0
//    */
//    @Test
//    public void getListMedicineBestSeller_6() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines/best-seller"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[9].medicineName").value("Agimoti Agimexpharm (60ml)"))
//                .andExpect(jsonPath("$[9].medicinePrice").value("37500.0"))
//                .andExpect(jsonPath("$[9].soldQuantity").value(2))
//                .andExpect(jsonPath("$[9].medicineTypeName").hasJsonPath())
//                .andExpect(jsonPath("$[9].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/__sized__/products/P17147_1_l-thumbnail-255x255.webp"));
//    }
//}
