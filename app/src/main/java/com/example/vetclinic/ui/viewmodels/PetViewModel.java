package com.example.vetclinic.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.Random;

public class PetViewModel extends ViewModel {
    private final MutableLiveData<PetRepository> repository;
    public PetViewModel(){
        repository = new MutableLiveData<>(new PetRepository(0));
    }
    public LiveData<PetRepository> getPet(){
        return repository;
    }
    public void rollPet(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        repository.setValue(new PetRepository(randInt));
    }
    public String getName(){
        return repository.getValue().getPet();
    }
}
