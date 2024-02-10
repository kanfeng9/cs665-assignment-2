package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShopCentralSystem implements ShopSubject {
    // The shop is started up with a list of delivery requests containing recipient, address, and product data
    private List<DeliveryRequest> deliveryRequests;
    // The list to register observers of our system. Drivers are notified within this list of new delivery requests
    private List<ShopObserver> shopObserverList;
    private static Logger logger = Logger.getLogger(ShopCentralSystem.class);

    /**
     *
     * @param deliveryRequests contains a list of deliveries required to start the central system
     */
    public ShopCentralSystem(List<DeliveryRequest> deliveryRequests) {
        shopObserverList = new ArrayList<>();
        if (deliveryRequests.size() == 0 || deliveryRequests == null) {
            logger.warn("Invalid input!");
            return;
        }
        this.deliveryRequests = deliveryRequests;
    }

    public List<DeliveryRequest> getDeliveryRequests() {
        return deliveryRequests;
    }

    public void setDeliveryData(List<DeliveryRequest> deliveryRequests) {
        this.deliveryRequests = deliveryRequests;
        notifyObservers();
    }

    /**
     *
     * @param o registers an observer to our notification system
     */
    @Override
    public void registerObserver(ShopObserver o) {
        shopObserverList.add(o);
        logger.info("Observer registered");
    }

    /**
     *
     * @param o removes an observer from out notification system
     * @return true if observer is removed, or false if observer isn't found
     */
    @Override
    public boolean removeObserver(ShopObserver o) {
        if (shopObserverList.contains(o)) {
            shopObserverList.remove(o);
            logger.info("Observer removed");
            return true;
        }
        logger.info("Observer not found!");
        return false;
    }

    /**
     * Broadcasts to the drivers the delivery requests
     */
    @Override
    public void notifyObservers() {
        for (ShopObserver observer : shopObserverList) {
            for (DeliveryRequest deliveryRequest : deliveryRequests) {
                observer.update(deliveryRequest.getProductData().getName(), deliveryRequest.getProductData().getPrice());
            }
        }
        logger.info("Drivers notified");
    }

    /**
     * Displays the list of names for delivery
     */
    public void display() {
        for (DeliveryRequest deliveryRequest : deliveryRequests) {
            System.out.printf("Name: %s\n" + "Address: %s\n", deliveryRequest.getName(), deliveryRequest.getAddress());
        }
    }
}
