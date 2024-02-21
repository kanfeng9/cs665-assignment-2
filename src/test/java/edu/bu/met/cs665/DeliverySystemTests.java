/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: DeliverySystemTests.java
 * Description: This class provides a suite of unit tests for the delivery notification system, specifically testing the functionality of the ShopCentralSystem.
 * It tests the system's ability to register observers, notify them of new delivery requests, and ensure that the notification content is accurate.
 * Mock objects are utilized to simulate the behavior of real observers in the system.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.Observers.TaxiDriver;
import edu.bu.met.cs665.Product.ProductData;
import edu.bu.met.cs665.ShopSystem.ShopCentralSystem;
import edu.bu.met.cs665.ShopSystem.ShopObserver;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeliverySystemTests {

    private ShopCentralSystem shopCentralSystem;
    private DeliveryRequest deliveryRequest;
    private ShopObserver mockDriver;

    /**
     * Sets up the testing environment before each test method. This includes initializing the ShopCentralSystem,
     * creating a mock delivery request, and registering a mock driver as an observer.
     */
    @Before
    public void setUp() {
        shopCentralSystem = new ShopCentralSystem(new ArrayList<>());
        ProductData productData = new ProductData("Gadget", 299.99);
        deliveryRequest = new DeliveryRequest("Jane Doe", "456 Elm St", productData);

        // Creating and registering a mock driver object
        mockDriver = mock(TaxiDriver.class);
        shopCentralSystem.registerObserver(mockDriver);
    }

    /**
     * Tests that all registered drivers are correctly notified of a new delivery request.
     */
    @Test
    public void testNotifyAllDrivers() {
        shopCentralSystem.addDeliveryRequest(deliveryRequest);
        shopCentralSystem.notifyObservers();
        verify(mockDriver).update(deliveryRequest);
    }

    /**
     * Tests the registration and subsequent removal of an observer from the ShopCentralSystem.
     */
    @Test
    public void testObserverRegistrationAndRemoval() {
        ShopObserver newDriver = mock(ShopObserver.class);
        shopCentralSystem.registerObserver(newDriver);
        assertTrue(shopCentralSystem.getObservers().contains(newDriver));

        shopCentralSystem.removeObserver(newDriver);
        assertFalse(shopCentralSystem.getObservers().contains(newDriver));
    }

    /**
     * Tests the addition of a new delivery request to the ShopCentralSystem.
     */
    @Test
    public void testAddDeliveryRequest() {
        DeliveryRequest newRequest = new DeliveryRequest("Jane Doe", "789 Oak St", new ProductData("Item X", 99.99));
        shopCentralSystem.addDeliveryRequest(newRequest);
        assertTrue(shopCentralSystem.getDeliveryRequests().contains(newRequest));
    }

    /**
     * Tests that a single notification is sent per delivery request to each observer.
     */
    @Test
    public void testSingleNotificationPerRequest() {
        shopCentralSystem.addDeliveryRequest(deliveryRequest);
        shopCentralSystem.notifyObservers();
        // Ensures the observer's update method is called exactly once
        verify(mockDriver, times(1)).update(deliveryRequest);
    }

    /**
     * Tests the content of the notification sent to observers to ensure it matches the delivery request details.
     */
    @Test
    public void testNotificationContent() {
        shopCentralSystem.addDeliveryRequest(deliveryRequest);
        shopCentralSystem.notifyObservers();
        verify(mockDriver).update(argThat(request ->
                "Gadget".equals(request.getProductData().getName()) &&
                        299.99 == request.getProductData().getPrice() &&
                        "456 Elm St".equals(request.getAddress())));
    }
}
