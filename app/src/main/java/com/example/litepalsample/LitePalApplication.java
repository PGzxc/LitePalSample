package com.example.litepalsample;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by admin on 2018/1/2.
 */

public class LitePalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
