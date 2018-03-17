package com.example.jeong_woochang.kingofstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MathFormulaActivity extends AppCompatActivity {

    WebView webView;
    WebSettings websettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_formula);

        webView=(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://chad76.cafe24.com/WIKI/index.php/%EC%88%98%ED%95%99");
    }
}
