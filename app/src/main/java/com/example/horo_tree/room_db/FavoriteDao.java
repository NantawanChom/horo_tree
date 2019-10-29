package com.example.horo_tree.room_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.horo_tree.model.Favorites_Tree;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Query("SELECT * FROM favorites_tree")
    List<Favorites_Tree> getAll();

    @Insert
    void insert(Favorites_Tree ledgerItem);

    @Delete
    void delete(Favorites_Tree ledgerItem);
}
