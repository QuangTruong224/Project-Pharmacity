package com.c1221g1.pharmacy.service.cart;
import com.c1221g1.pharmacy.dto.cart.PaymentOnlineForLookup;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaymentOnlineService {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database with payment id and customer name or just customer name
     *
     * @param paymentOnlineIdVal
     * @param customerNameVal
     * @param pageable
     * @return
     */
    Page<PaymentOnlineForLookup> findAll(String paymentOnlineIdVal, String customerNameVal, Pageable pageable);

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Save payment information in database
     * (using save(Entity) of spring data jpa because payment online Id have custom GenericGenerator (String and number)
     * and set cart status is completed.
     *
     * @param paymentOnline
     */
    void save(PaymentOnline paymentOnline);
}
