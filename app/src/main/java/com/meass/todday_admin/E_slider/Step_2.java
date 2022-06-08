package com.meass.todday_admin.E_slider;

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

import com.meass.todday_admin.Doctor_Details;
import com.meass.todday_admin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kaopiz.kprogresshud.KProgressHUD;

import es.dmoral.toasty.Toasty;

public class Step_2 extends AppCompatActivity {
    String url,uuid;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    EditText add_notes_title,blog_detail_desc;
    Button buttonSignIn;
    KProgressHUD kProgressHUD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_2);
        url=getIntent().getStringExtra("url");
        uuid=getIntent().getStringExtra("uuid");
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();
        kProgressHUD= KProgressHUD.create(Step_2.this);

        toolbar.setTitle("Edit Slider Post");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        add_notes_title=findViewById(R.id.add_notes_title);
        blog_detail_desc=findViewById(R.id.blog_detail_desc);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=add_notes_title.getText().toString();
                String notes=blog_detail_desc.getText().toString();
                if (TextUtils.isEmpty(title)||TextUtils.isEmpty(notes)) {
                    Toasty.error(getApplicationContext(),"Error", Toast.LENGTH_SHORT,true).show();
                    return;
                }
                else {
                    progress_check();
                    Model_admin model_admin=new Model_admin(url,uuid,title,notes);
                    firebaseFirestore.collection("Post_Slider")
                            .document(uuid)
                            .set(model_admin)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        kProgressHUD.dismiss();;
                                        startActivity(new Intent(getApplicationContext(),E_Slider_1.class));
                                    }
                                }
                            });
      }
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