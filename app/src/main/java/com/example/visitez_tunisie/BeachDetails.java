package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BeachDetails extends AppCompatActivity {
TextView beachDescription,searchtextmap;
ImageView BeachImage,backbtn,share2;
String messaj;
CheckBox fav_beach;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_details);
        beachDescription=findViewById(R.id.txtDetails);
        searchtextmap=findViewById(R.id.searchtextmap);
        BeachImage=findViewById(R.id.imgDetails);
        backbtn=findViewById(R.id.backbtn);
        fav_beach=findViewById(R.id.fav_beach);
       fav_beach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(BeachDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BeachDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
                }
            }
        });
       share2=findViewById(R.id.share2);
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messaj=beachDescription.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,messaj);
                sendIntent.setType("Text/plain");
                Intent intent = Intent.createChooser(sendIntent,null);
                startActivity(intent);
            }
        });
        backbtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),BeachActivity.class)));
        Bundle mBundle= getIntent().getExtras();
        if(mBundle!=null){
            beachDescription.setText(mBundle.getString("Description"));
            BeachImage.setImageResource(mBundle.getInt("Image"));
        }
        searchtextmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SearchMapActivity.class));
            }
        });
    }

}