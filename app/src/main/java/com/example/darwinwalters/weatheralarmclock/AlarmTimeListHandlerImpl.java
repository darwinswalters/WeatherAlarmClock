package com.example.darwinwalters.weatheralarmclock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by darwinwalters on 12/14/15.
 */
public class AlarmTimeListHandlerImpl implements AlarmTimeListHandler {

    private List<Calendar> alarmTimeList;

    public void setAlarmTimeList(List<Calendar> alarmTimeList) {
        this.alarmTimeList = alarmTimeList;
    }

    public AlarmTimeListHandlerImpl() {
        alarmTimeList = new ArrayList<Calendar>();
    }

    public List<Calendar> getAlarmTimeList() {
        return alarmTimeList;
    }

    public void addAlarmTimeToList(int hour, int minute) {
        Calendar addedAlarmTime = Calendar.getInstance();
        addedAlarmTime.set(Calendar.HOUR, hour);
        addedAlarmTime.set(Calendar.MINUTE, minute);

        alarmTimeList.add(addedAlarmTime);
    }

    private void arrangeAlarmTimeList() {

    }

    public void createAlarmDate(int selectedHour, int selectedMinute) {
        System.out.println("selectedHour");
    }
}
