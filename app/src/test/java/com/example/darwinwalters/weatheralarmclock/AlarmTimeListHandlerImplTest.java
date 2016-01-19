package com.example.darwinwalters.weatheralarmclock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import static org.junit.Assert.*;

/**
 * Created by darwinwalters on 12/14/15.
 */
public class AlarmTimeListHandlerImplTest {

    private SimpleDateFormat alarmTimeFormat;
    private Calendar alarmTime;
    private AlarmTimeListHandlerImpl alarmTimeListHandlerImpl;

    @Before
    public void setUp() throws Exception {
        alarmTimeListHandlerImpl = AlarmTimeListHandlerImpl.getInstance();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveOneAlarmTimeToList() {
        // IMPLEMENT
        String alarmTime = "16:20";
        boolean alarmActive = false;

        alarmTimeListHandlerImpl.addAlarmTimeToList(alarmTime, alarmActive);
        assertEquals(alarmTime, alarmTimeListHandlerImpl.getAlarmTimeList().get(0).getAlarmTime());
        assertEquals(alarmActive, alarmTimeListHandlerImpl.getAlarmTimeList().get(0).getAlarmActive());

    }

//    @Test
//    public void pairSuccessfullyConvertedToTimeStrings() {
//        // Test to see if date is updated to
//
//        AlarmPair testAlarmPair = new AlarmPair(4,20);
//
//
//        String testDateString = alarmTimeListHandlerImpl.pairToString(testAlarmPair);
//
//        assertEquals("4:20", testDateString);
//
//    }

    @Test
    public void stringSuccessfullyAddedToAlarmTimeStringList() {
        // Test if the string created in pairToString is added to the array list
    }
}