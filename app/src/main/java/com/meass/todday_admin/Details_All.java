package com.meass.todday_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.squareup.picasso.Picasso;


import es.dmoral.toasty.Toasty;

public class Details_All extends AppCompatActivity {
    ImageView setup_image;
    TextView setup_name,setup_skill,aboutyou,email,
            phoneNumber,phoneNumber1,phoneNumber11,
            phoneNumber111,phoneNumber1111,doctorfee1,payment_methode1
            ,docotpaymentnumber1,time1,days1;
    Button buttonSignIn,buttonSignIn1;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;

    String image,name,deg,gender,userPhone,location,
            bmdc,p_email,p_password,category,uuid;
    KProgressHUD kProgressHUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__all);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        toolbar.setTitle("Therapist Profile");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        kProgressHUD= KProgressHUD.create(Details_All.this);
        setup_image=findViewById(R.id.setup_image);
        setup_name=findViewById(R.id.setup_name);
        setup_skill=findViewById(R.id.setup_skill);
        aboutyou=findViewById(R.id.aboutyou);
        email=findViewById(R.id.email);
        phoneNumber=findViewById(R.id.phoneNumber);
        phoneNumber1=findViewById(R.id.phoneNumber1);
        phoneNumber11=findViewById(R.id.phoneNumber11);

        phoneNumber111=findViewById(R.id.phoneNumber111);
        phoneNumber1111=findViewById(R.id.phoneNumber1111);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        doctorfee1=findViewById(R.id.doctorfee);
        payment_methode1=findViewById(R.id.payment_methode);
        docotpaymentnumber1=findViewById(R.id.docotpaymentnumber);
        time1=findViewById(R.id.time);
        days1=findViewById(R.id.days);
        buttonSignIn1=findViewById(R.id.buttonSignIn1);
        p_email=getIntent().getStringExtra("p_email");
        category=getIntent().getStringExtra("category");
        firebaseFirestore.collection("Active_Doctor").document(p_email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                buttonSignIn.setEnabled(false);
                                buttonSignIn1.setEnabled(true);
                            }
                            else {
                                buttonSignIn.setEnabled(true);
                                buttonSignIn1.setEnabled(false);
                            }
                        }
                    }
                });

        firebaseFirestore.collection("All_Doctors")
                .document(p_email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull  Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                String image=task.getResult().getString("image");
                                try {
                                    Picasso.get()
                                            .load(image
                                            ).into(setup_image);
                                }catch (Exception e) {
                                }
                                setup_name.setText(task.getResult().getString("name"));
                                setup_skill.setText(task.getResult().getString("deg"));
                                aboutyou.setText(task.getResult().getString("gender"));
                                email.setText(task.getResult().getString("location"));
                                phoneNumber.setText(task.getResult().getString("userPhone"));
                                phoneNumber1.setText(task.getResult().getString("bmdc"));
                                phoneNumber11.setText(task.getResult().getString("p_email"));
                                phoneNumber111.setText(task.getResult().getString("p_password"));
                                phoneNumber1111.setText(task.getResult().getString("category"));
                                doctorfee1.setText(task.getResult().getString("doctorfee"));
                                payment_methode1.setText(task.getResult().getString("paymentMethode"));
                                docotpaymentnumber1.setText(task.getResult().getString("paymentNumber"));
                                time1.setText(task.getResult().getString("checkingtime"));
                                days1.setText(task.getResult().getString("doctorDate"));


                            }
                            else {
                                Toasty.error(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT, true).show();

                            }
                        }
                    }
                });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_check();
                Active_doctor active_doctor=new Active_doctor(phoneNumber11.getText().toString());
               firebaseFirestore.collection("Active_Doctor").document(phoneNumber11.getText().toString())
                       .set(active_doctor)
                      .addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {
                              if (task.isSuccessful()) {
                                  kProgressHUD.dismiss();
                                  Toasty.success(getApplicationContext(),"Done",Toast.LENGTH_SHORT,true).show();

                              }
                          }
                      });
            }
        });
        buttonSignIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_check();
                firebaseFirestore.collection("Active_Doctor")
                        .document(p_email)
                        .delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    kProgressHUD.dismiss();
                                    Toasty.success(getApplicationContext(),"Done",Toast.LENGTH_SHORT,true).show();
                                }
                            }
                        });
            }
        });
        Button buttonSignIn2=findViewById(R.id.buttonSignIn2);
        buttonSignIn2.setText("Delete Doctor");
        buttonSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_check();
             firebaseFirestore.collection("All_Doctors")
                        .document(phoneNumber11.getText().toString())
                        .delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            firebaseFirestore.collection(phoneNumber1111.getText().toString())
                                    .document(phoneNumber11.getText().toString())
                                    .delete()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                kProgressHUD.dismiss();
                                                startActivity(new Intent(getApplicationContext(),Doctor_Panel.class));
                                            }
                                        }
                                    });



                        }
                    }
                });
                Toast.makeText(Details_All.this, ""+phoneNumber1111.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void progress_check() {
        kProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }
}