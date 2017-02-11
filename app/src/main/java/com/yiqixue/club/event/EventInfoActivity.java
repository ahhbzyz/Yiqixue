package com.yiqixue.club.event;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;

import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.yiqixue.R;

/**
 * 文件名：EventInfoActivity
 * 描  述：活动详细信息界面
 * 作  者：Yaozhong
 * 时  间：
 */

public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);//页面加载条
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.setVisibility(View.INVISIBLE);

        ProgressBar eventProgressBar = (ProgressBar) findViewById(R.id.progressBar_project_progress);//活动进度条
        eventProgressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.theme), PorterDuff.Mode.SRC_IN);//设置颜色

        findViewById(R.id.btn_join).setOnClickListener(this);
        findViewById(R.id.btn_follow).setOnClickListener(this);
        findViewById(R.id.layout_event_comment).setOnClickListener(this);
        findViewById(R.id.layout_event_participants).setOnClickListener(this);



        //得到EventFragment传来的数据
        if( getIntent().getExtras()!=null){
            String[] eventTitle = getIntent().getExtras().getStringArray("eventTitle");
            String[] clubName = getIntent().getExtras().getStringArray("clubName");
            int position = getIntent().getExtras().getInt("position");
            //Toolbar
            setUpToolBar(eventTitle[position]);

            //活动标题
            TextView tvEventTitle = (TextView) findViewById(R.id.tv_event_title);
            tvEventTitle.setText(eventTitle[position]);

            //社团名字
            TextView tvClubName = (TextView) findViewById(R.id.tv_club_name);
            tvClubName.setText(clubName[position]);

        }else {
            setUpToolBar("活动详情");
        }


        //延迟加载界面
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //execute the task
                scrollView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_follow:

                Toast.makeText(getApplicationContext(), "关注成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_join:

                Toast.makeText(getApplicationContext(), "报名成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_event_comment:
                Intent intentComment = new Intent(this, EventCommentActivity.class);
                startActivity(intentComment);
                break;

            case R.id.layout_event_participants:
                Intent intentParticipant = new Intent(this, EventParticipantsActivity.class);
                startActivity(intentParticipant);
                break;
        }

    }


    private void setUpToolBar(String title) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_info, menu);
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
