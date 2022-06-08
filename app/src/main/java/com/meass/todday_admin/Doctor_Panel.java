package com.meass.todday_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Doctor_Panel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__panel);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);

        toolbar.setTitle(" Therapist  Panel");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);

        CardView card_view1=findViewById(R.id.card_view1);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pending_Doctor.class));
            }
        });
        CardView card_view=findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), All_Doctor.class));
            }
        });
        CardView card_view2=findViewById(R.id.card_view2);
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Category_List.class));
            }
        });
        CardView card_view34=findViewById(R.id.card_view34);
        card_view34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Top_Doctor.class));
            }
        });
        CardView card_view341=findViewById(R.id.card_view341);
        card_view341.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Toasy_Doctor.class));
            }
        });
        CardView card_view3141=findViewById(R.id.card_view3141);
        card_view3141.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Add_Doctor.class));
            }
        });
        CardView card_v2iew3141=findViewById(R.id.card_v2iew3141);
        card_v2iew3141.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Emergencey.class));
            }
        });
        CardView card_view31412=findViewById(R.id.card_view31412);
        card_view31412.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Payment_Request.class));
            }
        });

    }
}