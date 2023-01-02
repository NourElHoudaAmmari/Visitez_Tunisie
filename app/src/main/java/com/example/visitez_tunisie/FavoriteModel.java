package com.example.visitez_tunisie;

public class FavoriteModel {
    private int Image;
    private String Title;
    private String key_id;

    public FavoriteModel(int image, String title, String key_id) {
        Image = image;
        Title = title;
        this.key_id = key_id;
    }
    public FavoriteModel(){
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }
}
