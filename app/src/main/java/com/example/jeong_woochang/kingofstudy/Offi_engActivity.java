package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Offi_engActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offi_eng);

        btn1=(Button)findViewById(R.id.btn_M1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Offi_engActivity.this,M1_engActivity.class);
                startActivity(intent);
            }
        });
        btn2=(Button)findViewById(R.id.btn_M2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Offi_engActivity.this,M2_engActivity.class);
                startActivity(intent);
            }
        });
        btn3=(Button)findViewById(R.id.btn_M3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Offi_engActivity.this,M3_engActivity.class);
                startActivity(intent);
            }
        });
    }
}
