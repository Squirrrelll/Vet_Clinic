package com.example.vetclinic.ui.viewmodels;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.List;
import java.util.Random;

public class AppointmentViewModel extends ViewModel {
    public LiveData<List<AppointmentModel>> appointments;
       public AppointmentViewModel(){
      //  PetRepository petRepository = new PetRepository();
       // appointments = petRepository.getData();
    }
 /*   public LiveData<AppointmentModel> getAppointment(){
        return randomAppointment;
    }
    public void rollAppointment(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        randomAppointment.setValue(new AppointmentModel(AppointmentDataSource.getAppointmentsName(randInt)));
    }*/

}
