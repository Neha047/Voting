package com.example.votingapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileActivity extends Fragment {
    TextView tvname,tvroll,tvsid,tvbranch,tvcgpa,tvemail,tvcontact,tvid,etgen,click;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;
    public ProfileActivity() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth=FirebaseAuth.getInstance();
        tvname=v.findViewById(R.id.first);
        etgen=v.findViewById(R.id.etgen1);
       //  click=v.findViewById(R.id.etclick);
         tvcgpa=v.findViewById(R.id.tvcgpa);
          tvbranch=v.findViewById(R.id.etibr);
        tvroll=v.findViewById(R.id.tvdob);
        tvsid=v.findViewById(R.id.tvsex);
        tvemail=v.findViewById(R.id.tvemail);
        tvcontact=v.findViewById(R.id.contact);
        tvid=v.findViewById(R.id.etid);
       /* click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),UpdateFragment.class);
                startActivity(intent);


            }
        });

        */
fetch();

        return v;
    }
    private void fetch()
    {

        String uid = mAuth.getCurrentUser().getUid();
        final String com=mAuth.getCurrentUser().getPhoneNumber();

        db.collection("Users").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();
                if(documentSnapshot.exists()){
                    String title = documentSnapshot.getString("name");
                    String description = documentSnapshot.getString("rollno");
                    String gen = documentSnapshot.getString("gender");
                    String last = documentSnapshot.getString("stid");
                    String age = documentSnapshot.getString("cgpa");
                    String sex = documentSnapshot.getString("Branch");
                    String email = documentSnapshot.getString("email");
                    String contact = documentSnapshot.getString("Register no");
                    String uid = documentSnapshot.getId();

                    //Map<String, Object> note = documentSnapshot.getData();

                    tvname.setText( "name: "+ title );
                     tvroll.setText( "rollno: "+description );
                    etgen.setText( "gender: "+ gen );
                     tvsid.setText( "studentid: "+last );
                    tvcgpa.setText( "cgpa: "+age );
                    tvbranch.setText( "branch: "+sex );
                    tvemail.setText("emailid: "+ email );
                    tvcontact.setText( "Registered Contact: "+com );
                    tvid.setText( "UID: "+uid );


                }else{
                    Toast.makeText(getContext(), "Profile is uncompleted", Toast.LENGTH_SHORT);
                    String uid = documentSnapshot.getId();
                    tvid.setText( "UID: "+uid );
                    tvcontact.setText( "Registered Contact: "+com );
                }


            }
        }).addOnFailureListener(new OnFailureListener( ) {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }
}
