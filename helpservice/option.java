package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class option extends AppCompatActivity {

    Button needservice;
    Button servicegive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        needservice = findViewById(R.id.needservice);
        servicegive = findViewById(R.id.servicegive);

         needservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

         servicegive.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(),servitorlogin.class));
             }
         });
    }
    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter == 2)
        super.onBackPressed();
    }
}