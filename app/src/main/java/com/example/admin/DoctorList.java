package com.example.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DoctorList extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Doctor> doctorList;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctor");

        doctorList = new ArrayList<>();

        listAdapter = new ListAdapter(DoctorList.this, doctorList);

        listView = findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(DoctorList.this, "Right", Toast.LENGTH_LONG).show();

                //doctorList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Doctor doctor = dataSnapshot1.getValue(Doctor.class);
                    doctorList.add(doctor);
                }

                listView.setAdapter(listAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DoctorList.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        super.onStart();
    }
}
