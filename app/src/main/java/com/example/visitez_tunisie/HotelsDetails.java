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

import com.example.visitez_tunisie.databinding.ActivityMainBinding;

public class HotelsDetails extends AppCompatActivity {
    TextView hotDescription,searchtextmap5,hotPhone,mail,hotelpage;
    ImageView hotImage,backbtn4,share4;
    String mesaj;
    static int PERMISSION_CODE=1;
    CheckBox fav_hotel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_details);
        hotDescription=findViewById(R.id.txtDetails4);
        mail=findViewById(R.id.mail);
        fav_hotel=findViewById(R.id.fav_hotel);
       fav_hotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(HotelsDetails.this,"Item added to wishlist",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(HotelsDetails.this,"Item removed from wishlist",Toast.LENGTH_SHORT).show();
                }
            }
        });
       share4=findViewById(R.id.share4);
        share4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mesaj=hotDescription.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,mesaj);
                sendIntent.setType("Text/plain");
                Intent intent = Intent.createChooser(sendIntent,null);
                startActivity(intent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent = new Intent(Intent.ACTION_SENDTO);
intent.setData(Uri.parse("mailto"));
if(intent.resolveActivity(getPackageManager())!=null){
    startActivity(intent);
}else {
    Toast.makeText(HotelsDetails.this,"no app installed",Toast.LENGTH_SHORT).show();
}
            }
        });
        hotelpage=findViewById(R.id.hotelpage);
        hotelpage.setOnClickListener(view -> {
            gotoUrl("https://www.movenpick.com/fr/africa/tunisia/tunis/hotel-du-lac-tunis.html");
        });
        searchtextmap5=findViewById(R.id.searchtextmap5);
        hotImage=findViewById(R.id.imgDetails4);
        backbtn4=findViewById(R.id.backbtn4);
      backbtn4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),HotelActivity.class)));
        hotPhone=findViewById(R.id.phonecall);
        if(ContextCompat.checkSelfPermission(HotelsDetails.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(HotelsDetails.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }
      hotPhone.setOnClickListener(view -> {
            String phone = hotPhone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+phone));
            startActivity(intent);
        });
        Bundle mBundle= getIntent().getExtras();
        if(mBundle!=null){
            hotDescription.setText(mBundle.getString("Description"));
            hotImage.setImageResource(mBundle.getInt("Image"));
            hotPhone.setText(mBundle.getString("Phone"));
            mail.setText(mBundle.getString("Mail"));
            hotelpage.setText(mBundle.getString("Page"));
        }
        searchtextmap5.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SearchMapActivity.class)));
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}