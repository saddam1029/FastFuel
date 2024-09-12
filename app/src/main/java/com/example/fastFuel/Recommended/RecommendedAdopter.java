package com.example.fastFuel.Recommended;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.FastFuel.R;
import com.example.fastFuel.FoodDetail;

import java.util.List;

public class RecommendedAdopter extends RecyclerView.Adapter<CardViewHolder2>{

    private Context mContext;
    private List<RecommendedModel> mDataList;

    public RecommendedAdopter(Context context, List<RecommendedModel> itemList) {
        mContext = context;
        mDataList = itemList;
    }

    @NonNull
    @Override
    public CardViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommended_cardview, parent, false);
        return new CardViewHolder2(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull CardViewHolder2 holder, int position) {
        RecommendedModel data = mDataList.get(position);

        int imageResId = data.getRec_image();

        Glide.with(holder.itemView.getContext())
                .load(imageResId)
                .into(holder.tvFoodImage);

        holder.tvFoodName.setText(data.getRec_name());
        holder.tvPrice.setText(data.getRec_price());

        holder.tvFoodDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open FoodDetailActivity
                Intent intent = new Intent(holder.itemView.getContext(), FoodDetail.class);
                intent.putExtra("foodName", data.getRec_name());
                intent.putExtra("foodPic", data.getRec_image());
                intent.putExtra("foodPrice", data.getRec_price());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}

class CardViewHolder2 extends RecyclerView.ViewHolder {
    public ImageView tvFoodImage;
    public View tvFoodDetail;
    public TextView tvFoodName;
    public TextView tvPrice;

    public CardViewHolder2(View itemView) {
        super(itemView);
        tvFoodImage = itemView.findViewById(R.id.ivFoodPic);
        tvFoodName = itemView.findViewById(R.id.tvFoodName);
        tvFoodDetail = itemView.findViewById(R.id.tvFoodDetail);
        tvPrice = itemView.findViewById(R.id.tvPrice);

    }
}
