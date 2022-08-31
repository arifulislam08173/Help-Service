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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    EditText fullname, Email, password, phone;
    Button register;
    TextView login;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.fullname);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        rootNode=FirebaseDatabase.getInstance();

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                rootNode=FirebaseDatabase.getInstance();
               // reference=rootNode.getReference("For User");


                //String Uname = fullname.getEditableText().toString();

                //String Uname=fullname.getEditText.getText().toString();
                //String Uemail=Email.getEditableText().toString();
                //String Uemail=fAuth.getCurrentUser().getEmail();
               // String UphoneNo=phone.getEditableText().toString();
               // String Upassword=password.getEditableText().toString();
               // String Uid=fAuth.getUid();

               // String key = reference.push().getKey();



               // Userhelperclass helperclass = new Userhelperclass(Uname,Uemail,UphoneNo,Upassword);

                //reference.child(firebaseUser.getUid()).setValue(helperclass);

                if (email.isEmpty()) {

                    Email.setError("Email is Required.");

                    return;

                }

                if (Password.isEmpty()) {

                    password.setError("Password is Required.");

                    return;
                }

                if (password.length() < 6) {

                    password.setError("Password Must be > 6 Characters");

                    return;
                }

                progressBar.setVisibility(View.VISIBLE);



                //Register the user in firebase

                fAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){



                            String Uid = fAuth.getUid();
                            String Uemail = fAuth.getCurrentUser().getEmail();
                            String Uname = fullname.getEditableText().toString();
                            String UphoneNo=phone.getEditableText().toString();
                            String Upassword=password.getEditableText().toString();

                            Userhelperclass userhelperclass = new Userhelperclass(Uid,Uname,Uemail,UphoneNo,Upassword);

                            rootNode.getReference()
                                    .child("users")
                                    .child(Uid)
                                    .setValue(userhelperclass)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                        }
                                    });

                          //  Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                          //  startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Register.this, "Error!"+ task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

    }
}


