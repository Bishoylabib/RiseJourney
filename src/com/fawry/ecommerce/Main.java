package com.fawry.ecommerce;

import com.fawry.ecommerce.models.Cheese;
import com.fawry.ecommerce.models.TV;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cheese cheese = new Cheese("Cheddar", 100, 200, LocalDate.of(2024, 1, 1),400);
        TV tv = new TV("Samsung TV", 5000, 1000, 1500);

        Customer customer = new Customer("Bishoy", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);
    }
}