package com.yiqixue.education.institution;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;

/**
 * 文件名：InstitutionCommentFragment
 * 描  述：机构详情页的评价列表
 * 作  者：Yaozhong
 * 时  间：
 */

public class InstitutionCommentFragment extends Fragment {

    private View rootView;
    private String myDataset[] = { "小王", "小明","张丽","小王", "小明","张丽"};//模拟数据
    private int myDataset2[] = { 3,2,2,4,5,5};//模拟数据

    public InstitutionCommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =   inflater.inflate(R.layout.fragment_institution_comment, container, false);

        //设置评价列表
        ListView mCourseCommentLv = (ListView)rootView.findViewById(R.id.lv_instituion_comment);
        mCourseCommentLv.setAdapter(new InstitutionCommentLvAdapter(getActivity(), myDataset,myDataset2));

        return rootView;
    }


}
