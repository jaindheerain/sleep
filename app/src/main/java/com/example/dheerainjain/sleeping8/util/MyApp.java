package com.example.dheerainjain.sleeping8.util;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "SERIF", "fonts/montserratmedium.otf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/montserratmedium.otf");

    }
}
