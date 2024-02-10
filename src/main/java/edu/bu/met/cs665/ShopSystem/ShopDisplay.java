package edu.bu.met.cs665.ShopSystem;


public class ShopDisplay implements ShopObserver, Display {
    protected String name;
    protected double price;

    @Override
    public void update(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.printf("Product Name: %s\n" +
                "Product Price: %s\n", name, price);
    }

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
