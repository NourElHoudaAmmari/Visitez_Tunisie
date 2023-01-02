package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    List<EventData> myEventList;
    RecyclerView eventRecycler;
    EventData mEventData;
    ImageView arrowbackbtn;
 EventAdapter eventAdapter;
    private SearchView searchViewe;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
     searchViewe=findViewById(R.id.searchViewe);
        searchViewe.clearFocus();
       searchViewe.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
     arrowbackbtn=findViewById(R.id.arrowbackbtn);
        arrowbackbtn.setOnClickListener(view -> {
            Intent intent =new Intent(EventActivity.this,MainActivity.class);
            startActivity(intent);
        });
      eventRecycler=(RecyclerView) findViewById(R.id.eventRecycler);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(EventActivity.this,1);
    eventRecycler.setLayoutManager(gridLayoutManager);
    myEventList=new ArrayList<>();

      mEventData = new EventData("Festival of Carthage","The Carthage International Festival is a festival that takes place every year in July and August in the coastal city of Carthage and more precisely at the Ancient Theater of Carthage \"which was built during the second century, having several characteristics such as its location or its architecture”." ,"71 902 772",R.drawable.festivalcarthage);
       myEventList.add(mEventData);
     mEventData= new EventData("Amateur Film Festival","FIFAK'' is the abbreviation of the International Amateur Film Festival of Kelibia, it is organized by the Tunisian Federation of Amateur Filmmakers, in collaboration with the Ministry of Culture and the Municipality of the city of Kelibia a coastal town in the Northeast of Tunisia." +
                "\nOpening Time : from August 13 to 20","71 241 700",R.drawable.festivalfilm);
       myEventList.add(mEventData);
      mEventData = new EventData("Festival of Symphonic Music of El Jem","The International Festival of Symphonic Music of El Jem is a symphonic music festival that has been held every summer in the Tunisian city of El Jem since 1986. In Tunisia, the city of El Jem is the only one in the Arab world to organize a truly international festival dedicated to symphonic music." +
                "\nOpening Time : from July 12 to August 13"," 73 630 715",R.drawable.festivaljem);
       myEventList.add(mEventData);
       mEventData = new EventData("Sahara International Festival","The International Sahara Festival is an annual festival held in the Tunisian city of Douz. The event, which takes place over four days at the end of December, attracts thousands of people from all over Tunisia and other countries in the Maghreb and the Arab world." +
                "\nOpening Time : From December 22 to 25 ","75 471 920",R.drawable.festivalsahara);
      myEventList.add(mEventData);
     EventAdapter eventAdapter =new EventAdapter(EventActivity.this,myEventList);
       eventRecycler.setAdapter(eventAdapter);
    }

    private void fileList(String text) {
        ArrayList<EventData> filtredList = new ArrayList<>();
        for(EventData item :myEventList){
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filtredList.add(item);
            }
        }
        if(filtredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
          eventAdapter.setFilteredList(filtredList);
        }
    }
}