package com.example.visitez_tunisie;

public class MostViewedHelperClass {
    int imageView;
    String textView,descripation;

    public MostViewedHelperClass(int imageView, String textView, String descripation) {
        this.imageView = imageView;
        this.textView = textView;
        this.descripation = descripation;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTextView() {
        return textView;
    }

    public String getDescripation() {
        return descripation;
    }
}
