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

public class AirActivity extends AppCompatActivity {
    private RecyclerView AS;
    private LinearLayout ASnodata;
    private List<ServitorsData> list7;
    private ServitorsAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);

        AS = findViewById(R.id.AS);

        ASnodata = findViewById(R.id.ASnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        AS();
    }
    private void AS() {
        dbRef = reference.child("Air Condition Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ASnodata.setVisibility(View.VISIBLE);
                    AS.setVisibility(View.GONE);
                }else{
                    ASnodata.setVisibility(View.GONE);
                    AS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list7.add(data);
                    }
                    AS.setHasFixedSize(true);
                    AS.setLayoutManager(new LinearLayoutManager(AirActivity.this));
                    adapter=new ServitorsAdapter(list7,AirActivity.this);
                    AS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AirActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}