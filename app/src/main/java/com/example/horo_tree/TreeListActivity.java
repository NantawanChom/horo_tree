package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.horo_tree.adapter.RecyclerViewAdapter_TreeList;
import com.example.horo_tree.db.tree_databaseHelper;
import com.example.horo_tree.model.Favorites_Tree;
import com.example.horo_tree.model.Tree;
import com.example.horo_tree.room_db.FavoriteRepository;

import java.util.ArrayList;
import java.util.List;

public class TreeListActivity extends AppCompatActivity {

    private List<Tree> mTreeList = new ArrayList<>();
    tree_databaseHelper dbHelper;
    SQLiteDatabase treeDB;
    Cursor mCursor;
    private RecyclerViewAdapter_TreeList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_list);

        Button home = findViewById(R.id.home_tree_list_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TreeListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        dbHelper=new tree_databaseHelper(this);
        treeDB = dbHelper.getWritableDatabase();

        mCursor = treeDB.rawQuery("SELECT " + tree_databaseHelper.COL_NAME+ ", "  + tree_databaseHelper.COL_IMAGE
                 + " FROM " + tree_databaseHelper.TABLE_Tree, null);

        mCursor.moveToFirst();
        Tree tree;

        while ( !mCursor.isAfterLast() ){
            tree=new Tree(0,mCursor.getString(mCursor.getColumnIndex(tree_databaseHelper.COL_NAME)),Integer.valueOf(mCursor.getString(mCursor.getColumnIndex(tree_databaseHelper.COL_IMAGE))));
            mTreeList.add(tree);
            mCursor.moveToNext();
        }


        final RecyclerView recyclerView = findViewById(R.id.Tree_List_recycler_view);
        mAdapter = new RecyclerViewAdapter_TreeList(
                TreeListActivity.this,
                R.layout.tree_list_item,
                mTreeList
        );


        final LinearLayoutManager lm = new LinearLayoutManager(TreeListActivity.this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mAdapter);


    }


}
