package com.praga.calculator.Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public double addNumbers(double a1, double a2){
        return a1 + a2;
    }
}
