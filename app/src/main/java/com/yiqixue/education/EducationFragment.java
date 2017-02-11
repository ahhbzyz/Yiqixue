package com.yiqixue.education;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yiqixue.R;
import com.yiqixue.education.category.EduCategoryActivity;
import com.yiqixue.education.course.CourseInfoActivity;
import com.yiqixue.utils.MyGridView;
import com.yiqixue.utils.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 文件名：EducationFragment
 * 描  述：教育界面
 * 作  者：Yaozhong
 * 时  间：
 */

public class EducationFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private int mImgArray[] = {R.mipmap.hotcourse, R.mipmap.ielts, R.mipmap.ielts, R.mipmap.hotcourse,
            R.mipmap.hotcourse, R.mipmap.ielts, R.mipmap.ielts, R.mipmap.hotcourse};

    private String mCategoryNameArray[] = {"幼教小学", "初中高中", "考研出国", "考证职称",
            "语言培训", "艺术特长", "生活兴趣", "更多类目"};

    private String mCourseName[] = {"9月雅思口语", "雅思听说读写", "雅思听说读写", "9月雅思口语",
            "9月雅思口语", "雅思听说读写", "雅思听说读写", "9月雅思口语"};

    private String mTeacherName[] = {"金长麟", "郑仁和", "郑仁和", "金长麟",
            "金长麟", "郑仁和", "郑仁和", "金长麟"};

    //教育界面的slider图片来源
    private HashMap<String, String> datasetup() {
        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("ios", "http://img2.ph.126.net/83H4PcjBoRVnnQnxuKc2Kg==/6630744509281895675.jpg");
        url_maps.put("产品经理", "http://img2.ph.126.net/neSPaNJ_7DIA56dxllruWA==/6630693931747005038.jpg");
        url_maps.put("Excel", "http://img1.ph.126.net/EBhk6jqbpMF4iXGa4Y_NMQ==/6630761001956428411.jpg");
        url_maps.put("JavaScript", "http://img2.ph.126.net/oEZM2cD8aKCMgRHIOc11pw==/6619426136584826162.jpg");
        return url_maps;
    }

    private View rootView;
    private SliderLayout mDemoSlider;


    public EducationFragment() {
        // Required empty public constructor
    }

    //slider自动循环
    @Override
    public void onStart() {
        super.onStart();
        mDemoSlider.startAutoCycle();
    }

    //slider停止
    @Override
    public void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_education, container, false);
        mDemoSlider = (SliderLayout) rootView.findViewById(R.id.slider);

        setUpPullToRefreshView();//下拉刷新
        setUpSliderView();//设置sliderView
        setUpCategoryView();//设置8个课程项目的GridView
        setUpHotCourseVIew();//设置热门课程的GridView

        return rootView;
    }

    private void setUpPullToRefreshView() {

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.theme);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setUpSliderView() {

        for (String name : datasetup().keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    //.description(name)
                    .image(datasetup().get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);


            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.setCustomIndicator((PagerIndicator) rootView.findViewById(R.id.custom_indicator));

    }

    private void setUpCategoryView() {

        MyGridView mCategoryGridView = (MyGridView) rootView.findViewById(R.id.gv_category);

        ArrayList<HashMap<String, Object>> mCategoryArrayList = new ArrayList<>();

        for (int i = 0; i < mCategoryNameArray.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            //map.put("CategoryImg",mCategoryImgArray[i]);
            map.put("CategoryName", mCategoryNameArray[i]);
            mCategoryArrayList.add(map);
        }

        SimpleAdapter mCategoryAdapter = new SimpleAdapter(getActivity(), mCategoryArrayList,
                R.layout.gridview_item_category, new String[]{"CategoryName"},
                new int[]{R.id.tv_category_name});

        mCategoryGridView.setAdapter(mCategoryAdapter);
        mCategoryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EduCategoryActivity.class);
                intent.putExtra("CategoryName", mCategoryNameArray[position]);
                startActivity(intent);
            }
        });

    }

    private void setUpHotCourseVIew() {

        MyGridView mHotCourseGridView = (MyGridView) rootView.findViewById(R.id.gv_hotcourse);

        ArrayList<HashMap<String, Object>> mHotCourseArrayList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("CourseImg", mImgArray[i]);
            map.put("CourseName", mCourseName[i]);
            map.put("TeacherName", mTeacherName[i]);
            mHotCourseArrayList.add(map);
        }

        SimpleAdapter mCategoryAdapter = new SimpleAdapter(getActivity(), mHotCourseArrayList,
                R.layout.gridview_item_hotcourse, new String[]{"CourseImg", "CourseName", "TeacherName"},
                new int[]{R.id.img_course, R.id.tv_course_name, R.id.tv_teacher_name});

        mHotCourseGridView.setAdapter(mCategoryAdapter);

        mHotCourseGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), CourseInfoActivity.class);//跳转到课程信息界面
                Bundle bundle = new Bundle();
                bundle.putString("CourseName", (String) item.get("CourseName"));
                bundle.putString("TeacherName", (String) item.get("TeacherName"));
                intent.putExtra("hotcourse", bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Toast.makeText(getActivity().getApplicationContext(), baseSliderView.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }
}
