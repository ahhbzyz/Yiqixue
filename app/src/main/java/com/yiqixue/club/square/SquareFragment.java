package com.yiqixue.club.square;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yiqixue.R;
import com.yiqixue.club.clubinfo.ClubInfoActivity;


/**
 * 文件名：SquareFragment
 * 描  述：社团广场界面
 * 作  者：Yaozhong
 * 时  间：
 */

public class SquareFragment extends Fragment {


    private View rootView;
    private String[] clubName = new String[48];//模拟数据
    private int[] clubLogo = new int[48];//模拟数据

    public SquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_square, container, false);


        for(int i = 0; i<clubName.length;i++){
            clubName[i]="青年志愿者协会";
            clubLogo[i]= R.mipmap.clublogo;
        }

        setUpClubView();//设置社团广场的网格列表

        return rootView;
    }


    private void setUpClubView(){

       GridView mClubGridView = (GridView )rootView.findViewById(R.id.gridView);
        mClubGridView.setAdapter(new SquareGvAdapter(getActivity(), clubName,clubLogo));
        mClubGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ClubInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("position","user");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }



}
