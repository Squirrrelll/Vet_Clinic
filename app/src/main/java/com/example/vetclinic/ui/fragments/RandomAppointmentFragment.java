package com.example.vetclinic.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetclinic.R;
import com.example.vetclinic.databinding.FragmentMyAppointmentsBinding;
import com.example.vetclinic.databinding.FragmentRandomAppointmentBinding;
import com.example.vetclinic.ui.viewmodels.AppointmentViewModel;

import java.net.DatagramPacket;


public class RandomAppointmentFragment extends Fragment {

    FragmentRandomAppointmentBinding binding;
    private AppointmentViewModel model;//?????

    public RandomAppointmentFragment(){
        super(R.layout.fragment_random_appointment);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            binding.textView.setText(randomAppointment.getAppointmentName());
        });


       /* DatagramPacket viewModel;

        LiveData<String> liveData = viewModel.getData();
        liveData.observe(this, new Observer<String>(){
            @Override
            public void onChanged(@Nullable String value){
                binding.textView.setText(value);
            }
        });*/


    }



    }