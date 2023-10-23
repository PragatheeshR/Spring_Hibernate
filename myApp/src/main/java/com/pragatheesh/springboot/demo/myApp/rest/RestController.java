package com.pragatheesh.springboot.demo.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${company.name}")
    private String companyName;

    @Value("${company.state}")
    private String state;



    // expose '/' endpoint to return hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    //exposing new endpoint

    @GetMapping("/praga")
    public String sayPraga(){
        return "Hi Praga";
    }


    @GetMapping("/company")
    public String getCompanyInfo(){
        return companyName+", "+state;
    }

}
