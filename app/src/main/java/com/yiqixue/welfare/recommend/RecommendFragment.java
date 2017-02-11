package com.yiqixue.welfare.recommend;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import java.util.HashMap;

/**
 * 文件名：HomeFragment
 * 描  述：公益推荐界面
 * 作  者：yaozhong
 * 时  间：
 */
public class RecommendFragment extends Fragment implements View.OnClickListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    //公益推荐界面的slider图片来源
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

    private int myDataset[] = {42, 11, 32, 85, 74};//模拟数据

    public RecommendFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_welfare_recommend, container, false);
        mDemoSlider = (SliderLayout) rootView.findViewById(R.id.slider);
        setUpPullToRefreshView();//设置下拉刷新
        setUpSliderView();//设置滑动slider

        setUpRecommendWelfareLv();//设置推荐项目列表

        rootView.findViewById(R.id.layout_donated_num).setOnClickListener(this);
        rootView.findViewById(R.id.layout_fund_publisment).setOnClickListener(this);
        rootView.findViewById(R.id.layout_publish_volunteer).setOnClickListener(this);
        rootView.findViewById(R.id.layout_publish_funding).setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.layout_donated_num:
                Toast.makeText(getActivity().getApplicationContext(), "善款公开", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_fund_publisment:
                Toast.makeText(getActivity().getApplicationContext(), "善款公开", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_publish_volunteer:
                Toast.makeText(getActivity().getApplicationContext(), "发布招募", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_publish_funding:
                Toast.makeText(getActivity().getApplicationContext(), "发布筹款", Toast.LENGTH_SHORT).show();
                break;

        }

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


    private void setUpRecommendWelfareLv() {

        MyListView mRecommendWelfareLv = (MyListView) rootView.findViewById(R.id.lv_recommend_welfare);

        mRecommendWelfareLv.setAdapter(new RecommendLvAdapter(getActivity(), myDataset));

        mRecommendWelfareLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), FundingInfoActivity.class);
                intent.putExtra("participantsNum", myDataset);
                intent.putExtra("position", position);
                getActivity().startActivity(intent);

            }

        });


    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Toast.makeText(getActivity().getApplicationContext(), baseSliderView.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

}
