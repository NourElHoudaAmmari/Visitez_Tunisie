package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityViewHolder> {
    private Context mContext;
    private List<ActivityData> myActivityList;


    public ActivityAdapter(Context mContext, List<ActivityData> myActivityList) {
        this.mContext = mContext;
        this.myActivityList = myActivityList;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item2, viewGroup, false);
        return new ActivityViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder activityViewHolder, int i) {
       activityViewHolder.imageView.setImageResource(myActivityList.get(i).getItemImage());
      activityViewHolder.mTitle.setText(myActivityList.get(i).getItemName());
     activityViewHolder.mDescription.setText(myActivityList.get(i).getItemDescription());
     activityViewHolder.mPhone.setText(myActivityList.get(i).getItemNumber());
        activityViewHolder.mCardView2.startAnimation(AnimationUtils.loadAnimation(activityViewHolder.itemView.getContext(),R.anim.anim_from_right));
        activityViewHolder.mCardView2.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, ActivitiesDetails.class);
            intent.putExtra("Image", myActivityList.get(activityViewHolder.getAdapterPosition()).getItemImage());
            intent.putExtra("Description", myActivityList.get(activityViewHolder.getAdapterPosition()).getItemDescription());
            intent.putExtra("Phone", myActivityList.get(activityViewHolder.getAdapterPosition()).getItemNumber());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
       return myActivityList.size();
    }

 public void filerList(List<ActivityData>filteredList){
myActivityList = filteredList;
notifyDataSetChanged();
   }
}
class ActivityViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView mTitle, mDescription,mPhone;
    CardView mCardView2;


    public ActivityViewHolder(View itemView) {
        super((itemView));
        imageView = itemView.findViewById(R.id.atImage);
        mTitle = itemView.findViewById(R.id.atTitle);
        mDescription = itemView.findViewById(R.id.atDescription);
        mPhone=itemView.findViewById(R.id.atPhone);
        mCardView2= itemView.findViewById(R.id.myCardView2);

    }
}
