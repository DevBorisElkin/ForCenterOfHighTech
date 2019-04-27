package com.example.eafor.cht_test;

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
        Employee one, two;
        boolean working=true;
        while (working){
            working=false;
            for(int i=0;i<list.size();i++){
                one = list.get(i);
                two = new Employee("G","G","G");
                if(i+1<list.size()){
                    two=list.get(i+1);
                }
                if(one!=null&!two.getName().equals("G")){
                    char first = one.name.charAt(0);
                    char second = two.name.charAt(0);
                    if((int)first>(int)second){
                        list.set(i, two);
                        list.set(i+1, one);
                        working=true;
                    }
                }
            }
        }
    }
}

