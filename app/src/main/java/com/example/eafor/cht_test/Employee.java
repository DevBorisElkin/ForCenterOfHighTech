package com.example.eafor.cht_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    public String name;
    public String phoneNumber;
    public String skills;

    public Employee(String name, String phoneNumber, String skills) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSkills() {
        return skills;
    }

    public static void sortArrayList(List<Employee>list){
        Collections.sort(list, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    }
}



