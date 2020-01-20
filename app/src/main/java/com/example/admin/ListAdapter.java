package com.example.admin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Doctor> {


    private Activity context;
    private List<Doctor> doctorList;

    public ListAdapter(Activity context, List<Doctor> doctorList) {
        super(context, R.layout.list_layout, doctorList);
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_layout, null, true);

        Doctor doctor = doctorList.get(position);

        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.cityTextViewId);

        t1.setText("Name: " + doctor.getName());
        t2.setText("City: " + doctor.getCity());

        return view;
    }
}
