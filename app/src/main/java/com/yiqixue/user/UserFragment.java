package com.yiqixue.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yiqixue.R;


/**
 * 文件名：UserFragment
 * 描  述：用户界面
 * 作  者：yaozhong
 * 时  间：
 */

public class UserFragment extends Fragment implements View.OnClickListener {

    private View rootView;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user, container, false);
        rootView.findViewById(R.id.layout_my_message).setOnClickListener(this);
        rootView.findViewById(R.id.layout_my_credit).setOnClickListener(this);
        rootView.findViewById(R.id.layout_my_wallet).setOnClickListener(this);
        rootView.findViewById(R.id.layout_my_order).setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.layout_my_message:

                Toast.makeText(getActivity().getApplicationContext(), "我的消息",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_my_credit:

                Toast.makeText(getActivity().getApplicationContext(), "我的学分",
                        Toast.LENGTH_SHORT).show();

                break;

            case R.id.layout_my_wallet:

                Toast.makeText(getActivity().getApplicationContext(), "我的钱包",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_my_order:

                Toast.makeText(getActivity().getApplicationContext(), "我的订单",
                        Toast.LENGTH_SHORT).show();
                break;


        }


    }
}
