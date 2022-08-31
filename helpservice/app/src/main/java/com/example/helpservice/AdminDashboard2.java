package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard2 extends AppCompatActivity {
    LinearLayout layoutHome;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(AdminDashboard2.this,option.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard2);

        layoutHome = findViewById(R.id.layoutHome);
        layoutHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard2.this,AddServitors.class);
                startActivity(intent);
            }

        });
    }
    public void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),option.class));
        finish();
    }

}