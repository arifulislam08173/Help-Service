package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class DemoDashboard extends AppCompatActivity {

    RelativeLayout layoutHome1, layoutElectric1, layouyMedical1, layoutEmergency1, layoutComputer1, layoutWifi1, layoutShopping1, layoutShifting1, layoutAir1, layoutwater1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_dashboard);

        layoutHome1 = findViewById(R.id.layoutHome1);
        layoutHome1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutElectric1 = findViewById(R.id.layoutElectric1);
        layoutElectric1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layouyMedical1 = findViewById(R.id.layoutMedical1);
        layouyMedical1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutEmergency1 = findViewById(R.id.layoutEmergency1);
        layoutEmergency1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutComputer1 = findViewById(R.id.layoutComputer1);
        layoutComputer1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutWifi1 = findViewById(R.id.layoutWifi1);
        layoutWifi1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutShopping1 = findViewById(R.id.layoutShopping1);
        layoutShopping1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutShifting1 = findViewById(R.id.layoutShift1);
        layoutShifting1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutAir1 = findViewById(R.id.layoutAir1);
        layoutAir1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });

        layoutwater1 = findViewById(R.id.layoutWater1);
        layoutwater1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoDashboard.this,signinup.class);
                startActivity(intent);
            }

        });
    }
}