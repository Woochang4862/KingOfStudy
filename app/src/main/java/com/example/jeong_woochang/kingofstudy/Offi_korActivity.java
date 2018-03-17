package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Offi_korActivity extends AppCompatActivity {

    Button btn_M1,btn_M2,btn_M3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offi_kor);

        btn_M1=(Button)findViewById(R.id.btn_M1);
        btn_M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),M1_korActivity.class);
                startActivity(intent);
            }
        });
        btn_M2=(Button)findViewById(R.id.btn_M2);
        btn_M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),M2_korActivity.class);
                startActivity(intent);
            }
        });
        btn_M3=(Button)findViewById(R.id.btn_M3);
        btn_M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),M3_korActivity.class);
                startActivity(intent);
            }
        });
    }
}
