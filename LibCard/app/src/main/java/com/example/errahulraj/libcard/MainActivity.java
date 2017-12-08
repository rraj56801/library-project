package com.example.errahulraj.libcard;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    LinearLayout linearLayout;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.id_webview);
        linearLayout = (LinearLayout) findViewById(R.id.id_linear);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.mHandler = new Handler();
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mWebView.setVisibility(View.VISIBLE);
            mWebView.loadUrl("http://libcard.co.in/");

        } else {
            linearLayout.setVisibility(View.VISIBLE);
            m_Runnable.run();
        }

    }
    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            //Toast.makeText(MainActivity.this,"in runnable",Toast.LENGTH_SHORT).show();
            MainActivity.this.mHandler.postDelayed(m_Runnable,40000);
        }

    };
}

