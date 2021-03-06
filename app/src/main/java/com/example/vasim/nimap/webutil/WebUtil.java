package com.example.vasim.nimap.webutil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vasim.nimap.R;
import com.example.vasim.nimap.singleTone.VolleySingleTone;

import java.util.Map;

/**
 * Created by vasim on 24/08/2017.
 */

public class WebUtil {


    public static void threadLoadData(Context context, final Handler handler){
        final ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("Please wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        String url=context.getString(R.string.load_data);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Message message=new Message();
                message.obj=response;
                handler.sendMessage(message);
               // Log.d("test","RESPONSE:"+response.toString());
                progressDialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Log.d("test","ERROR:"+error.toString());
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        VolleySingleTone.getmInstance(context).addToRequestQue(stringRequest);

    }

}
