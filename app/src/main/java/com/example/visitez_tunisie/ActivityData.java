package com.example.visitez_tunisie;

public class ActivityData {
    private String itemName;
    private String itemDescription;
    private String itemNumber;
    private int itemImage;

    public ActivityData(String itemName, String itemDescription, String itemNumber, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemNumber = itemNumber;
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

    public int getItemImage() {
        return itemImage;
    }
}
