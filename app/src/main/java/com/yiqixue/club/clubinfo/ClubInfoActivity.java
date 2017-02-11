package com.yiqixue.club.clubinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yiqixue.R;

/**
 * 文件名：ClubInfoActivity
 * 描  述：社团信息界面
 * 作  者：Yaozhong
 * 时  间：
 */
public class ClubInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_info);

        setUpToolBar();


        //接受来自MyClubFragment的数据
        String  position = getIntent().getExtras().getString("position");

        View mLayoutManageOnly = findViewById(R.id.layout_manage_only);
        View mLayoutUserOnly = findViewById(R.id.layout_user_only);
        View mLayoutMemberOnly = findViewById(R.id.layout_member_only);


        //判断是参加的社团还是管理的社团
        switch (position){
            case "member":
                mLayoutManageOnly.setVisibility(View.GONE);
                mLayoutUserOnly.setVisibility(View.GONE);
                mLayoutMemberOnly.setVisibility(View.VISIBLE);
                break;
            case "leader":
                mLayoutManageOnly.setVisibility(View.VISIBLE);
                mLayoutUserOnly.setVisibility(View.GONE);
                mLayoutMemberOnly.setVisibility(View.VISIBLE);
                break;
            case "user":
                mLayoutManageOnly.setVisibility(View.GONE);
                mLayoutMemberOnly.setVisibility(View.GONE);
                mLayoutUserOnly.setVisibility(View.VISIBLE);
                break;
        }

        findViewById(R.id.layout_add_event).setOnClickListener(this);

        findViewById(R.id.layout_add_notifi).setOnClickListener(this);

        findViewById(R.id.layout_manage_club).setOnClickListener(this);

        findViewById(R.id.layout_club_notifi).setOnClickListener(this);

        findViewById(R.id.layout_club_intro).setOnClickListener(this);

        findViewById(R.id.layout_history_event).setOnClickListener(this);

        findViewById(R.id.layout_club_member).setOnClickListener(this);

        findViewById(R.id.layout_chief_phone).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.layout_add_event:

                Intent intent_add_event = new Intent(this, AddEventActivity.class);
                startActivity(intent_add_event);

                    break;

            case R.id.layout_add_notifi:

                Intent intent_add_notifi = new Intent(this, AddNotifiActivity.class);
                startActivity(intent_add_notifi);

                break;

            case R.id.layout_manage_club:

                Intent intent_manage_club = new Intent(this, ManageClubActivity.class);
                startActivity(intent_manage_club);

                break;




        }

    }



    private void setUpToolBar(){
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_club_info, menu);
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
