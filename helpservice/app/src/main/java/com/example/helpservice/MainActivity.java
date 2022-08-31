package com.example.helpservice;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout layoutHome, layoutElectric, layouyMedical, layoutEmergency, layoutComputer, layoutWifi, layoutShopping, layoutShifting, layoutAir, layoutwater;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MainActivity.this,option.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
       // nav_logout=findViewById(R.id.nav_logout);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



       /*drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

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
                Intent intent = new Intent(MainActivity.this,Blooddonation.class);
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
                Intent intent = new Intent(MainActivity.this,Category.class);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),option.class));
                finish();
                break;
            case R.id.nav_home:
                drawerLayout.closeDrawer(GravityCompat.START);
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                //finish();
                break;
            case R.id.nav_profile:

                startActivity(new Intent(getApplicationContext(),profile.class));
                finish();
                break;

          /*  case R.id.nav_upprofile:

                startActivity(new Intent(getApplicationContext(),setprofile.class));
                finish();
                break;*/

            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}


