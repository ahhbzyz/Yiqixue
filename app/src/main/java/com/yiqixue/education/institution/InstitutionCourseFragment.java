package com.yiqixue.education.institution;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;

/**
 * 文件名：InstitutionCourseFragment
 * 描  述：机构详情页的课程
 * 作  者：Yaozhong
 * 时  间：
 */

public class InstitutionCourseFragment extends Fragment {


    private View rootView;
    private String myDataset[] = { "小王", "小明","张丽","小王", "小明","张丽"};//模拟数据

    public InstitutionCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_institution_course, container, false);

        //设置课程列表
        ListView mInstitutionCourseLv = (ListView)rootView.findViewById(R.id.lv_institution_course);
        mInstitutionCourseLv.setAdapter(new InstitutionCourseLvAdapter(getActivity(), myDataset));


        return rootView;
    }


}
