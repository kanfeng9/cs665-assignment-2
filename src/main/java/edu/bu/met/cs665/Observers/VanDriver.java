/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: VanDriver.java
 * Description: Represents a van driver in the delivery notification system. This class extends ShopDisplay,
 * allowing van drivers to not only be notified about new delivery requests but also to display delivery
 * and product information. Each van driver has a unique name and ID for identification and operational purposes.
 */

package edu.bu.met.cs665.Observers;

import edu.bu.met.cs665.ShopSystem.ShopDisplay;

public class VanDriver extends ShopDisplay {
    private String name;
    private int id;

    /**
     * Constructs a new VanDriver with a given name and ID.
     *
     * @param name The name of the van driver.
     * @param id The unique identifier for the van driver.
     */
    public VanDriver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Displays the delivery and product information specific to van drivers. This overridden method
     * provides additional context relevant to van drivers, such as their dispatch status.
     */
    @Override
    public void display() {
        System.out.printf("[Van Driver Dispatched]: %s | %s \n", getName(), getId());
        System.out.printf("Product: %s | %.2f \n", super.name, super.price);
    }

    // Getters and setters

    /**
     * Returns the name of the van driver.
     *
     * @return The name of the van driver.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the van driver.
     *
     * @param name The new name of the van driver.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the van driver.
     *
     * @return The ID of the van driver.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the van driver.
     *
     * @param id The new ID of the van driver.
     */
    public void setId(int id) {
        this.id = id;
    }
}
