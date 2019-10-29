package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HoroTreeDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horo_tree_detail);

        Button home = findViewById(R.id.home_detail_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroTreeDetail.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.left_detail_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroTreeDetail.this, horotreeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button to_TreeList = findViewById(R.id.to_TreeList_button);
        to_TreeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroTreeDetail.this, TreeListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        String HoroName = intent.getStringExtra("name");
        int HoroImageRes = intent.getIntExtra("image", 0);
        String HoroInformation = intent.getStringExtra("information");


        ImageView coverImageView = findViewById(R.id.tree_image_view);
        coverImageView.setImageResource(HoroImageRes);

        TextView HoroNameTextView = findViewById(R.id.horo_tree_name_text_view);
        HoroNameTextView.setText(HoroName);

        TextView HoroInformationTextView = findViewById(R.id.information_editText);
        HoroInformationTextView.setText(HoroInformation);
    }
}
