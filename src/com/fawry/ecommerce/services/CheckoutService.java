package com.fawry.ecommerce.services;

import com.fawry.ecommerce.Cart;
import com.fawry.ecommerce.Customer;
import com.fawry.ecommerce.interfaces.Shippable;
import com.fawry.ecommerce.models.Product;
import com.fawry.ecommerce.utils.InputValidator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        // Validate cart not empty
        if (cart.isEmpty()) {
            System.err.println("Error: Cart is empty. Please add items to checkout.");
            return;
        }
        double subtotal = 0;
        double shippingFees = 0;
        Map<Product, Integer> items = cart.getItems();

        // Validate stock and expiry
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (!InputValidator.isQuantityAvailable(product, quantity)) {
                System.err.println("Error: Product " + product.getName() + " is out of stock.");
                return;
            }
            if (InputValidator.isExpired(product)) {
                System.err.println("Error: Product " + product.getName() + " is expired.");
                return;
            }
            subtotal += product.getPrice() * quantity;
        }
        // Calculate shipping fees
        Map<Shippable, Integer> shippableItems = cart.getShippableItems();
        if (!shippableItems.isEmpty()) {
            ShippingService.shipItems(shippableItems);
            shippingFees = 30;
        }
        else System.out.println("No items to ship.");

        double totalFees = subtotal + shippingFees;

        // Check customer balance
        if (!InputValidator.isBalanceSufficient(customer, totalFees)) {
            System.err.println("Error: Insufficient balance. Please add funds to your account.");
            return;
        }

        // Deduct balance and stock
        customer.debit(totalFees);
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.decreaseQuantity(quantity);
        }

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.getPrice() * quantity;
            System.out.printf("%dx %s %.0f%n", quantity, product.getName(), itemTotal);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f%n", subtotal);
        System.out.printf("Shipping\t%.0f%n", shippingFees);
        System.out.printf("Amount\t\t%.0f%n", totalFees);
        // Print customer balance after reduction - extra
        System.out.println("----------------------");
        System.out.printf("Balance\t\t%.0f%n", customer.getBalance());
    }
}
