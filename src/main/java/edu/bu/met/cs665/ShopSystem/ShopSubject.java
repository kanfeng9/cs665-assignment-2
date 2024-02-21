package edu.bu.met.cs665.ShopSystem;

public interface ShopSubject {
    void registerObserver(ShopObserver o);
    boolean removeObserver(ShopObserver o);
    void notifyObservers();
}
