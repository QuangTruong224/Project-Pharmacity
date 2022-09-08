package com.c1221g1.pharmacy.controller.invoice;

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
public class InvoiceMedicine_getListMedicine {
    @Autowired
    private MockMvc mockMvc;

    //test thất bại: database không có
    @Test
    public void getListMedicine_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-sale/invoiceMedicines/getMedicines"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test thành công
    @Test
    public void getListMedicine_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-sale/invoiceMedicines/getMedicines"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
