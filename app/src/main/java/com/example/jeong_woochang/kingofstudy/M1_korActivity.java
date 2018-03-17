package com.example.jeong_woochang.kingofstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class M1_korActivity extends AppCompatActivity {

    WebView webView;
    WebSettings websettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_kor);

        webView=(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://chad76.cafe24.com/WIKI/index.php/%EB%AC%B8%EB%B2%95:%EB%8B%A8%EC%96%B4");
    }
}
