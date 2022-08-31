package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Callservitors extends AppCompatActivity {

    LinearLayout hos_1,hos_2,hos_3,hos_4,hos_5,hos_6,hos_7,hos_8,hos_9,hos_10,hos_11,hos_12,hos_13,hos_14,hos_15,hos_16,hos_17,hos_18,hos_19,hos_20;
    TextView text_1,text_2,text_3,text_4,text_5,text_6,text_7,text_8,text_9,text_10,text_11,text_12,text_13,text_14,text_15,text_16,text_17,text_18,text_19,text_20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callservitors);

        hos_1 = findViewById(R.id.hos_1);
        text_1 = findViewById(R.id.text_1);

        hos_2= findViewById(R.id.hos_2);
        text_2= findViewById(R.id.text_2);

        hos_3= findViewById(R.id.hos_3);
        text_3= findViewById(R.id.text_3);

        hos_4= findViewById(R.id.hos_4);
        text_4= findViewById(R.id.text_4);

        hos_5= findViewById(R.id.hos_5);
        text_5= findViewById(R.id.text_5);

        hos_6= findViewById(R.id.hos_6);
        text_6= findViewById(R.id.text_6);

        hos_7= findViewById(R.id.hos_7);
        text_7= findViewById(R.id.text_7);

        hos_8= findViewById(R.id.hos_8);
        text_8= findViewById(R.id.text_8);

        hos_9= findViewById(R.id.hos_9);
        text_9= findViewById(R.id.text_9);

        hos_10= findViewById(R.id.hos_10);
        text_10= findViewById(R.id.text_10);

        hos_11= findViewById(R.id.hos_11);
        text_11= findViewById(R.id.text_11);

        hos_12= findViewById(R.id.hos_12);
        text_12= findViewById(R.id.text_12);

        hos_13= findViewById(R.id.hos_13);
        text_13= findViewById(R.id.text_13);

        hos_14= findViewById(R.id.hos_14);
        text_14= findViewById(R.id.text_14);

        hos_15= findViewById(R.id.hos_15);
        text_15= findViewById(R.id.text_15);

        hos_16= findViewById(R.id.hos_16);
        text_16= findViewById(R.id.text_16);

        hos_17= findViewById(R.id.hos_17);
        text_17= findViewById(R.id.text_17);

        hos_18= findViewById(R.id.hos_18);
        text_18= findViewById(R.id.text_18);

        hos_19= findViewById(R.id.hos_19);
        text_19= findViewById(R.id.text_19);

        hos_20= findViewById(R.id.hos_20);
        text_20= findViewById(R.id.text_20);


        hos_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_1.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_2.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_3.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_4.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_5.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_6.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_7.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_8.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_9.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_10.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_11.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_12.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_13.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_14.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_15.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_16.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_17.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_18.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_19.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

        hos_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bd = text_20.getText().toString();
                String aus = "tel:" + bd;
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse(aus));
                startActivity(ind);
            }
        });

    }
}