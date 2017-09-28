package com.guaju.webviewjs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guaju on 2017/9/26.
 */

public class WebViewActivity extends Activity {
    private static final String TAG = "WebViewActivity";
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        initWebView();
    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        //若想交互必须启用js
        settings.setJavaScriptEnabled(true);
        //加载页面
        //String first = "content://webviewjs/first.html";
        //"content://com.android.htmlfileprovider/sdcard/index.html");
        webview.loadUrl("file:///android_asset/first.html");
        //如果想判断打开的网页是什么网址
        webview.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = view.getUrl();
                Log.e(TAG, "shouldOverrideUrlLoading: "+url );
                return super.shouldOverrideUrlLoading(view, request);
            }
        });



    }
    public  void back(View v){
        //判断能不能goback
        if (webview.canGoBack()){
            webview.goBack();
        }else{
            finish();
        }

    }

    //当在此页面是，重写返回键的操作

//    @Override
//    public void onBackPressed() {
//        if (webview.canGoBack()){
//            webview.goBack();
//        }else{
//            finish();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (webview.canGoBack()){
                webview.goBack();
            }else{
                finish();
            }
        }
       return true;
    }
}

