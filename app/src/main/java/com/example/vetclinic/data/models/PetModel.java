package com.example.vetclinic.data.models;

public class PetModel {
    private final String pet;
    private final String AppointmentViewModel;

    public PetModel(String pet, String AppoitmentViewModel){
        this.pet = pet;
        this.AppointmentViewModel=AppoitmentViewModel;
    }

    public String getPet(){
        return pet;
    }

}

