package com.example.vetclinic.data.models;

public class PetModel {
    private final String PetName;

    public PetModel(String PetName){
        this.PetName = PetName;
    }

    public String getPetName(){
        return PetName;
    }

}

