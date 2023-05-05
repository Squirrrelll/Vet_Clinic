package com.example.vetclinic.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetclinic.R;
import com.example.vetclinic.databinding.FragmentRandomAppointmentBinding;
import com.example.vetclinic.ui.viewmodels.AppointmentViewModel;


public class RandomAppointmentFragment extends Fragment {

    FragmentRandomAppointmentBinding binding;
    private AppointmentViewModel model;
    private AppointmentViewModel appointmentViewModel;
    private Object appointmentAdapter;

    public RandomAppointmentFragment(){
        super(R.layout.fragment_random_appointment);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appointmentViewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRandomAppointmentBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(AppointmentViewModel.class);
        model.getAppointment().observe(getViewLifecycleOwner(), randomAppointment -> {
            binding.textView.setText(randomAppointment.getAppointment());
        });
        //public updateAppointments()
        //}

        //appointmentViewModel.appointments.observe(getViewLifecycleOwner(), appointments -> appointmentAdapter.updateAppointments(appointments));

/*
        LiveData<String> AppointmentViewMode = appointments.getData();
        AppointmentViewModel.appointments.observe(this, new Observer<String>(){
            @Override
            public void onChanged(@Nullable String value){
                binding.textView.setText(value);
            }
        });*/


    }



    }