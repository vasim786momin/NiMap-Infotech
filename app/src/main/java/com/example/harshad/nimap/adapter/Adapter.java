package com.example.harshad.nimap.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.harshad.nimap.R;
import com.example.harshad.nimap.model.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by harshad on 24/08/2017.
 */


public class Adapter extends BaseAdapter {

    ArrayList<Data>dataArrayList;
    Context context;
    String url;
    HashMap<String,String> url_map;

    public Adapter(Context context,ArrayList<Data>list){
        this.context=context;
        this.dataArrayList=list;
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Holder holder;
        if(convertView==null){
            holder=new Holder();
            convertView=View.inflate(context, R.layout.list_item,null);
            holder.txtView= (TextView) convertView.findViewById(R.id.txtView);
            holder.slider= (SliderLayout) convertView.findViewById(R.id.slider);
            convertView.setTag(holder);

        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.txtView.setText(dataArrayList.get(position).getCategoryName());


        for(Data.CategoryImage categoryImage:dataArrayList.get(position).getCategoryImageArrayList()){
             url_map=new HashMap<>();
             url=categoryImage.getIphoneImage();
            url = url.replaceAll(" ", "%20");
            Log.d("test","url12:"+url);

            url_map.put("", url);


            for (String name : url_map.keySet()) {
                TextSliderView textSliderView = new TextSliderView(context);
                textSliderView
                        .description(name)
                        .image(url_map.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                holder.slider.addSlider(textSliderView);

            }

        }

        holder.slider.setPresetTransformer(SliderLayout.Transformer.Default);
        holder.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
      //  holder.slider.setCustomAnimation(new DescriptionAnimation());
        holder.slider.setDuration(8000);

        return convertView;
    }

    class Holder{
        TextView txtView;
        SliderLayout slider;
    }
}
