package com.meass.todday_admin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.List;

public class Doctor_Cate extends RecyclerView.Adapter<Doctor_Cate.myView> {
    private final List<Temp_Doctor> data;

    public Doctor_Cate(List<Temp_Doctor> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_all,parent,false);
        return new Doctor_Cate.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Doctor_Cate.myView holder, int position) {
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
        holder.login1.setText(data.get(position).getDeg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Main_Settings.class);
                intent.putExtra("image",data.get(position).getImage());
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("deg",data.get(position).getDeg());
                intent.putExtra("gender",data.get(position).getDeg());
                intent.putExtra("userPhone",data.get(position).getUserPhone());
                intent.putExtra("location",data.get(position).getLocation());
                intent.putExtra("bmdc",data.get(position).getBmdc());
                intent.putExtra("p_email",data.get(position).getP_email());
                intent.putExtra("p_password",data.get(position).getP_password());
                intent.putExtra("category",data.get(position).getCategory());
                intent.putExtra("uuid",data.get(position).getUuid());
                intent.putExtra("doctorfee",data.get(position).getDoctorfee());
                intent.putExtra("paymentMethode",data.get(position).getPaymentMethode());
                intent.putExtra("paymentNumber",data.get(position).getPaymentNumber());
                intent.putExtra("checkingtime",data.get(position).getCheckingtime());
                intent.putExtra("doctorDate",data.get(position).getDoctorDate());

                v.getContext().startActivity(intent);
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
