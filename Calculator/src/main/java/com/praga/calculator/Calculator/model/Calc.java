package com.praga.calculator.Calculator.model;

public class Calc {

    private double firstVal;

    private double secVal;

    private double result;

    public Calc(){}

    public Calc(double firstVal, double secVal, double result) {
        this.firstVal = firstVal;
        this.secVal = secVal;
        this.result = result;
    }


    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getFirstVal() {
        return firstVal;
    }

    public void setFirstVal(double firstVal) {
        this.firstVal = firstVal;
    }

    public double getSecVal() {
        return secVal;
    }

    public void setSecVal(double secVal) {
        this.secVal = secVal;
    }
}
