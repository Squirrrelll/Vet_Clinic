package com.example.vetclinic.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.Random;

public class AppointmentViewModel extends ViewModel {
    private final MutableLiveData<AppointmentModel> randomAppointment;
    public AppointmentViewModel(){
        randomAppointment = new MutableLiveData<>(new AppointmentModel(null));
    }
    public LiveData<AppointmentModel> getAppointment(){
        return randomAppointment;
    }
    public void rollAppointment(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        randomAppointment.setValue(new AppointmentModel(AppointmentDataSource.getAppointmentsName(randInt)));
    }
}
