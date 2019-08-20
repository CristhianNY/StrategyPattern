package com.cristhian.com.strattegypattern;

public class Cupon implements  Strategy{

    @Override
    public String processPayment(float price) {
        return String.format("%.2f",price*0.9f);
    }
}
