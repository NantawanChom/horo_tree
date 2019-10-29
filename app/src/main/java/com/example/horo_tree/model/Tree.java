package com.example.horo_tree.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tree")
public class Tree {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "ImageRes")
    public int imageRes;

    public Tree(int id, String name, int imageRes) {
        this.id = id;
        this.name = name;
        this.imageRes = imageRes;
    }
}
