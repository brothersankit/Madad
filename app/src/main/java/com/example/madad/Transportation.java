package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Transportation extends AppCompatActivity {


    CardView ranchirail;
    CardView namkumrail;
    CardView hatiarail;
    CardView airport;
    CardView govtbus;
    CardView khadgarha;
    CardView ratu;
    CardView iti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        ranchirail = (CardView) findViewById(R.id.ranchirail);

        ranchirail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Ranchirailway.class);
                startActivity(i);
            }
        });

        namkumrail = (CardView) findViewById(R.id.namkumrail);

        namkumrail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Namkumrail.class);
                startActivity(i);
            }
        });

        hatiarail = (CardView) findViewById(R.id.hatiarail);

        hatiarail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Hatiarail.class);
                startActivity(i);
            }
        });

        airport = (CardView) findViewById(R.id.airport);

        airport.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Airport.class);
                startActivity(i);
            }
        });

        govtbus = (CardView) findViewById(R.id.governmentbus);

        govtbus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Governmentbus.class);
                startActivity(i);
            }
        });

        ranchirail = (CardView) findViewById(R.id.ranchirail);

        ranchirail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Ranchirailway.class);
                startActivity(i);
            }
        });

        khadgarha = (CardView) findViewById(R.id.khadgarhabus);

        khadgarha.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Khadgarhabus.class);
                startActivity(i);
            }
        });

        ratu = (CardView) findViewById(R.id.ratubus);

        ratu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Ratubus.class);
                startActivity(i);
            }
        });

        iti = (CardView) findViewById(R.id.itibus);

        iti.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Transportation.this, Itibus.class);
                startActivity(i);
            }
        });


    }
}