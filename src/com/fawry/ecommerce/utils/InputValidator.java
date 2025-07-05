package com.fawry.ecommerce.utils;

import com.fawry.ecommerce.Cart;
import com.fawry.ecommerce.Customer;
import com.fawry.ecommerce.interfaces.Expirable;
import com.fawry.ecommerce.models.Product;

import java.util.LinkedHashMap;

public class InputValidator {


    static public boolean isExpired(Product product){
        if (product instanceof Expirable) return ((Expirable) product).isExpired();
        return false;
    }

    static public boolean isQuantityAvailable(Product product, int quantityRequested){
        return product.getQuantity() >= quantityRequested;
    }
    // is ordered quantity greater than 0
    static public boolean isQuantityValid(int orderedQuantity){
        return orderedQuantity > 0;
    }

    static public boolean isBalanceSufficient(Customer customer, double totalAmount){
        return customer.getBalance() >= totalAmount;
    }

}
