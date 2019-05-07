package com.example.eafor.cht_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.eafor.cht_test.support.CustomAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public RecyclerView recView;
    public static List<Employee> empList = new ArrayList<>();
    public boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recView =findViewById(R.id.recView);
        new FetchData().execute();
        setAdapter();
    }

    public void setAdapter(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){
                    try {
                        Thread.sleep(10);
                        if(empList.size()>0){
                            running=false;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    CustomAdapter adapter = new CustomAdapter();
                                    recView.setAdapter(adapter);
                                    recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}


