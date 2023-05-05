package com.example.vetclinic.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.sources.PetDataSource;

import java.util.List;

public class PetRepository {
    private LiveData<List<PetModel>> pets;
    public PetRepository(){
        pets = PetDataSource.createPetList();
    }
    public LiveData<List<PetModel>> getPets(){
        return pets;
    }

}



