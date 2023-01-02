package com.example.visitez_tunisie;

public class FavoriteData {
    private String itemName;
    private String itemDescription;
    private Integer itemImage;

    public FavoriteData(String itemName, String itemDescription, Integer itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Integer getItemImage() {
        return itemImage;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemImage(Integer itemImage) {
        this.itemImage = itemImage;
    }
}
