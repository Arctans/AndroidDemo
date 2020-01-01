package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SubClass subClass = new SubClass();
        BaseClass baseClass = new SubClass();

        subClass.fly();
        baseClass.fly();
    }
}
