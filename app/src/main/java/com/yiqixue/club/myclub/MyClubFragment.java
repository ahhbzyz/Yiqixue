package com.yiqixue.club.myclub;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.yiqixue.R;
import com.yiqixue.club.clubinfo.ClubInfoActivity;
import com.yiqixue.club.event.EventInfoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 文件名：MyClubFragment
 * 描  述：我的社团界面
 * 作  者：Yaozhong
 * 时  间：
 */
public class MyClubFragment extends Fragment {

    private ClubExpandableListAdapter expListAdapter;
    private ExpandableListView expListView;
    private List<String> mDataParent;
    private HashMap<String, List<String>> mDataChild;

    private View rootView;

    public MyClubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_myclub, container, false);

        //模拟数据
        prepareListData();

        //设置可扩展列表
        expListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        expListAdapter = new ClubExpandableListAdapter(getActivity(), mDataParent, mDataChild);
        expListView.setAdapter(expListAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //点击子列表跳转到相应界面
                if (groupPosition == 0) {

                    Intent intent = new Intent(getActivity(), ClubInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("position", "member");
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else if (groupPosition == 1) {

                    Intent intent = new Intent(getActivity(), ClubInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("position", "leader");
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else if (groupPosition == 2) {

                    Intent intent = new Intent(getActivity(), EventInfoActivity.class);
                    startActivity(intent);

                } else if (groupPosition == 3) {

                    Intent intent = new Intent(getActivity(), EventInfoActivity.class);
                    startActivity(intent);

                }

                return false;
            }
        });

        return rootView;
    }


    private void prepareListData() {
        mDataParent = new ArrayList<>();
        mDataChild = new HashMap<>();

        // Adding child data
        mDataParent.add("我参加的社团");
        mDataParent.add("我管理的社团");
        mDataParent.add("我关注的活动");
        mDataParent.add("我参与的活动");

        // Adding child data
        List<String> mJoinedClub = new ArrayList<>();
        mJoinedClub.add("青年志愿者协会");
        mJoinedClub.add("轮滑社");
        mJoinedClub.add("电影社");
        mJoinedClub.add("舞蹈社");


        List<String> mManagedClub = new ArrayList<>();
        mManagedClub.add("社团联");

        List<String> mFollowedEvent = new ArrayList<>();
        mFollowedEvent.add("青协迎新志愿者活动");
        mFollowedEvent.add("电影大赛");

        List<String> mJoinedEvent = new ArrayList<>();
        mJoinedEvent.add("校园十佳歌手");

        mDataChild.put(mDataParent.get(0), mJoinedClub);
        mDataChild.put(mDataParent.get(1), mManagedClub);
        mDataChild.put(mDataParent.get(2), mFollowedEvent);
        mDataChild.put(mDataParent.get(3), mJoinedEvent);
    }


}
