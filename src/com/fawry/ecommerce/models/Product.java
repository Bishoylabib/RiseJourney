package com.fawry.ecommerce.models;

public class Product {
    private final String name;
    private final double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }


}
