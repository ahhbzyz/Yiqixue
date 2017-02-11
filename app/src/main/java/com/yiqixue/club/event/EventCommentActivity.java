package com.yiqixue.club.event;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.yiqixue.R;

/**
 * 文件名：EventCommentActivity
 * 描  述：社团活动界详情的评论页面
 * 作  者：Yaozhong
 * 时  间：
 */

public class EventCommentActivity extends AppCompatActivity {

    private String myDataset[] = { "小王", "小明","张丽","小王", "小明","张丽", "小王", "小明","张丽","小王", "小明","张丽"};
    private int myDataset2[] = { 3,2,2,4,5,5,3,2,2,4,5,5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_comment);

        setUpToolbar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "添加评论", Toast.LENGTH_SHORT).show();
            }
        });

        //设置评论列表
        ListView mEventCommentLv = (ListView)findViewById(R.id.lv_event_comment);
        mEventCommentLv.setAdapter(new EventCommentLvAdapter(this, myDataset,myDataset2));

    }

    private void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
