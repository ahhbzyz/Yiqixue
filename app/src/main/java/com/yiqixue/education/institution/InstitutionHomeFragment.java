package com.yiqixue.education.institution;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yiqixue.R;

/**
 * 文件名：InstitutionHomeFragment
 * 描  述：机构详情页的主页
 * 作  者：Yaozhong
 * 时  间：
 */

public class InstitutionHomeFragment extends Fragment {


    public InstitutionHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_institution_home, container, false);
    }


}
