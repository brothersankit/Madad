package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Police extends AppCompatActivity {

    CardView argora;
    CardView doranda;
    CardView hindpidi;
    CardView lower;
    CardView chutia;
    CardView mahila;
    CardView lalpur;
    CardView kotwali;
    CardView jag;
    CardView bariatu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        argora = (CardView) findViewById(R.id.aps);

        argora.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Argoraps.class);
                startActivity(i);
            }
        });

        doranda = (CardView) findViewById(R.id.dops);

        doranda.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Dorandapolice.class);
                startActivity(i);
            }
        });

        hindpidi = (CardView) findViewById(R.id.hps);

        hindpidi.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Hindpiripolice.class);
                startActivity(i);
            }
        });

        lower = (CardView) findViewById(R.id.lbps);

        lower.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Lowerbazarpolice.class);
                startActivity(i);
            }
        });

        chutia = (CardView) findViewById(R.id.chps);

        chutia.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Chutiapolice.class);
                startActivity(i);
            }
        });

        mahila = (CardView) findViewById(R.id.mps);

        mahila.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Mahilathana.class);
                startActivity(i);
            }
        });

        lalpur = (CardView) findViewById(R.id.lps);

        lalpur.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Lalpurpolice.class);
                startActivity(i);
            }
        });

        kotwali = (CardView) findViewById(R.id.kps);

        kotwali.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Kotwalipolice.class);
                startActivity(i);
            }
        });

        jag = (CardView) findViewById(R.id.jps);

        jag.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Jagarnathpolice.class);
                startActivity(i);
            }
        });

        bariatu = (CardView) findViewById(R.id.baps);

        bariatu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Police.this, Bariatupolice.class);
                startActivity(i);
            }
        });
    }
}