package edu.bu.met.cs665.ShopSystem;

import edu.bu.met.cs665.DeliveryRequest;

public interface ShopObserver {
    void update(DeliveryRequest deliveryRequest);
}
