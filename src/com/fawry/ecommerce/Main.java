package com.fawry.ecommerce;

import com.fawry.ecommerce.models.Cheese;
import com.fawry.ecommerce.models.ScratchCard;
import com.fawry.ecommerce.models.TV;
import com.fawry.ecommerce.services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cheese cheese = new Cheese("Cheddar", 100, 200, LocalDate.of(2026, 1, 1),400);
        TV tv = new TV("Samsung TV", 5000, 1000, 1500);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 50, 20);

        Customer customer = new Customer("Bishoy", 10000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(scratchCard, 2);

        CheckoutService.checkout(customer, cart);
    }
}