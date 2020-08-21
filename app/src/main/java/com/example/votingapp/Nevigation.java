package com.example.votingapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Nevigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button vot,btre;
    EditText etcode;
    String code="Nituk@123";
    TextView tv,tv1;
    FirebaseAuth mAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigation);
        mAuth=FirebaseAuth.getInstance();
        etcode=findViewById(R.id.code);
        vot=findViewById(R.id.btvot);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        hide();
        //fetch();
        vot.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                voting();

            }
        });
        btre=findViewById(R.id.btre);

        btre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
reg();


            }


        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = findViewById(R.id.fab);
      /*  fab.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show( );
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState( );
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed( );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater( ).inflate(R.menu.nevigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId( );

        //noinspection SimplifiableIfStatement
       if (id == R.id.action_settings) {
           Intent intent=new Intent(Nevigation.this,Nevigation.class);
           startActivity(intent);
           return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId( );

        if (id == R.id.nav_home) {
            tv.setVisibility(View.GONE);
            etcode.setVisibility(View.GONE);
            vot.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
           btre.setVisibility(View.GONE);
            FragmentManager fragmentManager=getSupportFragmentManager(); //create an object of fragmentManager
             ProfileActivity blankFragment=new ProfileActivity(); //create object of fragment activity
            fragmentManager.beginTransaction().replace(R.id.MAIN1,blankFragment).commit();
           // Intent intent=new Intent(Nevigation.this,Main2Activity.class);
          //  startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            tv.setVisibility(View.GONE);
            etcode.setVisibility(View.GONE);
            vot.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            btre.setVisibility(View.GONE);
            FragmentManager fragmentManager=getSupportFragmentManager(); //create an object of fragmentManager
            NotiFragment blankFragment=new NotiFragment(); //create object of fragment activity
            fragmentManager.beginTransaction().replace(R.id.MAIN1,blankFragment).commit();

        } else if (id == R.id.nav_slideshow) {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(Nevigation.this,MainActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_tools) {
            tv.setVisibility(View.GONE);
            etcode.setVisibility(View.GONE);
            vot.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            btre.setVisibility(View.GONE);
            FragmentManager fragmentManager=getSupportFragmentManager(); //create an object of fragmentManager
            UpdateFragment blankFragment=new UpdateFragment(); //create object of fragment activity
            fragmentManager.beginTransaction().replace(R.id.MAIN1,blankFragment).commit();

      //  } else if (id == R.id.nav_share) {

        //} else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void voting()
    {
        if(etcode.getText().toString().equals(code))
        {
            tv.setVisibility(View.GONE);
            etcode.setVisibility(View.GONE);
            vot.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            btre.setVisibility(View.GONE);
            Intent intent = new Intent(Nevigation.this, Main3Activity.class);
            startActivity(intent);
          // FragmentManager fragmentManager=getSupportFragmentManager(); //create an object of fragmentManager
            //BlankFragment blankFragment=new BlankFragment(); //create object of fragment activity
            //fragmentManager.beginTransaction().replace(R.id.MAIN1,blankFragment).commit();
        }
        else
        {
            //Intent intent = new Intent(Nevigation.this, Nevigation.class);
          //  startActivity(intent);
            Toast.makeText(Nevigation.this,"Wrong entries",Toast.LENGTH_LONG).show();
        }
    }
    public void reg()
    {
        String uid = mAuth.getCurrentUser().getUid();


        db.collection("Users").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();
                if (documentSnapshot.exists( )) {
                    String s=documentSnapshot.getString("cgpa");
                    double i = Double.parseDouble(s.trim());


                   if(i>=7.0)
                   {

                       Toast.makeText(Nevigation.this, " Eligible", Toast.LENGTH_LONG).show( );
                       Intent intent = new Intent(Nevigation.this, Main2Activity.class);
                       startActivity(intent);
                   }
                    Toast.makeText(Nevigation.this, "not Eligible", Toast.LENGTH_LONG).show( );
                }

            }
        });

    }
    public void hide()
    {
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        db.collection("registered").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();
                if(documentSnapshot.exists())
                {
                    tv1.setVisibility(View.GONE);
                    btre.setVisibility(View.GONE);
                    Toast.makeText(Nevigation.this, "already registered so registration not open", Toast.LENGTH_LONG).show( );
                   // Intent intent=new Intent(Nevigation.this,Nevigation.class);
                   // startActivity(intent);
                }


            }
        }).addOnFailureListener(new OnFailureListener( ) {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
    private void fetch()
    {
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        db.collection("Users").document(uid)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>( ) {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // documentSnapshot.getId();
                if(documentSnapshot.exists())
                {
                   ;
                }
                else
                {
                    Intent intent=new Intent(Nevigation.this,DetailsActivity.class);
                    startActivity(intent);
                }

            }
        }).addOnFailureListener(new OnFailureListener( ) {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }

    // @Override



}
