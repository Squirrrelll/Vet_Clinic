package com.example.vetclinic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView text_appointment;
    ImageView image_appointment;

    public ViewHolder(View view){
        super(view);
        text_appointment = view.findViewById(R.id.text_appointment);
        image_appointment = view.findViewById(R.id.image_appointment);
    }
}
