package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantDetails extends AppCompatActivity {
    TextView resDescription,searchtextmap3,restPhone, txtpage;
    ImageView restImage,backbtn3,share5;
    static int PERMISSION_CODE=1;
    String mesaj;
    CheckBox fav_restaurant;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        resDescription=findViewById(R.id.restdetails);
        searchtextmap3=findViewById(R.id.searchtextmap2);
        restImage=findViewById(R.id.restimage);
        backbtn3=findViewById(R.id.backbtn3);
        fav_restaurant=findViewById(R.id.fav_restaurant);
        fav_restaurant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(RestaurantDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RestaurantDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
                }
            }
        });
        share5=findViewById(R.id.share5);
        share5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mesaj=resDescription.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,mesaj);
                sendIntent.setType("Text/plain");
                Intent intent = Intent.createChooser(sendIntent,null);
                startActivity(intent);
            }
        });
        txtpage=findViewById(R.id.txtpage);
        txtpage.setOnClickListener(view -> {
            gotoUrl("https://sultanahmet.tn/");
        });
        restPhone=findViewById(R.id.txtphonenumber);
        if(ContextCompat.checkSelfPermission(RestaurantDetails.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(RestaurantDetails.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }
        restPhone.setOnClickListener(view -> {
            String phonum = restPhone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+phonum));
            startActivity(intent);
        });
        Bundle mBundle= getIntent().getExtras();
        if(mBundle!=null){
            resDescription.setText(mBundle.getString("Description"));
            restImage.setImageResource(mBundle.getInt("Image"));
            restPhone.setText(mBundle.getString("Phone"));
            txtpage.setText(mBundle.getString("Page"));

        }
        searchtextmap3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SearchMapActivity.class)));
       backbtn3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),RestaurantActivity.class)));
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    }
