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


import com.example.horo_tree.R;
import com.example.horo_tree.TreeListDetail;
import com.example.horo_tree.model.Tree;

import java.util.List;

public class RecyclerViewAdapter_TreeList extends RecyclerView.Adapter<RecyclerViewAdapter_TreeList.MyViewHolder>{

    private Context mContext;
    private int mResource;
    private List<Tree> mTreeList;

    public RecyclerViewAdapter_TreeList(Context mContext, int mResource, List<Tree> mTreeList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mTreeList = mTreeList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tree tree = mTreeList.get(position);

        holder.tree=tree;
        holder.nameTreeTextView.setText(tree.name);
        holder.TreeImageView.setImageResource(tree.imageRes);

    }

    @Override
    public int getItemCount() {
        return mTreeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView TreeImageView;
        private TextView nameTreeTextView;

        private Tree tree;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.TreeImageView = itemView.findViewById(R.id.logo_tree_imageView);
            this.nameTreeTextView = itemView.findViewById(R.id.name_tree_list_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TreeListDetail.class);
                    intent.putExtra("name", tree.name);
                    intent.putExtra("image", tree.imageRes);
                    mContext.startActivity(intent);
                    ((Activity)mContext).finish();
                }
            });
        }

    }
}
