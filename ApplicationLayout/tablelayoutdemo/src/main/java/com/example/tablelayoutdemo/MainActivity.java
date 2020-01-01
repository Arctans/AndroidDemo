package com.example.tablelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tv ;
    private RadioGroup rg;
    private LinearLayout linearLayout;
    private MyCheckListner myCheckListner;
    private ToggleButton togBn;
    private Switch swBn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        togglebutton_init();

//        TableLayout_init();
    }

    private void togglebutton_init(){
        setContentView(R.layout.togglebutton);
         linearLayout = findViewById(R.id.test);
        togBn = findViewById(R.id.togBn);
        swBn = findViewById(R.id.swBn);


        togBn.setOnCheckedChangeListener(mListner);
        swBn.setOnCheckedChangeListener(mListner);



    }

    private CompoundButton.OnCheckedChangeListener mListner = (buttonView,checkId)->{
        Log.d(TAG,"check id enter "+checkId);
            if(checkId){
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                togBn.setChecked(true);
                swBn.setChecked(true);

        }else {

                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                togBn.setChecked(false);
                swBn.setChecked(false);
        }
        Log.d(TAG,"check id exit "+checkId);
    };

    private void TableLayout_init(){
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        tv = findViewById(R.id.show);
        myCheckListner = new MyCheckListner();
        linearLayout = findViewById(R.id.checkLiner);
        rg.setOnCheckedChangeListener((group,checkedId)->{
            String trip = checkedId == R.id.male?"你选择了女性":"你选择了男性";
            tv.setText(trip);
        });

        this.CheckSet();
    }
    private void CheckSet(){
        ((CheckBox)findViewById(R.id.checkRed)).setOnCheckedChangeListener(myCheckListner);
        ((CheckBox)findViewById(R.id.checkBlue)).setOnCheckedChangeListener(myCheckListner);
        ((CheckBox)findViewById(R.id.checkGreen)).setOnCheckedChangeListener(myCheckListner);
    }

    public class MyCheckListner implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int id = buttonView.getId();
            if(id == R.id.checkBlue){
                Log.d(TAG, "onCheckedChanged: bulue checkout");
            }
            if(isChecked){
                //用户点击的复选框的内容
                String text=buttonView.getText().toString();
                Log.d(TAG,"id="+id+"text=" + text + ",isChecked=" + isChecked);
                Log.d(TAG,"当前控件处于选中状态");
            }else{
                Log.d(TAG,"id="+id+"当前控件取消了选中状态");
            }


        }
    }
}
