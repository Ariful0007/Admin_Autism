package com.meass.todday_admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.meass.todday_admin.E_slider.E_Slider_1;
import com.meass.todday_admin.patient_panel.Patient_Panel;
import com.meass.todday_admin.videos.Add_Videos;
import com.meass.todday_admin.videos.Videos_panel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);

        toolbar.setTitle(" Admin Panel");
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);

        CardView card_view1 = findViewById(R.id.card_view1);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Doctor_Panel.class));
            }
        });
        CardView card_view = findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), Patient_Panel.class));
            }
        });
        CardView card_view2 = findViewById(R.id.card_view2);
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(), Bkash_Activity.class));
            }
        });
        CardView card_view34 = findViewById(R.id.card_view34);
        card_view34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), Blood_BankAdd.class));
            }
        });
        CardView card_view341 = findViewById(R.id.card_view341);
        card_view341.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Videos_panel.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder warning = new AlertDialog.Builder(this)
                .setTitle("Do you want to exit to admin Panel ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {


                        dialog.dismiss();
                        finishAffinity();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // ToDO: delete all the notes created by the Anon user

                        // TODO: delete the anon user

                        dialog.dismiss();
                    }
                });

        warning.show();
    }
}