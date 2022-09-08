package com.c1221g1.pharmacy.controller.cart;

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
public class CartController_findCartByCustomerId {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find cart with customer id have id null.
     *
     * @throws Exception
     */
    @Test
    public void findCartByCustomerId_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/carts/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find cart with customer id have id empty.
     *
     * @throws Exception
     */
    @Test
    public void findCartByCustomerId_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/carts/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find cart with customer id don't contain in database.
     *
     * @throws Exception
     */
    @Test
    public void findCartByCustomerId_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/carts/{id}", "KH-100011"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find cart with customer id valid.
     *
     * @throws Exception
     */
    @Test
    public void findCartByCustomerId_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/carts/{id}", "KH-0001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dateCreate").value("2022-06-30"))
                .andExpect(jsonPath("$.customer.id").value("KH-0001"))
                .andExpect(jsonPath("$.cartStatus").value(false));
    }
}