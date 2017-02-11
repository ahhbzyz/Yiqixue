package com.yiqixue.education.course;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yiqixue.R;

/**
 * 文件名：CourseRelatedFragment
 * 描  述：课程详情页中相关课程
 * 作  者：Yaozhong
 * 时  间：
 */

public class CourseRelatedFragment extends Fragment {

    private View rootView;

    //模拟数据
    private String myDataset[] = {"中考语文阅读理解", "中考数学三角函数", "中考语文阅读理解", "中考数学三角函数",
            "中考语文阅读理解", "中考数学三角函数", "中考语文阅读理解", "中考数学三角函数",
            "中考语文阅读理解", "中考数学三角函数"};


    public CourseRelatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_course_related, container, false);

        //设置相关课程列表
        ListView mCourseCommentLv = (ListView)rootView.findViewById(R.id.lv_course_related);
        mCourseCommentLv.setAdapter(new CourseRelatedLvAdapter(getActivity(), myDataset));

        return rootView;
    }


}
