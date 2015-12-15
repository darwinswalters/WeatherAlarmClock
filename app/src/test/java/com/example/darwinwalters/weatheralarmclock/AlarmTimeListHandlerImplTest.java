package com.example.darwinwalters.weatheralarmclock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.*;


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
        alarmTimeListHandlerImpl = new AlarmTimeListHandlerImpl();
        alarmTimeFormat = new SimpleDateFormat("h:mm a");
        alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR, 4);
        alarmTime.set(Calendar.MINUTE, 20);


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveOneAlarmTimeToList() {
        // IMPLEMENT
        int hour = 4;
        int min = 20;

        alarmTimeListHandlerImpl.addAlarmTimeToList(hour, min);
        assertEquals(hour, alarmTimeListHandlerImpl.getAlarmTimeList().get(0).get(Calendar.HOUR));
        assertEquals(min, alarmTimeListHandlerImpl.getAlarmTimeList().get(0).get(Calendar.MINUTE));


    }
}