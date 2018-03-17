package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;

import static com.example.jeong_woochang.kingofstudy.R.id.nicnameText;

public class WriteActivity extends AppCompatActivity {

    Button writeButton;
    Spinner subjectSpinner,gradeSpinner;
    ArrayAdapter subjectAdapter,gradeAdapter;
    EditText titleText,contentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        titleText=(EditText)findViewById(R.id.titleText);
        contentText=(EditText)findViewById(R.id.contentText);

        subjectSpinner=(Spinner)findViewById(R.id.subjectSpinner);
        gradeSpinner=(Spinner)findViewById(R.id.gradeSpinner);

        subjectAdapter= ArrayAdapter.createFromResource(this,R.array.subject,android.R.layout.simple_dropdown_item_1line);
        subjectSpinner.setAdapter(subjectAdapter);

        gradeAdapter=ArrayAdapter.createFromResource(this,R.array.grade,android.R.layout.simple_dropdown_item_1line);
        gradeSpinner.setAdapter(gradeAdapter);

        writeButton=(Button)findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bulletinTitle = titleText.getText().toString();
                String bulletinSubject=subjectSpinner.getSelectedItem().toString();
                String bulletinGrade = gradeSpinner.getSelectedItem().toString();
                String bulletinContent = contentText.getText().toString();

                if (bulletinTitle.equals("") || bulletinContent.equals("")) {
                    Toast.makeText(getApplicationContext(), "빈칸을 모두 체워주세요", Toast.LENGTH_LONG).show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "글 쓰기를 성공하였습니다", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(WriteActivity.this, PediaActivity.class);
                                finish();
                                WriteActivity.this.startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "글 쓰기를 실패하였습니다", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                WriteRequest writeRequest=new WriteRequest(bulletinTitle,bulletinSubject,bulletinGrade,bulletinContent,responseListener);
                RequestQueue queue =Volley.newRequestQueue(WriteActivity.this);
                queue.add(writeRequest);
            }
        });
    }
}