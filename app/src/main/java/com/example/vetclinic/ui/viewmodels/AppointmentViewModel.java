package com.example.vetclinic.ui.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.databases.entity.AppointmentEntity;
import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.repositories.AppointmentRepository;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.List;
import java.util.Random;

public class AppointmentViewModel extends AndroidViewModel {
    private AppointmentRepository mRepository;
    private final LiveData<List<AppointmentModel>> mAllAppointments;
    public AppointmentViewModel (Application application) {
        super(application);
        mRepository = new AppointmentRepository(application);
        mAllAppointments = mRepository.getAllAppointments();
    }
    public LiveData<List<AppointmentModel>> getAllAppointments() { return mAllAppointments; }
    public void insert(AppointmentModel appointment) { mRepository
            .insert(new AppointmentEntity(appointment.getName())); }
}
