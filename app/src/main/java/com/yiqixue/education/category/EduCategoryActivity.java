package com.yiqixue.education.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.yiqixue.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 文件名：EduCategoryActivity
 * 描  述：8个课程类里的小分类
 * 作  者：Yaozhong
 * 时  间：
 */
public class EduCategoryActivity extends AppCompatActivity {

    private List<String> mDataParent;
    private HashMap<String, List<String>> mDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_category);

        String CategoryName = getIntent().getExtras().getString("CategoryName");
        setUpToolBar(CategoryName);//设置toolbar

        //模拟数据
        prepareListData();

        //设置可扩展列表来展示数据
        ExpandableListView expListView = (ExpandableListView) findViewById(R.id.expandableListView);
        final EduExpandableListAdapter listAdapter = new EduExpandableListAdapter(this, mDataParent, mDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Intent intent = new Intent(EduCategoryActivity.this, EduResultActivity.class);
                intent.putExtra("CategoryChildName", listAdapter.getChild(groupPosition, childPosition).toString());
                startActivity(intent);

                return false;
            }
        });


    }

    private void prepareListData() {
        mDataParent = new ArrayList<String>();
        mDataChild = new HashMap<String, List<String>>();

        // Adding child data
        mDataParent.add("初中语文");
        mDataParent.add("初中数学");
        mDataParent.add("初中外语");


        // Adding child data
        List<String> mC1 = new ArrayList<>();
        mC1.add("初一语文");
        mC1.add("初二语文");
        mC1.add("初三语文");


        List<String> mC2 = new ArrayList<>();
        mC2.add("初一数学");
        mC2.add("初二数学");
        mC2.add("初三数学");

        List<String> mC3 = new ArrayList<>();
        mC3.add("初一外语");
        mC3.add("初二外语");
        mC3.add("初三外语");


        mDataChild.put(mDataParent.get(0), mC1);
        mDataChild.put(mDataParent.get(1), mC2);
        mDataChild.put(mDataParent.get(2), mC3);

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
        getMenuInflater().inflate(R.menu.menu_edu_category, menu);
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
