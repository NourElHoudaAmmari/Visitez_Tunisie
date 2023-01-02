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

public class ActivitesActivity extends AppCompatActivity {
    RecyclerView mRecyclerView2;
    List<ActivityData> myActivityList;
   ActivityData mActivityData;
    ImageView backbtn;
    ActivityAdapter activityAdapter;
  SearchView searchView_text;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activites);

searchView_text=findViewById(R.id.searchView_text);
searchView_text.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filter(newText);
        return true;
    }
});

        backbtn=findViewById(R.id.back_btn1);
        backbtn.setOnClickListener(view -> {
            Intent intent =new Intent(ActivitesActivity.this,MainActivity.class);
            startActivity(intent);
        });
        mRecyclerView2=(RecyclerView) findViewById(R.id.beachRecycle2);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(ActivitesActivity.this,1);
        mRecyclerView2.setLayoutManager(gridLayoutManager);
       myActivityList=new ArrayList<>();

       mActivityData =new ActivityData("Golf of Carthage","Golf de Carthage is a golf course located in La Soukra near Tunis in Tunisia. Opened in 1927, it was designed by the French architect Yves Bureau. It was renovated in 1991." +
               "\n\nOpening Time : 08:00/02:00","99 882 398",R.drawable.golf);
      myActivityList.add(mActivityData);
        mActivityData =new ActivityData("yacht club Lac1","The Amaya Gondol's offers 20-minute walks in the lake by canoe, kayak or pedal boat on free routes or with certified instructors.. " +
                "\n\nOpening Time : 08:00/23:00","71 960 982",R.drawable.act1);
       myActivityList.add(mActivityData);
       mActivityData= new ActivityData("Ras Adar Hawarya Diving Center","We took our teenagers for a P1 CMAS certification. The courses and practices were to the highest standards. We went also on a couple dive trips. We really enjoyed. The staff is friendly and accommodating." +
               "\n\nOpening Time : 08:00/14:00","53 763 381",R.drawable.act2);
      myActivityList.add(mActivityData);
       mActivityData=new ActivityData("Billionaire of Gammarth","A great find in Gammarth! Billionaire club is a beautiful lounge restaurant club that exudes sophistication and class. The venue is spread across 2 floors." +
               "\n\nOpening Time : 11:00/05:00 ","23 064 064",R.drawable.billionaire);
      myActivityList.add(mActivityData);

      ActivityAdapter activityAdapter =new ActivityAdapter(ActivitesActivity.this,myActivityList);
        mRecyclerView2.setAdapter(activityAdapter);
    }

    private void filter(String newText) {
        List<ActivityData> filteredList = new ArrayList<>();
        for(ActivityData item : myActivityList){
            if(item.getItemName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        activityAdapter.filerList(filteredList);
    }
}
