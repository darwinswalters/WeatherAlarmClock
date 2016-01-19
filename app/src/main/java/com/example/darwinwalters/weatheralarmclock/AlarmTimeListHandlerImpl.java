package com.example.darwinwalters.weatheralarmclock;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darwinwalters on 12/14/15.
 */
public class AlarmTimeListHandlerImpl {

    private static AlarmTimeListHandlerImpl alarmTimeListHandlerImpl;

    private ArrayList<AlarmPair> alarmTimeList;

    private static List<String> alarmTimeStringList;

    private SimpleDateFormat dateFormatter;

    // private constructor
    private AlarmTimeListHandlerImpl() {
        alarmTimeList = new ArrayList<AlarmPair>();
        alarmTimeStringList = new ArrayList<String>();
        dateFormatter = new SimpleDateFormat("H:mm");
    }

    public static AlarmTimeListHandlerImpl getInstance() {
        if (alarmTimeListHandlerImpl == null) {
            alarmTimeListHandlerImpl = new AlarmTimeListHandlerImpl();
        }

        return alarmTimeListHandlerImpl;

    }

    public void setAlarmTimeList(ArrayList<AlarmPair> alarmTimeList) {
        this.alarmTimeList = alarmTimeList;
    }

    public ArrayList<AlarmPair> getAlarmTimeList() {
        return alarmTimeList;
    }

    public List<String> getAlarmTimeStringList() {
        return alarmTimeStringList;
    }

    public void setAlarmTimeStringList(List<String> alarmTimeStringList) {
        this.alarmTimeStringList = alarmTimeStringList;
    }

    public void addToAlarmTimeStringList(String selectedTime){
        alarmTimeStringList.add(selectedTime);
    }

    public void addAlarmTimeToList(String alarmTime, boolean alarmActive) {
        AlarmPair alarmPair = new AlarmPair(alarmTime, alarmActive );
        alarmTimeList.add(alarmPair);
    }

    private void arrangeAlarmTimeList() {

    }

    public void createAlarmDate(int selectedHour, int selectedMinute) {
        System.out.println("selectedHour");
    }

    public int getLength(){
        return alarmTimeList.size();
    }

//    public String pairToString(AlarmPair alarmPairToConvert) {
//
//        return alarmPairToConvert.getLeftVar() + ":" + alarmPairToConvert.getRightVar();
//    }
}
