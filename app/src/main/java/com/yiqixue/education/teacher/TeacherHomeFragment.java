package com.yiqixue.education.teacher;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yiqixue.R;
import com.yiqixue.pojo.Course;
import com.yiqixue.pojo.Teacher;

import java.util.List;

/**
 * 文件名：TeacherHomeFragment
 * 描  述：老师信息详情页中的主页
 * 作  者：Yaozhong
 * 时  间：
 */
public class TeacherHomeFragment extends Fragment {


    private View rootView;

    public TeacherHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_teacher_home, container, false);

        return rootView;
    }


}
