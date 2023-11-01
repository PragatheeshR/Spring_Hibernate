package com.praga.springdemo.springmvcsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails megala = User.builder()
                .username("megala")
                .password("{noop}megala")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails praga = User.builder()
                .username("praga")
                .password("praga")
                .roles("EMPLOYEE")
                .build();

        UserDetails thani = User.builder()
                .username("thani")
                .password("thani")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(megala, thani, praga);
    }
}
