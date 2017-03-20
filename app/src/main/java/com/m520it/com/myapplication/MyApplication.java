package com.m520it.com.myapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author Holly
 * @time 2017/3/14  20:07
 * @desc ${TODD}
 */

    public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
          Fresco.initialize(this);
        }
    }

