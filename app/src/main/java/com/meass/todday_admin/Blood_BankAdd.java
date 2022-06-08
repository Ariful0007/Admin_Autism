package com.meass.todday_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.meass.todday_admin.patient_panel.Patient_Panel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kaopiz.kprogresshud.KProgressHUD;

public class Blood_BankAdd extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    EditText add_notes_title,add_notes_title2,add_notes_ti6tle;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__bank_add);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);

        toolbar.setTitle(" Blood Bank");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        firebaseFirestore=FirebaseFirestore.getInstance();
        add_notes_title=findViewById(R.id.add_notes_title);
        add_notes_title2=findViewById(R.id.add_notes_title2);
        add_notes_ti6tle=findViewById(R.id.add_notes_ti6tle);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=add_notes_title.getText().toString();
                String area=add_notes_title2.getText().toString();
                String pho=add_notes_ti6tle.getText().toString();
                if (TextUtils.isDigitsOnly(name)||TextUtils.isEmpty(area)||TextUtils.isEmpty(pho)) {
                    Toast.makeText(Blood_BankAdd.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    final KProgressHUD progressDialog=  KProgressHUD.create(Blood_BankAdd.this)
                            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                            .setLabel("Uploading Data.....")
                            .setCancellable(false)
                            .setAnimationSpeed(2)
                            .setDimAmount(0.5f)
                            .show();
                    Long tsLong = System.currentTimeMillis()/1000;
                    String ts = tsLong.toString();
                    BloodBankModel bloodBankModel=new BloodBankModel(name,pho,area,ts);
                    firebaseFirestore.collection("BloodBank")
                            .add(bloodBankModel)
                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    if (task.isSuccessful()) {
                                        progressDialog.dismiss();
                                        Toast.makeText(Blood_BankAdd.this, "Done", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));

        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}