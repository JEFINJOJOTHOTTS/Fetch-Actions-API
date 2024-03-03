package com.shopalyst.models;

//@Data
public class Activity {

    private String customerId;
    private String timestamp;
    private String action;
    private String productId;
    private int count;

    public Activity(String customerId, String timestamp, String action, String productId, int count) {
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.action = action;
        this.productId = productId;
        this.count = count;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
