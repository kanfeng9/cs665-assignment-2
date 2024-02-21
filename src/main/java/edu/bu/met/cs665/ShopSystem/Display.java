/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: Display.java
 * Description: This interface defines the display functionality for elements within the delivery notification system.
 * Implementing classes are required to provide their own display method, which is used to output relevant information to the console or other display mediums.
 */

package edu.bu.met.cs665.ShopSystem;

public interface Display {

    /**
     * Displays information about the implementing object. This method is intended to output relevant data in a
     * human-readable format, facilitating debugging, logging, or user interaction scenarios.
     */
    void display();
}
