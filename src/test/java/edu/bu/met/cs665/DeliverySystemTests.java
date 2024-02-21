package edu.bu.met.cs665;

import edu.bu.met.cs665.Observers.TaxiDriver;
import edu.bu.met.cs665.Observers.VanDriver;
import edu.bu.met.cs665.Product.ProductData;
import edu.bu.met.cs665.ShopSystem.ShopCentralSystem;
import edu.bu.met.cs665.ShopSystem.ShopObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class DeliverySystemTests {

    private ShopCentralSystem shopCentralSystem;
    private DeliveryRequest deliveryRequest;
    private List<ShopObserver> drivers;

    @Before
    public void setUp() {
        shopCentralSystem = new ShopCentralSystem(new ArrayList<>());
        ProductData productData = new ProductData("Gadget", 299.99);
        deliveryRequest = new DeliveryRequest("Jane Doe", "456 Elm St", productData);

        // Creating and registering 5 driver objects (mocked for simplicity)
        drivers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ShopObserver driver = i % 2 == 0 ? mock(TaxiDriver.class) : mock(VanDriver.class);
            drivers.add(driver);
            shopCentralSystem.registerObserver(driver);
        }
    }

    @Test
    public void testNotifyAllDrivers() {
        // Assuming ShopCentralSystem has a method to add a delivery request directly
        shopCentralSystem.getDeliveryRequests().add(deliveryRequest);

        // Notify all drivers of the new delivery request
        shopCentralSystem.notifyObservers();

        // Verify that each driver received the notification
        drivers.forEach(driver ->
                verify(driver).update(deliveryRequest)
        );
    }

    @Test
    public void testObserversRegistrationAndNotification() {
        // Verify all 5 drivers are registered
        assertEquals("Five drivers should be registered", 5, drivers.size());

        // Add a delivery request and notify observers
        shopCentralSystem.getDeliveryRequests().add(deliveryRequest);
        shopCentralSystem.notifyObservers();

        // Verify each driver received exactly one update call
        drivers.forEach(driver -> verify(driver, times(1)).update(deliveryRequest));
    }
}
