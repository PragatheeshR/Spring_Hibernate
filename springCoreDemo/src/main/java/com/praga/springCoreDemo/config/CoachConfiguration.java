package com.praga.springCoreDemo.config;

import com.praga.springCoreDemo.implemets.SwimCoach;
import com.praga.springCoreDemo.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfiguration {

    @Bean("swim")  //if needed id can be used here
    public Coach getSwimCoach(){
        return new SwimCoach();
    }
}
