package com.praga.springCoreDemo.implemets;

import com.praga.springCoreDemo.interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // this is used when u have many implementation of an interface, letting spring knows which one is primary and to be considered
public class HockeyCoach implements Coach {

    HockeyCoach(){
        System.out.println("Currrently in" +this.getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Create a tempo for mid field run";
    }
}
