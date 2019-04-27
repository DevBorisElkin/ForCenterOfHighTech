package com.example.eafor.cht_test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static ListView listView;
    public static List<Employee> empList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listView =findViewById(R.id.listView);

       new FetchData(getApplicationContext()).execute();
    }
}

class CustomAdapter extends BaseAdapter {
    Context context;
    List<Employee>list;
    public CustomAdapter(Context context, List<Employee> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return MainActivity.empList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater. inflate(R.layout.item_container, parent, false);
        TextView name = row.findViewById(R.id.box_name);
        TextView phoneNumber = row.findViewById(R.id.box_phoneNumber);
        TextView skills = row.findViewById(R.id.box_skills);

        name.setText(list.get(position).name);
        phoneNumber.setText("Phone number: "+list.get(position).phoneNumber);
        skills.setText("Skills: "+list.get(position).skills);

        return row;
    }
}
