package com.praga.springCoreDemo.controller;

import com.praga.springCoreDemo.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

   //@Autowired
    private Coach coach;

    @Autowired // CONSTRUCTOR INJECTION ------ if only one const is available then Autowired is not needed
    public RestController(@Qualifier("swim") Coach coach){ //@Qualifier is used to say which implementer to be considered - give class name there
        System.out.println("Currrently in" +this.getClass().getSimpleName());
        this.coach = coach;
    }

   /* @Autowired
    public void setCoach(Coach coach){
        this.coach = coach;
    }*/

    @GetMapping("/mywork")
    public String getDailyWrk(){
        return coach.getWorkOut();
    }
}
