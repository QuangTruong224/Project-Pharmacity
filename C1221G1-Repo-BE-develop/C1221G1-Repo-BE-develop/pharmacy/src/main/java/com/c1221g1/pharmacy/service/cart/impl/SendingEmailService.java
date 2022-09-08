package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.*;
import com.c1221g1.pharmacy.service.cart.ISendingEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendingEmailService implements ISendingEmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;

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
    @Override
    public void sendEmail(CartAndDetailDto cartAndDetailDto, double total, double discountPercent) throws MessagingException, IOException, TemplateException {
        String format = "%,.0f";
        String totalAfterDiscount = String.format(format, total * (1 - discountPercent));
        String totalValueSending = String.format(format, total);
        CustomerDtoForCart customer = cartAndDetailDto.getCustomer();
        List<CartDetailDto> cartDetailDtos = cartAndDetailDto.getCartDetail();
        Map<String, Object> model = new HashMap<>();
        model.put("total", totalValueSending);
        model.put("discount", String.format(format, discountPercent * 100));
        model.put("customer", customer);
        model.put("totalAfter", totalAfterDiscount);
        model.put("cartDetailDtos", cartDetailDtos);
        model.put("location", "Đội ngũ C1221G1");
        model.put("signature", "Pharmacode Group");


        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/static/logo.jpg"));

        Template template = emailConfig.getTemplate("email.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        mimeMessageHelper.setTo(cartAndDetailDto.getCustomer().getCustomerUserName());
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setSubject("Đơn hàng của bạn đã được xác nhận");
        mimeMessageHelper.setFrom("noreply@C12Pharmacy.com");
        emailSender.send(message);
    }
}
