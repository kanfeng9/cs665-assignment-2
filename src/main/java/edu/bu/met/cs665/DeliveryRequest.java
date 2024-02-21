/**
 * Name: Zhiling Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/21/2024
 * File Name: DeliveryRequest.java
 * Description: Represents a delivery request in the delivery notification system.
 * This class encapsulates the details of a delivery request, including the recipient's name,
 * delivery address, and the product data associated with the delivery.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.Product.ProductData;

public class DeliveryRequest {
    private String name;
    private String address;
    private ProductData productData;

    /**
     * Constructs a new DeliveryRequest with specified name, address, and product data.
     *
     * @param name The name of the recipient.
     * @param address The delivery address.
     * @param productData The product data associated with this delivery request.
     */
    public DeliveryRequest(String name, String address, ProductData productData) {
        this.name = name;
        this.address = address;
        this.productData = productData;
    }

    /**
     * Gets the name of the recipient.
     *
     * @return The name of the recipient.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the recipient.
     *
     * @param name The new name of the recipient.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the delivery address.
     *
     * @return The delivery address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the delivery address.
     *
     * @param address The new delivery address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the product data associated with this delivery request.
     *
     * @return The product data.
     */
    public ProductData getProductData() {
        return productData;
    }

    /**
     * Sets the product data for this delivery request.
     *
     * @param productData The new product data.
     */
    public void setProductData(ProductData productData) {
        this.productData = productData;
    }
}
