<<<<<<< HEAD
//package com.c1221g1.pharmacy.controller.medicine;
//
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
///**
// * Creator: NghiaNTT Time: 30/02/2022
// * <p>
// * JUnit Test for method getMedicineDetailDtoById in MedicineController()
// */
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MedicineController_getMedicineDetailDtoById {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void getMedicineDetailDtoById_medicineId_1() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "null"))
//            .andDo(print())
//            .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getMedicineDetailDtoById_medicineId_2() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", ""))
//            .andDo(print())
//            .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getMedicineDetailDtoById_medicineId_3() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "INVALID_ID"))
//            .andDo(print())
//            .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getMedicineDetailDtoById_medicineId_4() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "T-00005"))
//            .andDo(print())
//            .andExpect(status().is2xxSuccessful())
//            .andExpect(jsonPath("$.medicineId").value("T-00005"))
//            .andExpect(jsonPath("$.medicineName").value("Dung d???ch v??? sinh m??i Nose Hygiene Spray (80ml)"))
//            .andExpect(jsonPath("$.medicineUsage").value("L??m s???ch c??c t???p ch???t v?? d???ch nh???y t??? ???????ng m??i, c???i thi???n h?? h???p."))
//            .andExpect(jsonPath("$.medicineImage").value("null"))
//            .andExpect(jsonPath("$.medicineActiveIngredients").value(
//                "???????c tinh chi???t t??? mu???i bi???n t??? nhi??n, gi??u kho??ng ch???t v?? nguy??n t??? vi l?????ng nh?? Ca++, Na+, Cu++, Zn++."))
//            .andExpect(jsonPath("$.medicinePrice").value( 2450000.0))
//            .andExpect(jsonPath("$.medicineManufacture").value("1"))
//            .andExpect(jsonPath("$.medicineInstruction").value(
//                "????a nh??? v??i phun v??o m??i cho v???a kh??t. ???n nhanh g???n v??i x???t 3-6 l???n v??o m???i b??n m??i. ????? dung d???ch th???a ch???y ra ngo??i sau ???? x?? m??i."))
//            .andExpect(jsonPath("$.medicineDescription").value(
//                "Dung d???ch v??? sinh m??i Nose Hygiene Spray ???????c tinh chi???t t??? mu???i bi???n t??? nhi??n v?? tinh d???u b???c h??, gi??u kho??ng ch???t v?? nguy??n t??? vi l?????ng nh?? Ca++, Na+, Cu++, Zn++, gi??p l??m s???ch c??c t???p ch???t v?? d???ch nh???y t??? ???????ng m??i, c???i thi???n h?? h???p, h??? tr??? ph??ng ng???a v?? l??m gi???m tri???u ch???ng s??? m??i, ng???t m??i..."))
//            .andExpect(jsonPath("$.medicineAgeApproved").value("Tr??? em tr??n 9 tu???i"));
//    }
//}
=======
package com.c1221g1.pharmacy.controller.medicine;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Creator: NghiaNTT Time: 30/02/2022
 * <p>
 * JUnit Test for method getMedicineDetailDtoById in MedicineController()
 */

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineController_getMedicineDetailDtoById {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMedicineDetailDtoById_medicineId_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "null"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", ""))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "INVALID_ID"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "T-00027"))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.medicineId").value("T-00027"))
            .andExpect(jsonPath("$.medicineName").value("Agiparofen 525mg"))
            .andExpect(jsonPath("$.medicineUsage").value("Gi???m ??au t??? nh??? ?????n v???a c??c ch???ng ??au li??n quan ?????n ??au ?????u, ??au l??ng, ??au b???ng kinh..."))
            .andExpect(jsonPath("$.medicineImage").value("https://firebasestorage.googleapis.com/v0/b/c1221g1-pharmacy.appspot.com/o/08-07-2022011558PMagiparofen.webp?alt=media&token=8953e897-5ffe-43b3-b89f-c7a98d9d9342"))
            .andExpect(jsonPath("$.medicineActiveIngredients").value(
                "Acetaminophen 325mg, Ibuprofen 200mg"))
            .andExpect(jsonPath("$.medicinePrice").value(2208.3333333333335))
            .andExpect(jsonPath("$.medicineManufacture").value("Nh?? M??y S???n Xu???t D?????c Ph???m Agimexpharm"))
            .andExpect(jsonPath("$.medicineInstruction").value(
                "U???ng thu???c sau b???a ??n."))
            .andExpect(jsonPath("$.medicineDescription").value(
                "Agiparofen ??t c?? t??c d???ng ph??? khi ???????c d??ng v???i li???u v?? th???i gian ????? ngh???"))
            .andExpect(jsonPath("$.medicineAgeApproved").value("tr??n 12 tu???i"));
    }
}
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383
