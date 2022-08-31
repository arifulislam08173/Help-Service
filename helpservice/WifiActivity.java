package com.example.helpservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WifiActivity extends AppCompatActivity {

    private RecyclerView WifiS;
    private LinearLayout WifiSnodata;
    private List<ServitorsData> list7;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        WifiS = findViewById(R.id.WifiS);

        WifiSnodata = findViewById(R.id.WifiSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        WifiS();
    }
    private void WifiS() {
        dbRef = reference.child("WiFi Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    WifiSnodata.setVisibility(View.VISIBLE);
                    WifiS.setVisibility(View.GONE);
                }else{
                    WifiSnodata.setVisibility(View.GONE);
                    WifiS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list7.add(data);
                    }
                    WifiS.setHasFixedSize(true);
                    WifiS.setLayoutManager(new LinearLayoutManager(WifiActivity.this));
                    adapter=new ServitorsAdapter(list7,WifiActivity.this);
                    WifiS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(WifiActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}