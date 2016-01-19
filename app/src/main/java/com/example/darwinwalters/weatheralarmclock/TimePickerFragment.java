package com.example.darwinwalters.weatheralarmclock;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by darwinwalters on 11/16/15.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    OnTimePickedListener mCallback;

    public interface OnTimePickedListener {
        public void onTimePicked();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                android.text.format.DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // method will be used to create new alarm
        int hr = hourOfDay;
        int min = minute;
        String selectedTime;
        if (minute < 10)
            selectedTime= hourOfDay + ":0" + minute;
        else
            selectedTime= hourOfDay + ":" + minute;

        AlarmTimeListHandlerImpl alarmTimeListHandlerImpl = AlarmTimeListHandlerImpl.getInstance();
        alarmTimeListHandlerImpl.addAlarmTimeToList(selectedTime, true);

        ((MainActivity) getActivity()).updateAlarmListView();

        String selectedTimeString = alarmTimeListHandlerImpl.getAlarmTimeList().get(0).getAlarmTime();

        Context toastContext = getActivity().getApplicationContext();
        CharSequence selectedTimeText = "Alarm set for "+ selectedTime;
        int duration = Toast.LENGTH_SHORT;


        Toast sampleToast = Toast.makeText(toastContext, selectedTimeText, duration);
        sampleToast.show();
    }

}
