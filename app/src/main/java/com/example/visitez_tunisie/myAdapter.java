package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<BeachViewHolder> {
    private Context mContext;
    private List<BeachData> myBeachList;

    public myAdapter(Context mContext, List<BeachData> myBeachList) {
        this.mContext = mContext;
        this.myBeachList = myBeachList;
    }

public void  setFilteredList(ArrayList<BeachData>filteredList){
        this.myBeachList=filteredList;
        notifyDataSetChanged();
}
    @NonNull
    @Override
    public BeachViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup,false);
        return new  BeachViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull BeachViewHolder beachViewHolder, int i) {
        beachViewHolder.imageView.setImageResource(myBeachList.get(i).getItemImage());
        beachViewHolder.mTitle.setText(myBeachList.get(i).getItemName());
        beachViewHolder.mDescription.setText(myBeachList.get(i).getItemDescription());
       beachViewHolder.mCardView.startAnimation(AnimationUtils.loadAnimation(beachViewHolder.itemView.getContext(),R.anim.anim_from_right));
        beachViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,BeachDetails.class) ;
                intent.putExtra("Image",myBeachList.get(beachViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myBeachList.get(beachViewHolder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myBeachList.size();
    }
}
class BeachViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView mTitle, mDescription;
    CardView mCardView;

    public BeachViewHolder(View itemView){
        super( (itemView));
        imageView=itemView.findViewById(R.id.itImage);
        mTitle=itemView.findViewById(R.id.itTitle);
        mDescription=itemView.findViewById(R.id.itDescription);
        mCardView=itemView.findViewById(R.id.myCardView);
    }
}
