package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Blooddonation extends AppCompatActivity {

    LinearLayout B1,B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blooddonation);

        B1=findViewById(R.id.B1);
        B2=findViewById(R.id.B2);

        B1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blooddonation.this,Callservitors.class);
                startActivity(intent);
            }

        });

        B2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blooddonation.this,MedicalActivity.class);
                startActivity(intent);
            }

        });
    }
}