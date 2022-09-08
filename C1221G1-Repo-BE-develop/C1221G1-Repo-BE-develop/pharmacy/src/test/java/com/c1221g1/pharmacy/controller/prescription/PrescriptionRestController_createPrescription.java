//package com.c1221g1.pharmacy.controller.prescription;
//
//import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
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
//public class PrescriptionRestController_createPrescription {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp name = null)
//     * 20:59 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_13() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp name = rỗng)
//     * 21:02 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_14() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp name sai format)
//     * 21:02 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_15() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("ADSD$#$@%@");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp name không >= minlength)
//     * 21:03 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_16() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("a");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp name không <= maxlength)
//     * 21:03 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_17() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp tất cả trường hợp lệ)
//     * 21:04 30/06/2022
//     */
//    @Test
//    public void createPrescription_name_18() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp symptom = null)
//     * 21:07 30/06/2022
//     */
//    @Test
//    public void createPrescription_symptom_13() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
////        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp symptom = rỗng)
//     * 21:09 30/06/2022
//     */
//    @Test
//    public void createPrescription_symptom_14() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp symptom sai format)
//     * 21:11 30/06/2022
//     */
//    @Test
//    public void createPrescription_symptom_15() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("ADSD$#$@%@Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp symptom không >= minlength)
//     * 21:13 30/06/2022
//     */
//    @Test
//    public void createPrescription_symptom_16() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("a");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp symptom không <= maxlength)
//     * 21:14 30/06/2022
//     */
//    @Test
//    public void createPrescription_symptom_17() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp targetUser = null)
//     * 21:16 30/06/2022
//     */
//    @Test
//    public void createPrescription_targetUser_13() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
////        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp targetUser = rỗng)
//     * 21:17 30/06/2022
//     */
//    @Test
//    public void createPrescription_targetUser_14() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp targetUser sai format)
//     * 21:18 30/06/2022
//     */
//    @Test
//    public void createPrescription_targetUser_15() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("NgườiADSD$#$@%@ lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp targetUser không >= minlength)
//     * 21:19 30/06/2022
//     */
//    @Test
//    public void createPrescription_targetUser_16() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("a");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp targetUser không <= maxlength)
//     * 21:20 30/06/2022
//     */
//    @Test
//    public void createPrescription_targetUser_17() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note = null)
//     * 21:21 30/06/2022
//     */
//    @Test
//    public void createPrescription_note_13() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
////        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note = rỗng)
//     * 21:22 30/06/2022
//     */
//    @Test
//    public void createPrescription_note_14() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note sai format)
//     * 21:23 30/06/2022
//     */
//    @Test
//    public void createPrescription_note_15() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("ADQ@Ứ#$@");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note không >= minlength)
//     * 21:24 30/06/2022
//     */
//    @Test
//    public void createPrescription_note_16() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("C");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note không <= maxlength)
//     * 21:25 30/06/2022
//     */
//    @Test
//    public void createPrescription_note_17() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ emaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp numberOfDays = null)
//     * 21:26 30/06/2022
//     */
//    @Test
//    public void createPrescription_numberOfDays_13() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
////        prescriptionDto.setPrescriptionNumberOfDays(5);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
////    /**
////     * HienTLD
////     * JUnit Thêm mới (trường hợp note = rỗng)
////     * 21:22 30/06/2022
////     */
////    @Test
////    public void createPrescription_note_14() throws Exception {
////
////        PrescriptionDto prescriptionDto = new PrescriptionDto();
////        prescriptionDto.setPrescriptionName("Cảm cúm NL");
////        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
////        prescriptionDto.setPrescriptionTargetUser("Người lớn");
////        prescriptionDto.setPrescriptionNote("");
////        prescriptionDto.setPrescriptionNumberOfDays(5);
////        prescriptionDto.setFlag(true);
////
////        this.mockMvc
////                .perform(MockMvcRequestBuilders
////                        .post("/api/manager-prescription/prescriptions/create")
////                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
////                        .contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andDo(print())
////                .andExpect(status().is4xxClientError());
////    }
////
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp numberOfDays sai format)
//     * 21:27 30/06/2022
//     */
//    @Test
//    public void createPrescription_numberOfDays_15() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(Integer.parseInt("a"));
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp numberOfDays không >= min)
//     * 21:28 30/06/2022
//     */
//    @Test
//    public void createPrescription_numberOfDays_16() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(0);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * HienTLD
//     * JUnit Thêm mới (trường hợp note numberOfDays <= max)
//     * 21:30 30/06/2022
//     */
//    @Test
//    public void createPrescription_numberOfDays_17() throws Exception {
//
//        PrescriptionDto prescriptionDto = new PrescriptionDto();
//        prescriptionDto.setPrescriptionName("Cảm cúm NL");
//        prescriptionDto.setPrescriptionSymptom("Sốt, đau đầu, sổ mũi");
//        prescriptionDto.setPrescriptionTargetUser("Người lớn");
//        prescriptionDto.setPrescriptionNote("Cấm trẻ em dưới 10 tuổi ...");
//        prescriptionDto.setPrescriptionNumberOfDays(366);
//        prescriptionDto.setFlag(true);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-prescription/prescriptions/create")
//                        .content(this.objectMapper.writeValueAsString(prescriptionDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
