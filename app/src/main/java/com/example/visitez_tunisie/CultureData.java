package com.example.visitez_tunisie;

public class CultureData {

    private String itemName;
    private String itemDescription;
    private String Key_id;
    private String favStatus;
    private int itemImage;
public CultureData(){
}
    public CultureData(String itemName, String itemDescription, String key_id, String favStatus, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        Key_id = key_id;
        this.favStatus = favStatus;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getKey_id() {
        return Key_id;
    }

    public void setKey_id(String key_id) {
        Key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

}
