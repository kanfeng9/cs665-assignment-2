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

  private static ShopCentralSystem initializeAndRegisterObservers(List<DeliveryRequest> deliveryRequests) {
    ShopCentralSystem shopCentralSystem = new ShopCentralSystem(deliveryRequests);

    // Create and register drivers directly as observers
    ShopObserver taxi1 = new TaxiDriver("Ranjit", 1);
    ShopObserver taxi2 = new TaxiDriver("Amy", 2);
    ShopObserver van1 = new VanDriver("Bob", 3);
    ShopObserver van2 = new VanDriver("Sanika", 6);
    ShopObserver taxi3 = new TaxiDriver("Ali", 4);

    shopCentralSystem.registerObserver(taxi1);
    shopCentralSystem.registerObserver(taxi2);
    shopCentralSystem.registerObserver(van1);
    shopCentralSystem.registerObserver(van2);
    shopCentralSystem.registerObserver(taxi3);

    return shopCentralSystem;
  }
}
