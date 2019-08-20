package com.cristhian.com.strattegypattern;

public class SinglePrice {

    private static SinglePrice singlePrice = new SinglePrice();

    private  float price;

    private SinglePrice(){

    }

    public static SinglePrice getInstance(){
        return singlePrice;
    }

    protected  float getPrice(){
        return price;
    }

    protected void setPrice(float f){
        price = f;
    }
}
