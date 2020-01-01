package com.example.textview;

import android.util.Log;

public class SubClass extends BaseClass{
    private static final String TAG = "MainActivity";
    public void fly(){
        Log.d(TAG,"Subclass class flay");
        super.fly();
    }
}
