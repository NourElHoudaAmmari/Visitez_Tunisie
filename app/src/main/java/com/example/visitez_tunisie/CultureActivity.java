package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CultureActivity extends AppCompatActivity {
    RecyclerView mRecyclerView1;
    List<CultureData> myCultureList;
    CultureData mCultureData;
    ImageView backto;
  CultureAdapter cultureAdapter;
    private SearchView searchView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture);
        backto=findViewById(R.id.backto);
        searchView2=findViewById(R.id.searchView2);
        searchView2.clearFocus();
        searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });
        backto.setOnClickListener(view -> {
            Intent intent =new Intent(CultureActivity.this,MainActivity.class);
            startActivity(intent);
        });
        mRecyclerView1=(RecyclerView) findViewById(R.id.beachRecycle1);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(CultureActivity.this,1);
        mRecyclerView1.setLayoutManager(gridLayoutManager);
        myCultureList=new ArrayList<>();

        mCultureData=new CultureData("EL Jem amphitheater","The amphitheater of El Jem, also called Colosseum of Thysdrus, is a Roman amphitheater located in the current Tunisian city of El Jem, the ancient Thysdrus of the Roman province of Africa." +
                "\n\nOpening Time:\n\n Winter timetable:07:30-17.30\n\n Summer timetable:07:30-18:30\n\n Entrance fee:\n\nRedisent:8TND/Non-resident:12TND","","",R.drawable.jem);
        myCultureList.add(mCultureData);
       mCultureData =new CultureData("Municipal Theater of Tunis","The Municipal Theater of Tunis is the principal theater of Tunis and the most famous of the theaters of modern Tunisia. Built in the Art Nouveau style on Avenue Jules-Ferry, it was inaugurated on November 20, 1902. It was then called Casino municipal de Tunis. " +
               "        \n\nOpening Time\n\n Winter timetable:08:30-17.30\n\n Summer timetable:07:30-14:00","","",R.drawable.theatremun);
       myCultureList.add(mCultureData);
      mCultureData= new CultureData("Mosquée Okba Ibn Nafaa","The Great Mosque of Kairouan, also called Oqba Ibn Nafi Mosque in memory of its founder Oqba Ibn Nafi, is one of the main mosques in Tunisia, located in Kairouan..","","",R.drawable.kairouan);
       myCultureList.add(mCultureData);
        mCultureData=new CultureData("Capitol of Sbeitla","The capitol, central element of any Roman city, is made up of three separate temples, dedicated to the capitoline triad Jupiter, Juno and Minerva, constituting the religious center of the city." +
                " \n\nOpening Time\n\n Winter timetable:08:30-17.30\n Summer timetable:08:30-19:00\n Entrance fee\n\n Redisent:5TND/Non-resident:8TND ","","",R.drawable.sbeitla);
      myCultureList.add(mCultureData);
       mCultureData=new CultureData("Carthage Amphitheater","The Carthage Amphitheater is a Roman amphitheater built in the 1st century in the city of Carthage, which was rebuilt by Julius Caesar and became the capital of the Roman province of Africa. " +
               "           \n\nOpening Time:08:0-19.00\n\n  Entrance fee : 5.2 DT + photo right 1 DT","","",R.drawable.amphiteatre);
 myCultureList.add(mCultureData);

       CultureAdapter cultureAdapter =new CultureAdapter(CultureActivity.this,myCultureList);
        mRecyclerView1.setAdapter(cultureAdapter);
    }
    private void fileList(String text) {
        ArrayList<CultureData> filteredList = new ArrayList<>();
        for(CultureData item :myCultureList){
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
            cultureAdapter.setFilteredList(filteredList);
        }
    }
    }
