package com.praga.springCoreDemo.implemets;

import com.praga.springCoreDemo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    CricketCoach(){
        System.out.println("Currrently in" +this.getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "practice fast bowling for 15 mins";
    }
}
