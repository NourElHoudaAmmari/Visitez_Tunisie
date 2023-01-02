package com.example.visitez_tunisie;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
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

public class MostViewAdapter extends RecyclerView.Adapter<MostViewViewHolder> {
    private Context mContext;
    private List<MostViewData> myViewList;

    public MostViewAdapter(Context mContext, List<MostViewData> myViewList) {
        this.mContext = mContext;
        this.myViewList = myViewList;
    }

    @NonNull
    @Override
    public MostViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mostview_item_list, viewGroup, false);
        return new MostViewViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewViewHolder mostViewViewHolder, int i) {
        mostViewViewHolder.imageView.setImageResource(myViewList.get(i).getTextImage());
        mostViewViewHolder.mTitle.setText(myViewList.get(i).getTextName());
        mostViewViewHolder.mDescription.setText(myViewList.get(i).getTextDescription());
        mostViewViewHolder.CardView_item.startAnimation(AnimationUtils.loadAnimation(mostViewViewHolder.itemView.getContext(),R.anim.anim_from_right));
        mostViewViewHolder.CardView_item.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, BeachDetails.class);
            intent.putExtra("Image", myViewList.get(mostViewViewHolder.getAdapterPosition()).getTextImage());
            intent.putExtra("Description", myViewList.get(mostViewViewHolder.getAdapterPosition()).getTextDescription());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return myViewList.size();
    }
}

    class MostViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mTitle, mDescription;
        CardView CardView_item;

        public MostViewViewHolder(View itemView) {
            super((itemView));
            imageView = itemView.findViewById(R.id.textImage);
            mTitle = itemView.findViewById(R.id.textName);
            mDescription = itemView.findViewById(R.id.textDescription);
            CardView_item = itemView.findViewById(R.id.CardView_item);
        }
    }

