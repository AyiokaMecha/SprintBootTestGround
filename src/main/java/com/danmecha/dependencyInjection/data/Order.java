package com.danmecha.dependencyInjection.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("cName")
    private String customerName;
    private String productName;
    private int quantity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order(String customerName, String productName, int quantity) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }




}
