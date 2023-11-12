package com.praga.springdemo.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getInfo() {
        try {
           // Thread.currentThread().wait(8000);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Today will be a good day";
    }

    @Override
    public String getInfo(boolean b) {
        if(b){
            throw new RuntimeException("BIG Accident");
        }

        return "All good";
    }
}
