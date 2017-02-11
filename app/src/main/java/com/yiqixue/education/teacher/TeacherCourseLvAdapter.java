package com.yiqixue.education.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yiqixue.R;

/**
 * 文件名：TeacherCourseLvAdapter
 * 描  述：老师信息详情页中的课程的适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class TeacherCourseLvAdapter extends BaseAdapter {

    private Context context;
    private final String[] myDataset;

    public TeacherCourseLvAdapter(Context context, String[] myDataset) {
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
