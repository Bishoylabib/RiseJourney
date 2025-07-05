package com.fawry.ecommerce.services;

import com.fawry.ecommerce.interfaces.Shippable;


import java.util.Map;

public class ShippingService {
    public static void shipItems(Map<Shippable, Integer> ShippableItems) {

        System.out.println("** Shipment notice **");
        int totalWeight = 0;
        for (Map.Entry<Shippable, Integer> entry : ShippableItems.entrySet()){
            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            int itemWeight= item.getWeight(); // assume getWeight() returns grams as int
            int totalItemWeight = itemWeight * quantity;
            totalWeight += totalItemWeight;

            if (itemWeight < 1000) {
                System.out.printf("%dx %s %dg%n", quantity, item.getName(), itemWeight);
            } else {
                double weightKg = itemWeight / 1000.0;
                System.out.printf("%dx %s %.1fkg%n", quantity, item.getName(), weightKg);
            }
        }
        if (totalWeight < 1000) {
            System.out.printf("Total package weight %dg%n", totalWeight);
        } else {
            double totalWeightKg = totalWeight / 1000.0;
            System.out.printf("Total package weight %.1fkg%n%n", totalWeightKg);
        }
    }
}
