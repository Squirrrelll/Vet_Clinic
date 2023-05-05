package com.example.vetclinic.ui.viewmodels;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.repositories.AppointmentRepository;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.List;
import java.util.Random;

public class AppointmentViewModel extends ViewModel {
    public LiveData<List<AppointmentModel>> appointments;
       public AppointmentViewModel(){
           AppointmentRepository appointmentRepository = new AppointmentRepository();
           appointments = appointmentRepository.getAppointment();
    }

    public LiveData<Object> getAppointment() {
    }
}
