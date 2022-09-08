//package com.c1221g1.pharmacy.controller.medicine;
//
//
//import com.c1221g1.pharmacy.dto.import_invoice.SupplierDto;
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
//public class SupplierRestController_createSupplier {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    /**
//     * trần ngọc luật
//     * test name supplier == null
//     * 16h10 30/06/2022
//     */
//    @Test
//    public void createSupplier_name_13() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        // test this
//        supplierDto.setSupplierName(null);
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        supplierDto.setSupplierPhone("09027726752");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test address supplier == null
//     * 16h10 30/06/2022
//     */
//    @Test
//    public void createSupplier_address_13() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An ");
//        // test this
//        supplierDto.setSupplierAddress(null);
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        supplierDto.setSupplierPhone("09027726752");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test email supplier == null
//     * 16h10 30/06/2022
//     */
//    @Test
//    public void createSupplier_email_13() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        // test this
//        supplierDto.setSupplierEmail(null);
//        supplierDto.setSupplierPhone("09027726752");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone supplier == null
//     * 16h10 30/06/2022
//     */
//    @Test
//    public void createSupplier_phone_13() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        // test this
//        supplierDto.setSupplierPhone(null);
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test note supplier == null
//     * 16h10 30/06/2022
//     * ( Because the note is not valid,
//     * it's okay to have it or not )
//     */
//    @Test
//    public void createSupplier_note_13() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        supplierDto.setSupplierPhone("0906465464");
//        // test this
//        supplierDto.setNote(null);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                // status ok
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test name supplier == ""
//     * 16h20 30/06/2022
//     */
//    @Test
//    public void createSupplier_name_14() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        // test this
//        supplierDto.setSupplierName("");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        supplierDto.setSupplierPhone("09027726752");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test Address supplier == ""
//     * 16h32 30/06/2022
//     */
//    @Test
//    public void createSupplier_address_14() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Minh Châu ");
//        // test this
//        supplierDto.setSupplierAddress("");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        supplierDto.setSupplierPhone("09027726752");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test phone email == ""
//     * 16h48 30/06/2022
//     */
//    @Test
//    public void createSupplier_email_14() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        // test this
//        supplierDto.setSupplierEmail("");
//        supplierDto.setSupplierPhone("0902292822");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone supplier == ""
//     * 18h56 30/06/2022
//     */
//    @Test
//    public void createSupplier_phone_14 () throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        // test this
//        supplierDto.setSupplierPhone("");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone regexp Malformed  !
//     * 18h11 30/06/2022
//     */
//    @Test
//    public void createSupplier_phone_15() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("thienan@gmail.com");
//        // test this
//        supplierDto.setSupplierPhone("9999999999");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test email regexp Malformed!
//     * 18h20 30/06/2022
//     */
//    @Test
//    public void createSupplier_email_15() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        // test this
//        supplierDto.setSupplierEmail("iugwiugw98kjs57kshb");
//        supplierDto.setSupplierPhone("0333167149");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * trần ngọc luật
//     * test all valid!
//     * 19h57 30/06/2022
//     */
//    @Test
//    public void createSupplier_valid_18() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Trần Bình Giảng ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Núi Thành Quảng Nam ");
//        supplierDto.setSupplierEmail("tranluat@gmail.com");
//        supplierDto.setSupplierPhone("0333167149");
//        supplierDto.setNote("Tốt");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier/")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone minlenght  Malformed!
//     * 16h20 1/7/2022
//     */
//    @Test
//    public void createSupplier_minlenght_16() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        // test this
//        supplierDto.setSupplierEmail("luahxzx   t@gail.com");
//        supplierDto.setSupplierPhone("0333");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone minlenght  Malformed!
//     * 16h20 1/7/2022
//     */
//    @Test
//    public void createSupplier_minLenghtName_16() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        // test this
//        supplierDto.setSupplierName("Nha");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("luahxzxt@gail.com");
//        supplierDto.setSupplierPhone("0333167149");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//     * trần ngọc luật
//     * test phone maxlenght  Malformed!
//     * 16h20 1/7/2022
//     */
//    @Test
//    public void createSupplier_maxlenght_17() throws Exception {
//
//        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
//        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
//        supplierDto.setSupplierEmail("iugwiugw@gmail.com");
//        // test this
//        supplierDto.setSupplierPhone("03331544968467149");
//        supplierDto.setNote("hòa nhã");
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/manager-medicine/medicines/supplier")
//                        .content(this.objectMapper.writeValueAsString(supplierDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//}
