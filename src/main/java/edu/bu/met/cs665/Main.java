/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: Main.java
 * Description: This class serves as the entry point for the delivery notification system application.
 * It demonstrates the initialization of the system with shops, drivers, and delivery requests.
 * It showcases the Observer pattern by registering drivers as observers to a shop's delivery requests and
 * notifying them when a new delivery request is added.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.Observers.TaxiDriver;
import edu.bu.met.cs665.Observers.VanDriver;
import edu.bu.met.cs665.Product.ProductData;
import edu.bu.met.cs665.ShopSystem.ShopCentralSystem;
import edu.bu.met.cs665.ShopSystem.ShopObserver;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final Logger logger = Logger.getLogger(Main.class);

  /**
   * The main method initializes the delivery notification system with a set of predefined delivery requests
   * and drivers. It then demonstrates the notification mechanism by notifying all registered drivers
   * of the delivery requests.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    List<DeliveryRequest> deliveryRequests = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      ProductData productData = new ProductData("Yeezy " + i, i * i);
      DeliveryRequest deliveryRequest = new DeliveryRequest(Integer.toString(i), "Address " + i, productData);
      deliveryRequests.add(deliveryRequest);
    }

    ShopCentralSystem shopCentralSystem = initializeAndRegisterObservers(deliveryRequests);

    // Notify observers with delivery requests
    shopCentralSystem.notifyObservers();
  }

  /**
   * Initializes the ShopCentralSystem with a list of delivery requests and registers a set of drivers as observers.
   * This method demonstrates the flexibility and decoupled nature of the Observer pattern in the application.
   *
   * @param deliveryRequests A list of DeliveryRequest objects to be added to the ShopCentralSystem.
   * @return An instance of ShopCentralSystem with registered observers (drivers).
   */
  private static ShopCentralSystem initializeAndRegisterObservers(List<DeliveryRequest> deliveryRequests) {
    ShopCentralSystem shopCentralSystem = new ShopCentralSystem(deliveryRequests);

    // Create and register drivers directly as observers
    ShopObserver taxi1 = new TaxiDriver("Ranjit", 1);
    ShopObserver taxi2 = new TaxiDriver("Amy", 2);
    ShopObserver van1 = new VanDriver("Bob", 3);
    ShopObserver van2 = new VanDriver("Sanka", 6);
    ShopObserver taxi3 = new TaxiDriver("Ali", 4);

    shopCentralSystem.registerObserver(taxi1);
    shopCentralSystem.registerObserver(taxi2);
    shopCentralSystem.registerObserver(van1);
    shopCentralSystem.registerObserver(van2);
    shopCentralSystem.registerObserver(taxi3);

    return shopCentralSystem;
  }
}
