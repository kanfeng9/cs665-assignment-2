/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: ShopDisplay.java
 * Description: The ShopDisplay class implements the ShopObserver and Display interfaces,
 * serving as an observer that reacts to updates in delivery requests. It showcases
 * the Observer pattern by updating its state based on the delivery request details
 * and displays the updated product information.
 */

package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;

public class ShopDisplay implements ShopObserver, Display {
    protected String name;
    protected double price;

    /**
     * Updates the display based on a delivery request.
     * This method captures the essence of the Observer pattern, where ShopDisplay
     * reacts to changes in the subject it observes, in this case, a delivery request.
     *
     * @param deliveryRequest The delivery request containing the product data to display.
     */
    @Override
    public void update(DeliveryRequest deliveryRequest) {
        // Assuming ProductData is a part of DeliveryRequest and has getName() and getPrice() methods
        this.name = deliveryRequest.getProductData().getName();
        this.price = deliveryRequest.getProductData().getPrice();
    }

    /**
     * Displays the product information.
     * This method is an implementation of the Display interface, showcasing the product name and price.
     */
    @Override
    public void display() {
        System.out.printf("Product Name: %s\nProduct Price: %.2f\n", name, price);
    }

    // Getters and setters

    /**
     * Returns the product name.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product price.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price The new price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
