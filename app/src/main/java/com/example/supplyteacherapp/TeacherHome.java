package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class TeacherHome extends AppCompatActivity {

    private CalendarPickerView calendar;
    Database database = new Database(this);
    TeacherDB teacherDB = new TeacherDB();
    ArrayList<String> setDates = new ArrayList<>();


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

    private ArrayList<Date> getSelectedDates(){
        return new ArrayList<>(calendar.getSelectedDates());

    }


    private ArrayList<String> getSelectedStringDates(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        ArrayList<String> selectedStringDates = new ArrayList<>();

        ArrayList<Date> selectedDates = getSelectedDates();
        for(Date d : selectedDates)
        {
            selectedStringDates.add(dateFormat.format(d).toString());
        }
        return selectedStringDates;

    }

    private Date convertToDate(String strDate)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);


        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;

    }

    public void setDates_onClick(View v)
    {
//        getSetDates("3U8XYv26TXYT7eTCSkr5FKDJTt63");
        teacherDB.getTeacherCurrentSetDates("3U8XYv26TXYT7eTCSkr5FKDJTt63", new Ong() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccessDates(ArrayList<String> currentSetDates) {
                for(String selectedDate: getSelectedStringDates())
                {
                    boolean dateRepeat = false;

                    for (String setDate : currentSetDates)
                    {
                        if(selectedDate.equals(setDate))
                        {
                            dateRepeat = true;
                        }

                    }
                    if(!dateRepeat)
                    {
                        database.addTeacherAvailability("3U8XYv26TXYT7eTCSkr5FKDJTt63",selectedDate);
                    }
                    else
                    {
                        System.out.println("not done");
                    }
                }
            }
        });
        calendar.highlightDates(getSelectedDates());

    }


}
