package com.guaju.webviewjs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guaju on 2017/9/28.
 */

public class AndroidCallJSActivity extends Activity {
    private static final String TAG = "AndroidCallJSActivity";

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidcalljs);
        ButterKnife.bind(this);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        String url="file:///android_asset/test.html";
        webview.loadUrl(url);
    }

    public void calljs(View v) {
        //android调用js
        webview.setWebViewClient(new WebViewClient(){

        });

        webview.loadUrl("javascript:hello()");
//        webview.evaluateJavascript("hello()", new ValueCallback<String>() {
//            @Override
//            public void onReceiveValue(String value) {
//                //获取返回值之后怎么做
//                Log.e(TAG, "onReceiveValue: "+value );
//            }
//        });

    }
}
