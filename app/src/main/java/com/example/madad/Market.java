package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Market extends AppCompatActivity {

    CardView atalsmriti;
    CardView upper;
    CardView daily;
    CardView harmu;
    CardView potala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        atalsmriti = (CardView) findViewById(R.id.atal);

        atalsmriti.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Market.this, Atalsmritimarket.class);
                startActivity(i);
            }
        });

        upper = (CardView) findViewById(R.id.upperbazar);

        upper.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Market.this, Upperbazar.class);
                startActivity(i);
            }
        });

        daily = (CardView) findViewById(R.id.dailymarket);

        daily.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Market.this, Dailymarket.class);
                startActivity(i);
            }
        });

        harmu = (CardView) findViewById(R.id.harmu);

        harmu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Market.this, Harmumarket.class);
                startActivity(i);
            }
        });

        potala = (CardView) findViewById(R.id.potala);

        potala.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Market.this, Potalamarket.class);
                startActivity(i);
            }
        });

    }
}