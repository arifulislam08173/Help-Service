package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking extends AppCompatActivity {

    private EditText Bname,Bnum,Baddress,Bemail,Bid;
    private Button Baddbtn;
    FirebaseAuth fAuth;
    private DatabaseReference reference,dbRef;
    private Spinner servitorCategory;
    private String category;
    private final int REQ = 1;
    private Bitmap bitmap = null;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);




        Bname = findViewById(R.id.Bname);
        Bemail = findViewById(R.id.Bemail);
        Baddress = findViewById(R.id.Baddress);
        Bnum = findViewById(R.id.Bnum);
        Baddbtn = findViewById(R.id.Baddbtn);
        Bid = findViewById(R.id.Bid);
        servitorCategory = findViewById(R.id.serviceCategory);

        pd=new ProgressDialog(this);

        fAuth = FirebaseAuth.getInstance();


        reference = FirebaseDatabase.getInstance().getReference().child("User Booking");

        String[] items = new String[]{"Select Service","Home Service","Electric Service","Medical Service","Computer Service","WiFi Service","Shopping Service","Shifting Service","Air Condition Service","Water Pipe Service"};
        servitorCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items));
        servitorCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = servitorCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Baddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = Bemail.getText().toString().trim();
                String phone = Bnum.getText().toString().trim();

                String BUname=Bname.getEditableText().toString();
                String BUemail=Bemail.getEditableText().toString();
                String BUphoneNo=Bnum.getEditableText().toString();
                String BUaddress=Baddress.getEditableText().toString();
                String BUid = Bid.getEditableText().toString();


                //Userhelperclass helperclass=new Userhelperclass(Uname,Uemail,UphoneNo,Upassword);

                  BookingData  bookingData=new BookingData (BUname,BUemail,BUphoneNo,BUaddress,BUid);

                //dbRef = reference.child(category);
                //final String uniqueKey = dbRef.push().getKey();

                reference.child(category).setValue(bookingData);

                if (TextUtils.isEmpty(email)) {

                    Bemail.setError("Email is Required.");

                    return;

                }

                if (TextUtils.isEmpty(phone)) {

                    Bnum.setError("Phone No is Required.");

                    return;
                }
                if (Bnum.length() < 11) {

                    Bnum.setError("Input valid 11 digit Mobile No.");

                    return;
                }
                else if (category.equals("Select Category")) {
                    Toast.makeText(Booking.this,"Please select Category ",Toast.LENGTH_SHORT).show();
                }
                //Register the user in firebase

                fAuth.createUserWithEmailAndPassword(email,phone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Booking.this, "Boking...", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Booking.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Booking.this, "Error!"+ task.getException(), Toast.LENGTH_SHORT).show();
                           // progressBar.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });
    }
}