package com.example.vetclinic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<String> appointments;
    private Context context;

    public MyCustomRecyclerViewAdapter(Context context, List<String> appointments) {
        this.inflater = LayoutInflater.from(context);
        this.appointments = appointments;
        this.context = context;
    }

    @Override
    public MyCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.appointment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.text_appointment.setText(appointments.get(position));
        holder.image_appointment.setImageResource(R.drawable.paper);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, appointments.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Log.i("RecyclerView", appointments.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_appointment;
        ImageView image_appointment;

        public ViewHolder(View view){
            super(view);
            text_appointment = view.findViewById(R.id.text_appointment);
            image_appointment = view.findViewById(R.id.image_appointment);
        }
    }

}
