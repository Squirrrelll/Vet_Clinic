package com.example.vetclinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomListViewAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private int layout;
    private List<String> appointments;

    public MyCustomListViewAdapter(Context context, int resource, List<String> appointments) {
        super(context, resource, appointments);
        this.appointments = appointments;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView text_appointments = view.findViewById(R.id.text_appointment);
        text_appointments.setText(appointments.get(position));

        ImageView image_appointment = view.findViewById(R.id.image_appointment);
        image_appointment.setImageResource(R.drawable.symbol);

        return view;
    }

}
