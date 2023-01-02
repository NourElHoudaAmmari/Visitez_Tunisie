package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MostView_Activity extends AppCompatActivity {
RecyclerView mostView_recycler;
MostViewAdapter mostViewAdapter;
    List<MostViewData> myViewList;
 MostViewData mostViewData;
    ImageView back_pressed;
    SearchView mostViewSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_view);
      mostView_recycler = findViewById(R.id.mostView_recycler);
      mostViewSearch=findViewById(R.id.mostViewSearch);
      mostViewSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String s) {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              return true;
          }
      });
      back_pressed=findViewById(R.id.back_pressed);
       back_pressed.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),MainActivity.class)));
        GridLayoutManager gridLayoutManager= new GridLayoutManager(MostView_Activity.this,1);
      mostView_recycler.setLayoutManager(gridLayoutManager);
        myViewList=new ArrayList<>();

        mostViewData =new MostViewData("Le Reservoir","A unique place dedicated to the five senses",R.drawable.burger);
     myViewList.add(mostViewData);
        mostViewData =new MostViewData("Mahdia Beach","The beauty of its beaches lies in the limpid aspect of the water, in the fine sand, but also in their virgin and wild aspect.",R.drawable.plagem);
       myViewList.add(mostViewData);
     mostViewData=new MostViewData("Carthage golf","A golf course located in La Soukra near Tunis in Tunisia. Opened in 1927, it was designed by the French architect Yves Bureau",R.drawable.golf);
      myViewList.add(mostViewData);
      mostViewData=new MostViewData("Sahara International Festival","The International Sahara Festival is an annual festival held in the Tunisian city of Douz. The event, which takes place over four days at the end of December, attracts thousands of people from all over Tunisia and other countries in the Maghreb and the Arab world",R.drawable.festivalsahara);
      myViewList.add(mostViewData);
        mostViewData=new MostViewData("SultanAhmet","In addition to its Turkish menu, the Sultan Ahmet restaurant offers a Syro-Lebanese menu led by chef ABU ABDU, which favors traditional cuisine",R.drawable.sultanahmet);
        myViewList.add(mostViewData);
        mostViewData=new MostViewData("Carthage Amphitheater","The Carthage Amphitheater is a Roman amphitheater built in the 1st century in the city of Carthage, which was rebuilt by Julius Caesar and became the capital of the Roman province of Africa.",R.drawable.amphiteatre);
        myViewList.add(mostViewData);

     MostViewAdapter mostViewAdapter =new MostViewAdapter(MostView_Activity.this,myViewList);
      mostView_recycler.setAdapter(mostViewAdapter);
    }
}