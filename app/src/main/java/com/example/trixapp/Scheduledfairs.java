package com.example.trixapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Scheduledfairs extends AppCompatActivity {

    Spinner toSpin;
    Spinner fromSpin;
    int fee;
    RadioGroup radioGroup;
    EditText noOftick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduledfairs);

        radioGroup = (RadioGroup) findViewById(R.id.rdGroup);

        toSpin = (Spinner) findViewById(R.id.to);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.stations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpin.setAdapter(adapter);

        fromSpin = (Spinner) findViewById(R.id.from);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.stations, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpin.setAdapter(adapter2);

        noOftick=(EditText) findViewById(R.id.noTicket);
        
        

    }


    public int calculateFair(int Start,int End){
         int sCount=Math.abs(End - Start);
         if(sCount > 4 ){
             fee=25;
         }else if(sCount > 8){
             fee=20;
         }else{
             fee=30; 
         }
         int amount= sCount * fee;
         int fair=(int)amount;
         return fair;
    }
    
    public void purchase(View view){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        int tickets=Integer.parseInt(noOftick.getText().toString());
        int to=toSpin.getSelectedItemPosition();
        int from=fromSpin.getSelectedItemPosition();

        int res=calculateFair(to,from);

        int fair=res*tickets*selectedId;

        Toast.makeText(Scheduledfairs.this, "Your calculated fair is : "+fair,
                Toast.LENGTH_LONG).show();
    }
}