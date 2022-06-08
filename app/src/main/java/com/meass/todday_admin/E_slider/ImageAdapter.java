package com.meass.todday_admin.E_slider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meass.todday_admin.HomeActivity;
import com.meass.todday_admin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.myview> {
    public List<SliderData> data;
    FirebaseFirestore firebaseFirestore;

    public ImageAdapter(List<SliderData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image2,parent,false);
        return new ImageAdapter.myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, final int position) {
        String image=data.get(position).getImgUrl();
        try {
            Picasso.get().load(image)
                    .placeholder(R.drawable.profile_image)
                    .into(holder.imageView);
        }catch ( Exception e) {
            e.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Warning")
                        .setMessage("Are you want to ")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                firebaseFirestore=FirebaseFirestore.getInstance();
                                firebaseFirestore.collection("Post_Slider")
                                        .document(data.get(position).getImgUrl())
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    if (task.getResult().exists()) {
                                                        firebaseFirestore.collection("Post_Slider")
                                                                .document(data.get(position).getImgUrl())
                                                                .delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {
                                                                    Intent intent1=new Intent(v.getContext(), HomeActivity.class);

                                                                    v.getContext().startActivity(intent1);
                                                                    Toast.makeText(v.getContext(), "Done", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });
                                                    }
                                                }


                                            }
                                        });

                            }
                        }).setNegativeButton("View Post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent1=new Intent(v.getContext(), Admin_Posty.class);
                        intent1.putExtra("uuid",data.get(position).getUuid());
                        intent1.putExtra("image",data.get(position).getImgUrl());
                        v.getContext().startActivity(intent1);
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

    class myview extends RecyclerView.ViewHolder{
        ImageView imageView;
        public myview(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
