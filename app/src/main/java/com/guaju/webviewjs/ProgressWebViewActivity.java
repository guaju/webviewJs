package com.guaju.webviewjs;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guaju on 2017/9/27.
 */

public class ProgressWebViewActivity extends Activity {
    private static final String TAG = "ProgressWebViewActivity";

    @BindView(R.id.wv)
    WebView wv;
    @BindView(R.id.pb)
    ProgressBar pb;
    private int versionCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progrss_webview);
        ButterKnife.bind(this);
        int sdk = Build.VERSION.SDK_INT;
        Log.e(TAG, "onCreate: "+sdk );
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
//        wv.loadUrl("file:///android_asset/first.html");
        wv.loadUrl("http://blackqwerty.com/");
        initProgress();
    }

    private void initProgress() {
        //设置webview的客户端，让webview自己打开网址，就不会跳转到系统应用中去了
        wv.setWebViewClient(new WebViewClient(){
            private WebResourceRequest webResourceRequest;
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e(TAG, "shouldOverrideUrlLoading: "+url );
                if (url.startsWith("http://blackqwerty.com/2017/09/27/")){
//                    wv.loadUrl("https://www.baidu.com");
                    wv.stopLoading();
//                    return  true;
                }
                return false;
            }
        });
        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                  pb.setProgress(newProgress);
                if (newProgress<100){
                pb.setVisibility(View.VISIBLE);
                wv.setVisibility(view.INVISIBLE);
                }else{
                    wv.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);
                }
            }
        });
    }
}
