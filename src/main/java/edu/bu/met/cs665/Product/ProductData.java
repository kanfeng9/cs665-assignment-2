/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: ProductData.java
 * Description: Represents the data for a product involved in a delivery request within the delivery notification system.
 * This class encapsulates product information such as name and price, providing a structured way to manage and access
 * product details.
 */

package edu.bu.met.cs665.Product;

public class ProductData {
    private String name;
    private double price;

    /**
     * Constructs a new ProductData instance with specified name and price.
     *
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public ProductData(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The new price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
