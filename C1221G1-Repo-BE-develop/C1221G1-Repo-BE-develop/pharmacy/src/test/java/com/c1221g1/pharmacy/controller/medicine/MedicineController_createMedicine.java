//package com.c1221g1.pharmacy.controller.medicine;
//
//import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
//import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
//import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
//import com.c1221g1.pharmacy.entity.medicine.MedicineType;
//import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
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
//public class MedicineController_createMedicine {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * this function use to test the validation of field name more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_name_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_name_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_name_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_name_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_name_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_activeIngredients_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_activeIngredients_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_activeIngredients_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC#%");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_activeIngredients_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("cc");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_activeIngredients_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("cccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
//                "ccccccccccccccccc");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field importPrice more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_importPrice_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field importPrice more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_importPrice_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(null);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_importPrice_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC#%");
//        medicineDto.setMedicineImportPrice(-500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field activeIngredients more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_importPrice_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field discount more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_discount_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field discount more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_discount_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(null);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field discount more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_discount_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(-3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field discount more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_discount_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(191.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field wholesaleProfit more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_wholesaleProfit_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field wholesaleProfit more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_wholesaleProfit_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(null);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field wholesaleProfit more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_wholesaleProfit_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(-2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field wholesaleProfit more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_wholesaleProfit_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(122.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailSaleProfit more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_retailSaleProfit_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailSaleProfit more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_retailSaleProfit_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(null);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailSaleProfit more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_retailSaleProfit_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field retailSaleProfit more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_retailSaleProfit_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field tax more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_tax_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field tax more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_tax_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(null);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field tax more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_tax_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field tax more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_tax_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field conversionRate more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_conversionRate_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field conversionRate more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_conversionRate_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(1.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field conversionRate more specific is not positive
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_conversionRate_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(-10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field conversionRate more specific is maximum
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_conversionRate_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(513.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field manufacture more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_manufacture_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field manufacture more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_manufacture_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("??dsad");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field manufacture more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_manufacture_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco#%");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field manufacture more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_manufacture_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("d");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field manufacture more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_manufacture_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
//                "                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field usage more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_usage_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field usage more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_usage_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("??dads");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field usage more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_usage_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t$#");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field usage more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_usage_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("d");
//        medicineDto.setMedicineUsage("a");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field usage more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_usage_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "gi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???tgi???m m?? m???t" +
//                "");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field instruction more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_instruction_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field instruction more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_instruction_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("dsadadsa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("aaaaa");
//        medicineDto.setMedicineInstruction("");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field instruction more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_instruction_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t$#");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t#@#");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field instruction more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_instruction_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("dddd");
//        medicineDto.setMedicineUsage("add");
//        medicineDto.setMedicineInstruction("a");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field instruction more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_instruction_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "nh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???tnh??? v??o m???t" +
//                "");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ageApproved more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_ageApproved_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ageApproved more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_ageApproved_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("dsads");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("aaaaa");
//        medicineDto.setMedicineInstruction("tr??n 18 tu???i");
//        medicineDto.setMedicineAgeApproved("");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ageApproved more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_ageApproved_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t$#");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t#@#");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i$@$");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ageApproved more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_ageApproved_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("dddd");
//        medicineDto.setMedicineUsage("add");
//        medicineDto.setMedicineInstruction("aedase");
//        medicineDto.setMedicineAgeApproved("a");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field ageApproved more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_ageApproved_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???tnh??? v??o m???tnh??? v??o");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???itr??n 18 tu???i" +
//                "tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field image more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_image_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field image more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_image_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aaa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("aaaaa");
//        medicineDto.setMedicineInstruction("tr??n 18 tu???i");
//        medicineDto.setMedicineAgeApproved("aaa");
//        medicineDto.setMedicineImage("");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field image more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_image_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t$#");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t#@#");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i$@$");
//        medicineDto.setMedicineImage("im#@g.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field image more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_image_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("dddd");
//        medicineDto.setMedicineUsage("add");
//        medicineDto.setMedicineInstruction("aedase");
//        medicineDto.setMedicineAgeApproved("a??wewe");
//        medicineDto.setMedicineImage("e");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field image more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_image_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???tnh??? v??o m???tnh??? v??o");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???itr??n 18 t+tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "img.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.pngimg.png" +
//                "");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_description_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is empty
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_description_14() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aaa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("aaaaa");
//        medicineDto.setMedicineInstruction("tr??n 18 tu???i");
//        medicineDto.setMedicineAgeApproved("aaa");
//        medicineDto.setMedicineImage("11aa");
//        medicineDto.setMedicineDescription("");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is containing special character
//     *
//     * @author LongNH
//     * @Time 15:02 30/06/2022
//     */
//    @Test
//    public void createMedicine_description_15() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t$#");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t#@#");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i$@$");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t#@#@");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is min length
//     *
//     * @author LongNH
//     * @Time 15:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_description_16() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("dddd");
//        medicineDto.setMedicineUsage("add");
//        medicineDto.setMedicineInstruction("aedase");
//        medicineDto.setMedicineAgeApproved("a??wewe");
//        medicineDto.setMedicineImage("e1??dds");
//        medicineDto.setMedicineDescription("a");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field Description more specific is max length
//     *
//     * @author LongNH
//     * @Time 18:05 30/06/2022
//     */
//    @Test
//    public void createMedicine_description_17() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???tnh??? v??o m???tnh??? v??o");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???itr??n 18 t+tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.pngimg.pngimg.pngimg");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t" +
//                "ch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???tch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field origin more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_origin_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field type more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_type_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field unit more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_unit_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field conversionUnit more specific is null
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_conversionUnit_13() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("th???c nh??? m???t");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to create medicine with all valid item
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void createMedicine_all_item_18() throws Exception {
//        MedicineDto medicineDto = new MedicineDto();
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        MedicineType medicineType = new MedicineType();
//        MedicineUnit medicineUnit = new MedicineUnit();
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("gi???m m?? m???t");
//        medicineDto.setMedicineInstruction("nh??? v??o m???t");
//        medicineDto.setMedicineAgeApproved("tr??n 18 tu???i");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("ch???ng ch??? ?????nh ch???t v??o m???t");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
