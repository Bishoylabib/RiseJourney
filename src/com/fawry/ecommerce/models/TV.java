package com.fawry.ecommerce.models;

import com.fawry.ecommerce.interfaces.Shippable;

public class TV extends Product implements Shippable {
    private final int weight;

    public TV(String name, double price, int quantity, int weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
