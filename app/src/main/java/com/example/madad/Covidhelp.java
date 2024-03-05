package com.example.madad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Covidhelp extends AppCompatActivity {

    CardView a;
    CardView b;
    CardView c;
    CardView d;
    CardView e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidhelp);

        a = (CardView)findViewById(R.id.hospitalcovid);

        a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Covidhelp.this, Covidhospital.class);
                startActivity(i);
            }
        });

        b = (CardView)findViewById(R.id.doctor);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Covidhelp.this, Coviddoctor.class);
                startActivity(i);
            }
        });

        c = (CardView)findViewById(R.id.oxygen);

        c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Covidhelp.this, Covidoxygen.class);
                startActivity(i);
            }
        });

        d = (CardView)findViewById(R.id.ambulance);

        d.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Covidhelp.this, Covidambulance.class);
                startActivity(i);
            }
        });

        e = (CardView)findViewById(R.id.dailyneed);

        e.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Covidhelp.this, Coviddailyneed.class);
                startActivity(i);
            }
        });


    }
}