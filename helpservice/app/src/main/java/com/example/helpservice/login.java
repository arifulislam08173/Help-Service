package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class  login extends AppCompatActivity {

    EditText Email, password;
    Button loginbtn;
    TextView createacc;
    FirebaseAuth fAuth;
    ProgressBar progressBar2;
    DatabaseReference reference;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        progressBar2 = findViewById(R.id.progressBar2);
        loginbtn = findViewById(R.id.loginbtn);
        createacc = findViewById(R.id.createacc);
        firebaseUser = fAuth.getCurrentUser();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getEditableText().toString().trim();
                String Password = password.getEditableText().toString().trim();


                if (TextUtils.isEmpty(email)) {

                    Email.setError("Email is Required.");

                    return;

                }

                if (TextUtils.isEmpty(Password)) {

                    password.setError("Password is Required.");

                    return;
                }

                if (password.length() < 6) {

                    password.setError("Password Must be > 6 Characters");

                    return;
                }

                progressBar2.setVisibility(View.VISIBLE);

                //user

            /*    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                Query checkUser = reference.orderByChild("uemail").equalTo(email);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            Email.setError(null);
                            Email.setEnabled(false);

                            String passwordDB = dataSnapshot.child(email).child("upassword").getValue(String.class);

                            if (passwordDB.equals(Password)) {

                                Email.setError(null);
                                Email.setEnabled(false);

                                String nameDB = dataSnapshot.child(email).child("uname").getValue(String.class);
                                String phoneDB = dataSnapshot.child(email).child("uphoneNo").getValue(String.class);
                                String emailDB = dataSnapshot.child(email).child("uemail").getValue(String.class);
                                // String nameDB=snapshot.child(email).child("Uname").getValue(String.class);

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                                intent.putExtra("uname", nameDB);
                                intent.putExtra("uphoneNo", phoneDB);
                                intent.putExtra("uemail", emailDB);
                                intent.putExtra("upassword", passwordDB);

                                startActivity(intent);
                            }
                            else {
                                password.setError("Wrong Password");
                                password.requestFocus();
                            }
                        }
                        else {
                            Email.setError("No such User Exist");
                            Email.requestFocus();


                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }*/



                fAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
                            Query checkUser = reference.orderByChild("Email").equalTo(email);

                            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        String passwordDB=dataSnapshot.child(email).child("upassword").getValue(String.class);

                                        if(passwordDB.equals(Password)){
                                            String nameDB=dataSnapshot.child(email).child("uname").getValue(String.class);
                                            String phoneDB=dataSnapshot.child(email).child("uphoneNo").getValue(String.class);
                                            String emailDB=dataSnapshot.child(email).child("uemail").getValue(String.class);
                                            // String nameDB=snapshot.child(email).child("Uname").getValue(String.class);

                                            Intent intent =new Intent(getApplicationContext(),profile.class);

                                            intent.putExtra("uname",nameDB);
                                            intent.putExtra("uphoneNo",phoneDB);
                                            intent.putExtra("uemail",emailDB);
                                            intent.putExtra("upassword",passwordDB);

                                            startActivity(intent);
                                        }

                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });



                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Intent intent=new Intent(login.this,MainActivity.class);

                            startActivity(intent);
                        }else{
                            Toast.makeText(login.this, "Error!"+ task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar2.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        //});
    }

}