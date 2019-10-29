package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horo_tree.Auth.calculate_horo;
import com.example.horo_tree.model.horo;


public class HoroDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horo_detail);

        Button home = findViewById(R.id.home_horo_detail_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroDetail.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.back_horo_detail_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroDetail.this, HoroActivity.class);
                startActivity(intent);
                finish();
            }
        });



        Intent intent = getIntent();
        final int date = intent.getIntExtra("date", 0);
        final int month = intent.getIntExtra("month", 0);



        calculate_horo h = new calculate_horo(date,month);
        horo horo = h.calculate();

        TextView HoroNameTextView = findViewById(R.id.name_horo_detail_textView);
        TextView HoroDataTextView = findViewById(R.id.character_textView);
        ImageView HoroImageView = findViewById(R.id.horo_detail_imageView);

        if(horo!=null){
            HoroNameTextView.setText(horo.name);
            HoroImageView.setImageResource(horo.image);
            HoroDataTextView.setText(horo.data);
        }




    }

}
