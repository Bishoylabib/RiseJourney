package com.fawry.ecommerce.services;

import com.fawry.ecommerce.Cart;
import com.fawry.ecommerce.Customer;
import com.fawry.ecommerce.models.Product;
import com.fawry.ecommerce.utils.InputValidator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        // Validate cart not empty
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty. Please add items to checkout.");
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
        ShippingService.shipItems();

        // 4. Check customer balance
        // 5. Deduct balance
        // 6. Print receipt
        // 7. Send shippable items to ShippingService
    }
}
