package com.example.visitez_tunisie;

import androidx.annotation.NonNull;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitiesDetails extends AppCompatActivity {
    TextView actDescription,searchtextmap1,actPhone;
    ImageView actImage,backbtn2,share1;
    static int PERMISSION_CODE=1;
    CheckBox cbHeart;
    String messaj;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_details);
        actDescription=findViewById(R.id.txtDetails1);
        searchtextmap1=findViewById(R.id.searchtextmap1);
       actImage=findViewById(R.id.imgDetails1);
        backbtn2=findViewById(R.id.backbtn2);
     cbHeart=findViewById(R.id.cbHeart);
     cbHeart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
if(isChecked){
    Toast.makeText(ActivitiesDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(ActivitiesDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
}
         }
     });
      share1=findViewById(R.id.share1);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messaj=actDescription.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,messaj);
                sendIntent.setType("Text/plain");
                Intent intent = Intent.createChooser(sendIntent,null);
                startActivity(intent);
            }
        });
        backbtn2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),ActivitesActivity.class)));
        actPhone=findViewById(R.id.txtphone);
       actPhone.setOnClickListener(view -> {
       makePhoneCall();
       });
        Bundle mBundle= getIntent().getExtras();
        if(mBundle!=null){
           actDescription.setText(mBundle.getString("Description"));
            actImage.setImageResource(mBundle.getInt("Image"));
            actPhone.setText(mBundle.getString("Phone"));
        }
        searchtextmap1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SearchMapActivity.class)));
    }

    private void makePhoneCall() {
        String number = actPhone.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(ActivitiesDetails.this,
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(ActivitiesDetails.this,
                        new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
            }else{
                String dial ="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
