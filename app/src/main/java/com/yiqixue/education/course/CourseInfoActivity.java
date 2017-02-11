package com.yiqixue.education.course;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.yiqixue.R;
import com.yiqixue.pojo.Course;
import com.yiqixue.utils.PagerSlidingTabStrip;

import java.util.List;

/**
 * 文件名：CourseInfoActivity
 * 描  述：课程详情页
 * 作  者：Yaozhong
 * 时  间：
 */
public class CourseInfoActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);


        //接受EduResultAdapter和EducationFragment传来的数据
        bundle = getIntent().getBundleExtra("course");

        //判断是来自EduResultAdapter还是来自EducationFragment
        if (bundle != null) {
            List<Course> courses = bundle.getParcelableArrayList("course");
            int position = bundle.getInt("position");
            setUpToolBar(courses.get(position).getName());
        } else {
            bundle = getIntent().getBundleExtra("hotcourse");
            setUpToolBar(bundle.getString("CourseName"));
        }

        //设置ViewPager
        setUpViewPager();


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


    private void setUpToolBar(String title) {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"课程详情", "课程评价", "相关课程"};

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

            final int pattern = position % 4;
            switch (pattern) {
                case 0:
                default: {

                    CourseHomeFragment courseHomeFragment = new CourseHomeFragment();
                    courseHomeFragment.setArguments(bundle);
                    return courseHomeFragment;
                }
                case 1: {
                    CourseCommentFragment courseCommentFragment = new CourseCommentFragment();
                    courseCommentFragment.setArguments(bundle);
                    return courseCommentFragment;
                }
                case 2: {

                    CourseRelatedFragment courseRelatedFragment = new CourseRelatedFragment();
                    courseRelatedFragment.setArguments(bundle);
                    return courseRelatedFragment;
                }


            }

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_info, menu);
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
