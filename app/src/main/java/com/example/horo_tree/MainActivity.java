package com.example.horo_tree;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.horo_tree.adapter.RecyclerViewAdapter;
import com.example.horo_tree.model.horo_tree;
import com.example.horo_tree.room_db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button HoroTree = findViewById(R.id.horo_tree_button);
        HoroTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, horotreeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button FavoriteTree = findViewById(R.id.favorites_tree_button);
        FavoriteTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button CalculateHoro = findViewById(R.id.horo_button);
        CalculateHoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, HoroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button Exit = findViewById(R.id.exit_button);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("แจ้งเตือน");
                dialog.setMessage("คุณต้องการออกจากแอพใช่หรือไม่");

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

dialog.show();
            }
        });


    }




}
