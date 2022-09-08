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
//public class MedicineController_getAllMedicineAndSearch {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /*
//       Created by AnP
//       Time: 14:30 30/06/2022
//       Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: pass in parameter name =null
//    */
//    @Test
//    public void getAllMedicineAndSearch_name_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?name=null")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//       Created by AnP
//       Time: 16:30 30/06/2022
//       Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: pass in parameter name = ""
//    */
//    @Test
//    public void getAllMedicineAndSearch_name_8() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?name=''")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//       Created by AnP
//       Time: 16:30 30/06/2022
//       Function: Test JUnit 5 for method getAllMedicineAndSearch(),
//       case: pass in parameter name not exist database
//    */
//    @Test
//    public void getAllMedicineAndSearch_name_9() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?name=thuoc")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//     Created by AnP
//     Time: 16:30 30/06/2022
//     Function: Test JUnit 5 for method getAllMedicineAndSearch(),
//     case: pass in parameter name exist database but size list = 0 (flag = 0)
//    */
//    @Test
//    public void getAllMedicineAndSearch_name_10() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?name=sot")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//       Created by AnP
//       Time: 17:00 30/06/2022
//       Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: pass in parameter typeId=null
//    */
//    @Test
//    public void getAllMedicineAndSearch_typeId_7() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?typeId=null")
//        )
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//         Created by AnP
//         Time: 18:30 30/06/2022
//         Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: pass in parameter typeId = ""
//      */
//    @Test
//    public void getAllMedicineAndSearch_typeId_8() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?typeId=''")
//        )
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /*
//      Created by AnP
//      Time: 18:45 30/06/2022
//      Function: Test JUnit 5 for method getAllMedicineAndSearch(),
//      case: pass in parameter typeID not exist database
//    */
//    @Test
//    public void getAllMedicineAndSearch_typeId_9() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?typeId=5")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//     Created by AnP
//     Time: 18:50 30/06/2022
//     Function: Test JUnit 5 for method getAllMedicineAndSearch(),
//     case: pass in parameter typeId exist database but size list = 0 (flag = 0)
//    */
//    @Test
//    public void getAllMedicineAndSearch_typeId_10() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?typeId=3")
//        )
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /*
//       Created by AnP
//       Time: 19:00 30/06/2022
//       Function: Test JUnit 5 for method getAllMedicineAndSearch(),
//       case: pass in the name and typeId parameter that exists in database and size list > 0
//    */
//    @Test
//    public void getAllMedicineAndSearch_11() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/manager-medicine/medicines?name=a&typeId=2"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(2))
//                .andExpect(jsonPath("$.content[1].medicineName").value("Saferon Drop 15ml"))
//                .andExpect(jsonPath("$.content[1].medicinePrice").value("150000.0"))
//                .andExpect(jsonPath("$.content[1].medicineTypeName").hasJsonPath())
//                .andExpect(jsonPath("$.content[1].medicineImage").value("https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/__sized__/products/P02072_1_l-thumbnail-255x255.webp"));
//    }
//}
