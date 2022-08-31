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

public class ShiftingActivity extends AppCompatActivity {

    private RecyclerView ShfS;
    private LinearLayout ShfSnodata;
    private List<ServitorsData> list9;
    private ServitorsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifting);

        ShfS = findViewById(R.id.ShfS);

        ShfSnodata = findViewById(R.id.ShfSnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        ShfS();
    }
    private void ShfS() {
        dbRef = reference.child("Shifting Service");
        dbRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ShfSnodata.setVisibility(View.VISIBLE);
                    ShfS.setVisibility(View.GONE);
                }else{
                    ShfSnodata.setVisibility(View.GONE);
                    ShfS.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list9.add(data);
                    }
                    ShfS.setHasFixedSize(true);
                    ShfS.setLayoutManager(new LinearLayoutManager(ShiftingActivity.this));
                    adapter=new ServitorsAdapter(list9,ShiftingActivity.this);
                    ShfS.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShiftingActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}