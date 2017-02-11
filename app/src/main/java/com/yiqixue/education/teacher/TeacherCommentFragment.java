package com.yiqixue.education.teacher;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;
import com.yiqixue.education.course.CourseCommentLvAdapter;

/**
 * 文件名：TeacherCommentFragment
 * 描  述：老师信息详情页中的评论列表
 * 作  者：Yaozhong
 * 时  间：
 */

public class TeacherCommentFragment extends Fragment {

    private String myDataset[] = { "小王", "小明","张丽","小王", "小明","张丽"};//模拟数据
    private int myDataset2[] = { 3,2,2,4,5,5}; //模拟数据

    private View rootView;

    public TeacherCommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_teacher_comment, container, false);

        //设置评论列表
        ListView mTeacherCommentLv = (ListView)rootView.findViewById(R.id.lv_teacher_comment);
        mTeacherCommentLv.setAdapter(new TeacherCommentLvAdapter(getActivity(), myDataset,myDataset2));

        return rootView;
    }


}
