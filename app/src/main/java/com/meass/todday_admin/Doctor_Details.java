package com.meass.todday_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
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

public class Doctor_Details extends AppCompatActivity {
    ImageView setup_image;
    TextView setup_name,setup_skill,aboutyou,email,
            phoneNumber,phoneNumber1,phoneNumber11,
            phoneNumber111,phoneNumber1111,doctorfee1,payment_methode1
            ,docotpaymentnumber1,time1,days1;
    Button buttonSignIn,buttonSignIn1;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;

    String image,name,deg,gender,userPhone,location,
            bmdc,p_email,p_password,category,uuid
            ,doctorfee,payment_methode,docotpaymentnumber,time,days;
    KProgressHUD kProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__details);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        kProgressHUD= KProgressHUD.create(Doctor_Details.this);

        toolbar.setTitle("Therapist Profile");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
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
        //getIntent
        uuid=getIntent().getStringExtra("uuid");
        image=getIntent().getStringExtra("image");
        name=getIntent().getStringExtra("name");
        deg=getIntent().getStringExtra("deg");
        gender=getIntent().getStringExtra("gender");
        userPhone=getIntent().getStringExtra("userPhone");
        location=getIntent().getStringExtra("location");
        bmdc=getIntent().getStringExtra("bmdc");
        p_email=getIntent().getStringExtra("p_email");
        p_password=getIntent().getStringExtra("p_password");
        category=getIntent().getStringExtra("category");
        doctorfee=getIntent().getStringExtra("doctorfee");
        doctorfee1.setText(doctorfee);
        payment_methode=getIntent().getStringExtra("paymentMethode");
        payment_methode1.setText(payment_methode);
        docotpaymentnumber=getIntent().getStringExtra("paymentNumber");
        docotpaymentnumber1.setText(docotpaymentnumber);
        time=getIntent().getStringExtra("checkingtime");
        time1.setText(time);
        days=getIntent().getStringExtra("doctorDate");
        days1.setText(days);




        firebaseFirestore.collection("Tempo_Doctor")
                .document(uuid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
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
                AlertDialog.Builder builder=new AlertDialog.Builder(Doctor_Details.this);
                builder.setTitle("Warning")
                        .setMessage("Are you sure to approve\nthis therapist.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                progress_check();
                                Temp_Doctor userModel=new Temp_Doctor(image,name,deg,gender,userPhone,location,
                                        bmdc,p_email,p_password,category,uuid,doctorfee,payment_methode,docotpaymentnumber,
                                        time,days);
                                firebaseFirestore.collection("All_Doctors")
                                        .document(p_email).set(userModel)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull  Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    firebaseFirestore.collection(category)
                                                            .document(p_email)
                                                            .set(userModel)
                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                @Override
                                                                public void onComplete(@NonNull  Task<Void> task) {
                                                                    if (task.isSuccessful()) {
                                                                        firebaseFirestore.collection("Tempo_Doctor")
                                                                                .document(p_email).delete()
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
                                                }
                                            }
                                        });

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),Pending_Doctor.class));
                    }
                });
                builder.create().show();



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