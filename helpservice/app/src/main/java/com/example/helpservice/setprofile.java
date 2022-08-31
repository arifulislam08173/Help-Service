package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setprofile extends AppCompatActivity {

    private Button continueBtn;
    private EditText nameBox, emailBox,ageBox,phoneBox, addressBox;

    public static final String CONTENT1 = "CONTENT1";
    public static final String CONTENT2 = "CONTENT2";
    public static final String CONTENT3 = "CONTENT3";
    public static final String CONTENT4 = "CONTENT4";
    public static final String CONTENT5 = "CONTENT5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setprofile);


        continueBtn = findViewById(R.id.continueBtn);
        nameBox = findViewById(R.id.nameBox);
        emailBox = findViewById(R.id.emailBox);
        ageBox = findViewById(R.id.ageBox);
        phoneBox = findViewById(R.id.phoneBox);
        addressBox = findViewById(R.id.addressBox);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = nameBox.getText().toString();
                String data2 = emailBox.getText().toString();
                String data3 = ageBox.getText().toString();
                String data4 = phoneBox.getText().toString();
                String data5 = addressBox.getText().toString();

                Intent intent = new Intent(setprofile.this,profile.class);
                intent.putExtra(CONTENT1,data1);
                intent.putExtra(CONTENT2,data2);
                intent.putExtra(CONTENT3,data3);
                intent.putExtra(CONTENT4,data4);
                intent.putExtra(CONTENT5,data5);
                startActivity(intent);
            }
        });

    }
}