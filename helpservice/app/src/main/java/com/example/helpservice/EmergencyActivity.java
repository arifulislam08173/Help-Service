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

public class EmergencyActivity extends AppCompatActivity {

    private RecyclerView EmS;
    private LinearLayout EmSnodata;
    private List<ServitorsData> list5;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        EmS = findViewById(R.id.EmS);

        EmSnodata = findViewById(R.id.EmSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        EmS();
    }
    private void EmS() {
        dbRef = reference.child("Medical Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    EmSnodata.setVisibility(View.VISIBLE);
                    EmS.setVisibility(View.GONE);
                }else{
                    EmSnodata.setVisibility(View.GONE);
                    EmS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list5.add(data);
                    }
                    EmS.setHasFixedSize(true);
                    EmS.setLayoutManager(new LinearLayoutManager(EmergencyActivity.this));
                    adapter=new ServitorsAdapter(list5,EmergencyActivity.this);
                    EmS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(EmergencyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}