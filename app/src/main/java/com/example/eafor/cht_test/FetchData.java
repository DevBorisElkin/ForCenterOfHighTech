package com.example.eafor.cht_test;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetchData extends AsyncTask<Void, Void, Void> {
    ListView view;
    public FetchData(ListView view) {
        this.view=view;
    }

    String data="";
    private JSONArray jsonArray;
    private List<Employee> localList = new ArrayList<>();
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("http://www.mocky.io/v2/56fa31e0110000f920a72134");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null){
                line = bufferedReader.readLine();
                data = data+line;
            }

            JSONObject jsonObject = new JSONObject(data);
            JSONObject jsonObjectCompany = new JSONObject(jsonObject.get("company").toString());
          //  JSONObject jsonObjectEmployees = new JSONObject(jsonObjectCompany.get("employees").toString());
            jsonArray = new JSONArray(jsonObjectCompany.get("employees").toString());

            for(int i=0; i<jsonArray.length();i++){
                JSONObject object = (JSONObject)jsonArray.get(i);
                String skills = object.get("skills").toString();
                skills=skills.replace("\"","").replace("[","").replace("]","");
                localList.add(new Employee(object.get("name").toString(),object.get("phone_number").toString(),skills));
            }
            Employee.sortArrayList(localList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

       MainActivity.empList = new ArrayList<>(localList);
       localList=null;
       CustomAdapter adapter = new CustomAdapter();
       view.setAdapter(adapter);
    }
}
