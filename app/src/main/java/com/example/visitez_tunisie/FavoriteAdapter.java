package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
  FavoriteData[]myFavoriteData;
  Context context;

    public FavoriteAdapter(FavoriteData[] myFavoriteData, Context context) {
        this.myFavoriteData = myFavoriteData;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fav_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
final FavoriteData myFavoriteDataList=myFavoriteData[position];
        holder.itemName.setText(myFavoriteDataList.getItemName());
        holder.itemDescription.setText(myFavoriteDataList.getItemDescription());
        holder.itemImage.setImageResource(myFavoriteDataList.getItemImage());
    }

    @Override
    public int getItemCount() {
        return myFavoriteData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
ImageView itemImage;
TextView itemName,itemDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.favImageView);
            itemName=itemView.findViewById(R.id.favTextView);
            itemDescription=itemView.findViewById(R.id.favDescription);
        }
    }
}
