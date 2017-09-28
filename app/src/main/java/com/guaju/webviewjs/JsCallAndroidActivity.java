package com.guaju.webviewjs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.guaju.webviewjs.model.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guaju on 2017/9/28.
 */

public class JsCallAndroidActivity extends Activity {
    private static final String TAG = "AndroidCallJSActivity";

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jscallandroid);
        ButterKnife.bind(this);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        String url="file:///android_asset/jscalljava.html";
        webview.loadUrl(url);
        //提供一个js接口供js调用
        webview.addJavascriptInterface(new ToastUtils(),"toastutils");
    }

    public void calljs(View v) {
        //android调用js
        webview.setWebViewClient(new WebViewClient(){

        });
    }



}
