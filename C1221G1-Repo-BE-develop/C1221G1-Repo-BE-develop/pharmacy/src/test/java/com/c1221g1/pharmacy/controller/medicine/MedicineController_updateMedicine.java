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
//public class MedicineController_updateMedicine {
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
//    public void updateMedicine_name_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_name_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_name_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_name_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_name_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_activeIngredients_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_activeIngredients_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_activeIngredients_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC#%");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_activeIngredients_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("cc");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_activeIngredients_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_importPrice_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_importPrice_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(null);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_importPrice_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC#%");
//        medicineDto.setMedicineImportPrice(-500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_importPrice_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_discount_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_discount_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(null);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_discount_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(-3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_discount_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.0);
//        medicineDto.setMedicineDiscount(191.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_wholesaleProfit_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_wholesaleProfit_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(null);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_wholesaleProfit_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(-2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_wholesaleProfit_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.0);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(122.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_retailSaleProfit_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_retailSaleProfit_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(null);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_retailSaleProfit_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_retailSaleProfit_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.0);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_tax_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_tax_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(null);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_tax_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_tax_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.1);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_conversionRate_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_conversionRate_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(1.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_conversionRate_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(-2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(-10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_conversionRate_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(10.0);
//        medicineDto.setMedicineDiscount(11.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(122.0);
//        medicineDto.setMedicineTax(513.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_manufacture_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_manufacture_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("ádsad");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_manufacture_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco#%");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_manufacture_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("d");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_manufacture_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_usage_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_usage_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("ádads");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aa");
//        medicineDto.setMedicineUsage("");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_usage_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt$#");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_usage_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_usage_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "giảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắtgiảm mù mắt" +
//                "");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_instruction_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_instruction_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_instruction_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt$#");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt#@#");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_instruction_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_instruction_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "nhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắtnhỏ vào mắt" +
//                "");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_ageApproved_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_ageApproved_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineInstruction("trên 18 tuổi");
//        medicineDto.setMedicineAgeApproved("");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_ageApproved_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt$#");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt#@#");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi$@$");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_ageApproved_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_ageApproved_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắtnhỏ vào mắtnhỏ vào");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổitrên 18 tuổi" +
//                "trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_image_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_image_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineInstruction("trên 18 tuổi");
//        medicineDto.setMedicineAgeApproved("aaa");
//        medicineDto.setMedicineImage("");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_image_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt$#");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt#@#");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi$@$");
//        medicineDto.setMedicineImage("im#@g.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_image_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineAgeApproved("aêwewe");
//        medicineDto.setMedicineImage("e");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_image_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắtnhỏ vào mắtnhỏ vào");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổitrên 18 t+trên 18 tuổi");
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
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_description_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_description_14() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineInstruction("trên 18 tuổi");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_description_15() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc bo t1#%$");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt$#");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt#@#");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi$@$");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt#@#@");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_description_16() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
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
//        medicineDto.setMedicineAgeApproved("aêwewe");
//        medicineDto.setMedicineImage("e1ádds");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_description_17() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("aa");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("aaa");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắtnhỏ vào mắtnhỏ vào");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổitrên 18 t+trên 18 tuổi");
//        medicineDto.setMedicineImage("img.pngimg.pngimg.pngimg");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt" +
//                "chống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắtchống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_origin_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_type_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_unit_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .patch("/api/manager-medicine/medicines")
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
//    public void updateMedicine_conversionUnit_13() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thốc nhỏ mắt");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
//        medicineDto.setFlag(true);
//        medicineOrigin.setMedicineOriginId(1);
//        medicineDto.setMedicineOrigin(medicineOrigin);
//        medicineType.setMedicineTypeId("LT0001");
//        medicineDto.setMedicineType(medicineType);
//        medicineUnit.setMedicineUnitId(1);
//        medicineDto.setMedicineUnit(medicineUnit);
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .patch("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to update medicine with all valid item
//     *
//     * @author LongNH
//     * @Time 15:00 30/06/2022
//     */
//    @Test
//    public void updateMedicine_all_item_18() throws Exception {
//        MedicineOrigin medicineOrigin = new MedicineOrigin();
//        medicineOrigin.setMedicineOriginId(1);
//        medicineOrigin.setMedicineOriginName("TQ");
//        MedicineType medicineType = new MedicineType();
//        medicineType.setMedicineTypeId("LT0001");
//        medicineType.setMedicineTypeName("Thuốc bổ");
//        MedicineUnit medicineUnit = new MedicineUnit();
//        medicineUnit.setMedicineUnitId(1);
//        medicineUnit.setMedicineUnitName("hộp");
//        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineConversionUnit.setMedicineConversionUnitId(1);
//        medicineConversionUnit.setMedicineConversionUnitName("viên");
//        MedicineDto medicineDto = new MedicineDto
//                ("T-00010", "thuoc ca", "omega3", 5000.0,
//                        5.0, 3.0, 2.0, 5.0, 10,
//                        "daphaco", "bo sung mat", "uong", "tren 18 tuoi",
//                        "thuocca.png", "la thuoc bo tro mat", true, medicineOrigin,
//                        medicineType, medicineUnit, medicineConversionUnit);
//        medicineDto.setMedicineName("thuoc nho mat");
//        medicineDto.setMedicineActiveIngredients("vitaminC");
//        medicineDto.setMedicineImportPrice(500.0);
//        medicineDto.setMedicineDiscount(3.0);
//        medicineDto.setMedicineWholesaleProfit(2.0);
//        medicineDto.setMedicineRetailSaleProfit(2.0);
//        medicineDto.setMedicineTax(5.0);
//        medicineDto.setMedicineConversionRate(10);
//        medicineDto.setMedicineManufacture("daphaco");
//        medicineDto.setMedicineUsage("giảm mù mắt");
//        medicineDto.setMedicineInstruction("nhỏ vào mắt");
//        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
//        medicineDto.setMedicineImage("img.png");
//        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
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
//                .patch("/api/manager-medicine/medicines")
//                .content(this.objectMapper.writeValueAsString(medicineDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}
