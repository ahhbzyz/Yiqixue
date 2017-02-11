package com.yiqixue.education.course;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：CourseRelatedLvAdapter
 * 描  述：相关课程列表适配器
 * 作  者：Yaozhong
 * 时  间：
 */


public class CourseRelatedLvAdapter extends BaseAdapter {
    private Context context;

    private final String[] myDataset;


    public CourseRelatedLvAdapter(Context context, String[] myDataset) {
        this.context = context;
        this.myDataset = myDataset;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listView;


        if (convertView == null) {

            listView = new View(context);

            // get layout from mobile.xml
            listView = inflater.inflate(R.layout.listview_item_course, null);

            //绑定课程名字
            TextView mCourseNameTv = (TextView) listView.findViewById(R.id.tv_course_name);
            mCourseNameTv.setText(myDataset[position]);


        } else {
            listView = (View) convertView;
        }

        return listView;
    }

    @Override
    public int getCount() {
        return myDataset.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
