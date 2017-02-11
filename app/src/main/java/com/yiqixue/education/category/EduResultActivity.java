package com.yiqixue.education.category;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.yiqixue.R;
import com.yiqixue.pojo.AttrComparator;
import com.yiqixue.pojo.Course;
import com.yiqixue.pojo.Institution;
import com.yiqixue.pojo.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 文件名：EduResultActivity
 * 描  述：课程列表结果: 包括课程 老师 机构的搜索结果
 * 作  者：Yaozhong
 * 时  间：
 */

public class EduResultActivity extends AppCompatActivity {

    private List<Course> course = new ArrayList<>();//课程对象List
    private List<Teacher> teacher = new ArrayList<>();//老师对象List
    private List<Institution> institution = new ArrayList<>();//机构对象List


    private EduResultAdapter mAdapterCourse;//课程列表适配器
    private EduResultAdapter mAdapterTeacher;//老师列表适配器
    private EduResultAdapter mAdapterInstitution;//机构列表适配器

    private RecyclerView mRecyclerView; //结果列表

    private int ITEM_TYPE = 0;//列表结果类型

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_result);

        //模拟数据
        preListData();

        //Toolbar
        String CategoryChildName = getIntent().getExtras().getString("CategoryChildName");
        setUpToolBar(CategoryChildName);

        //progressBar
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        setUpRecyclerView();//设置结果列表
        setUpSpinnerMain();//设置下拉列表（课程，机构，老师）
        setUpSpinnerOrder();//设置下拉列表（综合，距离，价格）


        //延迟显示结果界面
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                mRecyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }


    private void preListData(){
        course = new ArrayList<>();
        course.add(new Course("中考语文", "王强", 150, 1.2));
        course.add(new Course("中考数学", "陈忠和", 140, 1.3));
        course.add(new Course("中考地理", "王强", 130, 1.3));
        course.add(new Course("中考政治", "陈忠和", 120, 1.5));
        course.add(new Course("中考历史", "王强", 110, 1.1));
        course.add(new Course("中考化学", "陈忠和", 100, 1.7));
        course.add(new Course("中考物理", "王强", 160, 1.4));
        course.add(new Course("中考生物", "陈忠和", 170, 1.9));

        teacher = new ArrayList<>();
        teacher.add(new Teacher("小明", 50, 1.3));
        teacher.add(new Teacher("小王", 70, 1.7));
        teacher.add(new Teacher("小张", 60, 1.2));
        teacher.add(new Teacher("小李", 40, 1.9));
        teacher.add(new Teacher("小刘", 20, 1.2));
        teacher.add(new Teacher("小杨", 30, 1.3));
        teacher.add(new Teacher("小孙", 10, 1.1));
        teacher.add(new Teacher("小唐", 80, 1.5));


        institution = new ArrayList<>();
        institution.add(new Institution("新东方", 23, 1.5));
        institution.add(new Institution("朗阁雅思", 65, 1.6));
        institution.add(new Institution("新东方", 35, 1.7));
        institution.add(new Institution("朗阁雅思", 90, 1.2));
        institution.add(new Institution("新东方", 78, 1.3));
        institution.add(new Institution("朗阁雅思", 80, 1.4));
        institution.add(new Institution("新东方", 24, 1.8));
        institution.add(new Institution("朗阁雅思", 16, 1.9));

    }

    private void setUpRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setVisibility(View.INVISIBLE);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


    }


    private void setUpSpinnerMain() {
        Spinner spinnerMain = (Spinner) findViewById(R.id.spinner_main);

        String[] orderArray = {"课程", "老师", "机构"};

        ArrayList<HashMap<String, Object>> orderList = new ArrayList<>();

        for (int i = 0; i < orderArray.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("orderName", orderArray[i]);
            orderList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, orderList,
                R.layout.spinner_item_course_result, new String[]{"orderName"},
                new int[]{R.id.tv_spinner});

        spinnerMain.setAdapter(adapter);

        //下拉列表点击事件
        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mRecyclerView.setAdapter(mAdapterCourse);
                        ITEM_TYPE = 0;
                        break;

                    case 1:
                        mRecyclerView.setAdapter(mAdapterTeacher);
                        ITEM_TYPE = 1;
                        break;

                    case 2:
                        mRecyclerView.setAdapter(mAdapterInstitution);
                        ITEM_TYPE = 2;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void setUpSpinnerOrder() {
        Spinner spinnerOrder = (Spinner) findViewById(R.id.spinner_order);

        String[] orderArray = {"综合", "距离", "价格"};


        ArrayList<HashMap<String, Object>> orderList = new ArrayList<>();


        for (int i = 0; i < orderArray.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("orderName", orderArray[i]);
            orderList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, orderList,
                R.layout.spinner_item_course_result, new String[]{"orderName"},
                new int[]{R.id.tv_spinner});

        spinnerOrder.setAdapter(adapter);
        //下拉列表点击事件
        spinnerOrder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        sortList(0);//按综合排序
                        break;
                    case 1:
                        sortList(1);//按距离排序
                        break;
                    case 2:
                        sortList(2);//按价格排序
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void sortList(int ORDER_TYPE) {

        //新的数据来排序，老的数据保留给综合
        List<Course> newCourse = new ArrayList<>();
        List<Teacher> newTeacher = new ArrayList<>();
        List<Institution> newInstitution = new ArrayList<>();

        for (int i = 0; i < course.size(); i++) {
            newCourse.add(course.get(i));
        }
        for (int i = 0; i < teacher.size(); i++) {
            newTeacher.add(teacher.get(i));
        }

        for (int i = 0; i < institution.size(); i++) {
            newInstitution.add(institution.get(i));
        }


        //综合
        if (ORDER_TYPE == 0) {

            mAdapterCourse = new EduResultAdapter(course, teacher, institution, this, 0);
            mAdapterTeacher = new EduResultAdapter(course, teacher, institution, this, 1);
            mAdapterInstitution = new EduResultAdapter(course, teacher, institution, this, 2);

            //距离
        } else if (ORDER_TYPE == 1) {

            //按距离排序
            AttrComparator comparatorCourse = new AttrComparator("distance", "Course");
            AttrComparator comparatorTeacher = new AttrComparator("distance", "Teacher");
            AttrComparator comparatorInstitution = new AttrComparator("distance", "Institution");

            Collections.sort(newCourse, comparatorCourse);
            Collections.sort(newTeacher, comparatorTeacher);
            Collections.sort(newInstitution, comparatorInstitution);

            //新的Adapter
            mAdapterCourse = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 0);
            mAdapterTeacher = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 1);
            mAdapterInstitution = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 2);

            //价格
        } else {
            //按价格排序
            AttrComparator comparatorCourse = new AttrComparator("price", "Course");
            AttrComparator comparatorTeacher = new AttrComparator("price", "Teacher");
            AttrComparator comparatorInstitution = new AttrComparator("price", "Institution");

            Collections.sort(newCourse, comparatorCourse);
            Collections.sort(newTeacher, comparatorTeacher);
            Collections.sort(newInstitution, comparatorInstitution);

            //新的Adapter
            mAdapterCourse = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 0);
            mAdapterTeacher = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 1);
            mAdapterInstitution = new EduResultAdapter(newCourse, newTeacher, newInstitution, this, 2);
        }

        //如果当前的MainOrder是课程
        if (ITEM_TYPE == 0) {

            mRecyclerView.setAdapter(mAdapterCourse);

            //如果当前的MainOrder是老师
        } else if (ITEM_TYPE == 1) {

            mRecyclerView.setAdapter(mAdapterTeacher);

            //如果当前的MainOrder是机构
        } else {

            mRecyclerView.setAdapter(mAdapterInstitution);

        }

    }

    private void setUpToolBar(String title) {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
