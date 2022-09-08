<<<<<<< HEAD:pharmacy/src/test/java/com/c1221g1/pharmacy/controller/paymentOnline/PaymentOnlineController_getPaymentOnline.java
package com.c1221g1.pharmacy.controller.paymentOnline;

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
public class PaymentOnlineController_getPaymentOnline {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with id null.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_paymentOnlineId_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId="))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with id empty.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_paymentOnlineId_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=''"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with id not contain in database.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_paymentOnlineId_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=HDO-0101"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with id valid but have no result.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_paymentOnlineId_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=HDO-0001&customerName=AnPhan"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with customerName null.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_customerName_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?customerName=null"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with customerName is empty.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_customerName_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?customerName=''"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with customerName not contain in database.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_customerName_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?customerName=AnPhan"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case find paymentOnline with customerName valid but have no result.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_customerName_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=HDO-0001&customerName=AnPhan"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 1/7/2022
     * function: test case find paymentOnline with customerName valid paymentOnlineId valid.
     * But with page number greater than total pages
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=HDO-0002&customerName=Khoa&page=3&size=5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: KhoaPV
     * Date created: 1/7/2022
     * function: test case find paymentOnline with customerName valid paymentOnlineId valid. Have 1 item response.
     *
     * @throws Exception
     */
    @Test
    public void getPaymentOnline_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/payment-online?paymentOnlineId=HDO-0002&customerName=Khoa&page=0&size=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].paymentId").value("HDO-0002"))
                .andExpect(jsonPath("$.content[0].timeCreate").value("2022-06-30 08:00:32.00"))
                .andExpect(jsonPath("$.content[0].cart.id").value(2));
    }
}
=======
//package com.c1221g1.pharmacy.controller;
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
//public class PaymentOnlineController_getPaymentOnline {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with id null.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_paymentOnlineId_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with id empty.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_paymentOnlineId_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=''"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with id not contain in database.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_paymentOnlineId_9() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=HDO-0101"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with id valid but have no result.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_paymentOnlineId_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=HDO-0001&customerName=AnPhan"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with customerName null.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_customerName_7() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?customerName=null"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with customerName is empty.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_customerName_8() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?customerName=''"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with customerName not contain in database.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_customerName_9() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?customerName=AnPhan"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 30/6/2022
//     * function: test case find paymentOnline with customerName valid but have no result.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_customerName_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=HDO-0001&customerName=AnPhan"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 1/7/2022
//     * function: test case find paymentOnline with customerName valid paymentOnlineId valid.
//     * But with page number greater than total pages
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_10() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=HDO-0002&customerName=Khoa&page=3&size=5"))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }
//
//    /**
//     * Created by: KhoaPV
//     * Date created: 1/7/2022
//     * function: test case find paymentOnline with customerName valid paymentOnlineId valid. Have 1 item response.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getPaymentOnline_11() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/payment-online?paymentOnlineId=HDO-0002&customerName=Khoa&page=0&size=5"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(1))
//                .andExpect(jsonPath("$.totalElements").value(1))
//                .andExpect(jsonPath("$.content[0].paymentId").value("HDO-0002"))
//                .andExpect(jsonPath("$.content[0].timeCreate").value("2022-06-30 08:00:32.00"))
//                .andExpect(jsonPath("$.content[0].cart.id").value(2));
//    }
//}
>>>>>>> 8742e52c101e4dd6fe98881d155d8fd633cdc383:pharmacy/src/test/java/com/c1221g1/pharmacy/controller/PaymentOnlineController_getPaymentOnline.java
