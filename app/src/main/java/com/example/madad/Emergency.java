package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Emergency extends AppCompatActivity {

    CardView a;
    CardView b;
    CardView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        a = (CardView) findViewById(R.id.police);

        a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Emergency.this, Police.class);
                startActivity(i);
            }
        });

        b = (CardView)findViewById(R.id.fire);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Emergency.this, Fire.class);
                startActivity(i);
            }
        });

        c = (CardView)findViewById(R.id.municipal);

        c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Emergency.this, Municipal.class);
                startActivity(i);
            }
        });
    }
}