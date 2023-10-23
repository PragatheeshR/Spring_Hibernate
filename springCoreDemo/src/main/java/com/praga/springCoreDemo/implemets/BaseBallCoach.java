package com.praga.springCoreDemo.implemets;

import com.praga.springCoreDemo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

    BaseBallCoach(){
        System.out.println("Currrently in" +this.getClass().getSimpleName());
    }
    @Override
    public String getWorkOut() {
        return "Do BaseBall run for 10 mins";
    }
}
