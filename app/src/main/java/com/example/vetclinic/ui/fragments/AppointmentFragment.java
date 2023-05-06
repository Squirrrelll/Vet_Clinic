package com.example.vetclinic.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vetclinic.ui.adapters.MyCustomRecyclerViewAdapter;
import com.example.vetclinic.R;
import com.example.vetclinic.databinding.FragmentAppointmentBinding;
import com.example.vetclinic.ui.viewmodels.AppointmentViewModel;

import java.util.ArrayList;
import java.util.List;


public class AppointmentFragment extends Fragment {
    private FragmentAppointmentBinding binding;
    public AppointmentFragment() {super(R.layout.fragment_appointment);}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppointmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonUpload.setOnClickListener(v -> {
            String appointmentName = binding.editTextNameAppointment.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(appointmentName)) {
                binding.editTextNameAppointment.setError(null);
                bundle.putString("RESULT_OK_NAME", appointmentName);
                Navigation.findNavController(view).navigate(R.id.action_appointmentFragment_to_nameFragment, bundle);
            } else {
                binding.editTextNameAppointment.setError("Пустая строка");
            }
        });
    }
}
