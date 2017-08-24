package com.example.harshad.nimap.singleTone;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by harshad on 24/08/2017.
 */

public class VolleySingleTone {
    private static VolleySingleTone mInstance;
    private static Context context;
    private RequestQueue requestQueue;


    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    private VolleySingleTone(Context context){
        this.context=context;
        requestQueue=getRequestQueue();

    }

    public static synchronized VolleySingleTone getmInstance(Context context){
        if(mInstance==null){
            mInstance=new VolleySingleTone(context);
        }
        return mInstance;
    }

    public<T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }

}
