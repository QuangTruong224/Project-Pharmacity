package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.PaymentOnlineForLookup;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.repository.cart.IPaymentOnlineRepository;
import com.c1221g1.pharmacy.service.cart.ICartService;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentOnlineService implements IPaymentOnlineService {
    @Autowired
    private IPaymentOnlineRepository iPaymentOnlineRepository;
    @Autowired
    private ICartService iCartService;

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
    @Override
    public Page<PaymentOnlineForLookup> findAll(String paymentOnlineIdVal, String customerNameVal, Pageable pageable) {
        if (!paymentOnlineIdVal.equals("")) {
            return this.iPaymentOnlineRepository.findPaymentOnlineByIdAndCustomerName(paymentOnlineIdVal, customerNameVal, pageable);
        } else {
            return this.iPaymentOnlineRepository.findAllPaymentOnlineByCustomerName(customerNameVal, pageable);
        }
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Save payment information in database
     * (using save(Entity) of spring data jpa because payment online Id have custom GenericGenerator (String and number)
     * and set cart status is completed.
     *
     * @param paymentOnline
     */
    @Override
    public void save(PaymentOnline paymentOnline) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = now.format(format);
        paymentOnline.setTimeCreate(formatDateTime);
        this.iPaymentOnlineRepository.save(paymentOnline);
        this.iCartService.setCartComplete(paymentOnline.getCart().getCartId());
        //sending email for customer
    }
}
