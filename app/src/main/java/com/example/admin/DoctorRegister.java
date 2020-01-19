package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorRegister extends AppCompatActivity {

    EditText mPatientName, mEmail, mContactNo, mBirthdate, mAddress, mCity, mPassword;
    Button mRegister;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctor");

        mPatientName = findViewById(R.id.patientName);
        mEmail = findViewById(R.id.emailIdrg);
        mContactNo = findViewById(R.id.contactNorg);
        mBirthdate = findViewById(R.id.birthIdrg);
        mAddress = findViewById(R.id.addressIdrg);
        mCity = findViewById(R.id.cityIdrg);
        mPassword = findViewById(R.id.passWordIdrg);

        mRegister = findViewById(R.id.registerIdrg);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    public void saveData() {
        String name = mPatientName.getText().toString();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String contactNo = mContactNo.getText().toString();
        String birthDate = mBirthdate.getText().toString();
        String address = mAddress.getText().toString();
        String city = mCity.getText().toString();

        if (TextUtils.isEmpty(email)){
            mEmail.setError("Email is Required.");
            return;
        }
        if (TextUtils.isEmpty(password)){
            mPassword.setError("Password is Required.");
            return;
        }
        if (password.length()<6){
            mPassword.setError("Password Must be >= 6 Charecters");
            return;
        }


        String key = databaseReference.push().getKey();

        Doctor doctor = new Doctor(name, email, password, contactNo, birthDate, address, city);

        databaseReference.child(key).setValue(doctor);

        Toast.makeText(getApplicationContext(), "Doctor is added", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(DoctorRegister.this,DoctorMenu.class);
        startActivity(intent);

        mPatientName.setText("");
        mEmail.setText("");
        mPassword.setText("");
        mContactNo.setText("");
        mBirthdate.setText("");
        mAddress.setText("");
        mCity.setText("");
    }
}
