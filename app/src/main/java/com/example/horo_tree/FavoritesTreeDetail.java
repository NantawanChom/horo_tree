package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.horo_tree.model.Favorites_Tree;
import com.example.horo_tree.room_db.FavoriteRepository;

public class FavoritesTreeDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_tree_detail);

        Button home = findViewById(R.id.home_detail_favorite_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( FavoritesTreeDetail.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.back_favorite_detail_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( FavoritesTreeDetail.this, FavoritesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        final String TreeName = intent.getStringExtra("name");
        final int TreeImageRes = intent.getIntExtra("image", 0);

        TextView NameTextView = findViewById(R.id.list_tree_name_detail_TextView);
        NameTextView.setText(TreeName);

        ImageView TreeImageView = findViewById(R.id.tree_favorite_detail_imageView);
        TreeImageView.setImageResource(TreeImageRes);

        Button delete = findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorites_Tree favor=new Favorites_Tree(0,TreeName,TreeImageRes);
                FavoriteRepository repo= new FavoriteRepository(FavoritesTreeDetail.this);

                repo.DeleteFavorite(favor, new FavoriteRepository.DeleteCallback() {
                    @Override
                    public void onDeleteSuccess() {
                        Toast t = Toast.makeText(FavoritesTreeDetail.this,"ลบต้นไม้ออกจากรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                        t.show();

                        Intent intent = new Intent( FavoritesTreeDetail.this, FavoritesActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });


    }
}
