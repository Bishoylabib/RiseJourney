package com.fawry.ecommerce;

import com.fawry.ecommerce.interfaces.Shippable;
import com.fawry.ecommerce.models.Product;
import com.fawry.ecommerce.utils.InputValidator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final LinkedHashMap<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity){
        if (InputValidator.isQuantityValid(quantity)){
            if(items.containsKey(product)){
                int totalQty = items.get(product) + quantity;
                if (InputValidator.isQuantityAvailable(product,totalQty)){
                    items.put(product, totalQty);
                }
            }
            else if (InputValidator.isQuantityAvailable(product,quantity)){
                    items.put(product, quantity);
            }
        }
    }

    public void remove(Product product, int quantity){
        if (InputValidator.isQuantityValid(quantity)) {
            if (items.containsKey(product)) {
                int totalQty = items.get(product) - quantity;
                if (InputValidator.isQuantityValid(totalQty)) {
                    items.put(product, totalQty);
                } else {
                    items.remove(product);
                }
            }
        }
    }

    public LinkedHashMap<Shippable, Integer> getShippableItems() {
        LinkedHashMap<Shippable, Integer> shippableItems = new LinkedHashMap<>();

        for (Map.Entry<Product, Integer> entry : this.items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                shippableItems.put((Shippable) product, quantity);
            }
        }

        return shippableItems;
    }

    public Map<Product, Integer> getItems() {
        return new LinkedHashMap<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }



}
