package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Maintainance extends AppCompatActivity {

    CardView plum;
    CardView elec;
    CardView builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintainance);

        plum = (CardView)findViewById(R.id.plumber);

        plum.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Maintainance.this, Plumber.class);
                startActivity(i);
            }
        });

        elec = (CardView)findViewById(R.id.electri);

        elec.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Maintainance.this, Electrician.class);
                startActivity(i);
            }
        });

        builder = (CardView)findViewById(R.id.build);

        builder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Maintainance.this, Builder.class);
                startActivity(i);
            }
        });


    }
}