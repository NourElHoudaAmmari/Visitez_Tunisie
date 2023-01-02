package com.example.visitez_tunisie;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;

public class CategoriesHelperClass {
 GradientDrawable gradient;
    int image;
    String titile;

    public CategoriesHelperClass(GradientDrawable gradient, int image, String titile) {
        this.gradient = gradient;
        this.image = image;
        this.titile = titile;
    }



    public Drawable getGradient() {
        return gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitile() {
        return titile;
    }
}
