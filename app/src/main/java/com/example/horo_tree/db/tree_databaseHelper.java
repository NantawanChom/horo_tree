package com.example.horo_tree.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.horo_tree.R;

public class tree_databaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "treeList_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_Tree = "tree_List";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_PLACE =
            "CREATE TABLE " + TABLE_Tree + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_IMAGE + " INTEGER ) ";

    public tree_databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLACE);

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "แก้ว");
        cv.put(COL_IMAGE, R.drawable.glass_tree);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "วาสนา");
        cv.put(COL_IMAGE, R.drawable.vassana_tree);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "โป๊ยเซียน");
        cv.put(COL_IMAGE, R.drawable.poisian_tree);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "กุหลาบ");
        cv.put(COL_IMAGE, R.drawable.rose);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ต้นไผ่");
        cv.put(COL_IMAGE, R.drawable.bamboo);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราชพฤกษ์");
        cv.put(COL_IMAGE, R.drawable.ratchaphruek);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เข็ม");
        cv.put(COL_IMAGE, R.drawable.spike_flower);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เฟื่องฟ้า");
        cv.put(COL_IMAGE, R.drawable.bougainvillea);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "บอนไซ");
        cv.put(COL_IMAGE, R.drawable.bonsai);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "กล้วยไม้");
        cv.put(COL_IMAGE, R.drawable.orchid);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "โมก");
        cv.put(COL_IMAGE, R.drawable.mok);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "กล้วย");
        cv.put(COL_IMAGE, R.drawable.banana);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "มะม่วง");
        cv.put(COL_IMAGE, R.drawable.mango);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "มะยม");
        cv.put(COL_IMAGE, R.drawable.mayoom);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "มะขาม");
        cv.put(COL_IMAGE, R.drawable.tamarind);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ส้มโอ");
        cv.put(COL_IMAGE, R.drawable.somo);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ทับทิม");
        cv.put(COL_IMAGE, R.drawable.tubtim);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ชมพู่");
        cv.put(COL_IMAGE, R.drawable.rose_apple);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "พลูด่าง");
        cv.put(COL_IMAGE, R.drawable.spotted_betel);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ขนุน");
        cv.put(COL_IMAGE, R.drawable.jackfruit);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "จำปี");
        cv.put(COL_IMAGE, R.drawable.joompee);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "สนฉัตร");
        cv.put(COL_IMAGE, R.drawable.son_chat);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "หมากแดง");
        cv.put(COL_IMAGE, R.drawable.markdaeng);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ปาล์ม");
        cv.put(COL_IMAGE, R.drawable.palm);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "โกสน");
        cv.put(COL_IMAGE, R.drawable.goson);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "จำปา");
        cv.put(COL_IMAGE, R.drawable.joompa);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เฟิร์นข้าหลวง");
        cv.put(COL_IMAGE, R.drawable.fern);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "พวงแสด");
        cv.put(COL_IMAGE, R.drawable.orange);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ว่านสี่ทิศ");
        cv.put(COL_IMAGE, R.drawable.aloe_four);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เบญจมาศ");
        cv.put(COL_IMAGE, R.drawable.chrysanthemums);
        db.insert(TABLE_Tree, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "บัว");
        cv.put(COL_IMAGE, R.drawable.lotus);
        db.insert(TABLE_Tree, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
