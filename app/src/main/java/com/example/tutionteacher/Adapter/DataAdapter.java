package com.example.tutionteacher.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutionteacher.Model.Teacher;
import com.example.tutionteacher.R;
import com.example.tutionteacher.UI.MainActivity;
import com.example.tutionteacher.UI.TeacherDetail;
import com.example.tutionteacher.UI.TeacherList;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    MainActivity mainActivity = new MainActivity();

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
        holder.tv_distance.setText(round( distance(teacher.get(position).getLat(), mainActivity.LATTITUDE, teacher.get(position).getLongi(), mainActivity.LONGITUDE) , 2)+" kms away from you.");
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


            CardView cardView = (CardView)itemView.findViewById(R.id.cardview);

            cardView.setOnClickListener(v->{
                Intent intent = new Intent(v.getContext(), TeacherDetail.class);

                String teacher_name = tv_name.getText().toString();
                intent.putExtra("TEACHER_NAME", teacher_name);

                String teacher_subject = tv_subject.getText().toString();
                intent.putExtra("TEACHER_SUBJECT", teacher_subject);

                String teacher_fees = tv_fees.getText().toString();
                intent.putExtra("TEACHER_FEES", teacher_fees);

                v.getContext().startActivity(intent);
            });


        }
    }




    // for calculating distance between user and teacher.

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2) {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (c * r);
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
