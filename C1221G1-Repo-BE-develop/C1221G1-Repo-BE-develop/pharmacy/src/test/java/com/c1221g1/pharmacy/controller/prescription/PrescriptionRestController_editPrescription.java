//package com.c1221g1.pharmacy.controller.prescription;
//
//import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
//import com.c1221g1.pharmacy.entity.prescription.Prescription;
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
//public class PrescriptionRestController_editPrescription {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName = null
//     * 11:00 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_19() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
////        prescriptionDto.setPrescriptionName(null);
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName rỗng
//     * 11:30 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_20() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName sai format
//     * 11:00 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_21() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Viêm%#654^");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName không >= minlength
//     * 13:49 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_22() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("a");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName không <= maxlength
//     * 13:49 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_23() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionName tất cả trường hợp lệ
//     * 14:32 30/06/2022
//     */
//    @Test
//    public void editPrescription_name_24() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt NL");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, sốt, ho");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(7);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionSymptom = null
//     * 11:00 30/06/2022
//     */
//    @Test
//    public void editPrescription_symptom_19() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
////        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionSymptom rỗng
//     * 14:38 30/06/2022
//     */
//    @Test
//    public void editPrescription_symptom_20() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionSymptom sai format
//     * 14:41 30/06/2022
//     */
//    @Test
//    public void editPrescription_symptom_21() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau234%@#%");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionSymptom không >= minlength
//     * 14:56 30/06/2022
//     */
//    @Test
//    public void editPrescription_symptom_22() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("a");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionSymptom không <= maxlength
//     * 14:57 30/06/2022
//     */
//    @Test
//    public void editPrescription_symptom_23() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    /**
//     * HienTLD
//     * JUnit prescriptionTargetUser = null
//     * 16:05 30/06/2022
//     */
//    @Test
//    public void editPrescription_targetUser_19() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
////        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionTargetUser rỗng
//     * 16:08 30/06/2022
//     */
//    @Test
//    public void editPrescription_targetUser_20() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionTargetUser sai format
//     * 16:10 30/06/2022
//     */
//    @Test
//    public void editPrescription_targetUser_21() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ5342%#$@");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionTargetUser không >= minlength
//     * 16:11 30/06/2022
//     */
//    @Test
//    public void editPrescription_targetUser_22() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("a");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionTargetUser không <= maxlength
//     * 16:12 30/06/2022
//     */
//    @Test
//    public void editPrescription_targetUser_23() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNote = null
//     * 16:13 30/06/2022
//     */
//    @Test
//    public void editPrescription_note_19() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
////        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNote rỗng
//     * 16:15 30/06/2022
//     */
//    @Test
//    public void editPrescription_note_20() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNote sai format
//     * 16:17 30/06/2022
//     */
//    @Test
//    public void editPrescription_note_21() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm%#$@#%");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNote không >= minlength
//     * 16:18 30/06/2022
//     */
//    @Test
//    public void editPrescription_note_22() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("a");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNote không <= maxlength
//     * 16:19 30/06/2022
//     */
//    @Test
//    public void editPrescription_note_23() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionNumberOfDays(4);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    /**
//     * HienTLD
//     * JUnit prescriptionNumberOfDays = null
//     * 16:38 30/06/2022
//     */
//    @Test
//    public void editPrescription_NumberOfDays_19() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
////        prescriptionDto.setPrescriptionNumberOfDays(0);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
////    /**
////     * HienTLD
////     * JUnit prescriptionNote rỗng
////     * 16:15 30/06/2022
////     */
////    @Test
////    public void editPrescription_note_20() throws Exception {
////        PrescriptionDto prescriptionDto = new PrescriptionDto();
////        prescriptionDto.setPrescriptionId("DT-00009");
////        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
////        prescriptionDto.setFlag(true);
////        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
////        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
////        prescriptionDto.setPrescriptionNote("");
////        prescriptionDto.setPrescriptionNumberOfDays(4);
////        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
////                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
////                        .contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andDo(print()).andExpect(status().is4xxClientError());
////    }
////
//    /**
//     * HienTLD
//     * JUnit prescriptionNumberOfDays sai format
//     * 16:42 30/06/2022
//     */
//    @Test
//    public void editPrescription_numberOfDays_21() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(Integer.parseInt("ad"));
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNumberOfDays không >= min
//     * 16:44 30/06/2022
//     */
//    @Test
//    public void editPrescription_numberOfDays_22() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(0);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit prescriptionNumberOfDays không <= max
//     * 16:45 30/06/2022
//     */
//    @Test
//    public void editPrescription_numberOfDays_23() throws Exception {
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionId("DT-00009");
//        prescriptionDto.setPrescriptionName("Viêm họng hạt TE");
//        prescriptionDto.setFlag(true);
//        prescriptionDto.setPrescriptionSymptom("Đau họng, ho");
//        prescriptionDto.setPrescriptionTargetUser("Trẻ em");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ sơ sinh ...");
//        prescriptionDto.setPrescriptionNumberOfDays(366);
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/manager-prescription/prescriptions/edit/{id}", "DT-00009")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//}
