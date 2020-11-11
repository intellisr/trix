package com.example.trixapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

public class Contactus extends AppCompatActivity {
    ImageView qrImg;
    String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        qrImg=(ImageView)findViewById(R.id.qr);
        Bitmap bmp = BitmapFactory.decodeFile(savePath + "myQr.jpg");
        qrImg.setImageBitmap(bmp);
    }
}