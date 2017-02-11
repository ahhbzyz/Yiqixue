package com.yiqixue.education.teacher;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;

/**
 * 文件名：TeacherCourseFragment
 * 描  述：老师信息详情页中的课程
 * 作  者：Yaozhong
 * 时  间：
 */

public class TeacherCourseFragment extends Fragment {

    private View rootView;

    private String myDataset[] = {"小王", "小明", "张丽", "小王", "小明", "张丽"};//模拟数据

    public TeacherCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_teacher_course, container, false);

        //设置课程列表
        ListView mTeacherCourseLv = (ListView) rootView.findViewById(R.id.lv_teacher_course);
        mTeacherCourseLv.setAdapter(new TeacherCourseLvAdapter(getActivity(), myDataset));


        return rootView;
    }


}
