package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity implements OnFocusChangeListener {


    EditText editTextTextPersonName3,editTextPhone2,editTextTextEmailAddress3,editTextTextPersonName5,editTextTextPersonName6;
    Button bb;
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a = (Button)findViewById(R.id.button10);

        a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

        bb = (Button)findViewById(R.id.button6);
        bb.setFocusable(true);
        bb.setFocusableInTouchMode(true);
        bb.requestFocus();


        editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName3.setOnFocusChangeListener(this);
        editTextPhone2 = (EditText) findViewById(R.id.editTextPhone2);
        editTextPhone2.setOnFocusChangeListener(this);
        editTextTextEmailAddress3 = (EditText) findViewById(R.id.editTextTextEmailAddress3);
        editTextTextEmailAddress3.setOnFocusChangeListener(this);
        editTextTextPersonName5 = (EditText) findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName5.setOnFocusChangeListener(this);
        editTextTextPersonName6 = (EditText) findViewById(R.id.editTextTextPersonName6);
        editTextTextPersonName6.setOnFocusChangeListener(this);




    }
    @Override
    public void onFocusChange(View v, boolean gainFocus)
    {
        if(v.getId()==R.id.editTextTextPersonName3 && gainFocus)
            editTextTextPersonName3.setText(" ");
            //Toast.makeText(getApplicationContext(),"Name cleared!",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextPhone2 && gainFocus)
            editTextPhone2.setText(" ");
            //Toast.makeText(getApplicationContext(),"Phone No cleared",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextEmailAddress3 && gainFocus)
            editTextTextEmailAddress3.setText(" ");
            //Toast.makeText(getApplicationContext(),"Email cleared",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextPersonName5 && gainFocus)
            editTextTextPersonName5.setText(" ");
            //Toast.makeText(getApplicationContext(),"Pass cleared",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextPersonName6 && gainFocus)
            editTextTextPersonName6.setText(" ");
            //Toast.makeText(getApplicationContext(),"Confirm Pass Cleared",Toast.LENGTH_LONG).show();
    }




        /*public void process(View view) {
        editTextTextPersonName3=(EditText)findViewById(R.id.editTextTextPersonName3);
        editTextPhone2=(EditText)findViewById(R.id.editTextPhone2);
        editTextTextEmailAddress3=(EditText)findViewById(R.id.editTextTextEmailAddress3);
        editTextTextPersonName5=(EditText)findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6=(EditText)findViewById(R.id.editTextTextPersonName6);

        String fullname=editTextTextPersonName3.getText().toString().trim();
        String phone=editTextPhone2.getText().toString().trim();
        String email=editTextTextEmailAddress3.getText().toString().trim();
        String password=editTextTextPersonName5.getText().toString().trim();
        String confirmpassword=editTextTextPersonName6.getText().toString().trim();


        dataholder obj=new dataholder(fullname,email,password,confirmpassword);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Sign_Up");

        node.child(phone).setValue(obj);
        editTextTextPersonName3.setText("");
        editTextPhone2.setText("");
        editTextTextEmailAddress3.setText("");
        editTextTextPersonName5.setText("");
        editTextTextPersonName6.setText("");
        Toast.makeText(getApplicationContext(),"Sign Up Process Completed !",Toast.LENGTH_LONG).show();

    }*/

    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidMobile(String phone) {
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() ==10 ;
        }
        return false;
    }
    public boolean isValidWord( String word) {

        return word.matches("^[a-zA-Z][a-zA-Z\\s]+$");
    }
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    private boolean validate() {
        boolean fg=true;
        String pass=editTextTextPersonName5.getText().toString();
        //Toast.makeText(getApplicationContext(),pass,Toast.LENGTH_LONG).show();
        String cpass=editTextTextPersonName6.getText().toString();
        //Toast.makeText(getApplicationContext(),cpass,Toast.LENGTH_LONG).show();

         if(!pass.equals(cpass)){

            fg=false;
        }
        return fg;
    }

    public void process(android.view.View view) {
        editTextTextPersonName3=(EditText)findViewById(R.id.editTextTextPersonName3);
        editTextPhone2=(EditText)findViewById(R.id.editTextPhone2);
        editTextTextEmailAddress3=(EditText)findViewById(R.id.editTextTextEmailAddress3);
        editTextTextPersonName5=(EditText)findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6=(EditText)findViewById(R.id.editTextTextPersonName6);

        String fullname=editTextTextPersonName3.getText().toString().trim();
        String phone=editTextPhone2.getText().toString().trim();
        String email=editTextTextEmailAddress3.getText().toString().trim();
        String password=editTextTextPersonName5.getText().toString().trim();
        String confirmpassword=editTextTextPersonName6.getText().toString().trim();

        if(!isValidWord(fullname)){

            Toast.makeText(getApplicationContext(),"Invalid Name!",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }
        if(!isValidMobile(phone)){

            Toast.makeText(getApplicationContext(),"Invalid Phone Number!",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }
        if(!isValidMail(email)){

            Toast.makeText(getApplicationContext(),"Invalid Email Address!",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }
        if(!isValidPassword(password)){

            Toast.makeText(getApplicationContext(),"Invalid Password!",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }
        if(!validate()){
            Toast.makeText(getApplicationContext(),"Password Not matching",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }



        dataholder obj=new dataholder(fullname,email,password,confirmpassword,phone);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Sign_Up");

        node.child(phone).setValue(obj);
        editTextTextPersonName3.setText("");
        editTextPhone2.setText("");
        editTextTextEmailAddress3.setText("");
        editTextTextPersonName5.setText("");
        editTextTextPersonName6.setText("");
        Toast.makeText(getApplicationContext(),"Sign Up Process Completed !",Toast.LENGTH_LONG).show();
    }





}