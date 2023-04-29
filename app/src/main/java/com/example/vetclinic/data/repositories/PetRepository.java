package com.example.vetclinic.data.repositories;

import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.sources.PetDataSource;

public class PetRepository {
    private PetModel pet;
    public PetRepository(int index){
        createPet(index);
    }
    public String getData(){
        return pet.getPetName();
    }
    public void createPet(int index){
        pet = new PetModel(PetDataSource.getPetName(index));
    }
}



