package com.example.supplyteacherapp;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class TeacherDB {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DistanceCalculator distanceCalculator = new DistanceCalculator();


    public void getAllTeachers(final OnGetTeacherDataListener listener)
    {
        mDatabase.child("Teacher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final ArrayList<TeacherAccount> allTeachers = new ArrayList<>();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    TeacherAccount teacherAccount = snapshot.getValue(TeacherAccount.class);
                    allTeachers.add(teacherAccount);
                }
                listener.onSuccessTeacherObj(allTeachers);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void getTeacherIdsBySubject(final String subject, final OnGetTeacherDataListener listener )
    {
        listener.onStart();
        //Connects to the table
        mDatabase.child("TeacherLanguages")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {
                    final ArrayList <String> teacherList = new ArrayList<>();

                    //Loops though every Teacher in the above table
                    for (final DataSnapshot snapshot1 : dataSnapshot.getChildren())
                    {
                        //Set teacher ID
                        final String teacherID = snapshot1.getKey();

                        for( final DataSnapshot snapshot2 : snapshot1.getChildren())
                        {
                            String teacherSubject = Objects.requireNonNull(snapshot2.getValue()).toString();
                            //Checks if the teacher teaches the desired subject and returns the teacherID if true
                            if(subject.equals(teacherSubject))
                            {
                                teacherList.add(teacherID);
                            }
                        }
                    }
                    listener.onSuccessTeacherID(teacherList);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
    }




    public void getTeacherObjsById(final ArrayList<String> teacherIDs, final OnGetTeacherDataListener listener )
    {
        listener.onStart();
        mDatabase.child("Teacher")
            .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList <TeacherAccount> tempTeach = new ArrayList<>();
                for(String st : teacherIDs)
                {
                    TeacherAccount t = dataSnapshot.child(st).getValue(TeacherAccount.class);
                    tempTeach.add(t);
                }
                listener.onSuccessTeacherObj(tempTeach);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("This is an error "+ databaseError.getMessage());

            }
            });

    }


    public void getTeacherObjsBySubject(String subject, final OnGetTeacherDataListener listner)
    {
        listner.onStart();
        getTeacherIdsBySubject(subject, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {
                getTeacherObjsById(teacherIDs, new OnGetTeacherDataListener() {
                    @Override
                    public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

                    }

                    @Override
                    public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                        listner.onSuccessTeacherObj(teacherAccount);


                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
    }
    public void getTeacherObjsBySubject2 (String subject, OnGetTeacherDataListener listener)
    {
        mDatabase.child("TeacherLanguages")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        ArrayList <TeacherAccount> teacherObjListBySubj = new ArrayList<>();

                        //Loops though every Teacher in the above table
                        for (final DataSnapshot snapshot1 : dataSnapshot.getChildren())
                        {
                            //Set teacher ID
                            final String teacherID = snapshot1.getKey();

                            for( final DataSnapshot snapshot2 : snapshot1.getChildren())
                            {
                                String teacherSubject = Objects.requireNonNull(snapshot2.getValue()).toString();
                                //Checks if the teacher teaches the desired subject and returns the teacherID if true
                                if(subject.equals(teacherSubject))
                                {


                                }
                            }
                        }
                        System.out.println("this is a new list 8:" + teacherObjListBySubj.size());

                        listener.onSuccessTeacherObj(teacherObjListBySubj);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
    }


    public void getTeacherObjsByYearsOfExperience(final int yearOfExp, final OnGetTeacherDataListener listener)
    {
        listener.onStart();
        mDatabase.child("Teacher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<TeacherAccount> teacherAccounts = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {

                    TeacherAccount teacherAccount = snapshot.getValue(TeacherAccount.class);
                    if(teacherAccount.getYearsOfExperience()==yearOfExp)
                    {
                        teacherAccounts.add(teacherAccount);
                    }


                }
                listener.onSuccessTeacherObj(teacherAccounts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onFailure();

            }
        });

    }

    public void getTeacherObjsByDrivingLicense(final boolean drivingLicence, final OnGetTeacherDataListener listener)
    {
        listener.onStart();
        mDatabase.child("Teacher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<TeacherAccount> teacherAccounts = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {

                    TeacherAccount teacherAccount = snapshot.getValue(TeacherAccount.class);
                    if(teacherAccount.isDrivingLicense()==drivingLicence)
                    {
                        teacherAccounts.add(teacherAccount);
                    }


                }
                listener.onSuccessTeacherObj(teacherAccounts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onFailure();

            }
        });

    }

    public void getTeacherObjsByDBS(final boolean dbs, final OnGetTeacherDataListener listener)
    {
        ArrayList<TeacherAccount> teacherAccounts = new ArrayList<>();
        ArrayList<TeacherAccount> results = new ArrayList<>();


        listener.onStart();
        mDatabase.child("Teacher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {

                    TeacherAccount teacherAccount = snapshot.getValue(TeacherAccount.class);
                    if(teacherAccount.isDbs()==dbs)
                    {
                        teacherAccounts.add(teacherAccount);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onFailure();

            }
        });

    }
    public void getTeacherInRadius(String SchoolPostCode, double maxDistance , OnGetTeacherDataListener listener)
    {
        getAllTeachers(new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {

                ArrayList<TeacherAccount> teachers = new ArrayList<>();
                for (TeacherAccount teacherAcc : teacherAccount)
                {
                    String teacherPostCode = "";
                    teacherPostCode = teacherAcc.getPostcode();

                    double teacherDistance = 0;
                    try {
                        teacherDistance = distanceCalculator.getDrivingDist(teacherPostCode, SchoolPostCode);
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(teacherDistance <= maxDistance)
                    {
                        teachers.add(teacherAcc);
                    }


                }

                listener.onSuccessTeacherObj(teachers);

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

    }




    public void getAllReleventTeachers(String subject, int yearsOfExperience, boolean checkDrivingLicense, boolean checkDBS, String schoolPostCode, int maxTeacherDist, OnGetTeacherDataListener listener )
    {
        getTeacherObjsBySubject(subject, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println("this is a list 10: " +teacherAccount.size());
                ArrayList<TeacherAccount> result = new ArrayList<>();

                for(TeacherAccount t: teacherAccount)
                {
                    String teacherPostCode = "";
                    teacherPostCode = t.getPostcode();

                    double teacherDistance = 0;
                    try {
                        teacherDistance = distanceCalculator.getDrivingDist(teacherPostCode, schoolPostCode);
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(t.getYearsOfExperience()>=yearsOfExperience && teacherDistance <=maxTeacherDist)
                    {
                        if(!checkDBS || t.isDbs())
                        {
                            if(!checkDrivingLicense || t.isDrivingLicense())
                            {
                                result.add(t);
                            }

                        }
                    }
                }
                System.out.println("list 1 : " + result.size());
                listener.onSuccessTeacherObj(result);

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

    }





    public void getTeacherCurrentSetDates(String teacherID, Ong listener)
    {
        ArrayList<String> setDates = new ArrayList<>();
        ArrayList<String> subject = new ArrayList<>();
        listener.onStart();
        mDatabase.child("TeacherAvailability").child(teacherID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (final DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    String workingDate = snapshot.getValue().toString();
                    setDates.add(workingDate);
                }
                listener.onSuccessDates(setDates);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
