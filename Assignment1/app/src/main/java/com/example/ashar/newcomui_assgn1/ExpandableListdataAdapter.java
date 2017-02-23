package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ashar on 3/2/17.
 */

  public class ExpandableListdataAdapter extends BaseExpandableListAdapter
{
    Context mcontext;
    List<String> listhead;
    HashMap<String,List<String>> listchild;

    public ExpandableListdataAdapter(ExpandableListViewMain expandableListViewMain, List<String> listhead, HashMap<String, List<String>> listchild)
    {
        mcontext = expandableListViewMain;
        this.listhead = listhead;
        this.listchild = listchild;

    }

    @Override
    public int getGroupCount()
    {
        return listhead.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return listchild.get(listhead.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listhead.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listchild.get(listhead.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        final String grouptext = (String) getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) mcontext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_group, null);
        }

        TextView txtListgroup = (TextView) convertView
                .findViewById(R.id.list_group);

        txtListgroup.setText(grouptext);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) mcontext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.list_item);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
