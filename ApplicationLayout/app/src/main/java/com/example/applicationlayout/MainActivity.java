package com.example.applicationlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int[] TextViewID=new int[]{R.id.view0,R.id.view1,R.id.view2,R.id.view3,
                                        R.id.view4,R.id.view5,R.id.view6};

    private TextView views[] = new TextView[TextViewID.length];
    private Handler handler = new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Ztl_findView();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);

    }

    public void Ztl_findView(){
        for(int i= 0;i<TextViewID.length;i++){
            views[i]=  findViewById(TextViewID[i]);
        }
    }
    public class MyHandler extends Handler{

        private int currentColor = 0;
        private int [] colors =new int[]{R.color.color0,R.color.color1,R.color.color2,R.color.color3,
                                            R.color.color4,R.color.color5,R.color.color6} ;
        @Override
        public void handleMessage(Message msg) {

              if(msg.what==0x123){
                for(int i = 0;i<TextViewID.length;i++){
//                    views[i].setBackgroundResource(colors[(i+currentColor)%colors.length]);
                    views[i].setBackgroundResource(colors[(int)(Math.random()*100)%colors.length]);

                }
                currentColor++;
              }
              super.handleMessage(msg);
        }
    }


}
