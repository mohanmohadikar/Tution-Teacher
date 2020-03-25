package com.example.tutionteacher.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tutionteacher.Model.Teacher;
import com.example.tutionteacher.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Teacher> teacher;

    public DataAdapter(ArrayList<Teacher> teacher) {
        this.teacher = teacher;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(teacher.get(position).getName());
        holder.tv_subject.setText("Subject: "+teacher.get(position).getSubject());
        holder.tv_fees.setText("Fees: $"+teacher.get(position).getFees()+" /semester");
        holder.tv_distance.setText(teacher.get(position).getDist()+" kms away from you.");
    }

    @Override
    public int getItemCount() {
        return teacher.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_subject;
        private TextView tv_fees;
        private TextView tv_distance;


        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_subject = (TextView)itemView.findViewById(R.id.tv_subject);
            tv_fees = (TextView)itemView.findViewById(R.id.tv_fees);
            tv_distance = (TextView)itemView.findViewById(R.id.tv_distance);


        }
    }
}
