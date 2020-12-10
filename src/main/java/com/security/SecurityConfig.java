package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("h2-console/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests().antMatchers("/hi/user").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/hi/admin").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/user/list/**").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ADMIN')");

       //+
        http.authorizeRequests().antMatchers("/product/backoffice/list/").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/product/backoffice/list/{id}").access("hasAnyRole('USER','ADMIN')");
        //+
        http.authorizeRequests().antMatchers("/product/backoffice/add").access("hasRole('ADMIN')");
        //+
        http.authorizeRequests().antMatchers("/product/backoffice/update/**").access("hasRole('ADMIN')");
        //+
        http.authorizeRequests().antMatchers("/product/backoffice/delete/**").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/product/backoffice/list/category/**").access("hasRole('USER')");
        http.authorizeRequests().antMatchers("/product/backoffice/category").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/product/basket").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/product/basket/list").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/auth/listall").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/auth/add").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/auth/delete/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/auth/update").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/users/listall/**").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/users/listall").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/users/add").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/users/delete/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/users/update").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/category/listAll/**").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/category/listAll").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/category/addCategory").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/category/updateCategory/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/category/deleteCategory/**").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/category/listProduct").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/category/listProductByCategory/**").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/category/addProductByCategory/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/category/deleteProduct/**").access("hasRole('ADMIN')");
       http.authorizeRequests().antMatchers("/category/updateCategory/**").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/categoryTable/list/**").access("hasAnyRole('USER','ADMIN')");
        http.authorizeRequests().antMatchers("/categoryTable/add").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/categoryTable/update/**").access("hasRole('ADMIN')");
        http.authorizeRequests().antMatchers("/categoryTable/delete/**").access("hasRole('ADMIN')");

        http.httpBasic();
        http.cors();
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource);
    }

}
