package com.example.helpservice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.helpservice.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddServitors extends AppCompatActivity {

    private ImageView pp;
    private EditText name,num,address,age;
    private Spinner servitorCategory,servitorCategory2;
    private Button addbtn;
    private final int REQ = 1;
    private Bitmap bitmap = null;
    private String category,category2;

    private  String servitorName,servitorPhoneno,servitorAddress,servitorAge,dowloadUrl="";
    private ProgressDialog pd;
    private StorageReference storageReference;
    private DatabaseReference reference,dbRef,dbRefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_servitors);

        pp = findViewById(R.id.pp);
        name = findViewById(R.id.name);
        num = findViewById(R.id.num);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        servitorCategory = findViewById(R.id.serviceCategory);
        addbtn = findViewById(R.id.addbtn);

        pd=new ProgressDialog(this);

        reference = FirebaseDatabase.getInstance().getReference().child("Servitors");
        storageReference= FirebaseStorage.getInstance().getReference();

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

        servitorCategory2 = findViewById(R.id.serviceCategory2);
       // next = findViewById(R.id.next);

        //reference2 = FirebaseDatabase.getInstance().getReference().child("Area");

        String[] items2 = new String[]{"Select Area","Banani","Badda","Banasree","Motijheel","Mogbazar","Malibaag","Mirpur","Mohammadpur","Mohakhali","Tejgaon","Jatranari","Uttora"};
        servitorCategory2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items2));
        servitorCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category2 = servitorCategory2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pp.setOnClickListener((view) -> { openGallery(); });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
                Intent intent=new Intent(AddServitors.this,AdminDashboard2.class);
                startActivity(intent);
            }
        });


    }

    private void checkValidation () {

        servitorName = name.getText().toString();

        servitorPhoneno= num.getText().toString();

        servitorAddress = address.getText().toString();

        servitorAge=age.getText().toString();

        if (name.getTouchables().isEmpty()) {

            name.setError("Empty");
            name.requestFocus();
        }

         else if (num.getTouchables().isEmpty()) {

            num.setError("Empty");
            num.requestFocus();
        } else if (address.getTouchables().isEmpty()){

            address.setError("Empty");
            address.requestFocus();
        } else if (category.equals("Select Category")) {
            Toast.makeText(this, "Please provide servitors category", Toast.LENGTH_SHORT).show();

        } else if (bitmap == null) {
            pd.setMessage("Uploading...");
            pd.show();
            insertdata();
        } else {
            pd.setMessage("Uploading...");
            pd.show();
            uploadImage();
        }
    }

    private void uploadImage() {


        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bitmap.compress (Bitmap.CompressFormat.JPEG, 50,baos);

        byte[] finalimg = baos.toByteArray();

        final StorageReference filePath;

        filePath = storageReference.child("Add Servitors").child(finalimg+"jpg");

        final UploadTask uploadTask = filePath.putBytes(finalimg);

        uploadTask.addOnCompleteListener(AddServitors.this, new OnCompleteListener<UploadTask.TaskSnapshot>(){


            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot>task) {

                if (task.isSuccessful()) {

                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    dowloadUrl=String.valueOf(uri);
                                    insertdata();
                                }
                            });
                        }
                    });
                } else {
                    pd.dismiss();
                    Toast.makeText(AddServitors.this, "Somthing went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void insertdata() {

        dbRef = reference.child(category);
        final String uniqueKey = dbRef.push().getKey();

       // dbRef2 = reference2.child(category2);
        dbRefa=dbRef.child(category2);
        //reference= dbRef2.push();

        ServitorsData servitorsData = new ServitorsData(servitorName, servitorPhoneno, servitorAddress, servitorAge, dowloadUrl,uniqueKey);

      dbRefa.child(servitorPhoneno).setValue(servitorsData).addOnSuccessListener((OnSuccessListener)(aVoid)->{
         // pd.dismiss();
          Toast.makeText( AddServitors. this,"Servitor Added", Toast.LENGTH_SHORT).show();
      }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
              pd.dismiss();
              Toast.makeText( AddServitors. this,  "Something went wrong", Toast.LENGTH_SHORT).show();
          }
      });
    }





    private  void openGallery(){
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images .Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ && resultCode == RESULT_OK){
            Uri uri =data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pp.setImageBitmap(bitmap);
        }



    }
}