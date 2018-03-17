package com.example.jeong_woochang.kingofstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class M2_engActivity extends AppCompatActivity {

    WebView webView;
    WebSettings websettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_eng);

        webView=(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://chad76.cafe24.com/WIKI/index.php/%EC%A4%912%EC%98%81%EC%96%B4");
    }
}
