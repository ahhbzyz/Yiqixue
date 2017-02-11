package com.yiqixue.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.yiqixue.R;
/**
 * 文件名：TextSliderView
 * 描  述：SliderView中的TextSliderView
 * 作  者：yaozhong
 * 时  间：
 */
public class TextSliderView extends BaseSliderView {
    public TextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.view_slider_textview,null);
        ImageView target = (ImageView)v.findViewById(R.id.daimajia_slider_image);
        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}