package com.example.horo_tree.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites_tree")
public class Favorites_Tree {

   @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "ImageRes")
    public int imageRes;

    public Favorites_Tree(int id, String name, int imageRes) {
        this.id = id;
        this.name = name;
        this.imageRes = imageRes;
    }
}
