package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TeacherHome extends AppCompatActivity {

    private CalendarPickerView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime()).withSelectedDate(today)
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE);

    }

    private ArrayList<Date> setAvailability(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "04-03-2020";
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Date> availableDates = new ArrayList<>();
        availableDates.add(date);
        return availableDates;
    }

    public void setDates_onClick(View v)
    {
        for (Date d : setAvailability())
        {
            System.out.println(d);
        }

        calendar.highlightDates(setAvailability());
    }
}
