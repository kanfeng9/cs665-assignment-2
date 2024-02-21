/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: ShopCentralSystem.java
 * Description: The ShopCentralSystem class acts as the central hub for managing delivery requests and observers (drivers) in the delivery notification system.
 * It implements the ShopSubject interface, supporting registration, removal, and notification of observers based on changes in delivery requests.
 * This class embodies the Observer pattern, ensuring a loose coupling between the shop and the drivers.
 */

package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ShopCentralSystem implements ShopSubject {
    private final List<DeliveryRequest> deliveryRequests = new ArrayList<>();
    private final List<ShopObserver> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(ShopCentralSystem.class);

    /**
     * Constructs a ShopCentralSystem with an initial list of delivery requests.
     *
     * @param initialDeliveryRequests The initial list of delivery requests to be managed by the system.
     */
    public ShopCentralSystem(List<DeliveryRequest> initialDeliveryRequests) {
        if (initialDeliveryRequests != null && !initialDeliveryRequests.isEmpty()) {
            this.deliveryRequests.addAll(initialDeliveryRequests);
        } else {
            logger.warn("Starting with an empty list of delivery requests.");
        }
    }

    /**
     * Registers an observer to be notified of changes in delivery requests.
     *
     * @param o The observer to register.
     */
    @Override
    public void registerObserver(ShopObserver o) {
        if (o != null) {
            observers.add(o);
            logger.info("Observer registered: " + o.getClass().getSimpleName());
        }
    }

    /**
     * Removes an observer from the notification list.
     *
     * @param o The observer to remove.
     */
    @Override
    public void removeObserver(ShopObserver o) {
        if (o != null && observers.contains(o)) {
            observers.remove(o);
            logger.info("Observer removed: " + o.getClass().getSimpleName());
        } else {
            logger.warn("Attempt to remove an observer that is not registered.");
        }
    }

    /**
     * Notifies all registered observers of the current delivery requests.
     */
    @Override
    public void notifyObservers() {
        if (!deliveryRequests.isEmpty()) {
            deliveryRequests.forEach(request -> observers.forEach(observer -> observer.update(request)));
            logger.info("All observers have been notified.");
        } else {
            logger.warn("No delivery requests to notify observers about.");
        }
    }

    /**
     * Provides access to the current list of delivery requests.
     *
     * @return The list of delivery requests.
     */
    public List<DeliveryRequest> getDeliveryRequests() {
        return deliveryRequests;
    }

    /**
     * Adds a new delivery request to the system.
     *
     * @param request The delivery request to add.
     */
    public void addDeliveryRequest(DeliveryRequest request) {
        if (request != null) {
            deliveryRequests.add(request);
            logger.info("Delivery request added: " + request.getProductData().getName());
        }
    }

    /**
     * Provides access to the list of registered observers.
     *
     * Note: This method should be used cautiously, primarily for testing purposes.
     *
     * @return The list of registered observers.
     */
    public List<ShopObserver> getObservers() {
        return observers;
    }
}
