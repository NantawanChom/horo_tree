package com.example.horo_tree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.horo_tree.R;
import com.example.horo_tree.model.horo_tree;

import java.util.List;

public class HoroListAdapter extends ArrayAdapter<horo_tree> {
    private Context mContext;
    private int mResource;
    private List<horo_tree> mhoroTreeList;

    public HoroListAdapter(@NonNull Context context, int resource, @NonNull List<horo_tree> horoTreeList) {
        super(context, resource, horoTreeList);
        this.mContext = context;
        this.mResource = resource;
        this.mhoroTreeList = horoTreeList;
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

        // เข้าถึงออบเจ็ค Place ตาม position ที่ ListView ขอมา
        horo_tree horo = mhoroTreeList.get(position);

        // กำหนดชื่อสถานที่ลงใน TextView (place_name_text_view)
        TextView HoroNameTextView = v.findViewById(R.id.horo_button);
        HoroNameTextView.setText(horo.name);

        ImageView logoImageView = v.findViewById(R.id.logo_horo_image_view);
        logoImageView.setImageResource(horo.logoImage);

        return v;
    }

}
