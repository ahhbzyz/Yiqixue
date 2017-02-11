package com.yiqixue.education.teacher;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.yiqixue.R;

/**
 * 文件名：TeacherGalleryFragment
 * 描  述：老师信息详情页中的相册
 * 作  者：Yaozhong
 * 时  间：
 */

public class TeacherGalleryFragment extends Fragment {

    private View rootView;
    private int []  teacherPhotos = {R.mipmap.head1, R.mipmap.head2, R.mipmap.head3, R.mipmap.head1,
            R.mipmap.head2,R.mipmap.head3,R.mipmap.head1};//模拟数据

    public TeacherGalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_teacher_gallery, container, false);

        //设置图片网格列表
        GridView mTeacherPhotoGv = (GridView )rootView.findViewById(R.id.gv_teacher_photo);
        mTeacherPhotoGv.setAdapter(new TeacherGalleryGvAdapter(getActivity(), teacherPhotos));

        return rootView;
    }


}
