package com.fawry.ecommerce.models;

import com.fawry.ecommerce.interfaces.*;

import java.time.LocalDate;

public class Cheese extends Product implements Shippable, Expirable {
    private final LocalDate expDate;
    private final int weight;

    public Cheese(String name, double price, int quantity, LocalDate expDate, int weight) {
        super(name, price, quantity);
        this.expDate = expDate;
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public LocalDate getExpDate() {
        return expDate;
    }
}
