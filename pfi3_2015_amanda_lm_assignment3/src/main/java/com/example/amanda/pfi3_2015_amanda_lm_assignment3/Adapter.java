package com.example.amanda.pfi3_2015_amanda_lm_assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.Calendar;

import java.util.ArrayList;


/**
 * Created by Amanda on 2015-04-16.
 */
public class Adapter extends BaseExpandableListAdapter{

    private ArrayList<Journey> j;
    private Context c;

    public Adapter (Context c, ArrayList<Journey> j){
        this.c=c;
        this.j=j;
    }

    @Override
    public int getGroupCount(){
        return j.size();
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_collapsed,null);

        Journey journey = j.get(groupPosition);

        TextView depTime = (TextView) convertView.findViewById(R.id.depTime);
        String departure = journey.getDepDateTime().toString();
        depTime.setText(departure);

        TextView arrTime = (TextView) convertView.findViewById(R.id.arrTime);
        String arrival = journey.getArrDateTime().toString();
        arrTime.setText(arrival);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_expanded,null);

        Journey journey = j.get(groupPosition);

        TextView depTimeDev = (TextView) convertView.findViewById(R.id.depTimeDev);
        String deviation = journey.getDepTimeDeviation();
        depTimeDev.setText(deviation);

        TextView travelMinutes = (TextView) convertView.findViewById(R.id.travelMinutes);
        String time = journey.getTravelMinutes();
        travelMinutes.setText(time);

        return convertView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
