package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btn_DONE=(Button)findViewById(R.id.btn_DONE);

        Intent intent=getIntent();
        String userID=intent.getStringExtra("userID");

        btn_DONE.setText("[WELCOME]\n" +
                "오늘도 열심히\n" +
                "공부 합시다\n"+userID+"님");

        btn_DONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain=new Intent(WelcomeActivity.this, MainActivity.class);
                finish();
                startActivity(intentMain);
            }
        });
    }
}
