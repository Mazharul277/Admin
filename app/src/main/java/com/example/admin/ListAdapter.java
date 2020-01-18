package com.example.admin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Doctors> {


    private Activity context;
    private List<Doctors> doctorsList;

    public ListAdapter(Activity context, List<Doctors> doctorsList) {
        super(context, R.layout.list_layout, doctorsList);
        this.context = context;
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_layout, null, true);

        Doctors doctors = doctorsList.get(position);

        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.cityTextViewId);

        t1.setText("Name: " + doctors.getName());
        t2.setText("City: " + doctors.getCity());

        return view;
    }
}
