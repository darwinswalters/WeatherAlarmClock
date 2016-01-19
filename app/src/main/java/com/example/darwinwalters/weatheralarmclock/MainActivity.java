package com.example.darwinwalters.weatheralarmclock;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends FragmentActivity implements TimePickerFragment.OnTimePickedListener{

    public static AlarmTimeListHandlerImpl alarmTimeListHandlerImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        // see if this activity has a view called
        if (findViewById(R.id.alarm_list_container) != null) {

            if (savedInstanceState != null) {
                return;
            }



            AlarmListFragment alarmListFragment = new AlarmListFragment();

            alarmListFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.alarm_list_container, alarmListFragment).commit();
        }

        alarmTimeListHandlerImpl = alarmTimeListHandlerImpl.getInstance();
        //setTimeTextView();
    }

    private void setTimeTextView () {

        TextView currentTimeTextView = (TextView) this.findViewById(R.id.current_time_textbox);

        SimpleDateFormat currentTimeFormat = new SimpleDateFormat("h:mm a");
        Date currentTime = new Date();

        String formattedCurrentTime = currentTimeFormat.format(currentTime);

        currentTimeTextView.setText(formattedCurrentTime);

    }

    public void addAlarmClicked(View view) {
        // open up pop up
        /*Context toastContext = getApplicationContext();
        CharSequence sampleText = "FAB Pressed.";
        int duration = Toast.LENGTH_SHORT;

        Toast sampleToast = Toast.makeText(toastContext, sampleText, duration);
        sampleToast.show();*/
        DialogFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(), "timePicker");

    }




    @Override
    public void onTimePicked() {
//        AlarmListFragment alarmListFragment = (AlarmListFragment) getSupportFragmentManager().findFragmentById(R.id.alarm_list_container);
//        alarmListFragment.updateAlarmListView();
    }

    private class AlarmListViewUpdater extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void...params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Context context = MainActivity.this;
            alarmTimeListHandlerImpl = alarmTimeListHandlerImpl.getInstance();
            int alarmListSize = alarmTimeListHandlerImpl.getLength();
            //AlarmPair[] alarmListArray = alarmTimeListHandlerImpl.getAlarmTimeList().toArray(new AlarmPair[alarmListSize]);
            AlarmPairAdapter alarmPairAdapter = new AlarmPairAdapter(context, R.layout.alarm_list_item, alarmTimeListHandlerImpl.getAlarmTimeList());

            ListView alarmListView = (ListView) findViewById(R.id.alarm_item_list_view);
            alarmListView.setAdapter(alarmPairAdapter);

        }



    }

    public void updateAlarmListView() {
        // call an AsyncTask in order to update the listview
        AlarmListViewUpdater alarmListViewUpdater = new AlarmListViewUpdater();
        alarmListViewUpdater.execute();


    }
}
