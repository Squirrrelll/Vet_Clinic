package com.example.vetclinic.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetclinic.ui.adapters.MyCustomRecyclerViewAdapter;
import com.example.vetclinic.R;
import com.example.vetclinic.databinding.FragmentAppointmentBinding;

import java.util.ArrayList;
import java.util.List;


public class AppointmentFragment extends Fragment {
    FragmentAppointmentBinding binding;

    public AppointmentFragment(){
        super(R.layout.fragment_appointment);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAppointmentBinding.inflate(inflater, container,false);
        return binding.getRoot();
        //container.removeAllViews(); // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_appointment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> appointments_array = new ArrayList<String>();
        for (int i = 0; i < 300; i++){
            appointments_array.add("Запись " + (i+1));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);

        MyCustomRecyclerViewAdapter recyclerViewAdapter = new MyCustomRecyclerViewAdapter(getActivity(), appointments_array);
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        String arguments = getArguments().getString("navigation");
        binding.navigationText.setText(arguments);
    }
}

