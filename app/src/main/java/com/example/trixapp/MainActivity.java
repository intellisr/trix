package com.example.trixapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private EditText un;
    private EditText pw;
    public String username;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un = (EditText) findViewById(R.id.username);
        pw = (EditText) findViewById(R.id.Password);

        button = (Button) findViewById(R.id.signinbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=un.getText().toString();
                password=pw.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter UserName and Password to continue",
                            Toast.LENGTH_LONG).show();
                }else {
                    openmenu();
                }
            }
        });

        button2 = (Button) findViewById(R.id.signUpbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReg();
            }
        });
    }
    public void openmenu(){
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }
    public void openReg(){
        Intent intent = new Intent(this, topupcard.class);
        startActivity(intent);
    }
}