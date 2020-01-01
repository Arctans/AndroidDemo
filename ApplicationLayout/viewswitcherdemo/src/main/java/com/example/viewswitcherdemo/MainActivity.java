package com.example.viewswitcherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewSwitcher viewSwitcher;
    public static final int NUMBER_PER_SCREEN = 12;
    private List<DataItem> mList = new ArrayList<>();
    private int screenCount = 0;
    private int screenNo = -1;

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if(screenNo == screenCount-1&&mList.size()%NUMBER_PER_SCREEN!=0){
                return mList.size()%NUMBER_PER_SCREEN;
            }else{
                return NUMBER_PER_SCREEN;
            }
        }

        @Override
        public DataItem getItem(int position) {
            return mList.get(screenNo*NUMBER_PER_SCREEN+position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder viewHolder;
            if(convertView!=null){
                view = View.inflate(MainActivity.this,R.layout.labelicon,null);
                ImageView imageView = view.findViewById(R.id.imageviewID);
                TextView textView   = view.findViewById(R.id.textviewID);
                viewHolder = new ViewHolder(imageView,textView);
                view.setTag(viewHolder);
            }else{
                view = convertView;
                viewHolder = (ViewHolder)view.getTag();
            }
            viewHolder.imageView.setImageDrawable(getItem(position).drawable);
            viewHolder.textView.setText(getItem(position).dataName);
            return view;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        viewSwitcher = findViewById(R.id.viewSwitcherID);

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView() {
                return LayoutInflater.from(MainActivity.this).inflate(R.layout.sliderlistview,null);
            }
        });
        next(null);

    }

    public void next(View v){
        if(screenNo<screenCount-1){
            screenNo++;
//            viewSwitcher.setImportantForAccessibility(this.R.anim.slide_in_right);
            viewSwitcher.setInAnimation(this,R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this,R.anim.slide_out_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

    public void prev(View v){
        if(screenNo>0){
            screenNo--;
//            viewSwitcher.setImportantForAccessibility(this.R.anim.slide_in_right);
            viewSwitcher.setInAnimation(this,R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this,R.anim.slide_out_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.NextID:
                break;

            case R.id.PrevID:

                 break;

            default:
                 break;
        }
    }

    public static class ViewHolder {
        ImageView imageView;
        TextView textView;
        ViewHolder(ImageView imageView , TextView textView){
            this.imageView = imageView;
            this.textView = textView;
        }
    }
    public static  class DataItem {
          String dataName;
          Drawable drawable;
          DataItem(String dataName,Drawable drawable){
              this.dataName = dataName;
              this.drawable = drawable;
          }
    }

    public void initData(){
        for(int i =0;i<61;i++){
            DataItem mData = new DataItem(""+i,getResources().getDrawable(R.mipmap.ic_launcher_round));
            mList.add(mData);
        }
        screenCount = mList.size()%NUMBER_PER_SCREEN ==0?
                      mList.size()/NUMBER_PER_SCREEN:mList.size()/NUMBER_PER_SCREEN+1;
    }
}
