package com.example.darwinwalters.weatheralarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by darwinwalters on 12/14/15.
 */
public interface AlarmTimeListHandler {

     List<Calendar> getAlarmTimeList();

     public void addAlarmTimeToList(int hour, int minute);

     public void createAlarmDate(int selectedHour, int selectedMinute);

     //private void arrangeAlarmTimeList();
}
