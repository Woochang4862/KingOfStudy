package com.example.jeong_woochang.kingofstudy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeong-woochang on 2017. 10. 7..
 */

public class RegisterRequest extends StringRequest {

    final static private  String URL="http://chad76.cafe24.com/Register.php";
    private Map<String, String> parameters;

    public  RegisterRequest(String userID, String userPassword, String userNicname, String userMail, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters= new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userNicname", userNicname);
        parameters.put("userMail", userMail);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
