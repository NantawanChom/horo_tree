package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horo_tree.adapter.RecyclerViewAdapter;
import com.example.horo_tree.db.tree_horo_databaseHelper;
import com.example.horo_tree.model.horo_tree;
import com.example.horo_tree.room_db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class horotreeActivity extends AppCompatActivity {

    private List<horo_tree> mHoroList = new ArrayList<>();

    tree_horo_databaseHelper dbHelper;
    SQLiteDatabase horoDB;
    Cursor mCursor;


    private RecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horotree);

        Button home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( horotreeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        dbHelper=new tree_horo_databaseHelper(this);
        horoDB = dbHelper.getWritableDatabase();

        mCursor = horoDB.rawQuery("SELECT " + tree_horo_databaseHelper.COL_NAME+ ", "  + tree_horo_databaseHelper.COL_IMAGE
                + ", " + tree_horo_databaseHelper.COL_Tree_PIC + ", " + tree_horo_databaseHelper.COL_INFORMATION + " FROM " + tree_horo_databaseHelper.TABLE_Tree_horo, null);

        mCursor.moveToFirst();
        horo_tree horo;

        while ( !mCursor.isAfterLast() ){
            horo=new horo_tree(0,mCursor.getString(mCursor.getColumnIndex(tree_horo_databaseHelper.COL_NAME)),Integer.valueOf(mCursor.getString(mCursor.getColumnIndex(tree_horo_databaseHelper.COL_IMAGE))),
                    Integer.valueOf(mCursor.getString(mCursor.getColumnIndex(tree_horo_databaseHelper.COL_Tree_PIC))),mCursor.getString(mCursor.getColumnIndex(tree_horo_databaseHelper.COL_INFORMATION)));
            mHoroList.add(horo);
            mCursor.moveToNext();
        }

        final RecyclerView recyclerView = findViewById(R.id.tree_recycler_view);
        mAdapter = new RecyclerViewAdapter(
                horotreeActivity.this,
                R.layout.item_horotree,
                mHoroList
        );
        final LinearLayoutManager lm = new LinearLayoutManager(horotreeActivity.this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mAdapter);







    }
}


