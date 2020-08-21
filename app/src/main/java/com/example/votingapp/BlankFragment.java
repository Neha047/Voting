package com.example.votingapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.firebase.firestore.QuerySnapshot;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    RadioButton radioButton9;
    RadioButton radioButton10;
    RadioButton radioButton11;
    RadioButton radioButton12;
    RadioButton radbutton1;
    RadioButton radbutton2;
    RadioButton radbutton3;
    RadioButton radbutton4;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView;
    Button button;
    int x1=0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0,x8=0,x9=0,x10=0,x11=0,x12=0;
    DatabaseReference reff;
    Votes vote;

    FirebaseAuth mAuth;
    FirebaseFirestore db;


    public BlankFragment() {
        // Required empty public constructor
//        fetch();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_blank, container, false);
        mAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        radioGroup1=v.findViewById(R.id.radioGroup3);
        radioGroup2=v.findViewById(R.id.radioGroup2);
        radioGroup3=v.findViewById(R.id.radioGroup);
        radioGroup4=v.findViewById(R.id.radioGroup4);

        textView1=v.findViewById(R.id.textView1);
        textView2=v.findViewById(R.id.textView2);
        textView3=v.findViewById(R.id.textView3);
        textView4=v.findViewById(R.id.textView4);
        textView=v.findViewById(R.id.textView);

        radioButton1=v.findViewById(R.id.radioButton3);
        radioButton2=v.findViewById(R.id.radioButton2);
        radioButton3=v.findViewById(R.id.radioButton);
        radioButton4=v.findViewById(R.id.radioButton4);
        radioButton5=v.findViewById(R.id.radioButton5);
        radioButton6=v.findViewById(R.id.radioButton6);
        radioButton7=v.findViewById(R.id.radioButton7);
        radioButton8=v.findViewById(R.id.radioButton8);
        radioButton9=v.findViewById(R.id.radioButton9);
        radioButton10=v.findViewById(R.id.radioButton13);
        radioButton11=v.findViewById(R.id.radioButton14);
        radioButton12=v.findViewById(R.id.radioButton15);

        vote=new Votes();

        reff= FirebaseDatabase.getInstance().getReference();
        reff.child("Candidates").child("VP").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton1.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("VP").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton2.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("VP").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton3.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("treasurere").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton4.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("treasurere").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton5.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("treasurere").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton6.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });


        reff.child("Candidates").child("cultural secretary").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton7.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("cultural secretary").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton8.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("cultural secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton9.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("sports secretary").child("1").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton10.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("sports secretary").child("2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton11.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });

        reff.child("Candidates").child("sports secretary").child("3").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String v=dataSnapshot.getValue().toString();
                radioButton12.setText(v);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });


        button=v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId1=radioGroup1.getCheckedRadioButtonId();
                radbutton1=v.findViewById(radioId1);

                if(radbutton1 == radioButton1)
                {

                    reff.child("Candidates").child("VP").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();

                            int x1 = Integer.parseInt(v);
                            x1=x1+1;
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("VP").child("1").child("votes").setValue(x1);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton1 == radioButton2)
                {
                    reff.child("Candidates").child("VP").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x2 = Integer.parseInt(v);
                            x2=x2+1;
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("VP").child("2").child("votes").setValue(x2);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }


                if(radbutton1 == radioButton3)
                {

                    reff.child("Candidates").child("VP").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x3 = Integer.parseInt(v);
                            x3=x3+1;
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("VP").child("3").child("votes").setValue(x3);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getActivity(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                int radioId2=radioGroup2.getCheckedRadioButtonId();
                radbutton2=v.findViewById(radioId2);


                if(radbutton2 == radioButton4)
                {

                    reff.child("Candidates").child("treasurere").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x4 = Integer.parseInt(v);
                            x4=x4+1;
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("treasurere").child("1").child("votes").setValue(x4);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton2 == radioButton5)
                {

                    reff.child("Candidates").child("treasurere").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x5 = Integer.parseInt(v);
                            x5=x5+1;
                            textView.setText("jay aditya got "+x5+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("treasurere").child("2").child("votes").setValue(x5);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton2 == radioButton6)
                {

                    reff.child("Candidates").child("treasurere").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x6 = Integer.parseInt(v);
                            x6=x6+1;
                            textView.setText("jay aditya got "+x6+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("treasurere").child("3").child("votes").setValue(x6);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getActivity(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                int radioId3=radioGroup3.getCheckedRadioButtonId();
                radbutton3=v.findViewById(radioId3);

                if(radbutton3 == radioButton7)
                {

                    reff.child("Candidates").child("cultural secretary").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x7 = Integer.parseInt(v);
                            x7=x7+1;
                            textView.setText("jay aditya got "+x7+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("cultural secretary").child("1").child("votes").setValue(x7);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton3 == radioButton8)
                {

                    reff.child("Candidates").child("cultural secretary").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x8 = Integer.parseInt(v);
                            x8=x8+1;
                            textView.setText("jay aditya got "+x8+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("cultural secretary").child("2").child("votes").setValue(x8);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton3 == radioButton9)
                {

                    reff.child("Candidates").child("cultural secretary").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x9 = Integer.parseInt(v);
                            x9=x9+1;
                            textView.setText("jay aditya got "+x9+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("cultural secretary").child("3").child("votes").setValue(x9);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                int radioId4=radioGroup4.getCheckedRadioButtonId();
                radbutton4=v.findViewById(radioId4);

                if(radbutton4 == radioButton10)
                {

                    reff.child("Candidates").child("sports secretary").child("1").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x10 = Integer.parseInt(v);
                            x10=x10+1;
                            textView.setText("jay aditya got "+x10+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("sports secretary").child("1").child("votes").setValue(x10);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                if(radbutton4 == radioButton11)
                {

                    reff.child("Candidates").child("sports secretary").child("2").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x11 = Integer.parseInt(v);
                            x11=x11+1;
                            textView.setText("jay aditya got "+x11+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("sports secretary").child("2").child("votes").setValue(x11);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                if(radbutton4 == radioButton12)
                {

                    reff.child("Candidates").child("sports secretary").child("3").child("votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String v=dataSnapshot.getValue().toString();
                            int x12 = Integer.parseInt(v);
                            x12=x12+1;
                            textView.setText("jay aditya got "+x12+ " votes");
                            Toast.makeText(getContext(),"Thanks for voting",Toast.LENGTH_LONG).show();
                            reff.child("Candidates").child("sports secretary").child("3").child("votes").setValue(x12);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                button.setEnabled(false);
                String uid = mAuth.getCurrentUser().getUid();

                db.collection("Users").document(uid)
                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        // documentSnapshot.getId();
                        if(documentSnapshot.exists()){

                            String sex = documentSnapshot.getString("Branch");

                            if(sex.equals("cse"))
                            {
                                startActivity(new Intent(getActivity(),cse.class));
                            }
                            if(sex.equals("ece"))
                            {
                                startActivity(new Intent(getActivity(),ece.class));
                            }
                            if(sex.equals("civil"))
                            {
                                startActivity(new Intent(getActivity(),civil.class));
                            }



                        }else{
                            Toast.makeText(getContext(), "Document does not exits", Toast.LENGTH_SHORT);
                        }


                    }
                }).addOnFailureListener(new OnFailureListener( ) {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


            }
        });

        return v;
    }


}
