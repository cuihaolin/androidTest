package com.m520it.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "我是一个新的版本", Toast.LENGTH_SHORT).show();
    }
}