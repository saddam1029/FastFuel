package com.example.fastFuel.Categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.FastFuel.R;

import java.util.List;

public class CategoriesAdopter extends RecyclerView.Adapter<CardViewHolder> {

    private Context mContext;
    private List<CategoriesModel> mDataList;

    public CategoriesAdopter(Context context, List<CategoriesModel> itemList) {
        mContext = context;
        mDataList = itemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_cardview, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CategoriesModel data = mDataList.get(position);

        int imageResId = holder.itemView.getContext().getResources()
                .getIdentifier(data.getCat_image(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(imageResId)
                .into(holder.imageView);

        holder.titleTextView.setText(data.getCat_name());
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}

class CardViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView titleTextView;

    public CardViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivCategoriesPizza);
        titleTextView = itemView.findViewById(R.id.tvCategoriesPizza);
    }
}