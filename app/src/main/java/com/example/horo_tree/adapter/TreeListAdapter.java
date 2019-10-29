package com.example.horo_tree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.horo_tree.R;
import com.example.horo_tree.model.Tree;

import java.util.List;

public class TreeListAdapter extends ArrayAdapter<Tree> {

    private Context mContext;
    private int mResource;
    private List<Tree> mTreeList;

    public TreeListAdapter(@NonNull Context context, int resource, @NonNull List<Tree> TreeList) {
        super(context, resource, TreeList);
        this.mContext = context;
        this.mResource = resource;
        this.mTreeList = TreeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // ทำการ Inflate layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = convertView;
        if (v == null) {
            v = inflater.inflate(mResource, parent, false);
        }


        Tree tree = mTreeList.get(position);


        TextView TreeNameTextView = v.findViewById(R.id.name_tree_list_textView);
        TreeNameTextView.setText(tree.name);

        ImageView logoImageView = v.findViewById(R.id.logo_tree_imageView);
        logoImageView.setImageResource(tree.imageRes);

        return v;
    }
}
