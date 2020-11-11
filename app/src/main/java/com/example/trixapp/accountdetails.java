package com.example.trixapp;


import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;
import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class accountdetails extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    int fee;
    int Toatalfee;
    private ZXingScannerView mScannerView;
    String inputValue;
    String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        // Log.v("tag", rawResult.getText()); // Prints scan results
        // Log.v("tag", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Toast.makeText(accountdetails.this, rawResult.getText().toString(),
                Toast.LENGTH_LONG).show();

        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(this);
        String start = sharePref.getString("start",null);
        String end = rawResult.getText();

        Toatalfee=calculateFair(Integer.parseInt(start),Integer.parseInt(end));

        Toast.makeText(accountdetails.this,""+Toatalfee,
                Toast.LENGTH_LONG).show();

        String inputValue=start+"/"+end+"/"+Toatalfee;
        qrgEncoder = new QRGEncoder(inputValue,null,QRGContents.Type.TEXT,50*50);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
        } catch (WriterException e) {
            Log.v("tr", e.toString());
        }

        try {
            boolean save = QRGSaver.save(savePath, "myQr", bitmap, QRGContents.ImageType.IMAGE_JPEG);
            String result = save ? "Image Saved" : "Image Not Saved";
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //MainActivity.tvresult.setText(rawResult.getText());
        Intent intent = new Intent(this, purchasedtikcet.class);
        intent.putExtra("FEE", ""+Toatalfee);
        intent.putExtra("s1", start);
        intent.putExtra("s2", end);
        startActivity(intent);
        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
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


    }
