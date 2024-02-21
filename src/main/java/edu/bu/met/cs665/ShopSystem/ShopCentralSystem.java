package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ShopCentralSystem implements ShopSubject {
    private final List<DeliveryRequest> deliveryRequests = new ArrayList<>();
    private final List<ShopObserver> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(ShopCentralSystem.class);

    public ShopCentralSystem(List<DeliveryRequest> initialDeliveryRequests) {
        if (initialDeliveryRequests != null && !initialDeliveryRequests.isEmpty()) {
            this.deliveryRequests.addAll(initialDeliveryRequests);
        } else {
            logger.warn("Starting with an empty list of delivery requests.");
        }
    }

    @Override
    public void registerObserver(ShopObserver o) {
        if (o != null) {
            observers.add(o);
            logger.info("Observer registered: " + o.getClass().getSimpleName());
        }
    }

    @Override
    public boolean removeObserver(ShopObserver o) {
        if (o != null && observers.contains(o)) {
            observers.remove(o);
            logger.info("Observer removed: " + o.getClass().getSimpleName());
            return true;
        } else {
            logger.warn("Attempt to remove an observer that is not registered.");
            return false;
        }
    }

    @Override
    public void notifyObservers() {
        if (!deliveryRequests.isEmpty()) {
            deliveryRequests.forEach(request -> observers.forEach(observer -> observer.update(request)));
            logger.info("All observers have been notified.");
        } else {
            logger.warn("No delivery requests to notify observers about.");
        }
    }

    // Method to access the list of delivery requests
    public List<DeliveryRequest> getDeliveryRequests() {
        return deliveryRequests;
    }

    // Method to add a delivery request to the list
    public void addDeliveryRequest(DeliveryRequest request) {
        if (request != null) {
            deliveryRequests.add(request);
            logger.info("Delivery request added: " + request.getProductData().getName());
        }
    }

    // Method to access the list of observers
    // Note: This method should be used cautiously, primarily for testing purposes
    public List<ShopObserver> getObservers() {
        return observers;
    }
}
