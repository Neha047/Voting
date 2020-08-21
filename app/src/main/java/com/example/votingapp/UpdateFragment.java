package com.example.votingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class UpdateFragment extends Fragment {
    EditText etfirst,etmidd,etlast,etdob,etemail,branch1;
    Button btsave,btre;
    TextView etuid,etphone,branch2,gen2;
   // FirebaseFirestore db;
    Spinner branch,etgen;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;

    public UpdateFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_update, container, false);
    /*    mAuth=FirebaseAuth.getInstance();
        etfirst=v.findViewById(R.id.etfirst);
        etuid=v.findViewById(R.id.uid);
        etgen=v.findViewById(R.id.etgen);
        etmidd=v.findViewById(R.id.etmid);
        etlast=v.findViewById(R.id.etlast);
        etphone=v.findViewById(R.id.contact);
        etemail=v.findViewById(R.id.etemail);
        etdob=v.findViewById(R.id.etdob);
        branch=v.findViewById(R.id.etbranch);
        branch2=v.findViewById(R.id.etbranch2);
        gen2=v.findViewById(R.id.etgen2);
      //  branch1=v.findViewById(R.id.etbranch1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.branches,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getContext(),R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etgen.setAdapter(adapter1);
//        branch.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());
        btsave=v.findViewById(R.id.btsave);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               update();


            }
        });
fetch();

     */
        return v;
    }
  /* public void update(){
      String uid = mAuth.getCurrentUser().getUid();
       String fi = etfirst.getText().toString();
       String sex =  etgen.getSelectedItem().toString();

       String mid = etmidd.getText().toString();
       String last = etlast.getText().toString();
       String Age = etdob.getText().toString();
       String email = etemail.getText().toString();
       String con = etphone.getText().toString();
       String gen = branch.getSelectedItem().toString();
     //  final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();


       final Map<String, String> userMap = new HashMap<>();
       Task<Void> newUser = db.collection("Users").document(uid).set(userMap);
      db.collection("Users").document(uid).update("name: ",fi,"rollno :",mid,"gender :",sex,"studentid :",last,
              "cgpa:",Age,"email: ",email,"Registered:",con,"Branch:",gen,"uid",uid).addOnSuccessListener(new OnSuccessListener<Void>() {
          @Override
          public void onSuccess(Void aVoid) {
              Toast.makeText(getContext(),"Data update Successfully",Toast.LENGTH_LONG).show();
              Intent intent =new Intent(getContext(),Nevigation.class);
              startActivity(intent);
          }
      }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {

          }
      });


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

                    etfirst.setText( ""+title );
                    etmidd.setText( description );
                    gen2.setText(  gen );
                    etlast.setText( last );
                    etdob.setText( age );
                    branch2.setText( sex );
                    etemail.setText( email );
                    etphone.setText( com );
                    etuid.setText( uid );
                   // String uid = mAuth.getCurrentUser().getUid();


                }else{
                    Toast.makeText(getContext(), "Profile is uncompleted", Toast.LENGTH_SHORT);
                    String uid = documentSnapshot.getId();
                    etphone.setText( "Registered Contact: "+com );
                    etuid.setText( "UID: "+uid );
                }


            }
        }).addOnFailureListener(new OnFailureListener( ) {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

   */

}