<<<<<<< HEAD:pharmacy/src/test/java/com/c1221g1/pharmacy/controller/paymentOnline/PaymentOnlineController_savePayment.java
package com.c1221g1.pharmacy.controller.paymentOnline;

import com.c1221g1.pharmacy.dto.cart.PaymentOnlineDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentOnlineController_savePayment {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Test case create new paymentOnline with cart null
     * cart have type of Cart and cartId is Integer so case  14 and 15 is the same this case
     *
     * @throws Exception
     */
    @Test
    public void savePayment_cart_13() throws Exception {
        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();
        paymentOnlineDto.setCart(null);
        paymentOnlineDto.setNote("some note");
        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/payment-online")
                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Test case create new paymentOnline with cart id <0
     *
     * @throws Exception
     */
    @Test
    public void savePayment_cart_16() throws Exception {
        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();

        Cart cart = new Cart();
        cart.setCartId(-1);
        paymentOnlineDto.setCart(cart);

        paymentOnlineDto.setNote("some note");
        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/payment-online")
                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Test case create new paymentOnline with cart id <0
     *
     * @throws Exception
     */
    @Test
    public void savePayment_cart_17() throws Exception {
        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();

        Cart cart = new Cart();
        cart.setCartId(100);
        paymentOnlineDto.setCart(cart);

        paymentOnlineDto.setNote("some note");
        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/payment-online")
                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Test case create new paymentOnline with cart valid
     * Payment online only have 1 field to validate is cart
     *
     * @throws Exception
     */
    @Test
    public void savePayment_18() throws Exception {
        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();

        Cart cart = new Cart();
        cart.setCartId(3);
        paymentOnlineDto.setCart(cart);

        paymentOnlineDto.setNote("some note");
        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/payment-online")
                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
=======
//package com.c1221g1.pharmacy.controller;
//
//import com.c1221g1.pharmacy.dto.cart.PaymentOnlineDto;
//import com.c1221g1.pharmacy.entity.cart.Cart;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDateTime;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PaymentOnlineController_savePayment {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: Test case create new paymentOnline with cart null
//     * cart have type of Cart and cartId is Integer so case  14 and 15 is the same this case
//     *
//     * @throws Exception
//     */
//    @Test
//    public void savePayment_cart_13() throws Exception {
//        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();
//        paymentOnlineDto.setCart(null);
//        paymentOnlineDto.setNote("some note");
//        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/payment-online")
//                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: Test case create new paymentOnline with cart id <0
//     *
//     * @throws Exception
//     */
//    @Test
//    public void savePayment_cart_16() throws Exception {
//        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();
//
//        Cart cart = new Cart();
//        cart.setCartId(-1);
//        paymentOnlineDto.setCart(cart);
//
//        paymentOnlineDto.setNote("some note");
//        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/payment-online")
//                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: Test case create new paymentOnline with cart id <0
//     *
//     * @throws Exception
//     */
//    @Test
//    public void savePayment_cart_17() throws Exception {
//        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();
//
//        Cart cart = new Cart();
//        cart.setCartId(100);
//        paymentOnlineDto.setCart(cart);
//
//        paymentOnlineDto.setNote("some note");
//        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/payment-online")
//                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: Test case create new paymentOnline with cart valid
//     * Payment online only have 1 field to validate is cart
//     *
//     * @throws Exception
//     */
//    @Test
//    public void savePayment_18() throws Exception {
//        PaymentOnlineDto paymentOnlineDto = new PaymentOnlineDto();
//
//        Cart cart = new Cart();
//        cart.setCartId(3);
//        paymentOnlineDto.setCart(cart);
//
//        paymentOnlineDto.setNote("some note");
//        paymentOnlineDto.setTimeCreate(LocalDateTime.now().toString());
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/payment-online")
//                        .content(this.objectMapper.writeValueAsString(paymentOnlineDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//}
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383:pharmacy/src/test/java/com/c1221g1/pharmacy/controller/PaymentOnlineController_savePayment.java
