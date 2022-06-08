package com.meass.todday_admin.E_slider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.meass.todday_admin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Admin_Posty extends AppCompatActivity {
    String uuid;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    TextView add_notes_title,blog_detail_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__posty);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);

        toolbar.setTitle("Post");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        uuid=getIntent().getStringExtra("uuid");
        Toast.makeText(this, ""+uuid, Toast.LENGTH_SHORT).show();
        add_notes_title=findViewById(R.id.add_notes_title);
        blog_detail_desc=findViewById(R.id.blog_detail_desc);
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Post_Slider")
                .document(uuid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful())
                        {
                            if (task.getResult().exists()) {
                                add_notes_title.setText(task.getResult().getString("title"));
                                blog_detail_desc.setText(task.getResult().getString("notes"));
                            }
                        }
                    }
                });



    }
}