package com.example.horo_tree.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "horo")
public class horo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "image")
    public int image;

    @ColumnInfo(name = "data")
    public String data;

    public horo(String name, int image, String data) {
        this.name = name;
        this.image = image;
        this.data = data;
    }
}
