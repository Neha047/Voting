package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class DetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText etfirst,etmidd,etlast,etdob,etphone,etemail,branch1;
    Button btsave,btre;
    FirebaseFirestore db;
    Spinner branch,etgen;
    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        db = FirebaseFirestore.getInstance();

        etfirst=findViewById(R.id.etfirst);
        etgen=findViewById(R.id.etgen);
        etmidd=findViewById(R.id.etmid);
        etlast=findViewById(R.id.etlast);
       // etphone=findViewById(R.id.contact);
        etemail=findViewById(R.id.etemail);
        etdob=findViewById(R.id.etdob);
        branch=findViewById(R.id.etbranch);
      //  branch1=findViewById(R.id.etbranch1);
ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.branches,android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
branch.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etgen.setAdapter(adapter1);

branch.setOnItemSelectedListener(this);
        etgen.setOnItemSelectedListener(this);
        btsave=findViewById(R.id.btsave);



        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registration();
            }


        });



    }


    // {
    //    Toast.makeText(VerificationActivity.this, "User already registered", Toast.LENGTH_LONG).show();
    // }
    //}


    public void registration()
    {

        String fi = etfirst.getText().toString();
        String sex = etgen.getSelectedItem().toString();
        String mid = etmidd.getText().toString();
        String last = etlast.getText().toString();
        String Age = etdob.getText().toString();
        String gen = branch.getSelectedItem().toString();
        final Map<String, String> userMap = new HashMap<>();
        userMap.put("Branch",gen);
        if(gen.length()==0)
        {

            branch.requestFocus();
        }





        String email = etemail.getText().toString();
        final String com=FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userMap.put("Register no",com);
      //  Map<String, String> userMap = new HashMap<>();

        userMap.put("name", fi);
        if (fi.length() == 0) {
            etfirst.setError("please enter firstname");
            etfirst.requestFocus();
        }
        userMap.put("gender", sex);
        if (sex.length() == 0) {

            etgen.requestFocus();
        }
        userMap.put("rollno", mid);

        userMap.put("stid", last);
        if (last.length() == 0) {
            etlast.setError("please enter firstname");
            etlast.requestFocus();
        }
        userMap.put("uid", uid);

        userMap.put("cgpa", Age);
        if (Age.length() == 0) {
            etdob.setError("please enter firstname");
            etdob.requestFocus();
        }

        userMap.put("email", email);
        if (email.length() == 0) {
            etemail.setError("please enter firstname");
            etemail.requestFocus();
        }


        else {

            Task<Void> newUser = db.collection("Users").document(uid).set(userMap);

            newUser.addOnSuccessListener(new OnSuccessListener<Void>( ) {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(DetailsActivity.this,"Data Saved Successfully",Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(DetailsActivity.this,Nevigation.class);
                    startActivity(intent);

                }
            }).addOnFailureListener(new OnFailureListener( ) {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DetailsActivity.this,"Data Saved not Successfully",Toast.LENGTH_LONG).show();
                }
            });

        }
        }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
