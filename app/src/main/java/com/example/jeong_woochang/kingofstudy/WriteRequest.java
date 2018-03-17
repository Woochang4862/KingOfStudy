package com.example.jeong_woochang.kingofstudy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeong-woochang on 2017. 10. 7..
 */

public class WriteRequest extends StringRequest {

    final static private  String URL="http://chad76.cafe24.com/WriteBoard.php";
    private Map<String, String> parameters;

    public  WriteRequest(String bulletinTitle, String bulletinSubject, String bulletinGrade, String bulletinContent, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters= new HashMap<>();
        parameters.put("bulletinTitle", bulletinTitle);
        parameters.put("bulletinSubject", bulletinSubject);
        parameters.put("bulletGrade", bulletinGrade);
        parameters.put("bulletContent", bulletinContent);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
