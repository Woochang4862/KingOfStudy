package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        Button btn1,btn2,btn3,btn4;
        btn1=(Button)findViewById(R.id.btn_Calculator1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this,MathCalcurator1Activity.class);
                startActivity(intent);
            }
        });
        btn2=(Button)findViewById(R.id.btn_Calculator2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this, MathCalcurator2Activity.class);
                startActivity(intent);
            }
        });
        btn3=(Button)findViewById(R.id.btn_Calculator3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this, MathCalcurator3Activity.class);
                startActivity(intent);
            }
        });
        btn4=(Button)findViewById(R.id.btn_formula);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MathActivity.this,MathFormulaActivity.class);
                startActivity(intent);
            }
        });
    }
}
