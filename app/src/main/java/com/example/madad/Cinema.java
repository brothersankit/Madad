package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Cinema extends AppCompatActivity {

    CardView pvr;
    CardView srs;
    CardView fun;
    CardView carnival;
    CardView sujata;
    CardView popkorn;
    CardView plaza;
    CardView eylex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        pvr = (CardView) findViewById(R.id.pvrcinema);

        pvr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Pvrcinema.class);
                startActivity(i);
            }
        });

        srs = (CardView) findViewById(R.id.srscinema);

        srs.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Srscinema.class);
                startActivity(i);
            }
        });

        fun = (CardView) findViewById(R.id.funcinema);

        fun.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Funcinema.class);
                startActivity(i);
            }
        });

        carnival = (CardView) findViewById(R.id.jdhigh);

        carnival.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Carnivalcinema.class);
                startActivity(i);
            }
        });

        sujata = (CardView) findViewById(R.id.sujata);

        sujata.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Sujatacinema.class);
                startActivity(i);
            }
        });

        popkorn = (CardView) findViewById(R.id.popkorn);

        popkorn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Popkorncinema.class);
                startActivity(i);
            }
        });

        plaza = (CardView) findViewById(R.id.plaza);

        plaza.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Plazacinema.class);
                startActivity(i);
            }
        });

        eylex = (CardView) findViewById(R.id.eyelex);

        eylex.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Cinema.this, Eyelexcinema.class);
                startActivity(i);
            }
        });
    }
}