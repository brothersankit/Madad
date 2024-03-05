package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class pop extends AppCompatActivity {

    CardView covidhelp;

    CardView emergency;
    CardView aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);



        covidhelp = (CardView)findViewById(R.id.covidhelp);

        covidhelp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (pop.this, Covidhelp.class);
                startActivity(i);
            }
        });



        emergency = (CardView)findViewById(R.id.emergency);

        emergency.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (pop.this, Emergency.class);
                startActivity(i);
            }
        });

        aboutus = (CardView)findViewById(R.id.about);

        aboutus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(pop.this, aboutus.class);
                startActivity(i);
            }
        });

    }
}