package com.example.SECURITY.AUTHENTICATION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class Securityconfig  {
    @Bean
    UserDetailsManager UserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);


//    @Bean
//
//    //adding users
//    InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails sasank = User.builder()
//                .username("sasank")
//                .password("{noop}sasi")
//                .roles("admin")
//                .build();
//
//
//        UserDetails lohith = User.builder()
//                .username("lohith")
//                .password("{noop}lohith")
//                .roles("employee","manager")
//                .build();
//
//        UserDetails avinash = User.builder()
//                .username("avinash")
//                .password("{noop}avinash")
//                .roles("employee")
//                .build();
//
//        return new InMemoryUserDetailsManager(sasank,lohith,avinash);


    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/get/employees").hasAnyRole("employee","admin")
                .requestMatchers(HttpMethod.GET,"api/employees/**").hasAnyRole("employee","admin")
                .requestMatchers(HttpMethod.POST,"/api/employees/").hasRole("manager")
                .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("manager")
                .requestMatchers(HttpMethod.DELETE,"/api/employees").hasRole("admin")

        );
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
