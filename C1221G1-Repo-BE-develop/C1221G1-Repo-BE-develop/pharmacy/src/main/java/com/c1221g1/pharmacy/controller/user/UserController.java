package com.c1221g1.pharmacy.controller.user;

import com.c1221g1.pharmacy.dto.user.payload.*;
import com.c1221g1.pharmacy.entity.user.Provider;
import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.service.user.IRoleService;
import com.c1221g1.pharmacy.service.user.IUserRoleService;
import com.c1221g1.pharmacy.service.user.IUsersService;
import com.c1221g1.pharmacy.utils.JwtUtils;
import com.nimbusds.jose.crypto.PasswordBasedDecrypter;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-security/users")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsersService iUsersService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Created by HuuNQ
     * Time 16:00 30/06/2022
     * Function Sign-in Account Online and when success login server will return information with JWT
     */
    @PostMapping("/sign-in")
    public ResponseEntity<Object> getSignIn(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        new LoginRequest().validate(loginRequest, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (loginRequest.getUsername() != null) {
            List<Users> usersList = this.iUsersService.checkEmail(loginRequest.getUsername());
            if (usersList.isEmpty()) {
                errorMap.put("notExists", "Tài khoản chưa tồn tại trong hệ thống.");
            } else if (!usersList.get(0).isFlag()) {
                errorMap.put("isVerification", "Tài khoản chưa được xác thực.");
            }
        }
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(
                            err -> errorMap.put(err.getField(), err.getDefaultMessage())
                    );
        }
        if(!errorMap.isEmpty()){
            return ResponseEntity.badRequest().body(new ResponseMessage<>(false, "Failed", errorMap, new ArrayList<>()));
        }


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtKey(authentication);
        User user = (User) authentication.getPrincipal();
        List<String> role = user.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(
                jwt, loginRequest.getUsername(), loginRequest.getPassword(), role)
        );
    }

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function Sign Up Online And Validate Sign Up Form
     */
    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest, BindingResult bindingResult) {
        new SignUpRequest().validate(signUpRequest, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(
                            err -> errorMap.put(err.getField(), err.getDefaultMessage())
                    );
            return ResponseEntity.badRequest().body(new ResponseMessage<>(false, "Failed!", errorMap, new ArrayList<>()));
        }
        if (!this.iUsersService.checkEmail(signUpRequest.getEmail()).isEmpty()) {
            errorMap.put("email", "Email đã được sử dụng!");
            return ResponseEntity.badRequest().body(new ResponseMessage<>(false, "Failed!", errorMap, new ArrayList<>()));
        }
        try {
            this.iUsersService.saveUsers(signUpRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *
     * @Author HuuNQ
     * @Time 12:00:00 10/07/2022
     * @return facebookRequest
     */

    @PostMapping("/sign-in-facebook")
    public ResponseEntity<Users> signInWithFacebook(@RequestBody FacebookRequest facebookRequest) {
        List<Users> users = this.iUsersService.checkEmail(facebookRequest.getEmail());
        if (users.isEmpty()) {
            Users newUser = new Users();
            newUser.setUsername(facebookRequest.getEmail());
            newUser.setPassword(passwordEncoder.encode("Pharmacode@2022"));
            newUser.setProvider(Provider.FACEBOOK);
            newUser.setFlag(true);
            Roles roles = this.iRoleService.findRoleByName("ROLE_USER");
            if (roles == null) {
                roles = new Roles("ROLE_USER");
                this.iRoleService.saveRole(roles);
            }
            UserRole userRole = new UserRole();
            userRole.setUsers(newUser);
            userRole.setRoles(roles);
            this.iUsersService.saveUser(newUser);
            this.iUserRoleService.saveUserRole(userRole);
            return ResponseEntity.ok().body(newUser);
        } else {
            return ResponseEntity.ok().body(users.get(0));
        }
    }

    /**
     *
     * @Author HuuNQ
     * @Time 12:00:00 10/07/2022
     * @return this FUNCTION using to find users and set active account by sending token to customer email
     */

    @GetMapping("/verify/{token}/{username}")
    public ResponseEntity<Object> verifyUser(@PathVariable("username") String username,
                                             @PathVariable("token") String token) {
        Users users = this.iUsersService.findUserByToken(token);
        if (users.getUsername().equals(username) && !users.isFlag()) {
            users.setFlag(true);
            users.setActiveToken(null);
            this.iUsersService.saveUser(users);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
