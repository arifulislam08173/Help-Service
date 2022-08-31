package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutHome, layoutElectric, layouyMedical, layoutEmergency, layoutComputer, layoutWifi, layoutShopping, layoutShifting, layoutAir, layoutwater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutHome = findViewById(R.id.layoutHome);
        layoutHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }

        });

        layoutElectric = findViewById(R.id.layoutElectric);
        layoutElectric.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ElectricActivity.class);
                startActivity(intent);
            }

        });

        layouyMedical = findViewById(R.id.layoutMedical);
        layouyMedical.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MedicalActivity.class);
                startActivity(intent);
            }

        });

        layoutEmergency = findViewById(R.id.layoutEmergency);
        layoutEmergency.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EmergencyActivity.class);
                startActivity(intent);
            }

        });

        layoutComputer = findViewById(R.id.layoutComputer);
        layoutComputer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ComputerActivity.class);
                startActivity(intent);
            }

        });

        layoutWifi = findViewById(R.id.layoutWifi);
        layoutWifi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WifiActivity.class);
                startActivity(intent);
            }

        });

        layoutShopping = findViewById(R.id.layoutShopping);
        layoutShopping.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }

        });

        layoutShifting = findViewById(R.id.layoutShift);
        layoutShifting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShiftingActivity.class);
                startActivity(intent);
            }

        });

        layoutAir = findViewById(R.id.layoutAir);
        layoutAir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AirActivity.class);
                startActivity(intent);
            }

        });

        layoutwater = findViewById(R.id.layoutWater);
        layoutwater.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WaterActivity.class);
                startActivity(intent);
            }

        });

    }

}