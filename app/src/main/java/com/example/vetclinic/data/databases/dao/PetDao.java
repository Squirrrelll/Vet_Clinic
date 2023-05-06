package com.example.vetclinic.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.vetclinic.data.databases.entity.PetEntity;

import java.util.List;

@Dao
public interface PetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(PetEntity pet);

    @Query("DELETE FROM pet_table")
    void deleteAll();

    @Query("SELECT * FROM pet_table ORDER BY name")
    LiveData<List<PetEntity>> getAllPets();
}