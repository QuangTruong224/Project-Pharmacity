package com.c1221g1.pharmacy.dto.user.payload;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by HuuNQ
 * Time 12:00 30/06/2022
 * Function: use for login request when user submit sing in
 */
public class LoginRequest implements Validator {

    @Length(min = 5,message = "Tên tài khoản quá ngắn.")
    @Length(max = 50, message = "Tên tài khoản quá dài.")
    @Email(message = "Không đúng định dạng email.")
    @NotEmpty(message = "Vui lòng không bỏ trống.")
    private String username;
    @NotEmpty(message = "Vui lòng không bỏ trống.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequest loginRequest = (LoginRequest) target;
        final String PASSWORD = "password";
        final String USERNAME = "username";
        if(loginRequest.getUsername()==null){
            errors.rejectValue(USERNAME,"","Không được bỏ trống.");
        }

        if(loginRequest.getPassword().contains(" ")){
            errors.rejectValue(PASSWORD,"","Mật khẩu chứa kí tự trống.");
        }else if(loginRequest.getPassword().length()>50 || loginRequest.getPassword().length()<6){
            errors.rejectValue(PASSWORD,"","Độ dài mật khẩu phải từ 6 đến 50 kí tự.");
        }
//        else if(!loginRequest.getPassword().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,50})")){
//            errors.rejectValue(PASSWORD,"","Mật khẩu phải có ít nhất 1 chữ số,chữ thường,chữ hoa và kí tự đặc biệt.");
//        }
    }
}
