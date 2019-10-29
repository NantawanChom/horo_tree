package com.example.horo_tree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HoroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horo);

        Button home = findViewById(R.id.home_horo_activity_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HoroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button calculate = findViewById(R.id.calculate_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dateInput = findViewById(R.id.date_editText);
                int date = Integer.parseInt(dateInput.getText().toString());

                TextView monthInput = findViewById(R.id.month_editText);
                int month = Integer.parseInt(monthInput.getText().toString());

                if((date>=1 && date<=31) && (month>=1 && month<=12)){
                    if(month==4 || month==6 || month==9 || month==11){
                        if(date<=30){
                            // เดือนที่ลงท้ายด้วยยน ต้องไม่เกิน 30 วัน
                            Intent intent = new Intent(HoroActivity.this, HoroDetail.class);
                            intent.putExtra("date", date);
                            intent.putExtra("month", month);
                            startActivity(intent);
                            finish();

                        }else{
                            Toast t = Toast.makeText(HoroActivity.this,"ใส่วันที่ไม่ถูกต้อง",Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                        if(date<=31){
                            //// เดือนที่ลงท้ายด้วยยน ต้องไม่เกิน 31 วัน
                            Intent intent = new Intent(HoroActivity.this, HoroDetail.class);
                            intent.putExtra("date", date);
                            intent.putExtra("month", month);
                            startActivity(intent);
                            finish();

                        }else{
                            Toast t = Toast.makeText(HoroActivity.this,"ใส่วันที่ไม่ถูกต้อง",Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }else if(month==2){
                        if(date<=29){

                            Intent intent = new Intent(HoroActivity.this, HoroDetail.class);
                            intent.putExtra("date", date);
                            intent.putExtra("month", month);
                            startActivity(intent);
                            finish();

                        }else{
                            Toast t = Toast.makeText(HoroActivity.this,"ใส่วันที่ไม่ถูกต้อง",Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }else{
                        // มีข้อผิดพลาด
                        Toast t = Toast.makeText(HoroActivity.this,"ใส่วันทีหรือเดือน่ไม่ถูกต้อง",Toast.LENGTH_SHORT);
                        t.show();
                    }
                }else{
                    // ใส่วันที่หรือเดือนผิด
                    Toast t = Toast.makeText(HoroActivity.this,"ใส่วันทีหรือเดือน่ไม่ถูกต้อง",Toast.LENGTH_SHORT);
                    t.show();
                }


            }
        });


    }
}
