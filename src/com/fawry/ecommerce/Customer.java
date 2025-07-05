package com.fawry.ecommerce;

public class Customer {
    private final String name;
    private int balance;

    public Customer(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }

    public void debit(int amount){
        this.balance -= amount;
    }

    public void credit(int amount){
        this.balance += amount;
    }
}
