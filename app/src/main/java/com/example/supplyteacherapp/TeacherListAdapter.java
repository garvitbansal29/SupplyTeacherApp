package com.example.supplyteacherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TeacherListAdapter extends ArrayAdapter<TeacherAccount> {
    private Context mContext;
    int resource;
    ArrayList<TeacherAccount> teacherAccounts = new ArrayList<>();

    public TeacherListAdapter(Context context, int resource, ArrayList<TeacherAccount> teacherAccounts) {
        super(context, resource, teacherAccounts);
        mContext = context;
        this.resource = resource;
        this.teacherAccounts = teacherAccounts;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        String name = getItem(position).getAccountName();
        int yearsOfExperience = getItem(position).getYearsOfExperience();
        String postcode = getItem(position).getPostcode();

//        TeacherAccount teacherAccount = new TeacherAccount(name, postcode, yearsOfExperience);
        TeacherAccount teacherAccount = new TeacherAccount(name, postcode, "", "", "", "", "", "",false,yearsOfExperience,false);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(resource, parent, false);

        TextView tvName = convertView.findViewById(R.id.teacherNameView);
        TextView tvYearsOfExperience = convertView.findViewById(R.id.yearsOfExperienceField1);
        TextView tvPostcode= convertView.findViewById(R.id.postcodeField);

        tvName.setText(name);
        tvYearsOfExperience.setText("Years of Experience " + yearsOfExperience);
        tvPostcode.setText(postcode);

        return convertView;

    }

    @Override
    public TeacherAccount getItem(int position) {
        return teacherAccounts.get(position);
    }
}