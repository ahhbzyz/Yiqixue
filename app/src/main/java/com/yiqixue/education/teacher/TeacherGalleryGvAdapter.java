package com.yiqixue.education.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.yiqixue.R;

/**
 * 文件名：TeacherGalleryFragment
 * 描  述：老师信息详情页中的相册列表的适配器
 * 作  者：Yaozhong
 * 时  间：
 */

public class TeacherGalleryGvAdapter extends BaseAdapter {
    private Context context;
    private final int[] teacherPhotos;


    public TeacherGalleryGvAdapter(Context context, int[] teacherPhotos) {
        this.context = context;
        this.teacherPhotos = teacherPhotos;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.gridview_item_teacher_gallery, null);

            //绑定图片数据
            ImageView imageView = (ImageView) gridView.findViewById(R.id.img_teacher_photo);
            imageView.setImageResource(teacherPhotos[position]);


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return teacherPhotos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
