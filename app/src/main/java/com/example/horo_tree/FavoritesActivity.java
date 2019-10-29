package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.horo_tree.adapter.RecyclerViewAdapter_FavoritesTree;
import com.example.horo_tree.model.Favorites_Tree;
import com.example.horo_tree.room_db.FavoriteRepository;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Button home=findViewById(R.id.home_favorites_list_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( FavoritesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button add=findViewById(R.id.add_tree_favorites_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( FavoritesActivity.this, InsertActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        reloadData();
    }

    private void reloadData() {

        FavoriteRepository repo = new FavoriteRepository(FavoritesActivity.this);
        repo.getFavorite(new FavoriteRepository.CallBack() {
            @Override
            public void onGetFavorite(List<Favorites_Tree> itemList) {
                RecyclerView recyclerView = findViewById(R.id.favorites_list_recycler_view);
                RecyclerViewAdapter_FavoritesTree adapter = new RecyclerViewAdapter_FavoritesTree(FavoritesActivity.this, R.layout.favorites_item, itemList);

                recyclerView.setLayoutManager(new LinearLayoutManager(FavoritesActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }
}

