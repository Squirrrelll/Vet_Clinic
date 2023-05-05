package com.example.vetclinic.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.List;
import java.util.Random;

public class PetViewModel extends ViewModel {
    private LiveData<List<PetModel>> pets;
    public PetViewModel(){
        PetRepository petRepository= new PetRepository();
        pets = petRepository.getPet();
    }

    public LiveData<Object> getPet() {
    }
}
