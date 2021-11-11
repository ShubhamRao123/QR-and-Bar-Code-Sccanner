package com.example.qrcodescanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {


    Button scanBtn;
    public static TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},12);
        }
        else {
            Toast.makeText(this, "Permission Aloowed...", Toast.LENGTH_SHORT).show();
        }

        scanBtn = findViewById(R.id.scanBtn);
        textView =  findViewById(R.id.tvResult);
    }


    public void btnClicked(View view) {
        Intent intent = new Intent(MainActivity.this, ScannerView.class);
        startActivity(intent);
    }


}