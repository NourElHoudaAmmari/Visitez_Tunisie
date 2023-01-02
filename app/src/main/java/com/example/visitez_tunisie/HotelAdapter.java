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

public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {
    private Context mContext;
    private List<HotelData> myHotelList;

    public HotelAdapter(Context mContext, List<HotelData> myHotelList) {
        this.mContext = mContext;
        this.myHotelList = myHotelList;
    }
    public void  setFilteredList(ArrayList<HotelData> filteredList){
        this.myHotelList=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item4, viewGroup, false);
        return new HotelViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {
        hotelViewHolder.imageView.setImageResource(myHotelList.get(i).getItemImage());
        hotelViewHolder.mTitle.setText(myHotelList.get(i).getItemName());
        hotelViewHolder.mDescription.setText(myHotelList.get(i).getItemDescription());
       hotelViewHolder.mCardView4.startAnimation(AnimationUtils.loadAnimation(hotelViewHolder.itemView.getContext(),R.anim.anim_from_right));
       hotelViewHolder.mPhone.setText(myHotelList.get(i).getItemNumber());
       hotelViewHolder.mMail.setText(myHotelList.get(i).getItememail());
        hotelViewHolder.mPage.setText(myHotelList.get(i).getItemPage());
       hotelViewHolder.mCardView4.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, HotelsDetails.class);
            intent.putExtra("Image", myHotelList.get(hotelViewHolder.getAdapterPosition()).getItemImage());
            intent.putExtra("Description", myHotelList.get(hotelViewHolder.getAdapterPosition()).getItemDescription());
            intent.putExtra("Phone", myHotelList.get(hotelViewHolder.getAdapterPosition()).getItemNumber());
            intent.putExtra("Mail",myHotelList.get(hotelViewHolder.getAbsoluteAdapterPosition()).getItememail());
           intent.putExtra("Page",myHotelList.get(hotelViewHolder.getAbsoluteAdapterPosition()).getItemPage());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
       return myHotelList.size();
    }
}
class HotelViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView mTitle, mDescription,mPhone,mMail,mPage;
    CardView mCardView4;
    public HotelViewHolder(View itemView) {
        super((itemView));
        imageView = itemView.findViewById(R.id.htImage);
        mTitle = itemView.findViewById(R.id.htTitle);
        mDescription = itemView.findViewById(R.id.htDescription);
        mPhone=itemView.findViewById(R.id.htPhone);
        mCardView4= itemView.findViewById(R.id.myCardView4);
        mMail=itemView.findViewById(R.id.hotelmail);
        mPage=itemView.findViewById(R.id.hotPage);
    }
}