package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    Button b;
    Button c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b = (Button)findViewById(R.id.button5);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (MainActivity4.this, MainActivity3.class);
                startActivity(i);
            }
        });

        c = (Button)findViewById(R.id.button2);

        c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (MainActivity4.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }


}