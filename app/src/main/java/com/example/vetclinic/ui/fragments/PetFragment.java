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
import com.example.vetclinic.databinding.FragmentPetBinding;
import com.example.vetclinic.databinding.FragmentRandomAppointmentBinding;
import com.example.vetclinic.ui.viewmodels.AppointmentViewModel;
import com.example.vetclinic.ui.viewmodels.PetViewModel;

public class PetFragment extends Fragment {

    FragmentPetBinding binding;
    PetViewModel model;
    private PetViewModel petViewModel;

    public PetFragment(){
        super(R.layout.fragment_pet);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        petViewModel = new ViewModelProvider(this).get(PetViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPetBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(PetViewModel.class);
        model.getPet().observe(getViewLifecycleOwner(), randomPet -> {
            binding.textView.setText(randomPet.getPet());
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.rollPet();
            }
        });
    }
}

