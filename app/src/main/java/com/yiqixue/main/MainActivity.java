package com.yiqixue.main;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;


import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


import com.yiqixue.R;
import com.yiqixue.club.ClubFragment;
import com.yiqixue.education.EducationFragment;
import com.yiqixue.user.UserFragment;
import com.yiqixue.utils.MyFragmentTabHost;
import com.yiqixue.welfare.WelfareFragment;


/**
 * 文件名：MainActivity
 * 描  述：app 界面最外层框架, 顶部的toolbar和底栏的4个tab.
 * 作  者：Yaozhong
 * 时  间：
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MyFragmentTabHost mTabHost;
    private Class mFragmentArray[] = {EducationFragment.class, ClubFragment.class, WelfareFragment.class, UserFragment.class};
    private int mImageViewArray[] = {R.drawable.selector_tab_edu, R.drawable.selector_tab_club, R.drawable.selector_tab_welfare, R.drawable.selector_tab_user};
    private String mTextViewArray[] = {"教育", "社团", "公益", "个人"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //保证字体不受系统字体影响
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        //底部4个tab
        mTabHost = (MyFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mFragmentArray.length; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
            //设置Tab按钮的背景

        }
    }

    //设置tab的view
    private View getTabItemView(int index) {

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.view_tab, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_tab);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_tab_name);
        textView.setText(mTextViewArray[index]);

        return view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        if (id == R.id.action_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
