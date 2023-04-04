package com.manan.finalstudentapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class studentinfoadapater extends RecyclerView.Adapter<studentinfoadapater.helperview> {
    Context context;
    ArrayList<Studentinfomodel> arr;
    public studentinfoadapater(Context context, ArrayList<Studentinfomodel> arr)
    {
        this.context=context;
        this.arr=arr;


    }
    @NonNull
    @Override
    public helperview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//       View view= LayoutInflater.from(context).inflate(R.layout.student_info_row,parent,false);
//       helperview helperview=new helperview(view);
//       return  helperview;
        View view= LayoutInflater.from(context).inflate(R.layout.student_info_row,parent,false);
        helperview viewholder = new helperview(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull helperview holder, int position) {
        holder.name.setText(arr.get(position).studentname);
        holder.enrollment.setText(arr.get(position).studentenrollment);
        holder.age.setText(arr.get(position).studentage);
        holder.gender.setText(arr.get(position).studentgender);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class helperview extends RecyclerView.ViewHolder {
       TextView name,enrollment,age,gender;
        public helperview(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentname);
            enrollment = itemView.findViewById(R.id.studentenrollment);
            age = itemView.findViewById(R.id.studentage);
            gender = itemView.findViewById(R.id.stuentgender);


        }
    }
}
