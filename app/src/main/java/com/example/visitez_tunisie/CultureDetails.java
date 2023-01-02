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

public class CultureDetails extends AppCompatActivity {
    TextView CultureDescription,searchtextmap1;
    ImageView CultureImage,arrowback,share;
    String mesaj;
    CheckBox fav_culture;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_details);
        CultureDescription=findViewById(R.id.textDetails);
        searchtextmap1=findViewById(R.id.searchtextmap1);
        CultureImage=findViewById(R.id.imageDetails);
        arrowback=findViewById(R.id.arrowback);
        fav_culture=findViewById(R.id.fav_culture);
     fav_culture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(CultureDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CultureDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
                }
            }
        });
     share=findViewById(R.id.share);
     share.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             mesaj=CultureDescription.getText().toString();
             Intent sendIntent = new Intent();
             sendIntent.setAction(Intent.ACTION_SEND);
             sendIntent.putExtra(Intent.EXTRA_TEXT,mesaj);
             sendIntent.setType("Text/plain");
             Intent intent = Intent.createChooser(sendIntent,null);
             startActivity(intent);
         }
     });
        arrowback.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),CultureActivity.class)));
        Bundle mBundle= getIntent().getExtras();
        if(mBundle!=null){
            CultureDescription.setText(mBundle.getString("Description"));
          CultureImage.setImageResource(mBundle.getInt("Image"));
        }
        searchtextmap1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SearchMapActivity.class)));
    }
    }
