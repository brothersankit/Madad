package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class School extends AppCompatActivity {

    CardView jvm;
    CardView dps;
    CardView sfs;
    CardView bwnam;
    CardView hehal;
    CardView kapildev;
    CardView donbosco;
    CardView kvnamkum;
    CardView xavier;
    CardView suren;
    CardView kairali;
    CardView guru;
    CardView fira;
    CardView bwdoranda;
    CardView oxf;
    CardView metas;
    CardView tau;
    CardView tho;
    CardView lor;
    CardView sac;
    CardView kv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        jvm = (CardView) findViewById(R.id.jvmm);

        jvm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Jvmshyamli.class);
                startActivity(i);
            }
        });

        dps = (CardView) findViewById(R.id.dpss);

        dps.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Dpsschool.class);
                startActivity(i);
            }
        });

        sfs = (CardView) findViewById(R.id.sfss);

        sfs.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Stfrancis.class);
                startActivity(i);
            }
        });

        bwnam = (CardView) findViewById(R.id.bwgss);

        bwnam.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Bishopnamkum.class);
                startActivity(i);
            }
        });

        hehal = (CardView) findViewById(R.id.hehalss);

        hehal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Davhehal.class);
                startActivity(i);
            }
        });

        kapildev = (CardView) findViewById(R.id.kapilss);

        kapildev.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Davkapildev.class);
                startActivity(i);
            }
        });

        donbosco = (CardView) findViewById(R.id.donss);

        donbosco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Donbosco.class);
                startActivity(i);
            }
        });

        kvnamkum = (CardView) findViewById(R.id.kvnss);

        kvnamkum.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Kvnamkum.class);
                startActivity(i);
            }
        });

        xavier = (CardView) findViewById(R.id.xavss);

        xavier.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Xavierschool.class);
                startActivity(i);
            }
        });

        suren = (CardView) findViewById(R.id.sncss);

        suren.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Surendranath.class);
                startActivity(i);
            }
        });

        kairali = (CardView) findViewById(R.id.kairaliss);

        kairali.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Kairalischool.class);
                startActivity(i);
            }
        });

        guru = (CardView) findViewById(R.id.guruss);

        guru.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Gurunanakschool.class);
                startActivity(i);
            }
        });

        fira = (CardView) findViewById(R.id.firayass);

        fira.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Firayalalschool.class);
                startActivity(i);
            }
        });

        bwdoranda = (CardView) findViewById(R.id.bwgdss);

        bwdoranda.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Bishopdoranda.class);
                startActivity(i);
            }
        });

        oxf = (CardView) findViewById(R.id.opsss);

        oxf.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Oxfordschool.class);
                startActivity(i);
            }
        });

        metas = (CardView) findViewById(R.id.metasss);

        metas.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Metasschool.class);
                startActivity(i);
            }
        });

        tau = (CardView) findViewById(R.id.taurianss);

        tau.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Taurianschool.class);
                startActivity(i);
            }
        });

        tho = (CardView) findViewById(R.id.thomass);

        tho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Thomasschool.class);
                startActivity(i);
            }
        });

        lor = (CardView) findViewById(R.id.loretos);

        lor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Loretoschool.class);
                startActivity(i);
            }
        });

        sac = (CardView) findViewById(R.id.sacreds);

        sac.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Sacredschool.class);
                startActivity(i);
            }
        });

        kv = (CardView) findViewById(R.id.kvcrpfs);

        kv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (School.this, Kvcrpf.class);
                startActivity(i);
            }
        });
    }
}