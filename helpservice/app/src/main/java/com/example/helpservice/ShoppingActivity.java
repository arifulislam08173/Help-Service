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

public class ShoppingActivity extends AppCompatActivity {

    private RecyclerView SpS;
    private LinearLayout SpSnodata;
    private List<ServitorsData> list8;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        SpS = findViewById(R.id.SpS);

        SpSnodata = findViewById(R.id.SpSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        SpS();
    }
    private void SpS() {
        dbRef = reference.child("Shopping Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    SpSnodata.setVisibility(View.VISIBLE);
                    SpS.setVisibility(View.GONE);
                }else{
                    SpSnodata.setVisibility(View.GONE);
                    SpS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list8.add(data);
                    }
                    SpS.setHasFixedSize(true);
                    SpS.setLayoutManager(new LinearLayoutManager(ShoppingActivity.this));
                    adapter=new ServitorsAdapter(list8,ShoppingActivity.this);
                    SpS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShoppingActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}