package com.example.vetclinic.data.sources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vetclinic.R;
import com.example.vetclinic.data.models.PetModel;

import java.util.ArrayList;
import java.util.List;

public class PetDataSource {
    public static LiveData<List<PetModel>> createPetList(){
        MutableLiveData<List<PetModel>> list = new MutableLiveData<>();
        ArrayList<PetModel> pets = new ArrayList<>();
        for (int i=1; i<101; i++){
            PetModel temp = new PetModel("Животное" + i);
            pets.add(temp);
        }
        list.setValue(pets);
        return list;
    }
}