package com.meass.todday_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Category_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__list);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);

        toolbar.setTitle(" All Doctor");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        //1
        CardView card_view = findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Covid-19(coronavirus)");
                startActivity(intent);

            }
        });
        //2
        CardView card_view1 = findViewById(R.id.card_view1);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Cancer(Oncology)");
                startActivity(intent);

            }
        });
        //3
        CardView card_view2 = findViewById(R.id.card_view2);
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Cardio-Vascular Surgery");
                startActivity(intent);
            }
        });
        //4
        CardView card_view4 = findViewById(R.id.card_view4);
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Cardio-thoracic Surgery");
                startActivity(intent);

            }
        });
        //5
        CardView card_view5 = findViewById(R.id.card_view5);
        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Cardiology");
                startActivity(intent);

            }
        });
        //6
        CardView card_view6 = findViewById(R.id.card_view6);
        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Colorectal Surgery(Piles)");
                startActivity(intent);

            }
        });
        //7
        CardView card_view8 = findViewById(R.id.card_view8);
        card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Dentistry");
                startActivity(intent);
            }
        });
        //8
        CardView card_view7 = findViewById(R.id.card_view7);
        card_view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Dermathology");
                startActivity(intent);

            }
        });
        //9
        CardView card_view10 = findViewById(R.id.card_view10);
        card_view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Diabetes and Endocrinology");
                startActivity(intent);
            }
        });
        //10
        CardView card_view11 = findViewById(R.id.card_view11);
        card_view11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "ENT");
                startActivity(intent);
            }
        });
//11
        //11
        CardView card_view12 = findViewById(R.id.card_view12);
        card_view12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "EYE");
                startActivity(intent);
            }
        });
        //12
        CardView card_view9 = findViewById(R.id.card_view9);
        card_view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Gastroenterology");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //13
        CardView card_view14 = findViewById(R.id.card_view14);
        card_view14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "General Physician");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //14
        CardView card_view13 = findViewById(R.id.card_view13);
        card_view13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "General Practitioner");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //15
        CardView card_view15 = findViewById(R.id.card_view15);
        card_view15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "General Surgery");
                startActivity(intent);
                // Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
//16
        //16
        CardView card_view16 = findViewById(R.id.card_view16);
        card_view16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Gynecology");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //17
        CardView card_view117 = findViewById(R.id.card_view117);
        card_view117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Hematology");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //18
        CardView card_view17 = findViewById(R.id.card_view17);
        card_view17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Herbal");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //19
        CardView card_view19 = findViewById(R.id.card_view19);
        card_view19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Medicine");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //20
        CardView card_view20 = findViewById(R.id.card_view20);
        card_view20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Nepprology(Kidney)");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
//21
        //1
        CardView card_view21 = findViewById(R.id.card_view21);
        card_view21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Neurosurgery");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //22
        CardView card_view22 = findViewById(R.id.card_view22);
        card_view22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Neuro Medicine");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //23
        CardView card_view11723 = findViewById(R.id.card_view11723);
        card_view11723.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Nutritionist");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //24
        CardView card_view24 = findViewById(R.id.card_view24);
        card_view24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Oncology(Cancer)");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //25
        CardView card_view25 = findViewById(R.id.card_view25);
        card_view25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "orthopedics");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
//26
        //26
        CardView card_view26 = findViewById(R.id.card_view26);
        card_view26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Pain Medicine");
                startActivity(intent);
                //Toast.makeText(Category_List.this, "Click", Toast.LENGTH_SHORT).show();

            }
        });
        //27
        CardView card_view27 = findViewById(R.id.card_view27);
        card_view27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Pediatrics(Child)");
                startActivity(intent);
            }
        });
        //28
        CardView card_view28 = findViewById(R.id.card_view28);
        card_view28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Physical Medicine");
                startActivity(intent);
            }
        });
        //4
        CardView card_view129 = findViewById(R.id.card_view129);
        card_view129.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Physiotherapy");
                startActivity(intent);

            }
        });
        //29
        CardView card_view30 = findViewById(R.id.card_view30);
        card_view30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Plastic Surgery");
                startActivity(intent);

            }
        });

        //30
        //1
        CardView card_view31 = findViewById(R.id.card_view31);
        card_view31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Psychology");
                startActivity(intent);
            }
        });
        //31
        CardView card_view32 = findViewById(R.id.card_view32);
        card_view32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Respiratory Medicine");
                startActivity(intent);

            }
        });
        //32
        CardView card_view33 = findViewById(R.id.card_view33);
        card_view33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Skin and VD");
                startActivity(intent);

            }
        });
        //33
        CardView card_view313 = findViewById(R.id.card_view313);
        card_view313.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Urology");
                startActivity(intent);
            }
        });
        //34
        CardView card_view34 = findViewById(R.id.card_view34);
        card_view34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Vascular Surgery");
                startActivity(intent);

            }
        });
//31
        //135
        CardView card_view35 = findViewById(R.id.card_view35);
        card_view35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctor_Category.class);
                intent.putExtra("Key", "Vascular Surgery");
                startActivity(intent);

            }
        });


    }
}