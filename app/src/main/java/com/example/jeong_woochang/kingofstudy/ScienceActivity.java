package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScienceActivity extends AppCompatActivity {

    Button btn_Science1,btn_Science2,btn_Science3,btn_Science4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        btn_Science1=(Button)findViewById(R.id.btn_Sci1);
        btn_Science1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScienceActivity.this,Science1Activity.class);
                startActivity(intent);
            }
        });
        btn_Science2=(Button)findViewById(R.id.btn_Sci2);
        btn_Science2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScienceActivity.this,Science2Activity.class);
                startActivity(intent);
            }
        });
        btn_Science3=(Button)findViewById(R.id.btn_Sci3);
        btn_Science3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScienceActivity.this,Science3Activity.class);
                startActivity(intent);
            }
        });
        btn_Science4=(Button)findViewById(R.id.btn_Sci4);
        btn_Science4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScienceActivity.this,Science4Activity.class);
                startActivity(intent);
            }
        });
    }
}
