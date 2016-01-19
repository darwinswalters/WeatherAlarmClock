package com.example.darwinwalters.weatheralarmclock;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by darwinwalters on 1/17/16.
 */
public class AlarmPairAdapter extends ArrayAdapter<AlarmPair>{

    Context context;
    int layoutResourceId;
    ArrayList<AlarmPair> alarmPairArray = null;

    public AlarmPairAdapter(Context context, int layoutResourceId, ArrayList<AlarmPair> data) {
        super(context, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.alarmPairArray = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AlarmPairHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new AlarmPairHolder();
            holder.alarmTextView = (TextView)row.findViewById(R.id.alarm_textView);
            holder.alarmSwitch = (Switch)row.findViewById(R.id.alarm_switch);

            row.setTag(holder);
        }

        else {
            holder = (AlarmPairHolder)row.getTag();
        }

        AlarmPair alarmPair = alarmPairArray.get(position);
        holder.alarmTextView.setText(alarmPair.getAlarmTime());
        holder.alarmSwitch.setChecked(alarmPair.getAlarmActive());

        return row;
    }

    static class AlarmPairHolder
    {
        TextView alarmTextView;
        Switch alarmSwitch;
    }

}
