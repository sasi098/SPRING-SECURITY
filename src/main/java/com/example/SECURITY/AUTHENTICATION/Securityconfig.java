package com.example.SECURITY.AUTHENTICATION;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class Securityconfig  {
    @Bean

    //adding users
    InMemoryUserDetailsManager userDetailsManager(){
        UserDetails sasank = User.builder()
                .username("sasank")
                .password("{noop}sasi")
                .roles("admin")
                .build();


        UserDetails lohith = User.builder()
                .username("lohith")
                .password("{noop}lohith")
                .roles("employee,manager")
                .build();

        UserDetails avinash = User.builder()
                .username("avinash")
                .password("{noop}avinash")
                .roles("employee")
                .build();

        return new InMemoryUserDetailsManager(sasank,lohith,avinash);


    }
}
