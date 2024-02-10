package edu.bu.met.cs665;

import edu.bu.met.cs665.Observers.TaxiDriver;
import edu.bu.met.cs665.Observers.VanDriver;
import edu.bu.met.cs665.Product.ProductData;
import edu.bu.met.cs665.ShopSystem.ShopCentralSystem;
import edu.bu.met.cs665.ShopSystem.ShopDisplay;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
// import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    // This configuration is for setting up the log4j properties file.
    // It is better to set this using java program arguments.
    // PropertyConfigurator.configure("log4j.properties");

    // Let us create an object of the Main class.
    Main m = new Main();


    /*logger.trace("Trace Message!");
    logger.debug("Debug Message!");
    logger.info("Info Message!");
    logger.warn("Warn Message!");
    logger.error("Error Message!");
    logger.fatal("Fatal Message!");*/

    List<DeliveryRequest> deliveryRequests = new ArrayList<>();
    // Populating the list with 5 people wanting 5 different items
    for (int i = 0; i < 5; i++) {
      ProductData productData = new ProductData("Yeezy " + i, i * i);
      DeliveryRequest deliveryRequest = new DeliveryRequest(Integer.toString(i), Integer.toString(i), productData);
      deliveryRequests.add(deliveryRequest);
    }

    // Passing in the delivery requests to start the shop
    ShopCentralSystem shopCentralSystem = new ShopCentralSystem(deliveryRequests);

    // Creating 5 drivers to register to the shop
    ShopDisplay taxi1 = new TaxiDriver("Ranjit", 1);
    ShopDisplay taxi2 = new TaxiDriver("Amy", 2);
    ShopDisplay van1 = new VanDriver("Bob", 3);
    ShopDisplay van2 = new VanDriver("Sanika", 6);
    ShopDisplay taxi3 = new TaxiDriver("Ali", 4);

    // Registering the drivers to the shop
    shopCentralSystem.registerObserver(taxi1);
    shopCentralSystem.registerObserver(taxi2);
    shopCentralSystem.registerObserver(van1);
    shopCentralSystem.registerObserver(van2);
    shopCentralSystem.registerObserver(taxi3);

    shopCentralSystem.notifyObservers();
    shopCentralSystem.display();

    taxi1.display();
    van1.display();

  }


}
