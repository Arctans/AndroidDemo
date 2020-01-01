package com.example.recyclerviewdemo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//     private RecyclerView v;
//    private RecycleListView v;
    private RecyclerView recyclerView;
    private List<Person> persionList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyRecyclerAdapter());
    }
    public class MyRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder>{

        @NonNull
        @Override
        public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);
            PersonViewHolder personViewHolder = new PersonViewHolder(view,this);
            return personViewHolder;
            //RecyclerView.ViewHolder mhoder = null;
           // return mhoder;
        }

        @Override
        public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        }


        @Override
        public int getItemCount() {
            return persionList.size();
        }
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{

        View rootView;
        TextView textName;
        TextView textContent;
        ImageView imgeContent;
        private RecyclerView.Adapter adapter;
        public PersonViewHolder(View viewItem, RecyclerView.Adapter adapter){
            super(viewItem);
            this.textName = findViewById(R.id.nameID);
            this.textContent = findViewById(R.id.contentID);
            this.textContent = findViewById(R.id.contentID);
            this.imgeContent = findViewById(R.id.headID);
            this.rootView = findViewById(R.id.item_root);
            this.adapter = adapter;
        }

    }

    private void InitData(){

        String[] key = new String[]{"head", "name", "content"};
        String[] name = new String[]{"张三","李四","王五"};
        String[] dispContent = new String[]{"我是一个头","我是两个头","我是三个头"};
        int[] toContent = new int[]{R.id.headID, R.id.nameID, R.id.contentID};
        for(int i = 0;i<name.length;i++){
            persionList.add(new Person(name[i],dispContent[i],R.drawable.ic_launcher_background));
        }
    }


}
