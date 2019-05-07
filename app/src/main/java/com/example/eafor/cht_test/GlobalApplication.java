package com.example.eafor.cht_test;

import android.app.Application;
import android.content.Context;

/**
 *  К заданию не относится, но, решил оставить здесь, интересный способ получить Context.
 *
 **/
public class GlobalApplication extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}