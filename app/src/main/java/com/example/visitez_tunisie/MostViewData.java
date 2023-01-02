package com.example.visitez_tunisie;

public class MostViewData {
    private String textName;
    private String textDescription;
    private Integer textImage;

    public MostViewData(String textName, String textDescription, Integer textImage) {
        this.textName = textName;
        this.textDescription = textDescription;
        this.textImage = textImage;
    }

    public String getTextName() {
        return textName;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public Integer getTextImage() {
        return textImage;
    }
}
