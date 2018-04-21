package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.son.jawad.ui_widgets.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Adhamkh on 2017-08-18.
 */

public class DateTimeActivity extends AppCompatActivity {

    public TextView datetxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetime_layout);
        datetxt = (TextView) findViewById(R.id.datetxt);
    }

    public void selectdate(View view) {
        final DatePickerDialog timePicker = new DatePickerDialog(DateTimeActivity.this /*, R.style.DialogTheme*/,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        String sdt = sdf.format(date);
                        datetxt.setText(sdt);
                    }
                }, 2017, 0, 1);
        timePicker.show();
    }

    public void selecttime(View view) {
        final TimePickerDialog timePicker = new TimePickerDialog(DateTimeActivity.this /*, R.style.DialogTheme*/, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                Date date = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                String sdt = sdf.format(date);
                Log.v("hour", String.valueOf(hourOfDay));
                Log.v("minute", String.valueOf(minute));
                // Appointment_Time.setText(sdt);
            }
        }, 12, 1,false);
        timePicker.show();
    }
}
