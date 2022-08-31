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

public class WaterActivity extends AppCompatActivity {

    private RecyclerView WaS;
    private LinearLayout WaSnodata;
    private List<ServitorsData> list11;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        WaS = findViewById(R.id.WaS);

        WaSnodata = findViewById(R.id.WaSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        WaS();
    }
    private void WaS() {
        dbRef = reference.child("Water Pipe Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    WaSnodata.setVisibility(View.VISIBLE);
                    WaS.setVisibility(View.GONE);
                }else{
                    WaSnodata.setVisibility(View.GONE);
                    WaS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list11.add(data);
                    }
                    WaS.setHasFixedSize(true);
                    WaS.setLayoutManager(new LinearLayoutManager(WaterActivity.this));
                    adapter=new ServitorsAdapter(list11,WaterActivity.this);
                    WaS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(WaterActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}