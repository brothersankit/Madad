package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class Forgotpass extends AppCompatActivity implements OnFocusChangeListener {

    Button aa;
    public static String email;
    public static String mob;


    EditText editTextTextPersonName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setOnFocusChangeListener(this);
        aa = (Button)findViewById(R.id.button3);
        aa.setFocusable(true);
        aa.setFocusableInTouchMode(true);
        aa.requestFocus();
        //editTextTextPersonName.setFocusable(false);
        //editTextTextPersonName.setFocusableInTouchMode(false);
        aa.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mobile();
                //Intent i = new Intent (Forgotpass.this, OtpPassword.class);
               // startActivity(i);


            }


        });

    }

    @Override
    public void onFocusChange(View v, boolean gainFocus) {
        if (v.getId() == R.id.editTextTextPersonName && gainFocus)
            editTextTextPersonName.setText(" ");
    }



    public void mobile() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

         mob=editTextTextPersonName.getText().toString().trim();

        mDatabase.child("Sign_Up").child(mob).addListenerForSingleValueEvent(
                new ValueEventListener() {
                   @Override
                    public void onDataChange(@NotNull @org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
                       if(dataSnapshot.exists()) {
                           //Toast.makeText(getApplicationContext(),mob,Toast.LENGTH_LONG).show();
                           dataholder contact = dataSnapshot.getValue(dataholder.class);
                            assert contact != null;
                            email = contact.getEmail();
                          // Toast.makeText(getApplicationContext(),"Data Found"+" "+email,Toast.LENGTH_LONG).show();
                          try {
                               Thread.sleep(1000);
                               Intent i = new Intent (Forgotpass.this, OtpPassword.class);
                               startActivity(i);



                           } catch (Exception e) {

                               //e.printStackTrace();
                               Toast.makeText(getApplicationContext(), "Error"+e,Toast.LENGTH_LONG).show();
                           }


                       }else{
                           Toast.makeText(getApplicationContext()," User Not Exists",Toast.LENGTH_LONG).show();
                       }

                    }

                    @Override
                    public void onCancelled(@NotNull @org.jetbrains.annotations.NotNull DatabaseError databaseError) {

                    }
                });


    }





}