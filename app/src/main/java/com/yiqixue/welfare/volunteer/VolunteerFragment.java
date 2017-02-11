package com.yiqixue.welfare.volunteer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yiqixue.R;

/**
 * 文件名：VolunteerFragment
 * 描  述：公益招募界面
 * 作  者：Yaozhong
 * 时  间：
 */
public class VolunteerFragment extends Fragment {


    private View rootView;

    private int myDataset[] = {42, 11, 32, 85, 74, 50, 69, 10, 20};//模拟数据

    public VolunteerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_volunteer, container, false);

        setUpPullToRefreshView();//下拉刷新

        setUpRecyclerView();//结果列表

        return rootView;


    }

    private void setUpPullToRefreshView() {

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.theme);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    private void setUpRecyclerView() {

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        VolunteerRvAdapter mAdapter = new VolunteerRvAdapter(myDataset, getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }


}
