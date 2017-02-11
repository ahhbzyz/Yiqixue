package com.yiqixue.club.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：EventLvAdapter
 * 描  述：社团活动界面列表的适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class EventLvAdapter extends BaseAdapter {
    private Context context;

    private final String[] myDataset;
    private final String[] myDataset2;

    public EventLvAdapter(Context context, String[] myDataset, String[] myDataset2) {
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
            listView = inflater.inflate(R.layout.listview_item_event, null);

            //绑定模拟数据
            TextView tvEventTitle = (TextView) listView.findViewById(R.id.tv_event_title);
            tvEventTitle.setText(myDataset[position]);
            //绑定模拟数据
            TextView tvClubName = (TextView) listView.findViewById(R.id.tv_club_name);
            tvClubName.setText(myDataset2[position]);

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
