package com.example.simpleadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    SimpleAdapter mSimpleAdapter ;
    List<Map<String,Object>> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] key = new String[]{"head", "name", "content"};
        String[] name = new String[]{"张三","李四","王五"};
        String[] dispContent = new String[]{"我是一个头","我是两个头","我是三个头"};
        int[] toContent = new int[]{R.id.headID, R.id.nameID, R.id.contentID};

        for (int i = 0;i<key.length;i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put(key[0],R.drawable.ic_launcher_background);
            listItem.put(key[1],name[i]);
            listItem.put(key[2],dispContent[i]);
            mList.add(listItem);
        }


        mSimpleAdapter = new SimpleAdapter(this ,mList,R.layout.simple_item,key,toContent);
        ListView listView = findViewById(R.id.ListID);
        listView.setAdapter(mSimpleAdapter);

    }
}
