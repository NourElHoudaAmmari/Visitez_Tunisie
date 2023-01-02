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
import java.util.Locale;

public class BeachActivity extends AppCompatActivity {
RecyclerView mRecyclerView;
List<BeachData> myBeachList;
BeachData mBeachData;
ImageView backBtn;
myAdapter myAdapter;
private SearchView searchView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);
        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        backBtn=findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BeachActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView=(RecyclerView) findViewById(R.id.beachRecycle);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(BeachActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        myBeachList =new ArrayList<>();

        mBeachData=new BeachData("Mahdia Beach","Covered in fine, powdery sand, the beaches of Mahdia stretch along the northern coast of Tunisia in a long white line",R.drawable.plagem);
        myBeachList.add(mBeachData);
        mBeachData =new BeachData("Klebia Beach","Covered with fine white sand, the shore is divided into two unequal parts by a cape protruding into the sea. ",R.drawable.klebiaplage);
        myBeachList.add(mBeachData);
        mBeachData= new BeachData("Cap Engela Beach","La plage de sable est immense, calmement battue des flots de la Méditerranée. Il y a tellement peu de baigneurs qu'à certaines heures, on se croirait en plein milieu d'un endroit totalement désert.",R.drawable.rasenjla);
        myBeachList.add(mBeachData);
        mBeachData=new BeachData("Djerba Beach","Good beaches are located in the northeast of Djerba. It is here, in the Midoun area, where you can find a stretch of beach, ideal for a spa holiday. ",R.drawable.djerbaplage);
        myBeachList.add(mBeachData);
        mBeachData=new BeachData("haouaria Beach","The long white-sand beach of El Haouaria, complete with villas and restaurants, is a favorite with guests in northeastern Tunisia.",R.drawable.haouaria);
        myBeachList.add(mBeachData);
        mBeachData=new BeachData("Chaabna Beach","we treat ourselves to a sunbath with a crystalline sea",R.drawable.chaabna);
        myBeachList.add(mBeachData);

     myAdapter myAdapter =new myAdapter(BeachActivity.this,myBeachList);
     mRecyclerView.setAdapter(myAdapter);

    }

    private void fileList(String text) {
      ArrayList<BeachData> filtredList = new ArrayList<>();
        for(BeachData item :myBeachList){
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filtredList.add(item);
            }
        }
        if(filtredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
          myAdapter.setFilteredList(filtredList);
        }
    }
}