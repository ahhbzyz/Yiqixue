package com.yiqixue.education.course;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;

/**
 * 文件名：CourseCommentFragment
 * 描  述：课程详情页中的课程评价
 * 作  者：Yaozhong
 * 时  间：
 */

public class CourseCommentFragment extends Fragment {
    private View rootView;

    //模拟数据
    private String myDataset[] = {"小王", "小明", "张丽", "小王", "小明", "张丽"};
    private int myDataset2[] = {3, 2, 2, 4, 5, 5};

    public CourseCommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_course_comment, container, false);

        //设置评论List
        ListView mCourseCommentLv = (ListView) rootView.findViewById(R.id.lv_course_comment);
        mCourseCommentLv.setAdapter(new CourseCommentLvAdapter(getActivity(), myDataset, myDataset2));

        return rootView;
    }


}
