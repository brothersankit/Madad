package com.example.madad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtpPassword extends AppCompatActivity implements View.OnFocusChangeListener {


    Button aa;

    EditText otp;
    EditText password;
    EditText password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp_password);
        otp = (EditText) findViewById(R.id.otpp);
        otp.setOnFocusChangeListener(this);
        aa = (Button)findViewById(R.id.button11);
        aa.setFocusable(true);
        aa.setFocusableInTouchMode(true);
        aa.requestFocus();

        password=(EditText)findViewById(R.id.editTextTextPersonName7);
        password.setOnFocusChangeListener(this);

        password1=(EditText)findViewById(R.id.editTextTextPassword3);
        password1.setOnFocusChangeListener(this);

        aa.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OtpEmail();
            }
        });
    }

    @Override
    public void onFocusChange(View v, boolean gainFocus)
    {
        if(v.getId()==R.id.otpp && gainFocus)
            otp.setText(" ");
            //Toast.makeText(getApplicationContext(),"Name cleared!",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextPersonName7 && gainFocus)
            password.setText(" ");
            //Toast.makeText(getApplicationContext(),"Phone No cleared",Toast.LENGTH_LONG).show();
        else if(v.getId()==R.id.editTextTextPassword3 && gainFocus)
            password1.setText(" ");
            //Toast.makeText(getApplicationContext(),"Email cleared",Toast.LENGTH_LONG).show();

    }






    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }


    public void OtpEmail(){

        String email1=Forgotpass.email;
        String key_ph=Forgotpass.mob;
        String input=otp.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(!isValidPassword(pass)){

            Toast.makeText(getApplicationContext(),"Invalid Password!",Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1000);



            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            return;

        }

       if(input.charAt(0)==email1.charAt(0) && input.charAt(1)==email1.charAt(1) && input.charAt(2)==email1.charAt(email1.indexOf('@')-1) ){
            Toast.makeText(getApplicationContext(),"Password Updated"+key_ph, Toast.LENGTH_LONG).show();
           DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Sign_Up");
           reference.child(key_ph).child("password").setValue(pass);

        }else{
           Toast.makeText(getApplicationContext(),"Incorrect Credentials", Toast.LENGTH_LONG).show();
       }





    }
}