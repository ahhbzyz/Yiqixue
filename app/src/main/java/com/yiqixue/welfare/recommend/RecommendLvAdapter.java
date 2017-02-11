package com.yiqixue.welfare.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：RecommendLvAdapter
 * 描  述：公益推荐界面 项目列表的适配器
 * 作  者：yaozhong
 * 时  间：
 */
public class RecommendLvAdapter extends BaseAdapter {
    private Context context;

    private final int[] myDataset;


    public RecommendLvAdapter(Context context, int[] myDataset) {
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
            listView = inflater.inflate(R.layout.listview_item_recommend_welfare, null);

            //绑定模拟数据
            TextView tvProjectDonorNum = (TextView) listView.findViewById(R.id.tv_project_donor_num);
            tvProjectDonorNum.setText(myDataset[position] + "");


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
