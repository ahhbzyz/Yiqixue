package com.yiqixue.welfare.funding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：FundingParticipantsGvAdapter
 * 描  述：筹款详情的参与用户界面列表的适配器
 * 作  者：Yaozhong
 * 时  间：
 */
public class FundingParticipantsGvAdapter extends BaseAdapter {
    private Context context;
    private final int [] participantsPhotos;
    private final String [] participantsName;

    public FundingParticipantsGvAdapter(Context context, String[] participantsName, int[] participantsPhotos){
        this.context = context;
        this.participantsName = participantsName;
        this.participantsPhotos = participantsPhotos;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            gridView = inflater.inflate(R.layout.gridview_item_participants_gallery, null);

            //绑定模拟数据
            TextView textView = (TextView)gridView.findViewById(R.id.tv_participant_name);
            textView.setText(participantsName[position]);
            ImageView imageView = (ImageView)gridView.findViewById(R.id.img_participants_photo);
            imageView.setImageResource(participantsPhotos[position]);




        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return participantsPhotos.length;
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
