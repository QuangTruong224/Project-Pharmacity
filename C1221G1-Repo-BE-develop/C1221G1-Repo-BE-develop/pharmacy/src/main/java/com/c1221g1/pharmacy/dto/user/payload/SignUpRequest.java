package com.c1221g1.pharmacy.dto.user.payload;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by HuuNQ
 * Time 12:00 30/06/2022
 * Function: when user submit sign-up form, this class will use to take all field in sign-up form and send to url mapping method
 */
public class SignUpRequest implements Validator {

    private String name;
    @Email(message = "Không đúng định dạng email.")
    private String email;
    private String password;
    private String confirmPassword;
    private Integer gender;
    private String address;
    private String phone;
    private String dayOfBirth;
    private String note;

    public SignUpRequest() {
        //This use to create object no params
        //HuuNQ
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequest signUpRequest = (SignUpRequest) target;
        final String NAME = "name";
        final String EMAIL = "email";
        final String PASSWORD = "password";
//        if (signUpRequest.getName().length() > 50){
//            errors.rejectValue(NAME,"","Tên quá dài.");
//        }else if(signUpRequest.getName().length() < 5){
//            errors.rejectValue(NAME,"","Tên quá ngắn.");
//        }else
            if(!signUpRequest.getName().matches("^(\\s?[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỂưạảấầẩẫậắằẳẵặẹẻẽềểễỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]\\s?){5,50}$"))
        {
            errors.rejectValue(NAME,"","Tên không được các chứa kí tự đặc biệt và có độ dài từ 5-50 kí tự.");
        }

        if(signUpRequest.getEmail() == null){
            errors.rejectValue(EMAIL,"","Không được để trống.");
        }else if(signUpRequest.getEmail().length() > 70){
            errors.rejectValue(EMAIL,"","Vượt quá độ dài cho phép.");
        }else if(signUpRequest.getEmail().length() < 12){
            errors.rejectValue(EMAIL,"","Quá ngắn vui lòng nhập lại.");
        }

        if(signUpRequest.getPassword().contains(" ")){
            errors.rejectValue(PASSWORD,"","Có khoảng trống trong mật khẩu của bạn.");
        }else if(!signUpRequest.getPassword().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,50})")){
            errors.rejectValue(PASSWORD,"","Mật khẩu phải có ít nhất 1 chữ số,chữ thường,chữ hoa và kí tự đặc biệt.");
        }
//        else if(signUpRequest.getPassword().length()>50){
//            errors.rejectValue(PASSWORD,"","Mật khẩu vượt quá độ dài cho phép.");
//        }else if(signUpRequest.getPassword().length()<6){
//            errors.rejectValue(PASSWORD,"","Mật khẩu quá ngắn.");
//        }


        if(!signUpRequest.getPhone().matches("((09)|(08)|(07))\\d{8}")){
            errors.rejectValue("phone","phone.invalid.pattern","Số điện thoại phải bắt đầu bằng 09 08 hoặc 07 .");
        }

        LocalDate localDate = LocalDate.now();
        int age = Period.between(LocalDate.parse(signUpRequest.getDayOfBirth()),localDate).getYears();
        if(!signUpRequest.getDayOfBirth().matches("((19)(\\d){2}|(20)(([01]\\d)|[2][0-2]))-([0]\\d|[1][0-2])-([012]\\d|[3][0-1])$")){
            errors.rejectValue("dayOfBirth","","Sai định dạng ngày/tháng/năm.");
        }else if( age < 18){
            errors.rejectValue("dayOfBirth","","Quý khách chưa đủ 18 tuổi.");
        }

        if(!signUpRequest.getConfirmPassword().equals(signUpRequest.getPassword())){
            errors.rejectValue("confirmPassword","confirmPassword.invalid","Xác nhận mật khẩu chưa chính xác.");
        }
    }
}
