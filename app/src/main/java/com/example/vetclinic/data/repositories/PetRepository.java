package com.example.vetclinic.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.vetclinic.data.databases.dao.PetDao;
import com.example.vetclinic.data.databases.entity.PetEntity;
import com.example.vetclinic.data.databases.roomDatabase.PetRoomDatabase;
import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.sources.PetDataSource;

import java.util.List;
import java.util.stream.Collectors;

public class PetRepository {
    private final PetDao mPetDao;
    private final LiveData<List<PetModel>> mAllPets;
    private final Context context;
    private PetRoomDatabase roomDatabase;
    public PetRepository(Application applicationContext) {
        context = applicationContext;
        roomDatabase = PetRoomDatabase.getDatabase(context);
        mPetDao = PetRoomDatabase.getDatabase(context).petDao();
        mAllPets = Transformations.map(mPetDao.getAllPets(), entities -> entities.stream()
                .map(PetEntity::toPet).collect(Collectors.toList()));
    }
    public LiveData<List<PetModel>> getAllPets() {
        return mAllPets;
    }
    public void insert(PetEntity pet) {
        PetRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPetDao.insert(pet);
        });
    }
}



