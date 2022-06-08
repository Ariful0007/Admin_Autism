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

public class Payment_Adapter extends RecyclerView.Adapter<Payment_Adapter.myView> {
    private final List<Payment_Model23> data;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    public Payment_Adapter(List<Payment_Model23> data) {
        this.data = data;
    }

    @NonNull

    @Override
    public myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.payment,parent,false);
        return new Payment_Adapter.myView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Payment_Adapter.myView holder, int position) {
        holder.login_desc.setText(data.get(position).getPatient_name());
        holder.login_desc1.setText("Doctor Name : "+data.get(position).getDoctor_name());
holder.login_desc2.setText("Phone Number : "+data.get(position).getPohnenumber());
holder.login_desc3.setText("Transcation No : "+data.get(position).getTrans());
holder.login_desc4.setText("Date : "+data.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myView extends RecyclerView.ViewHolder{
        TextView login_desc,login1,login_desc2,login_desc1,login_desc3,login_desc4;
        ImageView imageView;

        public myView(@NonNull  View itemView) {
            super(itemView);
            login_desc=itemView.findViewById(R.id.login_desc);
            login_desc1=itemView.findViewById(R.id.login_desc1);
            login_desc2=itemView.findViewById(R.id.login_desc2);
            login_desc3=itemView.findViewById(R.id.login_desc3);
            login_desc4=itemView.findViewById(R.id.login_desc4);


        }
    }
}
