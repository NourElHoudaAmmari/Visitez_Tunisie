package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllCategories extends AppCompatActivity {
ImageView BackBtn;
Button exp1,exp2,exp3,exp4,exp5,exp6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        BackBtn=findViewById(R.id.back_pressed);
       exp1=findViewById(R.id.exp1);
        exp2=findViewById(R.id.exp2);
     exp3=findViewById(R.id.exp3);
        exp4=findViewById(R.id.exp4);
        exp5=findViewById(R.id.exp5);
   exp6=findViewById(R.id.exp6);
        overridePendingTransition(R.anim.anim_from_right,R.anim.anim_from_right);
        exp1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),CultureActivity.class)));
       exp2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),ActivitesActivity.class)));
       exp3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),RestaurantActivity.class)));
       exp4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),HotelActivity.class)));
       exp5.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),BeachActivity.class)));
       exp6.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),EventActivity.class)));
        BackBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),MainActivity.class)));
    }
}