package com.example.jeong_woochang.kingofstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dic_engActivity extends AppCompatActivity {

    private WebView webview;
    private WebSettings websettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic_eng);

        webview = (WebView) findViewById(R.id.web);
        webview.setWebViewClient(new WebViewClient());
        websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);

        webview.loadUrl("http://m.endic.naver.com/");
    }
}
