package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.dto.cart.MailModel;
import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.entity.user.Provider;
import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.user.IRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUserRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUsersRepository;
import com.c1221g1.pharmacy.service.user.IUsersService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UsersService implements IUsersService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUsersRepository iUsersRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function format Date, and save data for customer when sign up
     */
    @Override
    public void saveUsers(SignUpRequest signUpRequest) {
        Users users = new Users(signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()));
        users.setFlag(false);
        String tokenVerifier = RandomString.make(64);
        users.setActiveToken(tokenVerifier);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(2);
        customerType.setCustomerTypeName("Khách lẻ");
        Customer customer = new Customer();
        customer.setCustomerName(signUpRequest.getName());
        customer.setCustomerBirthday(signUpRequest.getDayOfBirth());
        customer.setCustomerAddress(signUpRequest.getAddress());
        customer.setCustomerNote(signUpRequest.getNote());
        customer.setCustomerPhone(signUpRequest.getPhone());
        customer.setCustomerGender(signUpRequest.getGender());
        customer.setCustomerUsername(users);
        customer.setCustomerType(customerType);
        customer.setFlag(true);
        Roles roles = this.iRoleRepository.findRolesByRoleName("ROLE_USER");
        UserRole userRole = new UserRole(users, roles);
        this.iUsersRepository.save(users);
        try {
            sendingVerificationToken(users);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
        this.iUserRoleRepository.save(userRole);
        this.iCustomerRepository.save(customer);
    }

    public void sendingVerificationToken(Users users) throws MessagingException, IOException, TemplateException {
        MailModel mailModel = new MailModel();

        Map<String, String> model = new HashMap<>();
        model.put("name", users.getUsername());
        model.put("token",users.getActiveToken());
        model.put("location", "Đội ngũ C1221G1");
        model.put("signature", "Pharmacode Group");
        /**
         * Add below line if you need to create a token to verification emails and uncomment line:32 in "email.ftl"
         * model.put("token",UUID.randomUUID().toString());
         */

        mailModel.setModel(model);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/static/logo.jpg"));

        Template template = emailConfig.getTemplate("verification.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailModel.getModel());

        mimeMessageHelper.setTo(users.getUsername());
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setSubject("Xác thực tài khoản đăng kí với Pharmacode");
        mimeMessageHelper.setFrom("noreply@C12Pharmacy.com");
        emailSender.send(message);

    }

    @Override
    public void saveUser(Users users) {
        this.iUsersRepository.save(users);
    }


    @Override
    public List<Users> checkEmail(String email) {
        return this.iUsersRepository.checkEmail(email);
    }

    @Override
    public Users findUserByToken(String token) {
        return this.iUsersRepository.findUserByToken(token);
    }
}
