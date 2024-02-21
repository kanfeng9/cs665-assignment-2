/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: ShopSubject.java
 * Description: This interface outlines the contract for a subject in the Observer pattern within the delivery
 * notification system. It defines methods for registering, removing, and notifying observers. Implementing this
 * interface allows a class to act as a central point of communication to various observers (e.g., drivers) about
 * changes or updates, such as new delivery requests.
 */

package edu.bu.met.cs665.ShopSystem;

public interface ShopSubject {
    /**
     * Registers an observer to the subject. Once registered, the observer will receive updates about
     * new delivery requests.
     *
     * @param o The observer to be registered.
     */
    void registerObserver(ShopObserver o);

    /**
     * Removes an observer from the subject. The observer will no longer receive updates about new delivery requests.
     *
     * @param o The observer to be removed.
     */
    void removeObserver(ShopObserver o);

    /**
     * Notifies all registered observers about a change or update, such as a new delivery request. This method
     * ensures that all observers are kept informed about relevant changes in the subject they are observing.
     */
    void notifyObservers();
}
