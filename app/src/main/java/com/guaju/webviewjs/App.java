package com.guaju.webviewjs;

import android.app.Application;
import android.content.Context;

/**
 * Created by guaju on 2017/9/28.
 */

public class App extends Application {
 public  static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext=this;
    }
}
