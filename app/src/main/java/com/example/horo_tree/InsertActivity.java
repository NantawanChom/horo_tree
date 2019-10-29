package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.horo_tree.model.Favorites_Tree;
import com.example.horo_tree.room_db.FavoriteRepository;

public class InsertActivity extends AppCompatActivity {

    private static final int PIC_IMAGE=1;

    private ImageView image=null;
    //private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);




        Button upload=findViewById(R.id.upload_pic_button);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( );
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Select app to pick image"), PIC_IMAGE);
            }
        });


        Button home=findViewById(R.id.home_save_tree_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( InsertActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button back=findViewById(R.id.back_save_tree_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( InsertActivity.this, FavoritesActivity.class);
                startActivity(intent);
                finish();
            }
        });



        Button save=findViewById(R.id.save_data_button);

     /*  save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameInput = findViewById(R.id.save_name_tree_edittext);
                final String name = nameInput.getText().toString();

                Favorites_Tree favor=new Favorites_Tree(0,name,R.drawable.ic_launcher_background);
                FavoriteRepository repo= new FavoriteRepository(InsertActivity.this);
                repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                    @Override
                   public void onInsertSuccess() {
                        Toast t = Toast.makeText(InsertActivity.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                       t.show();
                    }
                });
            }
        });*/




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameInput = findViewById(R.id.save_name_tree_edittext);
                final String name = nameInput.getText().toString();
                if(name.length() > 0){
                    if(image!=null){
                        Favorites_Tree favor=new Favorites_Tree(0,name,image.getId());
                        FavoriteRepository repo= new FavoriteRepository(InsertActivity.this);
                        repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                            @Override
                            public void onInsertSuccess() {
                                Toast t = Toast.makeText(InsertActivity.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                                t.show();
                            }
                        });
                    }else{
                        if(image==null){
                            Favorites_Tree favor=new Favorites_Tree(0,name,R.drawable.android_logo);
                            FavoriteRepository repo= new FavoriteRepository(InsertActivity.this);
                            repo.insertFavorite(favor, new FavoriteRepository.InsertCallback() {
                                @Override
                                public void onInsertSuccess() {
                                    Toast t = Toast.makeText(InsertActivity.this,"เพิ่มต้นไม้ลงในรายการที่ชื่นชอบเรียบร้อยแล้ว",Toast.LENGTH_SHORT);
                                    t.show();
                                }
                            });
                        }
                    }
                }else{
                    Toast t = Toast.makeText(InsertActivity.this,"กรุณาใส่ชื่อต้นไม้",Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent returnedIntent){
        super.onActivityResult(requestCode, resultCode,returnedIntent);

        switch (requestCode){
            case PIC_IMAGE:
                if(resultCode == RESULT_OK){
                    Uri imageUri = returnedIntent.getData();
                    String msg = "URI: " + imageUri + "\n";

                    String imagePath = findPath(imageUri);
                    msg += "Path: " + imagePath;

                    //text.setText(msg); เอาไว้ show ใน TextView

                    Bitmap imageData = BitmapFactory.decodeFile(imagePath);
                    image.setImageBitmap(imageData);
                    image.setImageBitmap(imageData);
                }
        }

    }

    private String findPath(Uri uri){
        String imagePath;

        String[] columns = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, columns, null,null, null);

        if (cursor != null) { // กรณีของแอพ Gallery
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(
                    MediaStore.Images.Media.DATA);

            imagePath = cursor.getString(columnIndex);
        }else{ // กรณีของแอพอื่นๆ เช่น OI File Manager, ASTRO File Manager
            imagePath = uri.getPath();
        }

        return imagePath;
    }
}
