package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Gym extends AppCompatActivity {

    CardView talwalkars;
    CardView nn;
    CardView gold;
    CardView sparx;
    CardView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        talwalkars = (CardView) findViewById(R.id.talwal);

        talwalkars.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Gym.this, Talwalkargym.class);
                startActivity(i);
            }
        });

        nn = (CardView) findViewById(R.id.nn);

        nn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Gym.this, Nngym.class);
                startActivity(i);
            }
        });

        gold = (CardView) findViewById(R.id.gold);

        gold.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Gym.this, Goldgym.class);
                startActivity(i);
            }
        });

        sparx = (CardView) findViewById(R.id.sparxx);

        sparx.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Gym.this, Sparxgym.class);
                startActivity(i);
            }
        });

        health = (CardView) findViewById(R.id.healthh);

        health.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Gym.this, Healthgym.class);
                startActivity(i);
            }
        });
    }
}