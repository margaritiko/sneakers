package com.source.customer;

import com.common.annotations.BuilderProperty;

public class Customer {

    private int amountOfMoney;
    private String name;

    @BuilderProperty
    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @BuilderProperty
    public void setName(String name) {
        this.name = name;
    }

}
