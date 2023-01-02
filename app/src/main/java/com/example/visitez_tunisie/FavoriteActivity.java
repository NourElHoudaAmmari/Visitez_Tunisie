package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
ImageView boutonback;
SearchView searchpage;
    FavoriteData[]myFavoriteData;
 FavoriteAdapter favoriteAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        searchpage=findViewById(R.id.searchpage);
        searchpage.clearFocus();
        boutonback=findViewById(R.id.boutonback);
        boutonback.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),MainActivity.class)));
        RecyclerView recyclerView = findViewById(R.id.favRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FavoriteData[] myFavoriteData = new FavoriteData[]{
                new FavoriteData("Carthage Festival","The Carthage Amphitheater is a Roman amphitheater built in the 1st century in the city of Carthage",R.drawable.festivalcarthage),
                new FavoriteData("Mahdia Beach","Covered in fine, powdery sand, the beaches of Mahdia stretch along the northern coast of Tunisia in a long white line",R.drawable.plagem),
        };
        FavoriteAdapter favoriteAdapter= new FavoriteAdapter(myFavoriteData,FavoriteActivity.this);
        recyclerView.setAdapter(favoriteAdapter);
    }


}