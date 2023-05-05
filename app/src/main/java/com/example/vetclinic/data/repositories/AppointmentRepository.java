package com.example.vetclinic.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.sources.AppointmentDataSource;
import com.example.vetclinic.data.sources.PetDataSource;

import java.util.List;

public class AppointmentRepository {
    private LiveData<List<AppointmentModel>> appointments;
    public AppointmentRepository(){
        appointments = AppointmentDataSource.createAppointmentList();
    }
    public LiveData<List<AppointmentModel>> getAppointments(){
        return appointments;
    }
}
