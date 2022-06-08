package com.meass.todday_admin;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;


import java.util.List;

public class Top_Adapter extends RecyclerView.Adapter<Top_Adapter.myView> {
    private final List<Temp_Doctor> data;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    public Top_Adapter(List<Temp_Doctor> data) {
        this.data = data;
    }

    @NonNull

    @Override
    public myView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.alldoctor,parent,false);
        return new Top_Adapter.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Top_Adapter.myView holder, int position) {
        holder.login_desc.setText(data.get(position).getName());
        String image=data.get(position).getImage();
        try {
            Picasso.get()
                    .load(image)
                    .placeholder(R.drawable.profile_image)
                    .into(holder.imageView);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        holder.login1.setText(data.get(position).getCategory());
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Delete")
                        .setMessage("Are you want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                firebaseFirestore.collection("Top Doctor")
                                        .document(data.get(position).getP_email())
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull  Task<DocumentSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    if(task.getResult().exists()) {
                                                        firebaseFirestore.collection("Top Doctor")
                                                                .document(data.get(position).getP_email())
                                                                .delete();
                                                        v.getContext().startActivity(new Intent(v.getContext(),Doctor_Panel.class));

                                                    }
                                                }
                                            }
                                        });

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myView extends RecyclerView.ViewHolder{
        TextView login_desc,login1;
        ImageView imageView;

        public myView(@NonNull  View itemView) {
            super(itemView);
            login_desc=itemView.findViewById(R.id.login_desc);
            imageView=itemView.findViewById(R.id.profile_image);
            login1=itemView.findViewById(R.id.login_desc1);
        }
    }
}
