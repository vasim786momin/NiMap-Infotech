package com.example.harshad.nimap;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.harshad.nimap.webutil.WebUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<Data>dataArrayList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);


        WebUtil.threadLoadData(MainActivity.this,new HandlerLoadData());


    }

    class HandlerLoadData extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg!=null){
                String response= (String) msg.obj;
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    JSONArray jsonArray=jsonObject.getJSONArray("cateloguecategory");
                    Log.d("test","json_array_lenght:"+jsonArray.length());

                    dataArrayList=new ArrayList<>();
                    for(int i=0;i<jsonArray.length();i++){

                        Data data=new Data();

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        data.setCategoryName(jsonObject1.getString("CategoryName"));

                        JSONArray jsonArray1=jsonObject1.getJSONArray("categoryImages");

                        ArrayList<Data.CategoryImage>categoryImageArrayList=new ArrayList<>();
                        for(int j=0;j<jsonArray1.length();j++){
                            Data.CategoryImage categoryImage=new Data.CategoryImage();
                            categoryImage.setIphoneImage(jsonArray1.getJSONObject(j).getString("iphone"));
                            //data.setIphone(jsonArray1.getJSONObject(j).getString("iphone"));
                            Log.d("test","iphone:"+jsonArray1.getJSONObject(j).getString("iphone"));

                            categoryImageArrayList.add(categoryImage);

                        }
                        data.setCategoryImageArrayList(categoryImageArrayList);

                        dataArrayList.add(data);

                        adapter=new Adapter(MainActivity.this,dataArrayList);
                        listView.setAdapter(adapter);


                    }
                    Log.d("test","DATA_SIZE:"+dataArrayList.size());


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
