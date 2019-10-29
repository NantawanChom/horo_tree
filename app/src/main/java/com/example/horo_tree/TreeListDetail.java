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

public class TreeListDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_list_detail);

        Button home = findViewById(R.id.home_tree_list_detail_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TreeListDetail.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.back_tree_list_detail_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TreeListDetail.this, TreeListActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Intent intent = getIntent();
        final String TreeName = intent.getStringExtra("name");
        final int TreeImageRes = intent.getIntExtra("image", 0);

        TextView NameTextView = findViewById(R.id.tree_list_name);
        NameTextView.setText(TreeName);

        ImageView TreeImageView = findViewById(R.id.tree_imageView);
        TreeImageView.setImageResource(TreeImageRes);

        Button save = findViewById(R.id.save_tree_list_detail_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorites_Tree favor=new Favorites_Tree(0,TreeName,TreeImageRes);
                FavoriteRepository repo= new FavoriteRepository(TreeListDetail.this);
                repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                    @Override
                    public void onInsertSuccess() {
                        Toast t = Toast.makeText(TreeListDetail.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                        t.show();
                    }
                });
            }
        });

    }
}

/*                if(!name.equals("")){
                    if(image!=null){
                        Favorites_Tree favor=new Favorites_Tree(0,name,image.getId());
                        FavoriteRepository repo= new FavoriteRepository(InsertActivity.this);
                        repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                            @Override
                            public void onInsertSuccess() {
                                Toast t = Toast.makeText(InsertActivity.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                                t.show();
                            }
                        });
                    }else{
                        if(image!=null){
                            Favorites_Tree favor=new Favorites_Tree(0,name,R.drawable.ic_launcher_background);
                            FavoriteRepository repo= new FavoriteRepository(InsertActivity.this);
                            repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                                @Override
                                public void onInsertSuccess() {
                                    Toast t = Toast.makeText(InsertActivity.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                                    t.show();
                                }
                            });
                    }
                }
            }else{
                    Toast t = Toast.makeText(InsertActivity.this,"กรุณาใส่ชื่อต้นไม้",Toast.LENGTH_SHORT);
                    t.show();
                } */