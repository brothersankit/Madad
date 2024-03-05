package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Hotel extends AppCompatActivity {

    CardView chanak;
    CardView le;
    CardView rain;
    CardView map;
    CardView av;
    CardView cap;
    CardView gre;
    CardView radi;
    CardView ras;
    CardView roy;
    CardView ele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        chanak = (CardView) findViewById(R.id.chanakya);

        chanak.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelchanakya.class);
                startActivity(i);
            }
        });
        le = (CardView) findViewById(R.id.lelac);

        le.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotellelac.class);
                startActivity(i);
            }
        });
        rain = (CardView) findViewById(R.id.raindew);

        rain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelraindew.class);
                startActivity(i);
            }
        });
        cap = (CardView) findViewById(R.id.capitol);

        cap.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelcapitol.class);
                startActivity(i);
            }
        });
        map = (CardView) findViewById(R.id.maple);

        map.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelmaple.class);
                startActivity(i);
            }
        });
        av = (CardView) findViewById(R.id.avm);

        av.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelavm.class);
                startActivity(i);
            }
        });
        gre = (CardView) findViewById(R.id.green);

        gre.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelgreen.class);
                startActivity(i);
            }
        });
        radi = (CardView) findViewById(R.id.radisson);

        radi.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelradisson.class);
                startActivity(i);
            }
        });
        ras = (CardView) findViewById(R.id.raso);

        ras.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelraso.class);
                startActivity(i);
            }
        });
        roy = (CardView) findViewById(R.id.royal);

        roy.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelroyal.class);
                startActivity(i);
            }
        });
        ele = (CardView) findViewById(R.id.element);

        ele.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Hotel.this, Hotelelement.class);
                startActivity(i);
            }
        });
    }
}