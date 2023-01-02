package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {
    private Context mContext;
    private List<RestaurantData> myRestaurantList;

    public RestaurantAdapter(Context mContext, List<RestaurantData> myRestaurantList) {
        this.mContext = mContext;
        this.myRestaurantList = myRestaurantList;
    }
    public void  setFilteredList(ArrayList<RestaurantData> filteredList){
        this.myRestaurantList=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item3, viewGroup, false);
        return new RestaurantViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
       restaurantViewHolder.imageView.setImageResource(myRestaurantList.get(i).getItemImage());
        restaurantViewHolder.mTitle.setText(myRestaurantList.get(i).getItemName());
        restaurantViewHolder.mDescription.setText(myRestaurantList.get(i).getItemDescription());
        restaurantViewHolder.mPhone.setText(myRestaurantList.get(i).getItemNumber());
        restaurantViewHolder.mPage.setText(myRestaurantList.get(i).getItemLink());
        restaurantViewHolder.mCardView3.startAnimation(AnimationUtils.loadAnimation(restaurantViewHolder.itemView.getContext(),R.anim.anim_from_right));
        restaurantViewHolder.mCardView3.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, RestaurantDetails.class);
            intent.putExtra("Image", myRestaurantList.get(restaurantViewHolder.getAdapterPosition()).getItemImage());
            intent.putExtra("Description", myRestaurantList.get(restaurantViewHolder.getAdapterPosition()).getItemDescription());
            intent.putExtra("Phone", myRestaurantList.get(restaurantViewHolder.getAdapterPosition()).getItemNumber());
            intent.putExtra("Page",myRestaurantList.get(restaurantViewHolder.getAdapterPosition()).getItemLink());
            mContext.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return myRestaurantList.size();
    }
}
class RestaurantViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView mTitle, mDescription,mPhone,mPage;
    CardView mCardView3;

    public RestaurantViewHolder(View itemView) {
        super((itemView));
        imageView = itemView.findViewById(R.id.rtImage);
        mTitle = itemView.findViewById(R.id.rtTitle);
        mDescription = itemView.findViewById(R.id.rtDescription);
        mPhone=itemView.findViewById(R.id.rtPhone);
        mPage=itemView.findViewById(R.id.rtPage);
        mCardView3= itemView.findViewById(R.id.myCardView3);
    }
}
