package com.example.monajuwitas.suratapl.Utils;

import android.app.Application;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/MFthin.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
}