package com.example.trixapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

public class purchasedtikcet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_purchasedtikcet);
        Intent intent = getIntent();

        String fee = intent.getStringExtra("FEE" );
        String start = intent.getStringExtra("s1" );
        String end = intent.getStringExtra("s2" );

        AlertDialog.Builder builder = new AlertDialog.Builder(purchasedtikcet.this);
        builder.setMessage("Fee:"+fee)
                .setTitle("Station "+start+" to "+"Station "+end);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
