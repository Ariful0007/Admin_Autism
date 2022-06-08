package com.meass.todday_admin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class Add_Doctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
private Spinner spinnerTextSize,spinnerTextSize1,spinnerTextSize2;
        EditText Email_Log;
        String valueFromSpinner;
        String valueFromSpinner1;
        String valueFromSpinner2;
        EditText Email_Log4;
        FirebaseFirestore firebaseFirestore;
        FirebaseAuth firebaseAuth;
        //
        TextView changeProfilePhoto;
        ImageButton image_button;
        ImageView imageView;
private final int PICK_IMAGE_REQUEST = 71;
private Uri filePath;//Firebase

        DocumentReference documentReference;
        Button floatingActionButton;
        FirebaseStorage storage;
        StorageReference storageReference;
private static final int CAMERA_REQUEST = 1888;
        Button generate_btn;
//doctor
private static final int READCODE = 1;
private static final int WRITECODE = 2;

private Uri mainImageUri = null;

private CircleImageView setupImage;
private EditText setupName;
private TextView changePhoto;
private EditText setupSkills;
private ImageView setupButton;
private ProgressBar setupProgress;
private Boolean isChanged = false;
private String current_user_id;
private EditText aboutYou;
private EditText emailUser;
private EditText phoneNumber;
private Bitmap compressedUserImage;
private Toolbar mToolbar;

        String user_id = "";


private FirebaseFirestoreSettings settings;
private FirebaseDatabase firebaseDatabase;
private DatabaseReference databaseReference;


