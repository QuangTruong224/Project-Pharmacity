<<<<<<< HEAD
package com.c1221g1.pharmacy.controller.prescription;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrescriptionRestController_listPrescription {
    @Autowired
    private MockMvc mockMvc;


     // trường hợp danh sách trả về size = 0
    @Test
    public void getListPrescription_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


     // JUnit trường hợp danh sách trả về size > 0
    @Test
    public void getListPrescription_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(9))
                .andExpect(jsonPath("$.content[2].prescriptionName").value("Viêm họng TE"))
                .andExpect(jsonPath("$.content[2].prescriptionSymptom").value("Đau họng, ho"))
                .andExpect(jsonPath("$.content[2].prescriptionTargetUser").value("Trẻ em"))
                .andExpect(jsonPath("$.content[2].prescriptionNote").value("Cấm trẻ sơ sinh ..."))
                .andExpect(jsonPath("$.content[2].prescriptionNumberOfDays").value(3))
                .andExpect(jsonPath("$.content[2].flag").value(true));
    }
}
=======
//package com.c1221g1.pharmacy.controller.prescription;
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
//public class PrescriptionRestController_listPrescription {
//    @Autowired
//    private MockMvc mockMvc;
<<<<<<< HEAD
//
//<<<<<<< HEAD
//    /**
//     * HienTLD
//     * JUnit trường hợp danh sách trả về size = 0
//     * 16:50 30/06/2022
//     */
//=======
//
//     // trường hợp danh sách trả về size = 0
//>>>>>>> 770b939a5d8a128ce0a183a30a2aaa58056ca229
=======
//x
//
//     // trường hợp danh sách trả về size = 0
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383
//    @Test
//    public void getListPrescription_5() throws Exception {
//
//        this.mockMvc.perform(
//<<<<<<< HEAD
//                        MockMvcRequestBuilders
//                                .get("/api/manager-prescription/prescriptions/"))
//=======
//                MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions/"))
//>>>>>>> 770b939a5d8a128ce0a183a30a2aaa58056ca229
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//<<<<<<< HEAD
//    /**
//     * HienTLD
//     * JUnit trường hợp danh sách trả về size > 0
//     * 17:13 30/06/2022
//     */
//=======
//
//     // JUnit trường hợp danh sách trả về size > 0
//>>>>>>> 770b939a5d8a128ce0a183a30a2aaa58056ca229
//    @Test
//    public void getListPrescription_6() throws Exception {
//
//        this.mockMvc.perform(
//<<<<<<< HEAD
//                        MockMvcRequestBuilders
<<<<<<< HEAD
//                                .get("/api/manager-prescription/prescriptions/"))
//=======
=======
////                                .get("/api/manager-prescraiption/prescriptions/"))
//=======a
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383
//                MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions/"))
//>>>>>>> 770b939a5d8a128ce0a183a30a2aaa58056ca229
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(3))
//                .andExpect(jsonPath("$.totalElements").value(9))
//                .andExpect(jsonPath("$.content[2].prescriptionName").value("Viêm họng TE"))
//                .andExpect(jsonPath("$.content[2].prescriptionSymptom").value("Đau họng, ho"))
//                .andExpect(jsonPath("$.content[2].prescriptionTargetUser").value("Trẻ em"))
//                .andExpect(jsonPath("$.content[2].prescriptionNote").value("Cấm trẻ sơ sinh ..."))
//                .andExpect(jsonPath("$.content[2].prescriptionNumberOfDays").value(3))
//                .andExpect(jsonPath("$.content[2].flag").value(true));
//    }
//<<<<<<< HEAD
//}
//=======
//}
//>>>>>>> 770b939a5d8a128ce0a183a30a2aaa58056ca229
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383
