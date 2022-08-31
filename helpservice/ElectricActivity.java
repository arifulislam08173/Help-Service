package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

public class ElectricActivity extends AppCompatActivity {

    private RecyclerView banasree,motijheel,banani,uttora,badda,Mog,Mali,Mir,Pur,Moha,Tej,Jatra;
    private LinearLayout banasreenodata,motijheelnodata,bananinodata,uttoranodata,baddanodata,Mognodata,Malinodata,Mirnodata,purnodata,Mohanodata,Tejnodata,Jatranodata;
    private List<ServitorsData> list1,list2,list3,list4,list5,list6,list7,list8,list9,list10,list11,list12;
    private ServitorsAdapter adapter;

    private DatabaseReference reference, dbRef,dbRef2,reference2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);

        motijheel= findViewById(R.id.motijheel);
        banasree = findViewById(R.id.banasree);
        banani = findViewById(R.id.banani);
        uttora= findViewById(R.id.uttora);
        badda = findViewById(R.id.badda);
        Mog = findViewById(R.id.Mog);
        Mali = findViewById(R.id.Mali);
        Mir = findViewById(R.id.Mir);
        Pur = findViewById(R.id.Pur);
        Moha = findViewById(R.id.Moha);
        Tej = findViewById(R.id.Tej);
        Jatra = findViewById(R.id.Jatra);



        motijheelnodata = findViewById(R.id.motijheelnodata);
        banasreenodata = findViewById(R.id.banasreenodata);
        bananinodata = findViewById(R.id.bananinodata);
        uttoranodata = findViewById(R.id.uttoranodata);
        baddanodata = findViewById(R.id.baddanodata);
        Mognodata = findViewById(R.id.Mognodata);
        Malinodata = findViewById(R.id.Malinodata);
        Mirnodata = findViewById(R.id.Mirnodata);
        purnodata = findViewById(R.id.purnodata);
        Mohanodata = findViewById(R.id.Mohanodata);
        Tejnodata = findViewById(R.id.Tejnodata);
        Jatranodata = findViewById(R.id.Jatranodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");

        motijheel();
        banasree();
        banani();
        uttora();
        badda();
        mogbazar();
        malibaag();
        mirpur();
        mohammadpur();
        mohakhali();
        tejgaon();
        jatrabari();
    }
    private void banasree() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Banasree");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    banasreenodata.setVisibility(View.VISIBLE);
                    banasree.setVisibility(View.GONE);
                }else{
                    banasreenodata.setVisibility(View.GONE);
                    banasree.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list3.add(data);
                    }
                    banasree.setHasFixedSize(true);
                    banasree.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list3,ElectricActivity.this);
                    banasree.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void motijheel() {
        dbRef = reference.child("Electric Service");

        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Motijheel");


        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    motijheelnodata.setVisibility(View.VISIBLE);
                    motijheel.setVisibility(View.GONE);
                }else{
                    motijheelnodata.setVisibility(View.GONE);
                    motijheel.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list1.add(data);
                    }
                    motijheel.setHasFixedSize(true);
                    motijheel.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list1,ElectricActivity.this);
                    motijheel.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void banani() {
        dbRef = reference.child("Electric Service");
        //dbRef = reference.child("Banasree");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Banani");
        //dbRef2 = dbRef.child("Banasree");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bananinodata.setVisibility(View.VISIBLE);
                    banani.setVisibility(View.GONE);
                }else{
                    bananinodata.setVisibility(View.GONE);
                    banani.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list2.add(data);
                    }
                    banani.setHasFixedSize(true);
                    banani.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list2,ElectricActivity.this);
                    banani.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uttora() {
        dbRef = reference.child("Electric Service");

        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Uttora");


        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    uttoranodata.setVisibility(View.VISIBLE);
                    uttora.setVisibility(View.GONE);
                }else{
                    uttoranodata.setVisibility(View.GONE);
                    uttora.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list4.add(data);
                    }
                    uttora.setHasFixedSize(true);
                    uttora.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list4,ElectricActivity.this);
                    uttora.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void badda() {
        dbRef = reference.child("Electric Service");
        //dbRef = reference.child("Banasree");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Badda");
        //dbRef2 = dbRef.child("Banasree");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    baddanodata.setVisibility(View.VISIBLE);
                    badda.setVisibility(View.GONE);
                }else{
                    baddanodata.setVisibility(View.GONE);
                    badda.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list5.add(data);
                    }
                    badda.setHasFixedSize(true);
                    badda.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list5,ElectricActivity.this);
                    badda.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mogbazar() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Mogbazar");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Mognodata.setVisibility(View.VISIBLE);
                    Mog.setVisibility(View.GONE);
                }else{
                    Mognodata.setVisibility(View.GONE);
                    Mog.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list6.add(data);
                    }
                    Mog.setHasFixedSize(true);
                    Mog.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list6,ElectricActivity.this);
                    Mog.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void malibaag() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Malibaag");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Malinodata.setVisibility(View.VISIBLE);
                    Mali.setVisibility(View.GONE);
                }else{
                    Malinodata.setVisibility(View.GONE);
                    Mali.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list7.add(data);
                    }
                    Mali.setHasFixedSize(true);
                    Mali.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list7,ElectricActivity.this);
                    Mali.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mirpur() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Mirpur");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Mirnodata.setVisibility(View.VISIBLE);
                    Mir.setVisibility(View.GONE);
                }else{
                    Mirnodata.setVisibility(View.GONE);
                    Mir.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list8.add(data);
                    }
                    Mir.setHasFixedSize(true);
                    Mir.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list8,ElectricActivity.this);
                    Mir.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mohammadpur() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Mohammadpur");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    purnodata.setVisibility(View.VISIBLE);
                    Pur.setVisibility(View.GONE);
                }else{
                    purnodata.setVisibility(View.GONE);
                    Pur.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list9.add(data);
                    }
                    Pur.setHasFixedSize(true);
                    Pur.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list9,ElectricActivity.this);
                    Pur.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mohakhali() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Mohakhali");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Mohanodata.setVisibility(View.VISIBLE);
                    Moha.setVisibility(View.GONE);
                }else{
                    Mohanodata.setVisibility(View.GONE);
                    Moha.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list10.add(data);
                    }
                    Moha.setHasFixedSize(true);
                    Moha.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list10,ElectricActivity.this);
                    Moha.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tejgaon() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Tejgaon");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Tejnodata.setVisibility(View.VISIBLE);
                    Tej.setVisibility(View.GONE);
                }else{
                    Tejnodata.setVisibility(View.GONE);
                    Tej.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list11.add(data);
                    }
                    Tej.setHasFixedSize(true);
                    Tej.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list11,ElectricActivity.this);
                    Tej.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void jatrabari() {
        dbRef = reference.child("Electric Service");
        dbRef2 = FirebaseDatabase.getInstance().getReference().child("Servitors").child("Electric Service").child("Jatranari");

        dbRef2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    Jatranodata.setVisibility(View.VISIBLE);
                    Jatra.setVisibility(View.GONE);
                }else{
                    Jatranodata.setVisibility(View.GONE);
                    Jatra.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ServitorsData data = snapshot.getValue(ServitorsData.class);
                        list12.add(data);
                    }
                    Jatra.setHasFixedSize(true);
                    Jatra.setLayoutManager(new LinearLayoutManager(ElectricActivity.this));
                    adapter=new ServitorsAdapter(list12,ElectricActivity.this);
                    Jatra.setAdapter(adapter);

                    Toast.makeText( ElectricActivity. this,"Electric Servitors", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ElectricActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}