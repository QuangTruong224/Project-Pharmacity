package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.dto.user.IUsersDto;
import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IUsersRepository extends JpaRepository<Users,String> {

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: use to check username and password when someone use login
     */
    @Query(value="SELECT username,password,flag FROM Users where username = :username and password = :password",nativeQuery=true)
    @Transactional
    @Modifying
    IUsersDto getUsersByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: use to check email exists in table users
     */
    @Query(value="select * from users u where exists (select * from users where u.username = :email)",nativeQuery=true)
    List<Users> checkEmail(@Param("email") String email);

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: use to save users
     */
    @Query(value="insert into users(username,password,flag) values (:username,:password,:flag)", nativeQuery=true)
    @Transactional
    @Modifying
    void saveUser(@Param("username") String username, @Param("password") String password, @Param("flag") boolean flag);
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: use to get User by username
     */
    @Query( value = "SELECT * FROM users u WHERE u.username = :username",nativeQuery=true)
    Users getUserByUsername(@Param("username") String username);


    @Query(value="SELECT * FROM users where active_token = :token",nativeQuery=true)
    Users findUserByToken(@Param("token") String token);
}
