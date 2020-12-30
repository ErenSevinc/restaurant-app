package com.security;

import com.auth.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(authenticationProvider());
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("h2-console/**").permitAll();
        http.authorizeRequests().antMatchers("users/login").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

//        http.authorizeRequests().antMatchers("/hi/user").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/hi/admin").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/user/list/**").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ADMIN')");
//
//       //+
//        http.authorizeRequests().antMatchers("/product/backoffice/list/").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/product/backoffice/list/{id}").access("hasAnyRole('USER','ADMIN')");
//        //+
//        http.authorizeRequests().antMatchers("/product/backoffice/add").access("hasRole('ADMIN')");
//        //+
//        http.authorizeRequests().antMatchers("/product/backoffice/update/**").access("hasRole('ADMIN')");
//        //+
//        http.authorizeRequests().antMatchers("/product/backoffice/delete/**").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/product/backoffice/list/category/**").access("hasRole('USER')");
//        http.authorizeRequests().antMatchers("/product/backoffice/category").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/product/basket").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/product/basket/list").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/auth/listall").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/auth/add").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/auth/delete/**").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/auth/update").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/users/listall/**").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/users/listall").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/users/add").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/users/delete/**").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/users/update").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/category/listAll/**").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/category/listAll").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/category/addCategory").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/category/updateCategory/**").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/category/deleteCategory/**").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/category/listProduct").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/category/listProductByCategory/**").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/category/addProductByCategory/**").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/category/deleteProduct/**").access("hasRole('ADMIN')");
//       http.authorizeRequests().antMatchers("/category/updateCategory/**").access("hasRole('ADMIN')");
//
//        http.authorizeRequests().antMatchers("/categoryTable/list/**").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/categoryTable/add").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/categoryTable/update/**").access("hasRole('ADMIN')");
//        http.authorizeRequests().antMatchers("/categoryTable/delete/**").access("hasRole('ADMIN')");

          http.authorizeRequests().antMatchers("/users/list").access("hasAnyRole('ADMIN','USER')");
//          http.authorizeRequests().antMatchers("/users/add").access("hasRole('ADMIN')");
          http.authorizeRequests().antMatchers("/users/update").access("hasRole('ADMIN')");
          http.authorizeRequests().antMatchers("/users/list-roles").access("hasRole('ADMIN')");
          http.authorizeRequests().antMatchers("/users/delete/**").access("hasRole('ADMIN')");
//          http.authorizeRequests().antMatchers("/users/login").access("hasRole('ADMIN')");
//            http.authorizeRequests().antMatchers("/file/list").access("hasRole('ADMIN')");
//            http.authorizeRequests().antMatchers("/file/add").access("hasRole('ADMIN')");
            http.authorizeRequests().antMatchers("/base/add-categories").access("hasRole('ADMIN')");
            http.authorizeRequests().antMatchers("/base/add-products").access("hasRole('ADMIN')");
        http.httpBasic();
        http.cors();
    }

}
