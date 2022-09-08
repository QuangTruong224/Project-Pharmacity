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
//public class PrescriptionRestController_filterPrescription {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Id (Id = null)
//     * update 9:05 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_id_7() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?id={id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Id (Id = rỗng)
//     * update 09:08 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_id_8() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?id={id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Id (Id không tồn tại trong DB)
//     * update 09:10 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_id_9() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?id={id}", "^#@$@AVVV"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Id (Id tồn tại trong DB trả về list = 0)
//     * update 09:12 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_id_10() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?id={id}", "DT-00002"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Id (Id tồn tại trong DB)
//     * update 09:14 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_id_11() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?id={id}", "DT-00002"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Name (Name = null)
//     * update 09:14 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_name_7() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?names={names}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Name (Name = rỗng)
//     * update 09:16 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_name_8() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?names={names}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Name (Name không tồn tại trong DB)
//     * update 09:18 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_name_9() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?names={names}", "^#@$@AVVV"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Name (Name tồn tại trong DB trả về list = 0)
//     * update 09:20 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_name_10() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?names={names}", "Viêm họng NL"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Name (Name tồn tại trong DB)
//     * update 09:22 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_name_11() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?names={names}", "Viêm họng NL"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo TargetUser (TargetUser = null)
//     * update 09:24 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_targetUser_7() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?target={target}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo TargetUser (TargetUser = rỗng)
//     * update 09:26 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_targetUser_8() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?target={target}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo TargetUser (TargetUser không tồn tại trong DB)
//     * update 09:28 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_targetUser_9() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?target={target}", "^#@$@AVVV"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo TargetUser (TargetUser tồn tại trong DB trả về list = 0)
//     * update 09:30 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_targetUser_10() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?target={target}", "Người lớn"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo TargetUser (TargetUser tồn tại trong DB)
//     * update 09:32 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_targetUser_11() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?target={target}", "Người lớn"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo Symptom (Symptom = null)
//     * update 09:34 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_symptom_7() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo symptom (symptom = rỗng)
//     * update 09:36 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_symptom_8() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo symptom (symptom không tồn tại trong DB)
//     * update 09:38 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_symptom_9() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "^#@$@AVVV"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo symptom (symptom tồn tại trong DB)
//     * update 09:40 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_symptom_10() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "Sốt, đau đầu, sổ mũi"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit tìm kiếm theo symptom (symptom tồn tại trong DB)
//     * update 09:42 01/07/2022
//     */
//    @Test
//    public void getSearchPrescription_symptom_11() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "Sốt, đau đầu, sổ mũi"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
