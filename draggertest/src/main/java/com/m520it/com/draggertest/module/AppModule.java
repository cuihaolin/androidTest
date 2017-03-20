package com.m520it.com.draggertest.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * @author Holly
 * @time 2017/3/15  10:50
 * @desc ${TODD}
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }
}