package com.cristhian.com.strattegypattern;

public class Payment {

    private Strategy strategy;

    public Payment(Strategy strategy){
        this.strategy = strategy;
    }

    public String employStrategy(float f){
        return this.strategy.processPayment(f);
    }
}
