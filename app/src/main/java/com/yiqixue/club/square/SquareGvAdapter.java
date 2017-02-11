package com.yiqixue.club.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：SquareGvAdapter
 * 描  述：社团广场界面列表的适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class SquareGvAdapter extends BaseAdapter {
    private Context context;
    private final String[] clubName;
    private final int[] clubLogo;


    public SquareGvAdapter(Context context, String[] clubName, int[] clubLogo) {
        this.context = context;
        this.clubName = clubName;
        this.clubLogo = clubLogo;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.gridview_item_club, null);

            //绑定模拟数据
            TextView textView = (TextView) gridView
                    .findViewById(R.id.tv_club_name);
            textView.setText(clubName[position]);

            //绑定模拟数据
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.img_club_logo);

            //绑定模拟数据
            textView.setText(clubName[position]);
            imageView.setBackgroundResource(clubLogo[position]);


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return clubName.length;
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
