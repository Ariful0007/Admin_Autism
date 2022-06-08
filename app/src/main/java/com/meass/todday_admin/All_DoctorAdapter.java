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

public class All_DoctorAdapter  extends RecyclerView.Adapter<All_DoctorAdapter.myView>{
    private final List<Temp_Doctor> data;

    public All_DoctorAdapter(List<Temp_Doctor> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.alldoctor,parent,false);
        return new All_DoctorAdapter.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  All_DoctorAdapter.myView holder, int position) {
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Details_All.class);

                intent.putExtra("p_email",data.get(position).getP_email());
                intent.putExtra("category",data.get(position).getCategory());

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
