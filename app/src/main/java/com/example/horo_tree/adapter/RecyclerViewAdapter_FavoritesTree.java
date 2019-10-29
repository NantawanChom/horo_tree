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

import com.example.horo_tree.FavoritesTreeDetail;
import com.example.horo_tree.R;
import com.example.horo_tree.model.Favorites_Tree;

import java.util.List;

public class RecyclerViewAdapter_FavoritesTree extends RecyclerView.Adapter<RecyclerViewAdapter_FavoritesTree.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private List<Favorites_Tree> mFavorotesTreeList;

    public RecyclerViewAdapter_FavoritesTree(Context mContext, int mResource, List<Favorites_Tree> mFavorotesTreeList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mFavorotesTreeList = mFavorotesTreeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Favorites_Tree ftree = mFavorotesTreeList.get(position);

        holder.ftree=ftree;
        holder.nameTreeTextView.setText(ftree.name);
        holder.TreeImageView.setImageResource(ftree.imageRes);

    }

    @Override
    public int getItemCount() {
        return mFavorotesTreeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView TreeImageView;
        private TextView nameTreeTextView;

        private Favorites_Tree ftree;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.TreeImageView = itemView.findViewById(R.id.tree_favorites_imageView);
            this.nameTreeTextView = itemView.findViewById(R.id.name_tree_favorites_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, FavoritesTreeDetail.class);
                    intent.putExtra("name", ftree.name);
                    intent.putExtra("image", ftree.imageRes);
                    mContext.startActivity(intent);
                    ((Activity)mContext).finish();
                }
            });
        }

    }

}
