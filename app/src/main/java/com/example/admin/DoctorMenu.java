package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorMenu extends AppCompatActivity {

    Button mDoctorListBtn, mDoctorAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_menu);

        mDoctorAddBtn = findViewById(R.id.addDoctorBtn);
        mDoctorListBtn = findViewById(R.id.doctorListAdBtn);

        mDoctorListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMenu.this, DoctorList.class);
                startActivity(intent);
            }
        });

        mDoctorAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMenu.this, DoctorRegister.class);
                startActivity(intent);
            }
        });

    }
}
