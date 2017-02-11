package com.yiqixue.welfare.volunteer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yiqixue.R;

/**
 * 文件名：VolunteerRvAdapter
 * 描  述：公益招募项目适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class VolunteerRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private int[] mDataset;
    private Context context;
    private static final int TYPE_ITEM = 1;


    //项目item的View
    public class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView tvProjectTitle, tvProjectDonorNum;
        public RelativeLayout layoutProjectItem;

        public VHItem(View view) {
            super(view);
            tvProjectTitle = (TextView) view.findViewById(R.id.tv_project_title);
            tvProjectDonorNum = (TextView) view.findViewById(R.id.tv_project_donor_num);

            view.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            //跳转至VolunteerInfoActivity界面
            Intent intent = new Intent(context, VolunteerInfoActivity.class);
            intent.putExtra("participantsNum", mDataset);
            intent.putExtra("position", getPosition());
            context.startActivity(intent);


        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VolunteerRvAdapter(int[] myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_volunteer, parent, false);
            //inflate your layout and pass it to view holder


            return new VHItem(v);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (holder instanceof VHItem) {
            //cast holder to VHItem and set data
            ((VHItem) holder).tvProjectDonorNum.setText(mDataset[position] + "");
        }


    }

    @Override
    public int getItemViewType(int position) {


        return TYPE_ITEM;
    }


    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
