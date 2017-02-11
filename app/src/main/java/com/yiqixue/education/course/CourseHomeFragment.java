package com.yiqixue.education.course;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.yiqixue.R;
import com.yiqixue.pojo.Course;

import java.util.List;

/**
 * 文件名：CourseHomeFragment
 * 描  述：课程详情页中的课程详情（介绍）
 * 作  者：Yaozhong
 * 时  间：
 */

public class CourseHomeFragment extends Fragment {

    private View rootView;
    private String courseName, teacherName;

    public CourseHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_course_info, container, false);

        //接受CourseInfoActivity传来的数据
        Bundle args = getArguments();

        //判断是来自EduResultAdapter还是来自EducationFragment
        if(args.getParcelableArrayList("course")!= null){
            List<Course> courses = args.getParcelableArrayList("course");
            int position = args.getInt("position");
            courseName =courses.get(position).getName();
            teacherName = courses.get(position).getTeacherName();
        }else {
            args = getArguments();
            courseName = args.getString("CourseName");
            teacherName = args.getString("TeacherName");
        }


        TextView tvCourseName = (TextView)rootView.findViewById(R.id.tv_course_name);
        tvCourseName.setText(courseName);

        TextView tvCourseTeacher = (TextView)rootView.findViewById(R.id.tv_teacher_name);
        tvCourseTeacher.setText(teacherName);

        return rootView;
    }


}
