package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.btn_Math);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MathActivity.class);
                startActivity(intent);
            }
        });
        button2=(Button)findViewById(R.id.btn_Sci);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ScienceActivity.class);
                startActivity(intent);
            }
        });
        button3=(Button)findViewById(R.id.btn_Korean);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KoreanActivity.class);
                startActivity(intent);
            }
        });
        button4=(Button)findViewById(R.id.btn_Eng);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EnglishActivity.class);
                startActivity(intent);
            }
        });
        button5=(Button)findViewById(R.id.btn_WIKI);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WIKI.class);
                startActivity(intent);
            }
        });
        button6=(Button)findViewById(R.id.btn_Inquiry);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InquiryActivity.class);
                startActivity(intent);
            }
        });
    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-lastTimeBackPressed<1500)
        {
            moveTaskToBack(true);
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            return;
        }
        Toast.makeText(this,"'뒤로가기'버튼을 한 번 더 누르시면 종료 됩니다",Toast.LENGTH_LONG).show();
        lastTimeBackPressed=System.currentTimeMillis();
    }
}
