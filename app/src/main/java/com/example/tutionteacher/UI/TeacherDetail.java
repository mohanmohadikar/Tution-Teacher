package com.example.tutionteacher.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tutionteacher.R;

public class TeacherDetail extends AppCompatActivity {

    ImageView imageView;
    TextView teacher_detail_name, teacher_detail_subject, teacher_detail_fees, teacher_detail_address;
    String teacher_name_raw, teacher_subject_raw, teacher_fees_raw, teacher_address_raw;
    String teacher_name, teacher_subject, teacher_fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        teacher_detail_name = (TextView) findViewById(R.id.teacher_detail_name);
        teacher_detail_subject = (TextView) findViewById(R.id.teacher_detail_subject);
        teacher_detail_fees = (TextView) findViewById(R.id.teacher_detail_fees);
        teacher_detail_address = (TextView) findViewById(R.id.teacher_detail_address);

        Intent intent = getIntent();

        teacher_name_raw = intent.getStringExtra("TEACHER_NAME");
        teacher_subject_raw = intent.getStringExtra("TEACHER_SUBJECT");
        teacher_fees_raw = intent.getStringExtra("TEACHER_FEES");

        teacher_address_raw = "ADDRESS: Tardeo Tower, 6 South, Balkrishna Nakashe Marg, Tardeo, Mumbai, Maharashtra 400034";

        teacher_name = "NAME: "+teacher_name_raw;
        teacher_subject = teacher_subject_raw;
        teacher_fees = teacher_fees_raw;

        teacher_detail_name.setText(teacher_name);
        teacher_detail_subject.setText(teacher_subject);
        teacher_detail_fees.setText(teacher_fees);
        teacher_detail_address.setText(teacher_address_raw);

    }
}
