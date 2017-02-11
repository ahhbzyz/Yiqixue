package com.yiqixue.education.category;

/**
 * 文件名：EduExpandableListAdapter
 * 描  述：ExpandableList适配器
 * 作  者：Yaozhong
 * 时  间：
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.yiqixue.R;

import java.util.HashMap;
import java.util.List;

public class EduExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> mDataParent; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> mDataChild;

    public EduExpandableListAdapter(Context context, List<String> listDataHeader,
                                    HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.mDataParent = listDataHeader;
        this.mDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.mDataChild.get(this.mDataParent.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //扩展列表的子表View
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandablelistview_child, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.tv_club_name);
        txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mDataChild.get(this.mDataParent.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mDataParent.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.mDataParent.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    //扩展列表的父表View
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandablelistview_parent, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.tv_expListview_parent);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
