package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    EditText etpost;
    Button btpost;
    DatabaseReference reff;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth=FirebaseAuth.getInstance();
        etpost=findViewById(R.id.etpost);
        btpost=findViewById(R.id.btpost);
        btpost.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
    }
    public void registration()
    {

        String uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();
                String type=etpost.getText().toString().trim();
                if(documentSnapshot.exists()){
                    String title = documentSnapshot.getString("name");
                    String description = documentSnapshot.getString("rollno");
                   String last = documentSnapshot.getString("gender");
                   // String age = documentSnapshot.getString("cgpa");
                    String sex = documentSnapshot.getString("Branch");
                   // String email = documentSnapshot.getString("email");
                   // String contact = documentSnapshot.getString("Register no");
                    String uid = documentSnapshot.getId();
                    //Map<String, Object> note = documentSnapshot.getData();

                    Map<String, String> userMap = new HashMap<>();

                    userMap.put("name",title);
                    userMap.put("rollno", description);
                    userMap.put("gender", last);
                    userMap.put("uid", uid);
                    userMap.put("branch", sex);
                    userMap.put("post", type);
                    if (type.length() == 0) {
                        etpost.setError("please enter firstname");
                        etpost.requestFocus();
                    }
                    else {

                        Task<Void> newUser = db.collection("registered").document(uid).set(userMap);

                        newUser.addOnSuccessListener(new OnSuccessListener<Void>( ) {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Main2Activity.this,"Data Saved Successfully",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(Main2Activity.this,Nevigation.class);
                                startActivity(intent);
                                set();

                            }
                        }).addOnFailureListener(new OnFailureListener( ) {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Main2Activity.this,"Data Saved not Successfully",Toast.LENGTH_LONG).show();
                            }
                        });

                    }


                }


            }

        });

    }
    public void set()
    {

        final String uid = mAuth.getCurrentUser().getUid();
        reff= FirebaseDatabase.getInstance().getReference();
        db.collection("registered").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();

                if(documentSnapshot.exists()){
                     final String title = documentSnapshot.getString("name").trim();
                    String post = documentSnapshot.getString("post");
                    String gen = documentSnapshot.getString("gender");
                   // String uid = documentSnapshot.getString("uid");


                    if (post.equals("girls representative")&& gen.equals("female")) {

                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("girls representative").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("girls representative").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("girls representative").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("girls representative").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });



                    }
                    if (post.equals("VP"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("VP").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("VP").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("VP").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("VP").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("cultural secretary"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("cultural secretary").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("cultural secretary").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("cultural secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("cultural secretary").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("sports secretary"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("sports secretary").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("sports secretary").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("sports secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("sports secretary").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("cse sports secretary"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("dssa").child("cse").child("sports secretary").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("sports secretary").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("dssa").child("cse").child("sports secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("sports secretary").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("cse cultural secretary"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("dssa").child("cse").child("cultural secretary").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("cultural secretary").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("dssa").child("cse").child("cultural secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("cultural secretary").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("cse technical secretary"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("dssa").child("cse").child("technical secretary").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("technical secretary").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("dssa").child("cse").child("technical secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("dssa").child("cse").child("technical secretary").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }
                    if (post.equals("treasurere"))
                    {
                        reff= FirebaseDatabase.getInstance().getReference();
                        //  final String uid=mAuth.getCurrentUser().getUid();
                        //  String uid = mAuth.getCurrentUser().getUid();



                        reff.child("Candidates").child("treasurere").child("3").child("uid").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("treasurere").child("3").child("uid").setValue(uid);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        reff.child("Candidates").child("treasurere").child("3").child("name").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String v=dataSnapshot.getValue().toString();


                                if(v.equals("a"))
                                {
                                    String uid=mAuth.getCurrentUser().getUid();
                                    reff.child("Candidates").child("treasurere").child("3").child("name").setValue(title);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(Main2Activity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    }





                }


            }

        });

    }

}
