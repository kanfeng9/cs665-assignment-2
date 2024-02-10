package edu.bu.met.cs665.ShopSystem;

public interface ShopSubject {

    public void registerObserver(ShopObserver o);

    public boolean removeObserver(ShopObserver o);

    public void notifyObservers();

}
