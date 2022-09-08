package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CartAndDetailDto;
import com.c1221g1.pharmacy.dto.cart.CustomerMailing;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ISendingEmailService {
    /**
     * Created by: KhoaPV
     * Date created: 01/7/2022
     * function: Sending email to customer when buying and pay with paypal successful
     * @param cartAndDetailDto
     * @param total
     * @param discountPercent
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void sendEmail(CartAndDetailDto cartAndDetailDto, double total, double discountPercent) throws MessagingException, IOException, TemplateException;
}
