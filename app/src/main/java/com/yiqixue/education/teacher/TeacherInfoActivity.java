package com.yiqixue.education.teacher;

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
import com.yiqixue.pojo.Teacher;
import com.yiqixue.utils.PagerSlidingTabStrip;

import java.util.List;

/**
 * 文件名：TeacherInfoActivity
 * 描  述：老师信息详情页
 * 作  者：Yaozhong
 * 时  间：
 */
public class TeacherInfoActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info);

        //接受EduResultAdapter传来的数据
        bundle = getIntent().getExtras();
        List<Teacher> teachers = bundle.getParcelableArrayList("teacher");
        int position = bundle.getInt("position");
        setUpToolBar("老师信息");

        //设置老师姓名
        TextView tvTeacherName = (TextView) findViewById(R.id.tv_teacher_name);
        tvTeacherName.setText(teachers.get(position).getName());

        //设置ViewPager
        setUpViewPager();

    }

    private void setUpToolBar(String title) {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpViewPager() {
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);

        //原来是getActivity().getSupportFragmentManager(). 但是viewPage会卡当切换fragment
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);

        PagerSlidingTabStrip mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.white));
        mPagerSlidingTabStrip.setShouldExpand(true);

        mPagerSlidingTabStrip.setIndicatorHeight(2);
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.theme));


        mPagerSlidingTabStrip.setDividerColor(getResources().getColor(R.color.transparent));
        mPagerSlidingTabStrip.setUnderlineColor(getResources().getColor(R.color.tab_line_color));
        mPagerSlidingTabStrip.setUnderlineHeight(1);

        //text
        mPagerSlidingTabStrip.setTextSize((int) getResources().getDimension(R.dimen.dimen_text_subhead));
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.theme));
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.tab_text_color));

        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"主页", "课程", "评价", "相册"};

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
                    TeacherHomeFragment teacherHomeFragment = new TeacherHomeFragment();
                    teacherHomeFragment.setArguments(bundle);
                    return teacherHomeFragment;
                }
                case 1: {
                    TeacherCourseFragment teacherCourseFragment = new TeacherCourseFragment();
                    teacherCourseFragment.setArguments(bundle);
                    return teacherCourseFragment;
                }
                case 2: {
                    TeacherCommentFragment teacherCommentFragment = new TeacherCommentFragment();
                    teacherCommentFragment.setArguments(bundle);
                    return teacherCommentFragment;
                }
                case 3: {
                    TeacherGalleryFragment teacherGalleryFragment = new TeacherGalleryFragment();
                    teacherGalleryFragment.setArguments(bundle);
                    return teacherGalleryFragment;
                }


            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher_info, menu);
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
