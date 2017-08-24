package com.example.harshad.nimap;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by harshad on 24/08/2017.
 */

public class Adapter extends BaseAdapter {

    ArrayList<Data>dataArrayList;
    Context context;

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
            convertView=View.inflate(context,R.layout.list_item,null);
            holder.txtView= (TextView) convertView.findViewById(R.id.txtView);
            holder.slider= (SliderLayout) convertView.findViewById(R.id.slider);
            convertView.setTag(holder);

        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.txtView.setText(dataArrayList.get(position).getCategoryName());


        HashMap<String,String> url_map=new HashMap<>();

        String url=dataArrayList.get(position).getIphone();
        url=url.replaceAll(" ","%20");

        for(int i=0;i<dataArrayList.size();i++){

        }
        url_map.put("",url);

        Log.d("test","URL_MAP_KEY_SET:"+url_map.keySet());

        for (String name : url_map.keySet()) {
            TextSliderView textSliderView = new TextSliderView(context);
            textSliderView
                    .description(name)
                    .image(url_map.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            holder.slider.addSlider(textSliderView);

        }
        holder.slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        holder.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
      //  holder.slider.setCustomAnimation(new DescriptionAnimation());
        holder.slider.setDuration(4000);

        return convertView;
    }

    class Holder{
        TextView txtView;
        SliderLayout slider;
    }
}
