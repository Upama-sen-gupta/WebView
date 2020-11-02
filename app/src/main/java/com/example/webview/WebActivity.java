package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web=findViewById(R.id.web);

        //for back button &tittle
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(("Web Page"));


        //comments

        //receive url
        String getUrl=getIntent().getExtras().getString("url");
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.loadUrl("http://"+getUrl);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && web.canGoBack())
        {
            web.goBack();
            return true;
        }
        else {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    //for back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if((item.getItemId()==android.R.id.home) && web.canGoBack())
        {
            web.goBack();
            return true;
        }
        else {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


