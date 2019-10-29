package com.example.horo_tree.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "horo")
public class horo_tree {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "logoImage")
    public int logoImage;

    @ColumnInfo(name = "TreePic")
    public int TreePic;

    @ColumnInfo(name = "information")
    public String information;

    public horo_tree(int id, String name, int logoImage,int TreePic, String information) {
        this.id = id;
        this.name = name;
        this.logoImage = logoImage;
        this.TreePic=TreePic;
        this.information=information;
    }
}
