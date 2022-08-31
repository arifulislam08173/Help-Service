package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateServitorsInfo extends AppCompatActivity {
    //LinearLayout AddButton;
    private RecyclerView HS;
    private LinearLayout HSnodata;
    private List<ServitorsData> list1;
    private ServitorsAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_servitors_info);

        HS = findViewById(R.id.HS);
        HSnodata = findViewById(R.id.HSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        HS();

    }

    private void HS() {
        dbRef = reference.child("Home Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    HSnodata.setVisibility(View.VISIBLE);
                    HS.setVisibility(View.GONE);
                }else{
                    HSnodata.setVisibility(View.GONE);
                    HS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list1.add(data);
                    }
                    HS.setHasFixedSize(true);
                    HS.setLayoutManager(new LinearLayoutManager(UpdateServitorsInfo.this));
                    adapter=new ServitorsAdapter(list1,UpdateServitorsInfo.this);
                    HS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateServitorsInfo.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
