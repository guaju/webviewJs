package com.guaju.webviewjs.model;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.guaju.webviewjs.App;

/**
 * Created by guaju on 2017/9/28.
 */

public class ToastUtils {
   @JavascriptInterface
  public void  showToast(String name){

      Toast.makeText(App.appContext, name, Toast.LENGTH_SHORT).show();

  }

}
