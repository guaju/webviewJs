package com.guaju.webviewjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void skip(View v){
        startActivity(new Intent(this,WebViewActivity.class));
    }
    public void showprogress(View v){
        startActivity(new Intent(this,ProgressWebViewActivity.class));
    }
    public void android2js(View v){
        startActivity(new Intent(this,AndroidCallJSActivity.class));
    }
public void js2andorid(View v){
        startActivity(new Intent(this,JsCallAndroidActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
