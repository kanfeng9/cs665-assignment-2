package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;

public class ShopDisplay implements ShopObserver, Display {
    protected String name;
    protected double price;

    @Override
    public void update(DeliveryRequest deliveryRequest) {
        // Assuming ProductData is a part of DeliveryRequest and has getName() and getPrice() methods
        this.name = deliveryRequest.getProductData().getName();
        this.price = deliveryRequest.getProductData().getPrice();
        // Optionally, call display() here or elsewhere to show updated info
    }

    @Override
    public void display() {
        System.out.printf("Product Name: %s\n" +
                "Product Price: %.2f\n", name, price);
    }

    // Getters and setters for name and price
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
