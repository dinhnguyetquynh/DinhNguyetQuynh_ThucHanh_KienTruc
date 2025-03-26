package org.example;

public class Product implements Item{

    private String name;
    private double price;
    public Product(){}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double totalPrice() {
        return this.price;
    }
}
