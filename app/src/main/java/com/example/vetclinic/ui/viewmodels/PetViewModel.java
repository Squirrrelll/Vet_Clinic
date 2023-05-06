package com.example.vetclinic.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vetclinic.data.databases.entity.PetEntity;
import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.repositories.PetRepository;
import com.example.vetclinic.data.sources.AppointmentDataSource;

import java.util.List;
import java.util.Random;

public class PetViewModel extends AndroidViewModel {
    private PetRepository mRepository;

    private final LiveData<List<PetModel>> mAllPets;

    public PetViewModel (Application application) {
        super(application);
        mRepository = new PetRepository(application);
        mAllPets = mRepository.getAllPets();
    }

    public LiveData<List<PetModel>> getAllPets() { return mAllPets; }

    public void insert(PetModel pet) { mRepository
            .insert(new PetEntity(pet.getName())); }
}