private String intentThatStartedThisActivity;

        DatabaseReference mDatabase;
        EditText bdms,personal_email,Personal_pass;
        TextView time;
        int t1Hour,t2Hour,t1Miniute,t2Miniute;
        EditText doctorfee,docotpaymentnumber;
        TextView time11;
        CheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;
        String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doctor);
            Toolbar toolbar = findViewById(R.id.profile_toolbar);

            toolbar.setTitle("Doctor Register");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setElevation(10.0f);
            firebaseFirestore=FirebaseFirestore.getInstance();
            firebaseAuth=FirebaseAuth.getInstance();
            spinnerTextSize1=findViewById(R.id.spinnerTextSize1);
            spinnerTextSize2=findViewById(R.id.spinnerTextSize2);
            spinnerTextSize2.setOnItemSelectedListener(this);
            spinnerTextSize1.setOnItemSelectedListener(this);
            doctorfee=findViewById(R.id.doctorfee);
            docotpaymentnumber=findViewById(R.id.docotpaymentnumber);
            time11=findViewById(R.id.time);
            checkBox=findViewById(R.id.checkBox);
            checkBox2=findViewById(R.id.checkBox2);
            checkBox3=findViewById(R.id.checkBox3);
            checkBox4=findViewById(R.id.checkBox4);
            checkBox5=findViewById(R.id.checkBox5);
            checkBox6=findViewById(R.id.checkBox6);
            checkBox7=findViewById(R.id.checkBox7);
            String url="https://www.ispr.gov.bd/en/national-collegiate-programming-contest-ncpc-2020-concludes-at-mist/#:~:text=Dhaka%2C%2022%20February%202020%3A%20The%20concluding%20ceremony%20of,Guest%20and%20gave%20away%20prizes%20among%20the%20winners.";

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(Uri.parse(url).toString()));
        startActivity(intent);


        //adapter3
            String[] textSizes2 = getResources().getStringArray(R.array.font_sizes11);
            ArrayAdapter adapter3 = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, textSizes2);
            spinnerTextSize2.setAdapter(adapter3);
            //
            String[] textSizes = getResources().getStringArray(R.array.payment);
            ArrayAdapter adapter1= new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, textSizes);
            spinnerTextSize1.setAdapter(adapter1);
            //


            //
            firebaseAuth = FirebaseAuth.getInstance();
            firebaseFirestore = FirebaseFirestore.getInstance();
            storageReference = FirebaseStorage.getInstance().getReference();


            changeProfilePhoto=findViewById(R.id.changeProfilePhoto);

            setupName = findViewById(R.id.setup_name);
            setupImage = findViewById(R.id.setup_image);
            setupSkills = findViewById(R.id.setup_skill);
            changePhoto = findViewById(R.id.changeProfilePhoto);
            aboutYou = findViewById(R.id.aboutyou);
            emailUser = findViewById(R.id.email);
            phoneNumber = findViewById(R.id.phoneNumber);
            bdms=findViewById(R.id.phoneNumber1);
            personal_email=findViewById(R.id.phoneNumber11);
            Personal_pass=findViewById(R.id.phoneNumber111);

            //time
            time=findViewById(R.id.time);
            time.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
                            TimePickerDialog timePickerDialog=new TimePickerDialog(
                                    Add_Doctor.this, new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                            t1Hour=hourOfDay;
                                            t1Miniute=minute;
                                            Calendar calendar=Calendar.getInstance();
                                            calendar.set(0,0,0,t1Hour,t1Miniute);
                                            time.setText(DateFormat.format("hh:mm aa",calendar));



                                    }
                            },12,0,false
                            );
                            timePickerDialog.updateTime(t1Hour,t1Miniute);
                            timePickerDialog.create();;
                            timePickerDialog.show();

                    }
            });


            Button button=findViewById(R.id.buttonSignIn);
            button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            final String userName = setupName.getText().toString();
                            final String deg = setupSkills.getText().toString();
                            final String gender = aboutYou.getText().toString();
                            final String userPhone = phoneNumber.getText().toString();
                            final String location = emailUser.getText().toString();
                            final String bmdc=bdms.getText().toString();
                            final  String p_email=personal_email.getText().toString();
                            final  String p_password=Personal_pass.getText().toString();
                            StringBuilder result=new StringBuilder();
                            if (checkBox.isChecked()) {
                                    result.append(" "+checkBox.getText().toString()+" ");

                            }
                            if (checkBox2.isChecked()) {
                                    result.append(" "+checkBox2.getText().toString()+"");
                            }
                            if (checkBox3.isChecked()) {
                                    result.append(" "+checkBox3.getText().toString()+" ");

                            }
                            if (checkBox4.isChecked()) {
                                    result.append(" "+checkBox4.getText().toString()+" ");
                            }
                            if (checkBox5.isChecked()) {
                                    result.append(" "+checkBox5.getText().toString()+" ");
                            }
                            if (checkBox6.isChecked()) {
                                    result.append(" "+checkBox6.getText().toString()+" ");

                            }
                            if (checkBox7.isChecked()) {
                                    result.append(" "+checkBox7.getText().toString()+" ");
                            }
                            result.append(".");
                            message=result.toString();


                            if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(deg)||TextUtils.isEmpty(gender)
                                    || TextUtils.isEmpty(userPhone) || TextUtils.isEmpty(location)
                                    || TextUtils.isEmpty(bmdc) || TextUtils.isEmpty(p_email)|| TextUtils.isEmpty(p_password)
                                    || TextUtils.isEmpty(valueFromSpinner2)||TextUtils.isEmpty(valueFromSpinner1) || TextUtils.isEmpty(message)
                                    || TextUtils.isEmpty(doctorfee.getText().toString())||TextUtils.isEmpty(docotpaymentnumber.getText().toString())||
                                    TextUtils.isEmpty(time11.getText().toString())) {
                                    Toast.makeText(Add_Doctor.this, "Somethings is error", Toast.LENGTH_SHORT).show();
                                    return;
                            }
                            else {
                                textSend_user();
                                firebaseAuth.createUserWithEmailAndPassword(p_email,p_password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    textSend_user();
                                                    uploadImage();
                                                }
                                            }
                                        });

                            }

                    }
            });
            changeProfilePhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                    }
            });


    }



        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.spinnerTextSize2) {
                        valueFromSpinner2 = parent.getItemAtPosition(position).toString();
                        //txtHelloWorld.setTextSize(Float.parseFloat(valueFromSpinner));
                }
                if (parent.getId()==R.id.spinnerTextSize1) {
                        valueFromSpinner1=parent.getItemAtPosition(position).toString();
                }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                        && data != null && data.getData() != null )
                {
                        filePath = data.getData();
                        try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                                setupImage.setImageBitmap(bitmap);

                        }
                        catch (IOException e)
                        {
                                e.printStackTrace();
                        }
                }
        }

        private void uploadImage() {

                if(filePath != null)
                {
                        final ProgressDialog progressDialog = new ProgressDialog(this);
                        progressDialog.setTitle("Uploading...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();

                        StorageReference ref = storageReference.child("Doctor_images/"+ UUID.randomUUID().toString());
                        ref.putFile(filePath)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                                                while (!uriTask.isSuccessful());
                                                final Uri downloadUri=uriTask.getResult();



                                                if (uriTask.isSuccessful()) {
                                                        final String userName = setupName.getText().toString();
                                                        final String deg = setupSkills.getText().toString();
                                                        final String gender = aboutYou.getText().toString();
                                                        final String userPhone = phoneNumber.getText().toString();
                                                        final String location = emailUser.getText().toString();
                                                        final String bmdc=bdms.getText().toString();
                                                        final  String p_email=personal_email.getText().toString();
                                                        final  String p_password=Personal_pass.getText().toString();
                                                        String uuid=firebaseAuth.getCurrentUser().getEmail();

                                                        Temp_Doctor userModel=new Temp_Doctor(downloadUri.toString(),
                                                                userName,deg,gender,userPhone,location,bmdc,p_email,p_password,valueFromSpinner2 ,uuid,doctorfee.getText().toString(),
                                                                valueFromSpinner1,docotpaymentnumber.getText().toString(),time11.getText().toString(),
                                                                message);
                                                        firebaseFirestore.collection("Tempo_Doctor").document(personal_email.getText().toString()).set(userModel)

                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                        @Override
                                                                        public void onComplete(@NonNull Task<Void> task) {

                                                                                if (task.isSuccessful()) {
                                                                                        firebaseFirestore.collection("Checker_Doctor")
                                                                                                .document(personal_email.getText().toString())
                                                                                                .set(userModel)
                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                        @Override
                                                                                                        public void onComplete(@NonNull  Task<Void> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                        send_counter();
                                                                                                                        DOctor_passed();
                                                                                                                        new_user(downloadUri.toString(),personal_email.getText().toString(),
                                                                                                                                userName,"Doctors","Doctors",userPhone,p_email);

                                                                                                                        firebaseFirestore.collection("Checker")
                                                                                                                                .document(personal_email.getText().toString())
                                                                                                                                .set(userModel)
                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                        @Override
                                                                                                                                        public void onComplete(@NonNull  Task<Void> task) {
                                                                                                                                                if(task.isSuccessful()) {
                                                                                                                                                        firebaseFirestore.collection("All_UnRegister")
                                                                                                                                                                .document(personal_email.getText().toString())
                                                                                                                                                                .set(userModel)
                                                                                                                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                                                                        @Override
                                                                                                                                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                                                                                                                                if (task.isSuccessful()) {



                                                                                                                                                                                        progressDialog.dismiss();
                                                                                                                                                                                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                                                                                                                                                                        Toasty.success(getApplicationContext(), "Admin will approve you!", Toast.LENGTH_SHORT, true).show();
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
                                                                        }
                                                                }).addOnFailureListener(new OnFailureListener() {
                                                                @Override
                                                                public void onFailure(@NonNull Exception e) {
                                                                        Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                                                }
                                                        });




                                                }
                                                else {
                                                        progressDialog.dismiss();
                                                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                                }

                                        }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                                progressDialog.dismiss();
                                                Toast.makeText(Add_Doctor.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                                double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                                        .getTotalByteCount());
                                                progressDialog.setMessage("Uploaded "+(int)progress+"%");
                                        }
                                });
                }
        }

        private void new_user(String toString, String email,
                              String userName, String doctors, String doctors1,
                              String userPhone, String p_email)
        {
                user23 user23=new user23(userPhone,userName,doctors,doctors1,userPhone,p_email,toString);
                firebaseFirestore.collection("User2")
                        .document(personal_email.getText().toString())
                        .set(user23)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                        }
                                }
                        });
        }

        private void send_counter() {
                Counter counter=new Counter(personal_email.getText().toString(),"0");
                firebaseFirestore.collection("Main_Counter")
                        .document(personal_email.getText().toString())
                        .set(counter)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull  Task<Void> task) {
                                        if (task.isSuccessful()) {
                                        }
                                }
                        });
        }

        private void textSend_user() {
                int permission= ContextCompat.checkSelfPermission(Add_Doctor.this, Manifest.permission.SEND_SMS);
                if (permission== PackageManager.PERMISSION_GRANTED) {
                        sending();
                }
                else {
                        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
                }
        }
        private void sending() {
                String phone_number1233="+88"+phoneNumber.getText().toString();
                String sm333s="Dear doctor admin adding you as a registered doctor.\nYour " +
                        "login details here.\nEmail : "+personal_email.getText().toString()+"Password : "+Personal_pass.getText().toString()
                        +"\nGive best trreatment stay with us.\n"
                        +"সেবা যত্ন";
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(phone_number1233,null,sm333s,null,null);
                Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();

        }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                switch (requestCode)
                {
                        case 0:
                                if (grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                                        sending();;
                                }
                                else {
                                        Toast.makeText(this, "Don't  Have permission", Toast.LENGTH_SHORT).show();
                                }
                                break;

                }

        }
        //
        private void DOctor_passed() {
                Doctor_key doctor_key=new Doctor_key(personal_email.getText().toString(),setupName.getText().toString()+"("+valueFromSpinner2+")"+bdms.getText().toString());
                firebaseFirestore.collection("Doctor_key").document(personal_email.getText().toString())
                        .set(doctor_key)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {

                                        }
                                }
                        });
        }




}