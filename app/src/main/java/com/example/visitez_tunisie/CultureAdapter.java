package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CultureAdapter extends RecyclerView.Adapter<CultureViewHolder> {
    private Context mContext;
    private List<CultureData> myCultureList;
    private FavDB favDB;

    public CultureAdapter(Context mContext, List<CultureData> myCultureList) {
        this.mContext = mContext;
        this.myCultureList = myCultureList;
    }
    public void  setFilteredList(ArrayList<CultureData>filteredList){
        this.myCultureList=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CultureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        favDB = new FavDB(mContext);
        SharedPreferences prefs = mContext.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);
        if(firstStart){
            createTableOnFirstStart();
        }
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item1, viewGroup, false);
        return new CultureViewHolder(mView);
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();
        SharedPreferences prefs=mContext.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }

    @Override
    public void onBindViewHolder(@NonNull CultureViewHolder cultureViewHolder, int i) {
        cultureViewHolder.imageView.setImageResource(myCultureList.get(i).getItemImage());
        cultureViewHolder.mTitle.setText(myCultureList.get(i).getItemName());
        cultureViewHolder.mDescription.setText(myCultureList.get(i).getItemDescription());
       cultureViewHolder.mCardView1.startAnimation(AnimationUtils.loadAnimation(cultureViewHolder.itemView.getContext(),R.anim.anim_from_right));
        cultureViewHolder.mCardView1.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, CultureDetails.class);
            intent.putExtra("Image", myCultureList.get(cultureViewHolder.getAdapterPosition()).getItemImage());
            intent.putExtra("Description", myCultureList.get(cultureViewHolder.getAdapterPosition()).getItemDescription());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return myCultureList.size();
    }
}


    class CultureViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mTitle, mDescription;
        CardView mCardView1;


        public CultureViewHolder(View itemView) {
            super((itemView));
            imageView = itemView.findViewById(R.id.ctImage);
            mTitle = itemView.findViewById(R.id.ctTitle);
            mDescription = itemView.findViewById(R.id.ctDescription);
            mCardView1 = itemView.findViewById(R.id.myCardView1);

        }
    }


