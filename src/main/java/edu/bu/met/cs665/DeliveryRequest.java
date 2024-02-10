package edu.bu.met.cs665;

import edu.bu.met.cs665.Product.ProductData;

public class DeliveryRequest {
    private String name;
    private String address;
    private ProductData productData;

    public DeliveryRequest(String name, String address, ProductData productData) {
        this.name = name;
        this.address = address;
        this.productData = productData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }
}
