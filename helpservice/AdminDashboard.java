package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdminDashboard extends AppCompatActivity {

    LinearLayout AddProfile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        AddProfile1 = findViewById(R.id.AddProfile1);

        AddProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this,AddServitors.class);
                startActivity(intent);
            }
        });
    }
}