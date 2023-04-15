package com.example.vetclinic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.vetclinic.databinding.FragmentMyAppointmentsBinding;
import com.example.vetclinic.databinding.FragmentMyProfileBinding;

import java.util.ArrayList;
import java.util.List;


public class MyAppointmentsFragment extends Fragment {
    FragmentMyAppointmentsBinding binding;

    public MyAppointmentsFragment(){
        super(R.layout.fragment_my_appointments);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyAppointmentsBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String arguments = getArguments().getString("navigation");
        binding.navigationText.setText(arguments);

        List<String> appointments_array = new ArrayList<String>();
        for (int i = 0; i < 300; i++){
            appointments_array.add("Моя запись " + (i+1));
        }

        MyCustomListViewAdapter listViewAdapter = new MyCustomListViewAdapter(getActivity(), R.layout.appointment_item, appointments_array);
        binding.listView.setAdapter(listViewAdapter);
          binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), appointments_array.get(i), Toast.LENGTH_SHORT).show();
                Log.i("ListView", appointments_array.get(i));
            }
        });

    }
}

