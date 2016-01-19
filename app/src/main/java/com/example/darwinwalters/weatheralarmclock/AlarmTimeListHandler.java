package com.example.darwinwalters.weatheralarmclock;

import java.util.List;

/**
 * Created by darwinwalters on 12/14/15.
 */
public interface AlarmTimeListHandler {

     public AlarmTimeListHandlerImpl getInstance();

     List<AlarmPair> getAlarmTimeList();

     public void addAlarmTimeToList(int hour, int minute);

     public void createAlarmDate(int selectedHour, int selectedMinute);

     public String pairToString(AlarmPair alarmPairToConvert);

     //private void arrangeAlarmTimeList();
}
