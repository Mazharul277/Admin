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
    private List<Doctors> doctorsList;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        databaseReference = FirebaseDatabase.getInstance().getReference("Doctors");

        doctorsList = new ArrayList<>();

        listAdapter = new ListAdapter(DoctorList.this, doctorsList);

        listView = findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(DoctorList.this, "Linner", Toast.LENGTH_LONG).show();

                doctorsList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Doctors doctors = dataSnapshot1.getValue(Doctors.class);
                    doctorsList.add(doctors);
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
