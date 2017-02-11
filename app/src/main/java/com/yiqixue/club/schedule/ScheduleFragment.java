package com.yiqixue.club.schedule;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.yiqixue.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


import java.util.Date;


import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;
import com.yiqixue.club.event.EventInfoActivity;

/**
 * 文件名：ScheduleFragment
 * 描  述：社团日程界面
 * 作  者：yaozhong
 * 时  间：
 */

public class ScheduleFragment extends Fragment {


    private View rootView;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 1);

        //设置日历
        final CalendarPickerView calendar = (CalendarPickerView) rootView.findViewById(R.id.calendar_view);

        //模拟当日有活动的日期数据
        final Calendar today = Calendar.getInstance();
        final ArrayList<Date> dates = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            today.add(Calendar.DAY_OF_MONTH, 3);
            dates.add(today.getTime());
        }

        //初始化日历
        calendar.init(new Date(), nextYear.getTime())
                .inMode(SelectionMode.SINGLE)
                .withHighlightedDates(dates);

        calendar.setOnInvalidDateSelectedListener(new CalendarPickerView.OnInvalidDateSelectedListener() {
            @Override
            public void onInvalidDateSelected(Date date) {
                Toast.makeText(getActivity().getApplicationContext(), "该时间点击不了哦", Toast.LENGTH_SHORT).show();
            }
        });

        //当date被点击是判断当日是否有活动
        final String items[] = {"青协迎新志愿者活动", "养老院志愿者活动"};
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                boolean flag = false;

                for (int i = 0; i < dates.size(); i++) {
                    if (formatDate(dates.get(i)).equals(formatDate(date))) {
                        showEventDialog(items, date);
                        flag = true;
                    } else {

                    }
                }
                if (!flag) {
                    Toast.makeText(getActivity().getApplicationContext(), "当日没有活动", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onDateUnselected(Date date) {

            }
        });

        return rootView;
    }

    //对话框显示当日活动
    private void showEventDialog(final String[] eventTitle, Date date) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);  //先得到构造器
        builder.setTitle(formatDate(date)); //设置标题
        builder.setItems(eventTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getActivity().getApplicationContext(), eventTitle[which], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), EventInfoActivity.class);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //格式化date格式
    private String formatDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
        return df.format(date);
    }


}
