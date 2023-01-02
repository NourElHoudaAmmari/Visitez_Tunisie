package com.example.visitez_tunisie;

public class RestaurantData {
    private String itemName;
    private String itemDescription;
    private String itemNumber;
    private String itemLink;
    private int itemImage;

    public RestaurantData(String itemName, String itemDescription, String itemNumber, String itemLink, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemNumber = itemNumber;
        this.itemLink = itemLink;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getItemLink() {
        return itemLink;
    }

    public int getItemImage() {
        return itemImage;
    }
}
