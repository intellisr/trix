package com.example.trixapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {
    ImageButton scan;
    ImageButton qr;
    ImageButton exit;
    ImageButton resv;
    ImageButton time;
    ImageButton shedu;
    ImageButton topup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        scan = (ImageButton) findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });

        qr = (ImageButton) findViewById(R.id.qr);
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qr();
            }
        });

        exit = (ImageButton) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });

        time = (ImageButton) findViewById(R.id.timet);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time();
            }
        });

        resv = (ImageButton) findViewById(R.id.resv);
        resv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resv();
            }
        });

        shedu = (ImageButton) findViewById(R.id.shedu);
        shedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shedule();
            }
        });

        topup = (ImageButton) findViewById(R.id.topup);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shedule();
            }
        });

    }

    public void scan(){
        Intent intent = new Intent(this,Setting.class);
        startActivity(intent);
    }

    public void qr(){
        Intent intent = new Intent(this,Contactus.class);
        startActivity(intent);
    }

    public void exit(){
        Intent intent = new Intent(this, accountdetails.class);
        startActivity(intent);
    }

    public void time(){
        Intent intent = new Intent(this, timetable.class);
        startActivity(intent);
    }

    public void resv(){
        Intent intent = new Intent(this, Reservation.class);
        startActivity(intent);
    }

    public void shedule(){
        Intent intent = new Intent(this, Scheduledfairs.class);
        startActivity(intent);
    }

    public void topup(){
        Intent intent = new Intent(this, topupcard.class);
        startActivity(intent);
    }
}