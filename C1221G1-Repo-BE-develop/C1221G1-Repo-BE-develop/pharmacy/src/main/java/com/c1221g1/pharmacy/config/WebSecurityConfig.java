package com.c1221g1.pharmacy.config;

import com.c1221g1.pharmacy.service.user.impl.UsersDetailsService;
import com.c1221g1.pharmacy.utils.AuthEntryPointJwt;
import com.c1221g1.pharmacy.utils.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsersDetailsService usersDetailService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    public AuthTokenFilter authTokenFilter;

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function : this method use to encode password
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function Create Bean AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Override method configure to config
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * @Author HuuNQ
         * @Time 17:00:00 04/07/2022
         * @Function Config role to access api url
         */
        http.cors().and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/manager-security/users/sign-in"

                        , "/api/manager-security/users/sign-up",
                        "/api/manager-security/users/verify/**",
                        "/api/carts/saveCart",
                        "/api/manager-online**",
                        "/api/carts/customer/**",
                        "/api/carts/**",
                        "/api/manager-security/users/sign-in-facebook"
                        ,"/api/manager-medicine/**"
                )
                .permitAll()
                .antMatchers("/api/manager-prescription/**"
                        , "/api/manager-sale/invoiceMedicines/getMedicines"
                        , "/api/manager-report/report/**"
                        ,"/api/manager-sale/invoices**" // Đã check
                        ,"/api/manager-customer/customers/**" // ĐÃ check
                        ,"/api/manager-customer/customerTypes"
                        ,"/api/manager-position/positions",
                        "/api/manager-employee/employees/list"
                )
                .hasAnyRole("EMPLOYEE", "MANAGER")
                .antMatchers(
                        "/api/manager-account/account/listAccount",
                        "/api/manager-account/account/**"
                        , "/api/manager-employee/employees/**"
                        )
                .hasRole("MANAGER")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(computeDurationInMilliseconds()).and().logout().logoutSuccessUrl("/");

        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    public int computeDurationInMilliseconds() {
        return (60 * 60 * 60);
    }

    private PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}