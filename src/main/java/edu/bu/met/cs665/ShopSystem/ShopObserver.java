/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: ShopObserver.java
 * Description: This interface defines the responsibilities of an observer in the delivery notification system.
 * Implementing classes are required to provide an implementation for the update method, allowing them to react
 * to changes in delivery requests. It is a key component in the Observer pattern, facilitating decoupled communication
 * between the shop (subject) and drivers (observers).
 */

package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;

public interface ShopObserver {
    /**
     * Updates the observer with a new delivery request. This method is called by the ShopCentralSystem
     * when a new delivery request is added, ensuring that all registered observers are notified of the change.
     *
     * @param deliveryRequest The delivery request that triggers the update.
     */
    void update(DeliveryRequest deliveryRequest);
}
