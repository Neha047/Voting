package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class civil extends AppCompatActivity {
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    RadioButton radioButton9;
    RadioButton radbutton1;
    RadioButton radbutton2;
    RadioButton radbutton3;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView;
    Button button;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    int x1=0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0,x8=0,x9=0;
    DatabaseReference reff;
    Votes vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_civil);
        radioGroup1=findViewById(R.id.radioGroup3);
        radioGroup2=findViewById(R.id.radioGroup2);
        radioGroup3=findViewById(R.id.radioGroup);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView=findViewById(R.id.textView);

        radioButton1=findViewById(R.id.radioButton3);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton);
        radioButton4=findViewById(R.id.radioButton4);
        radioButton5=findViewById(R.id.radioButton5);
        radioButton6=findViewById(R.id.radioButton6);
        radioButton7=findViewById(R.id.radioButton7);
        radioButton8=findViewById(R.id.radioButton8);
        radioButton9=findViewById(R.id.radioButton9);


        vote=new Votes();

        reff= FirebaseDatabase.getInstance().getReference();

        reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton1.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton2.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton3.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton4.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton5.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton6.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton7.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton8.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton9.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(civil.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup1.getCheckedRadioButtonId( );
                radbutton1 = findViewById(radioId);

                if (radbutton1 == radioButton1) {

                    reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x1 = Integer.parseInt(v);
                            x1 = x1 + 1;
                            textView.setText("sharma pooja got " + x1 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("1").child("votes").setValue(x1);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                if (radbutton1 == radioButton2) {
                    reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x2 = Integer.parseInt(v);
                            x2 = x2 + 1;
                            textView.setText("anmol goyal got " + x2 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("2").child("votes").setValue(x2);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                if (radbutton1 == radioButton3) {
                    reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x3 = Integer.parseInt(v);
                            x3 = x3 + 1;
                            textView.setText("anmol goyal got " + x3 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("sports secretary").child("3").child("votes").setValue(x3);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }
                int radioId2 = radioGroup2.getCheckedRadioButtonId( );
                radbutton2 = findViewById(radioId2);

                if (radbutton2 == radioButton4) {
                    reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x4 = Integer.parseInt(v);
                            x4 = x4 + 1;
                            textView.setText("anmol goyal got " + x4 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("1").child("votes").setValue(x4);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                if (radbutton2 == radioButton5) {
                    reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x5 = Integer.parseInt(v);
                            x5 = x5 + 1;
                            textView.setText("anmol goyal got " + x5 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("2").child("votes").setValue(x5);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                if (radbutton2 == radioButton6) {
                    reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x6 = Integer.parseInt(v);
                            x6 = x6 + 1;
                            textView.setText("anmol goyal got " + x6 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("technical secretary").child("3").child("votes").setValue(x6);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                int radioId3 = radioGroup3.getCheckedRadioButtonId( );
                radbutton3 = findViewById(radioId3);

                if (radbutton3 == radioButton7) {
                    reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x7 = Integer.parseInt(v);
                            x7 = x7 + 1;
                            textView.setText("anmol goyal got " + x7 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("1").child("votes").setValue(x7);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }


                if (radbutton3 == radioButton8) {
                    reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x8 = Integer.parseInt(v);
                            x8 = x8 + 1;
                            textView.setText("anmol goyal got " + x8 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("2").child("votes").setValue(x8);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }


                if (radbutton3 == radioButton9) {
                    reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener( ) {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v = dataSnapshot.getValue( ).toString( );
                            int x9 = Integer.parseInt(v);
                            x9 = x9 + 1;
                            textView.setText("anmol goyal got " + x9 + " votes");
                            Toast.makeText(civil.this, "Thanks for voting", Toast.LENGTH_LONG).show( );
                            reff.child("candidates").child("dssa").child("civil").child("cultural secretary").child("3").child("votes").setValue(x9);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(civil.this, databaseError.getCode( ), Toast.LENGTH_SHORT).show( );

                        }
                    });

                }

                button.setEnabled(false);
                String uid = mAuth.getCurrentUser( ).getUid( );

                db.collection("Users").document(uid)
                        .get( ).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        // documentSnapshot.getId();
                        if (documentSnapshot.exists( )) {

                            String sex = documentSnapshot.getString("gender");

                            if (sex.equals("female")) {
                                startActivity(new Intent(civil.this, girl.class));
                            }


                        } else {
                            Toast.makeText(civil.this, "Document does not exits", Toast.LENGTH_SHORT);
                        }


                    }
                }).addOnFailureListener(new OnFailureListener( ) {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });

    }
}
