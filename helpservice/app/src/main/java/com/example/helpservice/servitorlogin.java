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

public class servitorlogin extends AppCompatActivity {

    EditText Email, password;
    Button loginbtn1;
    TextView createacc2;
    FirebaseAuth fAuth;
    ProgressBar progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servitorlogin);

        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        progressBar4 = findViewById(R.id.progressBar4);
        loginbtn1 = findViewById(R.id.loginbtn1);
        createacc2 = findViewById(R.id.createacc2);



        loginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String Password = password.getText().toString().trim();

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

                progressBar4.setVisibility(View.VISIBLE);

                //Register the user in firebase

                fAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(servitorlogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Intent intent=new Intent(servitorlogin.this,AdminDashboard2.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(servitorlogin.this, "Error!"+ task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar4.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        createacc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), servitorregister.class));
            }
        });

    }
}