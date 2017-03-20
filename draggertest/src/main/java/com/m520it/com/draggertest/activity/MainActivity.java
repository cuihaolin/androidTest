package com.m520it.com.draggertest.activity;

import android.content.Intent;
import android.os.Bundle;

import com.m520it.com.draggertest.AppComponent;
import com.m520it.com.draggertest.R;
import com.m520it.com.draggertest.activity.BaseActivity;
import com.m520it.com.draggertest.activity.ReposListActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.showButton)
    public void onShowRepositoriesClick() {
        startActivity(new Intent(this, ReposListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent){

    }
}