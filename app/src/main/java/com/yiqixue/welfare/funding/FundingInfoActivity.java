package com.yiqixue.welfare.funding;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.yiqixue.R;
import com.yiqixue.welfare.volunteer.VolunteerCommentActivity;


/**
 * 文件名：FundingInfoActivity
 * 描  述：公益筹款 每个活动 详细信息 界面
 * 作  者：yaozhong
 * 时  间：
 */
public class FundingInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding_info);

        //加载界面
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.setVisibility(View.INVISIBLE);

        //项目进度
        ProgressBar projectProgressBar = (ProgressBar) findViewById(R.id.progressBar_project_progress);
        projectProgressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.theme), PorterDuff.Mode.SRC_IN);

        //Toolbar
        setUpToolBar("贫困儿童助养");

        int[] participantsNum = getIntent().getExtras().getIntArray("participantsNum");
        int position = getIntent().getExtras().getInt("position");

        findViewById(R.id.btn_donate).setOnClickListener(this);
        findViewById(R.id.btn_invite).setOnClickListener(this);
        findViewById(R.id.layout_funding_participants).setOnClickListener(this);
        findViewById(R.id.layout_funding_comment).setOnClickListener(this);

        //设置参与人数
        TextView tvParticipantsNum = (TextView) findViewById(R.id.tv_participants_num);
        tvParticipantsNum.setText(participantsNum[position] + "人");


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
            case R.id.btn_donate:

                Toast.makeText(getApplicationContext(), "捐款成功", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btn_invite:

                Toast.makeText(getApplicationContext(), "邀请成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_funding_participants:

                Intent intentParticipant = new Intent(this, FundingParticipantsActivity.class);
                startActivity(intentParticipant);
                break;

            case R.id.layout_funding_comment:

                Intent intentComment = new Intent(this, FundingCommentActivity.class);
                startActivity(intentComment);
                break;
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
        getMenuInflater().inflate(R.menu.menu_funding_info, menu);
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
