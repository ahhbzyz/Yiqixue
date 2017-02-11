package com.yiqixue.club.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yiqixue.R;
import com.yiqixue.utils.MyListView;
import com.yiqixue.utils.TextSliderView;
import com.yiqixue.welfare.funding.FundingInfoActivity;
import com.yiqixue.welfare.recommend.RecommendLvAdapter;

import java.util.HashMap;

/**
 * 文件名：EventFragment
 * 描  述：社团活动界面
 * 作  者：Yaozhong
 * 时  间：
 */

public class EventFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    //社团活动界面的slider图片来源
    private HashMap<String, String> datasetup() {
        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("老兵", "http://img1.gtimg.com/gongyi/pics/hv1/239/168/1782/115917629.jpg?v=4.0");
        url_maps.put("支教", "http://mat1.gtimg.com/gongyi/2014/lejuan3.0/20150703175447.jpg");
        url_maps.put("困境", "http://mat1.gtimg.com/gongyi/2013yuejuan/15-wytm/tongmeng-banner.jpg");
        url_maps.put("白内障", "http://mat1.gtimg.com/gongyi/2013yuejuan/7-wjgm/guangming-banner.jpg");
        return url_maps;
    }

    private View rootView;
    private SliderLayout mDemoSlider;


    //模拟数据
    private String myDataset[] = {"青协迎新活动", "轮滑社迎新活动", "飞盘社迎新活动", "电影社迎新活动",
            "青协迎新活动", "轮滑社迎新活动", "飞盘社迎新活动", "电影社迎新活动",
            "青协迎新活动", "轮滑社迎新活动", "飞盘社迎新活动", "电影社迎新活动",
            "青协迎新活动", "轮滑社迎新活动", "飞盘社迎新活动", "电影社迎新活动",};

    //模拟数据
    private String myDataset2[] = {"青年志愿者协会", "轮滑社迎新活动", "飞盘社", "电影社",
            "青年志愿者协会", "轮滑社", "飞盘社", "电影社",
            "青年志愿者协会", "轮滑社", "飞盘社", "电影社",
            "青年志愿者协会", "轮滑社", "飞盘社", "电影社"};


    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_event, container, false);

        mDemoSlider = (SliderLayout) rootView.findViewById(R.id.slider);

        setUpSliderView();//设置sliderView

        setUpPullToRefreshView();//下拉刷新

        setUpEventLv();//设置Event列表

        return rootView;
    }


    //slider自动循环
    @Override
    public void onStart() {
        super.onStart();
        mDemoSlider.startAutoCycle();
    }

    //slider停止
    @Override
    public void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }


    private void setUpSliderView() {

        for (String name : datasetup().keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    //.description(name)
                    .image(datasetup().get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);


            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.setCustomIndicator((PagerIndicator) rootView.findViewById(R.id.custom_indicator));

    }


    private void setUpPullToRefreshView() {

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.theme);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    private void setUpEventLv() {

        MyListView mEventLv = (MyListView) rootView.findViewById(R.id.lv_event);

        mEventLv.setAdapter(new EventLvAdapter(getActivity(), myDataset, myDataset2));

        mEventLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Event item点击跳转Event详情
                Intent intent = new Intent(getActivity(), EventInfoActivity.class);
                intent.putExtra("eventTitle", myDataset);
                intent.putExtra("clubName", myDataset2);
                intent.putExtra("position", position);
                getActivity().startActivity(intent);

            }
        });

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity().getApplicationContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }
}
