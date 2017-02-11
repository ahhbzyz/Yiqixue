package com.yiqixue.education.category;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.yiqixue.R;
import com.yiqixue.education.course.CourseInfoActivity;
import com.yiqixue.education.institution.InstitutionInfoActivity;
import com.yiqixue.pojo.Course;
import com.yiqixue.pojo.Institution;
import com.yiqixue.pojo.Teacher;
import com.yiqixue.education.teacher.TeacherInfoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：EduResultAdapter
 * 描  述：课程，老师，机构结果适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class EduResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private int ItemType;


    private static final int TYPE_COURSE = 0;//课程
    private static final int TYPE_TEACHER = 1;//老师
    private static final int TYPE_INSTITUTION = 2;//机构


    private List<Course> course = new ArrayList<>();
    private List<Teacher> teacher = new ArrayList<>();
    private List<Institution> institution = new ArrayList<>();


    // Provide a suitable constructor (depends on the kind of dataset)
    public EduResultAdapter(List<Course> course, List<Teacher> teacher, List<Institution> institution, Context context, int ItemType) {
        this.course = course;
        this.teacher = teacher;
        this.institution = institution;
        this.context = context;
        this.ItemType = ItemType;
    }


    //课程结果
    public class VHCourse extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTvCourseName;
        public TextView mTvCoursePrice;
        public TextView mTvCourseDistance;
        public RelativeLayout layout;

        public VHCourse(View view) {
            super(view);
            mTvCourseName = (TextView) view.findViewById(R.id.tv_course_name);
            mTvCoursePrice = (TextView) view.findViewById(R.id.tv_course_price);
            mTvCourseDistance = (TextView) view.findViewById(R.id.tv_course_distance);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, CourseInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("course", (ArrayList<? extends Parcelable>) course);
            bundle.putInt("position", getPosition());
            intent.putExtra("course", bundle);
            context.startActivity(intent);
        }
    }

    //老师结果
    public class VHTeacher extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTvTeacherName;
        public TextView mTvTeacherPrice;
        public TextView mTvTeacherDistance;
        public RelativeLayout layout;

        public VHTeacher(View view) {
            super(view);
            mTvTeacherName = (TextView) view.findViewById(R.id.tv_teacher_name);
            mTvTeacherPrice = (TextView) view.findViewById(R.id.tv_teacher_price);
            mTvTeacherDistance = (TextView) view.findViewById(R.id.tv_teacher_distance);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, TeacherInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("teacher", (ArrayList<? extends Parcelable>) teacher);
            bundle.putInt("position", getPosition());
            intent.putExtras(bundle);
            context.startActivity(intent);

        }
    }

    //机构结果
    public class VHInstitution extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTvInstitutionName;
        public TextView mTvInstitutionPrice;
        public TextView mTvInstitutionDistance;
        public RelativeLayout layout;

        public VHInstitution(View view) {
            super(view);
            mTvInstitutionName = (TextView) view.findViewById(R.id.tv_institution_name);
            mTvInstitutionPrice = (TextView) view.findViewById(R.id.tv_institution_price);
            mTvInstitutionDistance = (TextView) view.findViewById(R.id.tv_institution_distance);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, InstitutionInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("institution", (ArrayList<? extends Parcelable>) institution);
            bundle.putInt("position", getPosition());
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        //加载课程Item
        if (viewType == TYPE_COURSE) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_course_result, parent, false);
            //inflate your layout and pass it to view holder
            return new VHCourse(v);

            //加载老师Item
        } else if (viewType == TYPE_TEACHER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_teacher_result, parent, false);
            return new VHTeacher(v);

            //加载机构Item
        } else if (viewType == TYPE_INSTITUTION) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_institution_result, parent, false);
            return new VHInstitution(v);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //绑定课程数据
        if (holder instanceof VHCourse) {
            ((VHCourse) holder).mTvCourseName.setText(course.get(position).getName());
            ((VHCourse) holder).mTvCoursePrice.setText("￥" + course.get(position).getPrice());
            ((VHCourse) holder).mTvCourseDistance.setText(course.get(position).getDistance() + " km");

            //绑定老师数据
        } else if (holder instanceof VHTeacher) {
            ((VHTeacher) holder).mTvTeacherName.setText(teacher.get(position).getName());
            ((VHTeacher) holder).mTvTeacherPrice.setText("￥" + teacher.get(position).getPrice());
            ((VHTeacher) holder).mTvTeacherDistance.setText(teacher.get(position).getDistance() + " km");

            //绑定机构数据
        } else if (holder instanceof VHInstitution) {
            ((VHInstitution) holder).mTvInstitutionName.setText(institution.get(position).getName());
            ((VHInstitution) holder).mTvInstitutionPrice.setText("￥" + institution.get(position).getPrice());
            ((VHInstitution) holder).mTvInstitutionDistance.setText(institution.get(position).getDistance() + " km");

        }


    }

    @Override
    public int getItemViewType(int position) {
        if (ItemType == 1) {
            return TYPE_TEACHER;
        } else if (ItemType == 2) {
            return TYPE_INSTITUTION;
        }
        return TYPE_COURSE;
    }


    @Override
    public int getItemCount() {
        return course.size();
    }
}
