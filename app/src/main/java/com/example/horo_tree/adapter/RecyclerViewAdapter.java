package com.example.horo_tree.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horo_tree.HoroTreeDetail;
import com.example.horo_tree.R;
import com.example.horo_tree.model.horo_tree;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private List<horo_tree> mHoroList;

    public RecyclerViewAdapter(Context mContext, int mResource, List<horo_tree> mPlaceList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mHoroList = mPlaceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        horo_tree horo_tree = mHoroList.get(position);

        holder.horo_tree = horo_tree;
        holder.nameTextView.setText(horo_tree.name);
        holder.LogoHoroImageView.setImageResource(horo_tree.logoImage);
    }

    @Override
    public int getItemCount() {
        return mHoroList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView LogoHoroImageView;
        private TextView nameTextView;

        private horo_tree horo_tree;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.LogoHoroImageView = itemView.findViewById(R.id.logo_horo_image_view);
            this.nameTextView = itemView.findViewById(R.id.horo_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, HoroTreeDetail.class);
                    intent.putExtra("name", horo_tree.name);
                    intent.putExtra("image", horo_tree.TreePic);
                    intent.putExtra("information", horo_tree.information);
                    mContext.startActivity(intent);
                    ((Activity)mContext).finish();
                }
            });
        }

    }
}
