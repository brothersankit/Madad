package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class College extends AppCompatActivity {

    CardView rims;
    CardView bit;
    CardView bitex;
    CardView rinpas;
    CardView bethesda;
    CardView paul;
    CardView goss;
    CardView iim;
    CardView cit;
    CardView xavins;
    CardView iiit;
    CardView marwari;
    CardView xav;
    CardView nir;
    CardView doran;
    CardView women;
    CardView marg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        rims = (CardView) findViewById(R.id.rimss);

        rims.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Rimscollege.class);
                startActivity(i);
            }
        });

        bit = (CardView) findViewById(R.id.bits);

        bit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Bitmesra.class);
                startActivity(i);
            }
        });

        bitex = (CardView) findViewById(R.id.bitexs);

        bitex.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Bitextension.class);
                startActivity(i);
            }
        });

        rinpas = (CardView) findViewById(R.id.rinpass);

        rinpas.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Rinpas.class);
                startActivity(i);
            }
        });

        bethesda = (CardView) findViewById(R.id.bethesdas);

        bethesda.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Betesdacollege.class);
                startActivity(i);
            }
        });

        paul = (CardView) findViewById(R.id.pauls);

        paul.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Stpaulcollege.class);
                startActivity(i);
            }
        });

        goss = (CardView) findViewById(R.id.gossners);

        goss.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Gossenercollege.class);
                startActivity(i);
            }
        });

        iim = (CardView) findViewById(R.id.iims);

        iim.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Iimcollege.class);
                startActivity(i);
            }
        });

        cit = (CardView) findViewById(R.id.cits);

        cit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Citcollege.class);
                startActivity(i);
            }
        });

        xavins = (CardView) findViewById(R.id.xisss);

        xavins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Xavierinstitute.class);
                startActivity(i);
            }
        });

        iiit = (CardView) findViewById(R.id.iiits);

        iiit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Iiitcollege.class);
                startActivity(i);
            }
        });

        marwari = (CardView) findViewById(R.id.marwaris);

        marwari.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Marwaricollege.class);
                startActivity(i);
            }
        });

        xav = (CardView) findViewById(R.id.xavcs);

        xav.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Stxaviercollege.class);
                startActivity(i);
            }
        });

        nir = (CardView) findViewById(R.id.nirmalas);

        nir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Nirmalacollege.class);
                startActivity(i);
            }
        });

        doran = (CardView) findViewById(R.id.dorandas);

        doran.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Dorandacollege.class);
                startActivity(i);
            }
        });

        women = (CardView) findViewById(R.id.womens);

        women.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Womencollege.class);
                startActivity(i);
            }
        });

        marg = (CardView) findViewById(R.id.marwarigs);

        marg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (College.this, Marwarigirls.class);
                startActivity(i);
            }
        });


    }
}