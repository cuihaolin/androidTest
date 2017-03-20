package com.m520it.com.draggertest.application;

import android.app.Application;

import com.m520it.com.draggertest.AppComponent;
import com.m520it.com.draggertest.DaggerAppComponent;
import com.m520it.com.draggertest.module.AppModule;
import com.m520it.com.draggertest.module.GithubApiModule;

/**
 * @author Holly
 * @time 2017/3/15  10:46
 * @desc http://www.cnblogs.com/zhuyp1015/p/5119727.html
 */
public class AppApplication extends Application{

    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }
    //生成一个对象
    private void setupCompoent(){
        appComponent = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication getsInstance(){
        return sInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}