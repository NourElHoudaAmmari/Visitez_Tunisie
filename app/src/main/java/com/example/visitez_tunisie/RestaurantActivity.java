package com.example.visitez_tunisie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    RecyclerView mRecyclerView3;
    List<RestaurantData> myRestaurantList;
   RestaurantData mRestaurantData;
    ImageView backto;
  RestaurantAdapter restaurantAdapter;
    private SearchView searchView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
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
        backto=findViewById(R.id.backto1);
        backto.setOnClickListener(view -> {
            Intent intent =new Intent(RestaurantActivity.this,MainActivity.class);
            startActivity(intent);
        });
        mRecyclerView3=(RecyclerView) findViewById(R.id.recycler1);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(RestaurantActivity.this,1);
        mRecyclerView3.setLayoutManager(gridLayoutManager);
        myRestaurantList=new ArrayList<>();

        mRestaurantData =new RestaurantData("SultanAhmet","In addition to its Turkish menu, the Sultan Ahmet restaurant offers a Syro-Lebanese menu led by chef ABU ABDU, which favors traditional cuisine .." +
                "\n\nOpening Time : 09:00/00:00","71 888 722","https://sultanahmet.tn",R.drawable.sultanahmet);
        myRestaurantList.add(mRestaurantData);
        mRestaurantData =new RestaurantData("Le Réservoir","Le Reservoir: A unique place dedicated to the five senses, Le Reservoir will transport you with pleasure through the flavors, scents, music, setting and dandyism of modern times. Quiet non-smoking place… a varied menu… fresh juices… dynamic smiling waiters… warm welcome." +
                "\n\nOpening Time : 12:00/23:00"," 93 239 228","https://www.facebook.com/ReservoirBistro",R.drawable.burger);
        myRestaurantList.add(mRestaurantData);
        mRestaurantData= new RestaurantData("La Closerie","A gastronomic restaurant which exalts Mediterranean flavors with passion and delicacy, an urban and distinguished lounge welcoming eclectic DJs and original Live-bands and finally a terrace which brings together each summer, around \"THE\" swimming pool, the guests of the two spaces around evenings whose reputation is second to none." +
                "\n\nOpening Time : 10:00/18:00"," 70 938 537","http://lacloserie.tn",R.drawable.lacloserie);
        myRestaurantList.add(mRestaurantData);
        mRestaurantData=new RestaurantData("Fondok el Attarine","In the heart of the souks, Fondouk el Attarine an identically renovated caravanserai. Restaurant/ tea room. Permanent sale exhibition of a wide range of Tunisian handicraft products. Privatizable in the evening for family or professional receptions. Open every day except Sunday from 10 a.m. to 6 p.m. Malouf every Saturday from 5 p.m." +
                "\n\nOpening Time : 10:00/18:00 ","71 322 244","http://www.fondoukelattarine.com",R.drawable.fondokattarine);
        myRestaurantList.add(mRestaurantData);

        RestaurantAdapter restaurantAdapter =new RestaurantAdapter(RestaurantActivity.this,myRestaurantList);
        mRecyclerView3.setAdapter(restaurantAdapter);
    }

    private void fileList(String text) {
        ArrayList<RestaurantData> filtredList = new ArrayList<>();
        for(RestaurantData item :myRestaurantList){
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filtredList.add(item);
            }
        }
        if(filtredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
            restaurantAdapter.setFilteredList(filtredList);
        }
    }

}
