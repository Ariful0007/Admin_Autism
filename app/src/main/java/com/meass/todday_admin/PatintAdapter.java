package com.meass.todday_admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.meass.todday_admin.patient_panel.Patient_Panel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.List;
import java.util.UUID;

public class PatintAdapter extends RecyclerView.Adapter<PatintAdapter.myview> {
    public List<Message_user> data;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;

    public PatintAdapter(List<Message_user> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PatintAdapter.myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.paymen2t,parent,false);
        return new PatintAdapter.myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatintAdapter.myview holder, final int position) {
        holder.customer_name.setText("Patient ID : "+data.get(position).getName());
        holder.customer_number.setText("Doctor Name : "+data.get(position).getDoctor_name());
        holder.customer_area1.setText("Payment Number : "+data.get(position).getPaymentnumber()+"\n" +
                "Transcation ID : "+data.get(position).getPaymentTransation());
        holder.customer_area.setText("Doctor Category : "+data.get(position).getCategory());
       // holder.logout.setText(data.get(position).getStatus());
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        holder.card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Conform")
                        .setMessage("Are you want to place this patient in doctor panel")
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();


                        final KProgressHUD progressDialog=  KProgressHUD.create(v.getContext())
                                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                                .setLabel("Checking Data.....")
                                .setCancellable(false)
                                .setAnimationSpeed(2)
                                .setDimAmount(0.5f)
                                .show();
                        firebaseFirestore.collection("Pending_Patients")
                                .document(data.get(position).getName()+"@gmail.com")
                                .delete()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Message_user message_user=new Message_user(data.get(position).getName(),
                                                    data.get(position).getImage(),data.get(position).getSkills()
                                            ,data.get(position).getAbout(),data.get(position).getPhone(),data.get(position).getEmail(),data.get(position).getDoctor_name()
                                            ,data.get(position).getCategory(),data.get(position).getPaymentnumber(),data.get(position).getPaymentTransation());
                                            firebaseFirestore.collection("AllPatients")
                                                    .document(UUID.randomUUID().toString())
                                                    .set(message_user)
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                firebaseFirestore.collection("All_Doctor_Patient_List").document(data.get(position).getEmail()).collection("All_Patient")
                                                                        .document(data.get(position).getName()+"@gmail.com")
                                                                        .set(message_user)
                                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                if (task.isSuccessful()) {
                                                                                    firebaseFirestore.collection("DoctorDateAndTime")
                                                                                            .document(data.get(position).getName()+"@gmail.com")
                                                                                            .collection("List")
                                                                                            .document(data.get(position).getEmail())
                                                                                            .get()
                                                                                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                                @Override
                                                                                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                    if (task.isSuccessful()) {
                                                                                                        if (task.getResult().exists()) {
                                                                                                            String first=task.getResult().getString("first");
                                                                                                            firebaseFirestore.collection(first)
                                                                                                                   .document(data.get(position).getEmail()).collection("Patient")
                                                                                                                    .document(data.get(position).getName()+"@gmail.com")
                                                                                                                    .set(message_user)
                                                                                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                        @Override
                                                                                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                                                                            if (task.isSuccessful()) {
                                                                                                                                progressDialog.dismiss();
                                                                                                                                Toast.makeText(v.getContext(), "Done", Toast.LENGTH_SHORT).show();
                                                                                                                                v.getContext().startActivity(new Intent(v.getContext(), Patient_Panel.class));
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });


                                                                                                        }
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
                                });
                    }
                }).create().show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myview extends RecyclerView.ViewHolder{
        TextView customer_name,customer_number,customer_area,logout,customer_area1;
        CardView card_view8;
        public myview(@NonNull View itemView) {
            super(itemView);
            customer_name=itemView.findViewById(R.id.customer_name);
            customer_number=itemView.findViewById(R.id.customer_number);
            customer_area=itemView.findViewById(R.id.customer_area);
            logout=itemView.findViewById(R.id.logout);
            card_view8=itemView.findViewById(R.id.card_view8);
            customer_area1=itemView.findViewById(R.id.customer_area1);
        }
    }
}


