package com.example.visitez_tunisie;

public class HotelData {
    private String itemName;
    private String itemDescription;
    private String itemNumber;
    private String itememail;
    private String itemPage;
    private int itemImage;

    public HotelData(String itemName, String itemDescription, String itemNumber, String itememail, String itemPage, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemNumber = itemNumber;
        this.itememail = itememail;
        this.itemPage = itemPage;
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

    public String getItememail() {
        return itememail;
    }

    public String getItemPage() {
        return itemPage;
    }

    public int getItemImage() {
        return itemImage;
    }
}
