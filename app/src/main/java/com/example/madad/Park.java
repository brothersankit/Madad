package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Park extends AppCompatActivity {

    CardView biodiversity;
    CardView biological;
    CardView children;
    CardView nakshatra;
    CardView nigam;
    CardView oxygen;
    CardView rock;
    CardView sindhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        biodiversity = (CardView) findViewById(R.id.biodiversity);

        biodiversity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Biodiversitypark.class);
                startActivity(i);
            }
        });

        biological = (CardView) findViewById(R.id.biologicalpark);

        biological.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Biologicalpark.class);
                startActivity(i);
            }
        });

        children = (CardView) findViewById(R.id.childrenpark);

        children.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Childrenpark.class);
                startActivity(i);
            }
        });

        nakshatra = (CardView) findViewById(R.id.nakshatra);

        nakshatra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Nakshatrapark.class);
                startActivity(i);
            }
        });

        nigam = (CardView) findViewById(R.id.nigampark);

        nigam.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Nigampark.class);
                startActivity(i);
            }
        });

        oxygen = (CardView) findViewById(R.id.oxygenpark);

        oxygen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Oxygenpark.class);
                startActivity(i);
            }
        });

        rock = (CardView) findViewById(R.id.rockgarden);

        rock.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Rockgarden.class);
                startActivity(i);
            }
        });

        sindhu = (CardView) findViewById(R.id.sindhupark);

        sindhu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Park.this, Sindhukanhupark.class);
                startActivity(i);
            }
        });
    }
}