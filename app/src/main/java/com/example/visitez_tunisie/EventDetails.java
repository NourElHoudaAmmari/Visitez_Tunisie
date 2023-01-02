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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetails extends AppCompatActivity {
    TextView evtDescription, searchtextmap8, evtPhone;
    ImageView evtImage, arrowbackbtn1,share3;
    Button favBtn;
    static int PERMISSION_CODE = 1;
    String messaj;
    CheckBox fav_event;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
       evtDescription = findViewById(R.id.eventDetails);
        searchtextmap8 = findViewById(R.id.searchtextmap8);
        evtImage = findViewById(R.id.eventImage);
        arrowbackbtn1= findViewById(R.id.arrowbackbtn1);
        fav_event=findViewById(R.id.fav_event);
      fav_event.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(EventDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EventDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
                }
            }
        });
    share3= findViewById(R.id.share3);
        share3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messaj=evtDescription.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,messaj);
                sendIntent.setType("Text/plain");
                Intent intent = Intent.createChooser(sendIntent,null);
                startActivity(intent);
            }
        });
        arrowbackbtn1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),EventActivity.class)));
       evtPhone = findViewById(R.id.eventphone);
        if (ContextCompat.checkSelfPermission(EventDetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EventDetails.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
        }
        evtPhone.setOnClickListener(view -> {
            String phoneno = evtPhone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneno));
            startActivity(intent);
        });
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            evtDescription.setText(mBundle.getString("Description"));
            evtImage.setImageResource(mBundle.getInt("Image"));
            evtPhone.setText(mBundle.getString("Phone"));
        }
        searchtextmap8.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SearchMapActivity.class)));
    }
}