package com.yiqixue.education.institution;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yiqixue.R;
import com.yiqixue.pojo.Institution;
import com.yiqixue.pojo.Teacher;
import com.yiqixue.utils.PagerSlidingTabStrip;

import java.util.List;

/**
 * 文件名：InstitutionInfoActivity
 * 描  述：机构详情页
 * 作  者：Yaozhong
 * 时  间：
 */
public class InstitutionInfoActivity extends AppCompatActivity {


    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_info);

        //接受EduResultAdapter传来的数据
        bundle = getIntent().getExtras();
        List<Institution> institutions = bundle.getParcelableArrayList("institution");
        int position = bundle.getInt("position");

        //设置Toolbar
        setUpToolBar("机构信息");


        //设置机构姓名
        TextView tvInstitution = (TextView)findViewById(R.id.tv_institution_name);
        tvInstitution.setText(institutions.get(position).getName());

        //设置ViewPager
        setUpViewPager();
    }
    private void setUpToolBar(String title){
        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpViewPager(){
        ViewPager mViewPager = (ViewPager)findViewById(R.id.viewPager);

        //原来是getActivity().getSupportFragmentManager(). 但是viewPage会卡当切换fragment
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);

        PagerSlidingTabStrip mPagerSlidingTabStrip = (PagerSlidingTabStrip)findViewById(R.id.tabs);

        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.white));
        mPagerSlidingTabStrip.setShouldExpand(true);

        mPagerSlidingTabStrip.setIndicatorHeight(2);
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.theme));


        mPagerSlidingTabStrip.setDividerColor(getResources().getColor(R.color.transparent));
        mPagerSlidingTabStrip.setUnderlineColor(getResources().getColor(R.color.tab_line_color));
        mPagerSlidingTabStrip.setUnderlineHeight(1);

        //text
        mPagerSlidingTabStrip.setTextSize((int)getResources().getDimension(R.dimen.dimen_text_subhead));
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.theme));
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.tab_text_color));

        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = { "主页", "课程", "老师", "评价"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {


            final int pattern = position % 5;
            switch (pattern) {
                case 0:
                default: {
                    return new InstitutionHomeFragment();
                }
                case 1:{
                    return new InstitutionCourseFragment();
                }
                case 2:{
                    return new InstitutionTeacherFragment();
                }
                case 3:{

                    return new InstitutionCommentFragment();
                }


            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_institution_info, menu);
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
