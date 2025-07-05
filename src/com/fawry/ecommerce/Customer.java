package com.fawry.ecommerce;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName(){
        return this.name;
    }

    public double getBalance(){
        return this.balance;
    }

    public void debit(double amount){
        this.balance -= amount;
    }

    public void credit(double amount){
        this.balance += amount;
    }
}
