package com.example.supplyteacherapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;


public class Database {

    private FirebaseAuth mAuth;

    private static final String TAG = "MainActivity";
    private Context classContext;
    private DatabaseReference mDatabase;
    private TeacherDB teacherDB;


    Database(Context classContext) {
        mAuth = FirebaseAuth.getInstance();
        this.classContext = classContext;
        mDatabase = FirebaseDatabase.getInstance().getReference();


    }


    public void registerNewUser(String email, String password, Class nextActivityClass) {
        final Class nextActivityClassFinal = nextActivityClass;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                            updateUIOnRegistration(user, nextActivityClassFinal);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(classContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            updateUIOnRegistration(null, nextActivityClassFinal);
                        }

                        // ...
                    }
                });

    }

    public void signinUser(String email, String password, Class nextActivityClass, final String logInAs) {
        final Class nextActivityClassFinal = nextActivityClass;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String username = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUIOnSignIn(user, nextActivityClassFinal);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(classContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUIOnSignIn(null, nextActivityClassFinal);
                        }

                        // ...
                    }
                });

    }


    public void addTeacherDetails(TeacherAccount teacher, String teacherID) {
        mDatabase.child("Teacher").child(teacherID).setValue(teacher);
    }

    public void addSchool(School s, String schoolID) {
        mDatabase.child("School").child(schoolID).setValue(s);
    }


    public void updateUIOnSignIn(FirebaseUser account, Class nextActivityContext) {
        if (account != null) {
            Intent intent = new Intent(classContext, nextActivityContext);
            Toast.makeText(classContext, "SignIn Successful", Toast.LENGTH_LONG).show();

            classContext.startActivity(intent);
        } else {
            Toast.makeText(classContext, "SignInFailed", Toast.LENGTH_LONG).show();

        }
    }

    public void updateUIOnRegistration(FirebaseUser account, Class nextActivityContext) {
        if (account != null) {
            Intent intent = new Intent(classContext, nextActivityContext);
            Toast.makeText(classContext, "Registration Successful", Toast.LENGTH_LONG).show();

            classContext.startActivity(intent);
        } else {
            Toast.makeText(classContext, "Registration Failed", Toast.LENGTH_LONG).show();

        }
    }

    public void addTeacherSubjects(String userID, String subject) {
        mDatabase.child("TeacherLanguages").child(userID).push().setValue(subject);
    }

    public void addTeacherAvailability(String teacherID, String newDate)
    {
        mDatabase.child("TeacherAvailability").child(teacherID).push().setValue(newDate);

    }

    public void addTeacherJobInvite(String teacherID, String schoolID)
    {
        mDatabase.child("teacherJob").child(teacherID).push().setValue(schoolID);
    }
}
