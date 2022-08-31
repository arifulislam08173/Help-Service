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

public class servitorregister extends AppCompatActivity {

    EditText Email, password,phone;
    Button register1;
    TextView login2;
    FirebaseAuth fAuth;
    ProgressBar progressBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servitorregister);

        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register1 = findViewById(R.id.register1);
        login2 = findViewById(R.id.login2);

        fAuth = FirebaseAuth.getInstance();
        progressBar3 = findViewById(R.id.progressBar3);

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }


        register1.setOnClickListener(new View.OnClickListener() {
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

                progressBar3.setVisibility(View.VISIBLE);

                //Register the user in firebase

                fAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(servitorregister.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),AdminDashboard.class));
                        }else{
                            Toast.makeText(servitorregister.this, "Error!"+ task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar3.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });

        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),servitorlogin.class));
            }
        });

    }

}