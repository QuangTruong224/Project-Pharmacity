package com.c1221g1.pharmacy.service.user;
import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;

import com.c1221g1.pharmacy.entity.user.Users;

import java.util.List;

public interface IUsersService {


    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     *
     */
    void saveUsers(SignUpRequest signUpRequest);

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     *
     */
    void saveUser(Users users);

    List<Users> checkEmail(String email);

    Users findUserByToken(String token);
}
