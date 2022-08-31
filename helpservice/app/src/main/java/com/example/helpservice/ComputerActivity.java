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

public class ComputerActivity extends AppCompatActivity {

    private RecyclerView CS;
    private LinearLayout CSnodata;
    private List<ServitorsData> list3;
    private ServitorsAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        CS = findViewById(R.id.CS);

        CSnodata = findViewById(R.id.CSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        CS();
    }
    private void CS() {
        dbRef = reference.child("Computer Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    CSnodata.setVisibility(View.VISIBLE);
                    CS.setVisibility(View.GONE);
                }else{
                    CSnodata.setVisibility(View.GONE);
                    CS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list3.add(data);
                    }
                    CS.setHasFixedSize(true);
                    CS.setLayoutManager(new LinearLayoutManager(ComputerActivity.this));
                    adapter=new ServitorsAdapter(list3,ComputerActivity.this);
                    CS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ComputerActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}