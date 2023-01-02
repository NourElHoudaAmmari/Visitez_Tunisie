package com.example.visitez_tunisie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.visitez_tunisie.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
ImageView page1,page2,page3,page4,favpage;
TextView most_view,viewall;
RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4,gradient5,gradient6;
DrawerLayout drawerLayout;
NavigationView navigationView;
ImageView menuIcon;
static final float END_SCALE=0.7f;
LinearLayout contentView;
SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.searchView);
        featuredRecycler=findViewById(R.id.featured_recycler);
        favpage=findViewById(R.id.favpage);
      favpage.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),FavoriteActivity.class)));
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        viewall= findViewById(R.id.viewall);
        menuIcon=findViewById(R.id.menu_icon);
        contentView =findViewById(R.id.content);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        most_view=findViewById(R.id.most_view);
        most_view.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),MostView_Activity.class)));
        page1=findViewById(R.id.page1);
        page2=findViewById(R.id.page2);
        page3=findViewById(R.id.page3);
        page4=findViewById(R.id.page4);
        page1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),RestaurantActivity.class)));
        page2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),HotelActivity.class)));
        page3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),CultureActivity.class)));
        page4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),BeachActivity.class)));
        viewall.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),AllCategories.class)));
        navigationDrawer();
//Recycler views Functions Calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(),query,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getBaseContext(),newText,Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void categoriesRecycler() {
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient6 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
       categoriesHelperClasses.add(new CategoriesHelperClass(gradient1,R.drawable.musem,"Culture"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2,R.drawable.activit,"Activities"));
       categoriesHelperClasses.add(new CategoriesHelperClass(gradient3,R.drawable.tablederestaurant,"Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4,R.drawable.hoteletoiles,"Hotels"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient5,R.drawable.iconsplage,"Beaches"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient6,R.drawable.festival,"Events and festivals"));

        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.burger,"Le Réservoir","A unique place dedicated to the five senses."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.plagem, "Mahdia Beach","The beauty of its beaches lies in the limpid aspect of the water, in the fine sand, but also in their virgin and wild aspect."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.bardo, "Bardo National Musem","It is one of the most important museums in the Mediterranean basin and the second largest museum on the African continent after the Egyptian Museum in Cairo."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.golf, "Carthage golf","A golf course located in La Soukra near Tunis in Tunisia. Opened in 1927, it was designed by the French architect Yves Bureau"));
        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }

    //Navigation Drawer Functions
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
     switch (item.getItemId()){
         case R.id.restaurant:
             startActivity(new Intent(getApplicationContext(),RestaurantActivity.class));
             return true;
         case R.id.home:
             startActivity(new Intent(getApplicationContext(),MainActivity.class));
             return true;
         case R.id.map:
             startActivity(new Intent(getApplicationContext(),SearchMapActivity.class));
             return true;
         case R.id.culture:
             startActivity(new Intent(getApplicationContext(),CultureActivity.class));
             return true;
         case R.id.activite:
             startActivity(new Intent(getApplicationContext(),ActivitesActivity.class));
             return true;
         case R.id.plages:
             startActivity(new Intent(getApplicationContext(),BeachActivity.class));
             return true;
         case R.id.hotel:
             startActivity(new Intent(getApplicationContext(),HotelActivity.class));
             return true;
         case R.id.music:
             startActivity(new Intent(getApplicationContext(),EventActivity.class));
             return true;
         case R.id.video:
             startActivity(new Intent(getApplicationContext(),VideoActivity.class));
             return true;
         default:  return super.onOptionsItemSelected(item);
     }
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navigation_view);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.card1));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffset=slideOffset*(1- END_SCALE);
                final float offsetScale=1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth()*slideOffset;
                final float xOffsetDiff= contentView.getWidth()*diffScaledOffset/2;
                final float xTranslation =xOffset -xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        }
        );

    }

    // Recycler views Functions
    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<FeaturedHelperClass>featuredLocations =new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.fondokattarine,"Fondok El Attarine","\n" +
                "\n" +
                "In the heart of the labyrinth of alleys of the medina of Tunis, there is a real architectural jewel in the old."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.amphiteatre,"Carthage Roman Amphitheater","Amphitheater of Carthage is a Roman amphitheater built between the end of the 1st century and the beginning of the 2nd century in the city of Carthage"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.movenpik,"Movenpick Hotel Du Lac Tunis","Have a pleasant stay in Tunis by choosing the Mövenpick Hotel du Lac Tunis."));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }


}