package com.example.vetclinic.data.sources;

public class PetDataSource {
    private static final String petsNames[] = {"Собака", "Кошка", "Птица"};
    public static String getPetName(int index){
        return petsNames[index];
    }
}