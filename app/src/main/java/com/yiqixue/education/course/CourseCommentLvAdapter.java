package com.yiqixue.education.course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yiqixue.R;
import com.yiqixue.utils.RatingBarView;

/**
 * 文件名：CourseCommentLvAdapter
 * 描  述：课程评价列表适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class CourseCommentLvAdapter extends BaseAdapter {
    private final String[] myDataset;
    private final int[] myDataset2;
    private Context context;

    public CourseCommentLvAdapter(Context context, String[] myDataset, int[] myDataset2) {
        this.context = context;
        this.myDataset = myDataset;
        this.myDataset2 = myDataset2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listView;


        if (convertView == null) {

            listView = new View(context);

            // get layout from mobile.xml
            listView = inflater.inflate(R.layout.listview_item_comment, null);

            //每条评论的打分
            RatingBarView ratingBar = (RatingBarView) listView.findViewById(R.id.ratingBar);
            ratingBar.setmClickable(false);
            ratingBar.setStar(myDataset2[position]);


            //每条评论的用户名
            TextView mUserNameTv = (TextView) listView.findViewById(R.id.tv_user_name);
            mUserNameTv.setText(myDataset[position]);


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
