package com.yiqixue.welfare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yiqixue.R;
import com.yiqixue.utils.PagerSlidingTabStrip;
import com.yiqixue.welfare.funding.FundingFragment;
import com.yiqixue.welfare.recommend.RecommendFragment;
import com.yiqixue.welfare.volunteer.VolunteerFragment;

/**
 * 文件名：WelfareFragment
 * 描  述：公益界面
 * 作  者：Yaozhong
 * 时  间：
 */
public class WelfareFragment extends Fragment {


    private View rootView;

    public WelfareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_welfare, container, false);


        setUpViewPager();//设置viewpager


        return rootView;
    }

    private void setUpViewPager(){
        ViewPager mViewPager = (ViewPager) rootView.findViewById(R.id.viewPager);

        //原来是getActivity().getSupportFragmentManager(). 但是viewPage会卡当切换fragment
        mViewPager.setAdapter(new MyPagerAdapter(this.getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(3);

        PagerSlidingTabStrip mPagerSlidingTabStrip = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);

        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.white));
        mPagerSlidingTabStrip.setShouldExpand(true);

        mPagerSlidingTabStrip.setIndicatorHeight(0);
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

        private final String[] TITLES = { "推荐", "招募", "筹款"};

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
                    return new RecommendFragment();
                }
                case 1:{
                    return new VolunteerFragment();
                }
                case 2:{

                    return new FundingFragment();
                }


            }

        }

    }


}
