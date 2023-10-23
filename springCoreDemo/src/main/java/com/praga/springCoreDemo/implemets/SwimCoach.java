package com.praga.springCoreDemo.implemets;

import com.praga.springCoreDemo.interfaces.Coach;

public class SwimCoach implements Coach {
    @Override
    public String getWorkOut() {
        return "Swim for 1 hr today";
    }
}
