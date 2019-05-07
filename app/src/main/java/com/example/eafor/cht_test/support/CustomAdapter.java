package com.example.eafor.cht_test.support;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import com.example.eafor.cht_test.MainActivity;
import com.example.eafor.cht_test.R;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_container, viewGroup, false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(MainActivity.empList.get(i).name);
        viewHolder.skills.setText(MainActivity.empList.get(i).skills);
        viewHolder.phone_number.setText(MainActivity.empList.get(i).phoneNumber);
    }

    @Override
    public int getItemCount() {
        return MainActivity.empList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, skills, phone_number;
        public ViewHolder(View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.box_name);
            skills=itemView.findViewById(R.id.box_skills);
            phone_number=itemView.findViewById(R.id.box_phoneNumber);
        }
    }
}