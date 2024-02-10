package edu.bu.met.cs665.Observers;

import edu.bu.met.cs665.ShopSystem.ShopDisplay;

public class TaxiDriver extends ShopDisplay {
    private String name;
    private int id;

    public TaxiDriver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void display() {
        System.out.printf("[Taxi Driver Dispatched]: %s | %s \n", getName(), getId());
        System.out.printf("Product: %s | %s \n", super.name, super.price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
