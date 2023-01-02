package com.example.visitez_tunisie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private Context mContext;
    private List<EventData> myEventList;

    public EventAdapter(Context mContext, List<EventData> myEventList) {
        this.mContext = mContext;
        this.myEventList = myEventList;
    }
    public void  setFilteredList(ArrayList<EventData>filteredList){
        this.myEventList=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item5, viewGroup, false);
        return new EventViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        eventViewHolder.imageView.setImageResource(myEventList.get(i).getItemImage());
      eventViewHolder.mTitle.setText(myEventList.get(i).getItemName());
      eventViewHolder.mDescription.setText(myEventList.get(i).getItemDescription());
       eventViewHolder.mPhone.setText(myEventList.get(i).getItemNumber());
     eventViewHolder.mCardView5.startAnimation(AnimationUtils.loadAnimation(eventViewHolder.itemView.getContext(),R.anim.anim_from_right));
     eventViewHolder.mCardView5.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, EventDetails.class);
            intent.putExtra("Image", myEventList.get(eventViewHolder.getAdapterPosition()).getItemImage());
            intent.putExtra("Description", myEventList.get(eventViewHolder.getAdapterPosition()).getItemDescription());
            intent.putExtra("Phone", myEventList.get(eventViewHolder.getAdapterPosition()).getItemNumber());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return myEventList.size();
    }
}
class EventViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView mTitle, mDescription,mPhone;
    CardView mCardView5;


    public EventViewHolder(View itemView) {
        super((itemView));
        imageView = itemView.findViewById(R.id.etImage);
        mTitle = itemView.findViewById(R.id.etTitle);
        mDescription = itemView.findViewById(R.id.etDescription);
        mPhone=itemView.findViewById(R.id.etPhone);
        mCardView5= itemView.findViewById(R.id.myCardView5);
    }
}
