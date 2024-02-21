/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: TaxiDriver.java
 * Description: Represents a taxi driver in the delivery notification system. This class implements the ShopObserver interface,
 * allowing taxi drivers to be notified about new delivery requests. Each driver has a unique name and ID for identification.
 */

package edu.bu.met.cs665.Observers;

import edu.bu.met.cs665.DeliveryRequest;
import edu.bu.met.cs665.ShopSystem.ShopObserver;

public class TaxiDriver implements ShopObserver {
    private final String name;
    private final int id;

    /**
     * Constructs a new TaxiDriver with a given name and ID.
     *
     * @param name The name of the taxi driver.
     * @param id The unique identifier for the taxi driver.
     */
    public TaxiDriver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Notifies the taxi driver of a new delivery request. This method is called by the ShopCentralSystem
     * when a new delivery request is added. It prints out the delivery request details to the console.
     *
     * @param deliveryRequest The delivery request about which the driver is being notified.
     */
    @Override
    public void update(DeliveryRequest deliveryRequest) {
        System.out.printf("Taxi Driver %s (ID: %d) has been notified about a new delivery: %s, %s, Price: %.2f\n",
                name, id, deliveryRequest.getProductData().getName(), deliveryRequest.getAddress(),
                deliveryRequest.getProductData().getPrice());
    }
}
