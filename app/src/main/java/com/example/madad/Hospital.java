package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Hospital extends AppCompatActivity {

    CardView sante;
    CardView bhag;
    CardView orch;
    CardView medanta;
    CardView guru;
    CardView raj;
    CardView rani;
    CardView kc;
    CardView drlal;
    CardView prabha;
    CardView devk;
    CardView maa;
    CardView praga;
    CardView rims;
    CardView nagar;
    CardView sadar;
    CardView bbrims;
    CardView bbhec;
    CardView bbred;
    CardView bbnagar;
    CardView bbarch;
    CardView bbjh;
    CardView bbdev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        sante = (CardView) findViewById(R.id.santevitahos);

        sante.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Santevita.class);
                startActivity(i);
            }
        });

        bhag = (CardView) findViewById(R.id.bhagwanhos);

        bhag.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Bhagwanhos.class);
                startActivity(i);
            }
        });

        orch = (CardView) findViewById(R.id.orchidhos);

        orch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Orchid.class);
                startActivity(i);
            }
        });

        medanta = (CardView) findViewById(R.id.medantahos);

        medanta.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, MedantaHos.class);
                startActivity(i);
            }
        });

        guru = (CardView) findViewById(R.id.gurunanakhos);

        guru.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Gurunanakhos.class);
                startActivity(i);
            }
        });

        raj = (CardView) findViewById(R.id.rajjhos);

        raj.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Rajhospital.class);
                startActivity(i);
            }
        });

        rani = (CardView) findViewById(R.id.raniihos);

        rani.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Ranihospital.class);
                startActivity(i);
            }
        });

        kc = (CardView) findViewById(R.id.kchosp);

        kc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Kcroyhospital.class);
                startActivity(i);
            }
        });

        drlal = (CardView) findViewById(R.id.drlalhos);

        drlal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Drlalhospital.class);
                startActivity(i);
            }
        });

        prabha = (CardView) findViewById(R.id.prabhawatihos);

        prabha.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Prabhawatihospital.class);
                startActivity(i);
            }
        });

        devk = (CardView) findViewById(R.id.devkamalhos);

        devk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Devkamalhospital.class);
                startActivity(i);
            }
        });

        maa = (CardView) findViewById(R.id.maaramhosp);

        maa.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Maaramhospital.class);
                startActivity(i);
            }
        });

        praga = (CardView) findViewById(R.id.pragatihos);

        praga.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Pragatihospital.class);
                startActivity(i);
            }
        });

        rims = (CardView) findViewById(R.id.rimshosp);

        rims.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Rimshospital.class);
                startActivity(i);
            }
        });

        nagar = (CardView) findViewById(R.id.nagarmalhos);

        nagar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Nagarmalhospital.class);
                startActivity(i);
            }
        });

        sadar = (CardView) findViewById(R.id.sadarhosp);

        sadar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, Sadarhospital.class);
                startActivity(i);
            }
        });

        bbrims = (CardView) findViewById(R.id.bloodbrims);

        bbrims.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankRims.class);
                startActivity(i);
            }
        });

        bbhec = (CardView) findViewById(R.id.bloodbhec);

        bbhec.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankHec.class);
                startActivity(i);
            }
        });

        bbred = (CardView) findViewById(R.id.bloodred);

        bbred.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankRedcross.class);
                startActivity(i);
            }
        });

        bbnagar = (CardView) findViewById(R.id.bloodbnag);

        bbnagar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankNagarmal.class);
                startActivity(i);
            }
        });

        bbarch = (CardView) findViewById(R.id.bloodbarchi);

        bbarch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankArchi.class);
                startActivity(i);
            }
        });

        bbjh = (CardView) findViewById(R.id.bloodbjh);

        bbjh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankJharkhand.class);
                startActivity(i);
            }
        });

        bbdev = (CardView) findViewById(R.id.bloodbdev);

        bbdev.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hospital.this, BloodbankDevkamal.class);
                startActivity(i);
            }
        });

    }
}