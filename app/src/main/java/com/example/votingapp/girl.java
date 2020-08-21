package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

public class girl extends AppCompatActivity {
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    RadioButton radbutton1;

    TextView textView1;
    TextView textView;
    Button button;
    int x1=0,x2=0,x3=0;
    DatabaseReference reff;
    Votes vote;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl);
        radioGroup1=findViewById(R.id.radioGroup3);
mAuth=FirebaseAuth.getInstance();
db=FirebaseFirestore.getInstance();
        textView1=findViewById(R.id.textView1);
        textView=findViewById(R.id.textView);


        radioButton1=findViewById(R.id.radioButton3);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton);
set();

        vote=new Votes();

        reff= FirebaseDatabase.getInstance().getReference();
      //  final String uid=mAuth.getCurrentUser().getUid();

        reff.child("Candidates").child("girls representative").child("1").child("uid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();


                if(v.equals("a"))
                {
                    String uid=mAuth.getCurrentUser().getUid();
                    reff.child("Candidates").child("girls representative").child("1").child("uid").setValue(uid);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(girl.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });


        reff.child("Candidates").child("girls representative").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton1.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(girl.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("girls representative").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton2.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(girl.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("girls representative").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton3.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(girl.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });



        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId=radioGroup1.getCheckedRadioButtonId();
                radbutton1=findViewById(radioId);

                if(radbutton1 == radioButton1)
                {

                    reff.child("Candidates").child("girls representative").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x1 = Integer.parseInt(v);
                            x1=x1+1;
                            textView.setText("sharma pooja got "+x1+ " votes");
                            Toast.makeText(girl.this,"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("girls representative").child("1").child("votes").setValue(x1);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(girl.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton1 == radioButton2)
                {
                    reff.child("Candidates").child("girls representative").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x2 = Integer.parseInt(v);
                            x2=x2+1;
                            textView.setText("anmol goyal got "+x2+ " votes");
                            Toast.makeText(girl.this,"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("girls representative").child("2").child("votes").setValue(x2);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(girl.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton1 == radioButton3)
                {
                    reff.child("Candidates").child("girls representative").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x3 = Integer.parseInt(v);
                            x3=x3+1;
                            textView.setText("anmol goyal got "+x3+ " votes");
                            Toast.makeText(girl.this,"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("girls representative").child("3").child("votes").setValue(x3);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(girl.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                button.setEnabled(false);
            }
        });



    }
    public void set()
    {

        final String uid = mAuth.getCurrentUser().getUid();

        db.collection("registered").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();

                if(documentSnapshot.exists()){
                    // final String title = documentSnapshot.getString("name");
                    String post = documentSnapshot.getString("post");


                    if (post.equals("girls representative")) {

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

                                Toast.makeText(girl.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });
                        /* final String title = documentSnapshot.getString("name");
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

                                Toast.makeText(girl.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

                            }
                        });*/



                    }





                }


            }

        });

    }
}