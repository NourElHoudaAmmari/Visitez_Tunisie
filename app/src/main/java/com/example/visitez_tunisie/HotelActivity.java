package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    RecyclerView hotelRecycleview;
    List<HotelData> myHotelList;
HotelData mHotelData;
    ImageView backbtn4;
   HotelAdapter hotelAdapter;
    private SearchView searchView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        searchView3=findViewById(R.id.searchView3);
        searchView3.clearFocus();
        searchView3.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        backbtn4=findViewById(R.id.back_btn1);
        backbtn4.setOnClickListener(view -> {
            Intent intent =new Intent(HotelActivity.this,MainActivity.class);
            startActivity(intent);
        });
        hotelRecycleview=(RecyclerView) findViewById(R.id.hotelRecycleview);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(HotelActivity.this,1);
       hotelRecycleview.setLayoutManager(gridLayoutManager);
      myHotelList=new ArrayList<>();

        mHotelData =new HotelData("Mövenpick Hotel Du Lac Tunis","le Mövenpick Hotel du Lac Tunis est un hotel 5 étoiles situé aux Berges du Lac, l'élégant quartier diplomatique et des affaires de la capitale tunisienne.","36 421 000","hotel.dulactunis@movenpick.com","https://www.movenpick.com/fr/africa/tunisia/tunis/hotel-du-lac-tunis.html",R.drawable.movenpik);
        myHotelList.add(mHotelData);
        mHotelData =new HotelData("Iberostar Selection Royal El Mansour","Iberostar Selection Royal El Mansour: voici un autre des trésors cachés de Mahdia. Situé face à la plage, à côté de la vieille ville, ce 5étoiles pour toute ...","73 681 100","royal.mansour@iberostar.tn","https://www.iberostar.com/fr/hotels/mahdia/iberostar-royal-el-mansour-thalasso/",R.drawable.royalmansour);
        myHotelList.add(mHotelData);
        mHotelData= new HotelData("Iberostar Mehari Djerba","L'hôtel Iberostar Mehari Djerba est sans nul doute l'amphitryon idéal pour un voyage unique dans l'une des destinations les plus magiques de la Tunisie.","75 745 240","meharidjerba@iberostar.com.tn","https://www.iberostar.com/fr/hotels/djerba/iberostar-mehari-djerba/",R.drawable.meharidjerba);
        myHotelList.add(mHotelData);
        mHotelData=new HotelData("Hotel Marhaba Royal Salem","Le Marhaba Royal Hotel est la destination préférée des familles et des couples à Sousse. Au milieu des palmiers et au coeur de la pureté de la nature, les vacances ne peuvent être que merveilleuses..","73 271 588","hroyal.salem@planet.tn","https://www.marhabahotels.tn/marhaba-royal-salem/",R.drawable.marhabaroyalsalem);
        myHotelList.add(mHotelData);

      HotelAdapter hotelAdapter =new HotelAdapter(HotelActivity.this,myHotelList);
       hotelRecycleview.setAdapter(hotelAdapter);
    }

    private void fileList(String text) {
        ArrayList<HotelData> filteredList = new ArrayList<>();
        for(HotelData item :myHotelList){
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
            hotelAdapter.setFilteredList(filteredList);
        }
    }
}
