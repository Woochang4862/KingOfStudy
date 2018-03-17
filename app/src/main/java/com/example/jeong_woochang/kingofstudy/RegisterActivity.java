package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private boolean validate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText=(EditText)findViewById(R.id.idText);
        final EditText passwordText=(EditText)findViewById(R.id.passwordText);
        final EditText nicnameText =(EditText)findViewById(R.id.nicnameText);
        final EditText mailText=(EditText)findViewById(R.id.mailText);
        final Button validateButton =(Button)findViewById(R.id.ValidateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID=idText.getText().toString();
                if(validate)
                {
                    return;
                }
                if(userID.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"아이디를 입력해주세요",Toast.LENGTH_LONG).show();
                    return;
                }
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(),"아이디를 사용하실 수 있습니다",Toast.LENGTH_LONG).show();
                                idText.setEnabled(false);
                                validate=true;
                                idText.setBackgroundResource(R.color.colorGray);
                                validateButton.setBackgroundResource(R.color.colorGray);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"아이디를 사용할 수 없습니다",Toast.LENGTH_LONG).show();
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest=new ValidateRequest(userID,responseListener);
                RequestQueue queue=Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });
        Button registerButton=(Button)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID=idText.getText().toString();
                String userPassword=passwordText.getText().toString();
                String userNicname=nicnameText.getText().toString();
                String userMail=mailText.getText().toString();

                if(!validate)
                {
                    Toast.makeText(getApplicationContext(),"중복체크를 해주세요",Toast.LENGTH_LONG).show();
                    return;
                }
                if(userID.equals("")||userPassword.equals("")||userMail.equals("")||userNicname.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"빈칸을 모두 체워주세요",Toast.LENGTH_LONG).show();
                    return;
                }
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원 가입을 성공하였습니다", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "회원 가입을 실패하였습니다", Toast.LENGTH_LONG).show();
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest=new RegisterRequest(userID,userPassword,userNicname,userMail,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
