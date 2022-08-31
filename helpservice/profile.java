package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    private TextView full_name, email, age, phoneNo, address;
    private Button upbtn;
   // FirebaseDatabase ;
    //DatabaseReference reference;
    FirebaseAuth fAuth;
    ProgressBar progressBar2;
    DatabaseReference reference;
    private FirebaseUser firebaseUser;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(profile.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        phoneNo = findViewById(R.id.phoneNo);
        address = findViewById(R.id.address);



        fAuth = FirebaseAuth.getInstance();

        firebaseUser = fAuth.getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Userhelperclass userhelperclass = snapshot.getValue(Userhelperclass.class);

                assert userhelperclass!=null;

                full_name.setText(userhelperclass.getUname());
                email.setText(userhelperclass.getUemail());
                age.setText(userhelperclass.getUid());
                phoneNo.setText(userhelperclass.getUphoneNo());
                address.setText(userhelperclass.getUpassword());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


       /* Intent intent = getIntent();
        String result1 = intent.getStringExtra(setprofile.CONTENT1);
        String result2 = intent.getStringExtra(setprofile.CONTENT2);
        String result3 = intent.getStringExtra(setprofile.CONTENT3);
        String result4 = intent.getStringExtra(setprofile.CONTENT4);
        String result5 = intent.getStringExtra(setprofile.CONTENT5);

        full_name = findViewById(R.id.full_name);
        full_name.setText(result1);

        email = findViewById(R.id.email);
        email.setText(result2);

        age = findViewById(R.id.age);
        age.setText(result3);

        phoneNo = findViewById(R.id.phoneNo);
        phoneNo.setText(result4);

        address = findViewById(R.id.address);
        address.setText(result5);

        upbtn=findViewById(R.id.upbtn);
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, setprofile.class);
                startActivity(intent);
            }
        });*/

     /*   full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phoneNo);
        age = findViewById(R.id.age);

        FirebaseDatabase DB= FirebaseDatabase.getInstance();
        DatabaseReference dRef= DB.getReference().child("users");

        Query checkuser = dRef.orderByChild("uemail").equalTo("uemail");

        checkuser.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

                if(snapshot.exists()){
                    String str = snapshot.child("uname").getValue().toString();
                    full_name.setText(str);

                }
            }

            @Override
            public void onChildChanged(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull  DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

      /*  dRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String res=snapshot.child("uname").getValue().toString();
                    full_name.setText(res);

                    String res2=snapshot.child("uemail").getValue().toString();
                    email.setText(res2);

                    String res3=snapshot.child("uphoneNo").getValue().toString();
                    phoneNo.setText(res3);

                    String res4=snapshot.child("upassword").getValue().toString();
                    age.setText(res4);




            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });*/

    }
}