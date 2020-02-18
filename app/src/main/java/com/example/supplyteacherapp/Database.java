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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Database {

    private FirebaseAuth mAuth;

    private static final String TAG = "MainActivity";
    private Context classContext;
    private DatabaseReference mDatabase;



    Database(Context classContext)
    {
        mAuth = FirebaseAuth.getInstance();
        this.classContext = classContext;
        mDatabase = FirebaseDatabase.getInstance().getReference();


    }


    public void registerNewUser(String email, String password)
    {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(classContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });

    }
    public void signinUser(String email, String password,  Class nextActivityContext )
    {
        final Class nextActivityContextFinal = nextActivityContext;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user, nextActivityContextFinal);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(classContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null, nextActivityContextFinal);
                        }

                        // ...
                    }
                });

    }

    public void addTeacherDetails(String username, String name, String address, String phone)
    {
        mDatabase.child("Teacher").child(username).child("Name").setValue(name);
        mDatabase.child("Teacher").child(username).child("Address").setValue(address);
        mDatabase.child("Teacher").child(username).child("Phone").setValue(phone);


    }
    public void addStudentDetails(String username, String name, String address, String phone)
    {
        mDatabase.child("School").child(username).child("Name").setValue(name);
        mDatabase.child("School").child(username).child("Address").setValue(address);
        mDatabase.child("School").child(username).child("Phone").setValue(phone);
    }

    public void addSchoolDetailsWithSchoolClass(String schoolID, School school)
    {
        mDatabase.child("School").child(schoolID).setValue(school);

    }

    public void addTeacherDetailsWithTeachClass(TeacherAccount teacher, String teacherID)
    {
        mDatabase.child("Teacher").child(teacherID).setValue(teacher);
    }


    public void  updateUI(FirebaseUser account, Class nextActivityContext){
        if(account != null){
            Intent intent = new Intent(classContext,nextActivityContext);
            Toast.makeText(classContext,"SignIn Successful",Toast.LENGTH_LONG).show();

            classContext.startActivity(intent);
        }else {
            Toast.makeText(classContext,"SignInFailed",Toast.LENGTH_LONG).show();

        }
    }

}
