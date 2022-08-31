package com.example.dashboard.Servitors;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.dashboard.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddServitors extends AppCompatActivity {

    private ImageView pp;
    private EditText name,num,address,age;
    private Spinner servitorCategory;
    private Button addbtn;
    private final int REQ = 1;
    private Bitmap bitmap = null;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_servitors);

        pp = findViewById(R.id.pp);
        name = findViewById(R.id.name);
        num = findViewById(R.id.num);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        servitorCategory = findViewById(R.id.serviceCategory);
        addbtn = findViewById(R.id.addbtn);

        String[] items = new String[]{"Select Service","Home Service","Electric Service","Medical Service","Computer Service","WiFi Service","Shopping Service","Shifting Service","Air Condition Service","Water Pipe Service"};
        servitorCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item));
        servitorCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = servitorCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pp.setOnClickListener((view) -> { openGallery(); });
    }

    private  void openGallery(){
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ && resultCode == RESULT_OK){
            Uri uri =data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pp.setImageBitmap(bitmap);
        }
    }
}