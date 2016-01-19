package com.example.darwinwalters.weatheralarmclock;

/**
 * Created by darwinwalters on 12/15/15.
 */
public class AlarmPair {

    private String alarmTime;
    private boolean alarmActive;

    public AlarmPair(String alarmTime, boolean alarmActive) {
        this.alarmTime = alarmTime;
        this.alarmActive = alarmActive;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setRightVar(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean getAlarmActive() {
        return alarmActive;
    }

    public void setLeftVar(boolean alarmActive) {
        this.alarmActive = alarmActive;
    }
}
