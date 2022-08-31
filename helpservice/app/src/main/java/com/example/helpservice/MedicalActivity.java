package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class MedicalActivity extends AppCompatActivity {

    private RecyclerView MS;
    private LinearLayout MSnodata;
    private List<ServitorsData> list4;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        MS = findViewById(R.id.MS);

        MSnodata = findViewById(R.id.MSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        MS();
    }
    private void MS() {
        dbRef = reference.child("Medical Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    MSnodata.setVisibility(View.VISIBLE);
                    MS.setVisibility(View.GONE);
                }else{
                    MSnodata.setVisibility(View.GONE);
                    MS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list4.add(data);
                    }
                    MS.setHasFixedSize(true);
                    MS.setLayoutManager(new LinearLayoutManager(MedicalActivity.this));
                    adapter=new ServitorsAdapter(list4,MedicalActivity.this);
                    MS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MedicalActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}