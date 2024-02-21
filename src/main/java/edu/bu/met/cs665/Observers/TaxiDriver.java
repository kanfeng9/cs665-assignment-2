package edu.bu.met.cs665.Observers;

import edu.bu.met.cs665.DeliveryRequest;
import edu.bu.met.cs665.ShopSystem.ShopObserver;

public class TaxiDriver implements ShopObserver {
    private final String name;
    private final int id;

    public TaxiDriver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void update(DeliveryRequest deliveryRequest) {
        System.out.printf("Taxi Driver %s (ID: %d) has been notified about a new delivery: %s, %s, Price: %.2f\n",
                name, id, deliveryRequest.getProductData().getName(), deliveryRequest.getAddress(),
                deliveryRequest.getProductData().getPrice());
    }
}
